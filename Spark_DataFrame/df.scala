import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

//val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008") //Finantial Crisis
//val df = spark.read.csv("CitiGroup2006_2008") //Finantial Crisis

//First 5 rows
df.head(5)

for(row <- df.head(5)){
    println(row)
}

//columns
df.columns

df.describe().show()

//Select a column
df.select("Volume").show()

//Select multiple columns
df.select($"Date", $"Close").show()


//create new columns
val df2 = df.withColumn("HighPlusLow", df("High")+df("Low"))

df("High")

df2.printSchema()

df2("HighPlusLow").as("HPL")

df2.select(df2("HighPlusLow").as("HPL"), df("Close")).show()