import org.apache.spark.sql.SparkSession

val spar = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("ContainsNull.csv")

df.printSchema()

df.show()

//df.na.drop().show()
//df.na.drop(2).show()
//df.na.fill(100).show()
//df.na.fill("Missing Name")
//df.na.fill("New name", Array("Name")).show() 
//df.na.fill(200, Array("Sales")).show() 

//df.describe().show()
//df.na.fill(400.5, Array("Sales")).show()
//df.na.fill("Missing name", Array("Name")).show()

//val df2 =df.na.fill(400.5, Array("Sales"))
//df2.na.fill("Missing name", Array("Name")).show()