import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("fakefriends.csv")

println("Nuestro esquema inferido por el DataFrame")
df.printSchema()

println("Muestra los datos del data frame")
df.show()

println("Selecciona la columna name")
df.select("name").show()

println("Personas con edad menor a 21")
df.filter(df("age") < 21).show()

println("Agrupar por edad:")
df.groupBy(("age")).count().show()

println("Hacer a las personas 10 años mayores")
df.select(df("name"), df("age") + 10).show()

// Agrupar promedio de amgigos por edad
val friendsByAge = df.select("age", "friends")

// resultado simple con decimales
val result_1 = friendsByAge.groupBy("age").avg("friends")
result_1.show()

// resultado formatedo profesional
val result_2 = friendsByAge.groupBy("age").agg(round(avg("friends"), 2).alias("friends_avg")).sort("age")
result_2.show()