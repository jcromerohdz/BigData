
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("customer-orders.csv")

df.printSchema()

df.show()

//Elaborar una consulta la cual nos de el total gastado por cliente