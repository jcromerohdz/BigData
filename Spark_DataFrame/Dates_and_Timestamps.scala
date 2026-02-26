import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")

df.printSchema()

df.head(2)

df.select(month(df("Date"))).show()

df.select(year(df("Date"))).show()

val df2 = df.withCoumn("Year", year(df("Date")))
val df3 = df2.withColumn("Month", month(df("Date")))

val dfavgs = df3.groupBy("Year", "Month").mean()

dfavgs.select($"Year", $"avg(Close)").show()

val dfmins = df2.groupBy("Year").min()

dfmins.select($"Year", $"min(Close)").show()