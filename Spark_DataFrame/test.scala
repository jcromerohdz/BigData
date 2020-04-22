// DATAFRAME PROJECT

import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()


val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")


df.columns


df.printSchema()


df.head(5)


df.describe().show()


val df2 = df.withColumn("HV Ratio",df("High")/df("Volume"))


//df.orderBy($"High".desc).show(1)


df.select(mean("Close")).show()

// What is the max and min of the Volume column?
df.select(max("Volume")).show()
df.select(min("Volume")).show()

// For Scala/Spark $ Syntax
import spark.implicits._

// How many days was the Close lower than $ 600?
df.filter($"Close"<600).count()

// What percentage of the time was the High greater than $500 ?
(df.filter($"High">500).count()*1.0/df.count())*100

// What is the Pearson correlation between High and Volume?
df.select(corr("High","Volume")).show()

// What is the max High per year?
val yeardf = df.withColumn("Year",year(df("Date")))
val yearmaxs = yeardf.select($"Year",$"High").groupBy("Year").max()
yearmaxs.select($"Year",$"max(High)").show()

// What is the average Close for each Calender Month?
val monthdf = df.withColumn("Month",month(df("Date")))
val monthavgs = monthdf.select($"Month",$"Close").groupBy("Month").mean()
monthavgs.select($"Month",$"avg(Close)").show()