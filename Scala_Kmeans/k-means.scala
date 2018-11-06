import org.apache.spark.sql.SparkSession

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

import org.apache.spark.ml.clustering.KMMeans

val dataset = spark.read.format("libsvm").load("sample_kmeans_data.txt")

//trains the k-means model
val kmeans = new KMMeans().setK(2).setSeed(1L)
val model = kmeans.fit(dataset)

// Evaluate clustering by calculate Within Set Sum of Squared Errors.
val WSSE = model.computeCOst(dataset)
println(s"Within set sum of Squared Errors = $WSSSE")

// Show results
println("Cluster Centers: ")
model.clusterCenters.foreach(println)