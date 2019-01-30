import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().appName("PCA_Example").getOrCreate()

val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("Cancer_Data")

data.printSchema()

import org.apache.spark.ml.feature.{PCA,StandardScaler,VectorAssembler}

import org.apache.spark.ml.linalg.Vectors

val colnames = (Array("mean radius", "mean texture", "mean perimeter", "mean area", "mean smoothness",
"mean compactness", "mean concavity", "mean concave points", "mean symmetry", "mean fractal dimension",
"radius error", "texture error", "perimeter error", "area error", "smoothness error", "compactness error",
"concavity error", "concave points error", "symmetry error", "fractal dimension error", "worst radius",
"worst texture", "worst perimeter", "worst area", "worst smoothness", "worst compactness", "worst concavity",
"worst concave points", "worst symmetry", "worst fractal dimension"))

val assembler = new VectorAssembler().setInputCols(colnames).setOutputCol("features")


val output = assembler.transform(data).select($"features")


val scaler = (new StandardScaler()
  .setInputCol("features")
  .setOutputCol("scaledFeatures")
  .setWithStd(true)
  .setWithMean(false))


val scalerModel = scaler.fit(output)


val scaledData = scalerModel.transform(output)

val pca = (new PCA()
  .setInputCol("scaledFeatures")
  .setOutputCol("pcaFeatures")
  .setK(4)
  .fit(scaledData))

val pcaDF = pca.transform(scaledData)

val result = pcaDF.select("pcaFeatures")
result.show()

result.head(1)
