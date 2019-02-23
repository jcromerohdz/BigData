import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Sales.csv")

df.printSchema()

df.show()

df.groupBy("Company").mean().show()

df.groupBy("Company").count().show()

df.groupBy("Company").max().show()

df.groupBy("Company").min().show()

df.groupBy("Company").sum().show()

// Other Aggregate Functions
// https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$

df.select(countDistinct("Sales")).show()

df.select(sumDistinct("Sales")).show()

df.select(variance("Sales")).show()

df.select(stddev("Sales")).show()

df.select(collect_set("Sales")).show()
