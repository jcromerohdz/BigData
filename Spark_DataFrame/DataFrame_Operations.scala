import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")

df.printSchema()

///////////////////////
/// Two way to make filters 1 with scala and 2 with sparksql
///////////////////////

import spark.implicits._

//scala notation
df.filter($"Close">480).show()

//sparksql notation
df.filter("Close > 480").show()

df.filter($"Close" < 480 && $"High" < 480).show()
df.filter("Close < 480 AND High < 480").show()

//Collect the results
val result = df.filter($"Close" < 480 && $"High" < 480).collect()

//Count the results
val result = df.filter($"Close" < 480 && $"High" < 480).count()

//equality
df.filter($"High"===484.40).show()
df.filter("High = 484.40").show()

//Pearson correlation
//https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$
df.select(corr("High", "Low")).show()

