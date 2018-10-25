import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("titanic.csv")

data.printSchema()

data.head(1)

val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}

val logregdataall = (data.select(data("Survived").as("label"), $"Pclass", $"Name",
                    $"Sex", $"Age", $"SibSp", $"Parch", $"Fare", $"Embarked"))

val logregdata = logregdataall.na.drop()

import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors

// Convertir strings a valores numericos - Transforming string into numerical values
val genderIndexer = new StringIndexer().setInputCol("Sex").setOutputCol("SexIndex")
val embarkIndexer = new StringIndexer().setInputCol("Embarked").setOutputCol("EmbarkIndex")

// Convertir los valores nuemericos a One Hot Encoding 0 - 1
val genderEncoder = new OneHotEncoder().setInputCol("SexIndex").setOutputCol("SexVec")
val embarkEncoder = new OneHotEncoder().setInputCol("EmbarkIndex").setOutputCol("EmbarkVec")
// (lbel, features)
//val assembler = new VectorAssembler().setInputCol(Array("Pclass", "SexVec", "Age", "SibSp", "Parch", "Fare", "EmbarkedVec")).setOutputCol("features")
val assembler = (new VectorAssembler()
                  .setInputCols(Array("Pclass","SexVec", "Age","SibSp","Parch","Fare","EmbarkVec"))
                  .setOutputCol("features"))

val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)

import org.apache.spark.ml.Pipeline

val lr = new LogisticRegression()

// val pipeline = new Pipeline().setStages(Array(genderIndexer,embarkIndexer,embarkEncoder,assembler,lr))
val pipeline = new Pipeline().setStages(Array(genderIndexer,embarkIndexer,genderEncoder,embarkEncoder,assembler,lr))

val model = pipeline.fit(training)

val results = model.transform(test)


//Probar el modelo solo se puede con la libreria vieja
import org.apache.spark.mllib.evaluation.MulticlassMetrics

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

// Matriz de confusion
println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy
