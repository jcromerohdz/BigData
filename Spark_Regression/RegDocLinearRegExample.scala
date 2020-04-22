import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

def main(): Unit = {
  // Create Session App
  val spark = SparkSession.builder().appName("LinearRegressionExample").getOrCreate()

  // May need to replace with full file path starting with file:///.
  val path = "sample_linear_regression_data.txt"

  // Training Data
  val training = spark.read.format("libsvm").load(path)
  training.printSchema()

  // Create new LinearRegression Object
  val lr = new LinearRegression().setMaxIter(100).setRegParam(0.3).setElasticNetParam(0.8)

  // Fit the model
  val lrModel = lr.fit(training)

  // Print the coefficients and intercept for linear regression
  println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

  // Summarize the model over the training set and print out some metrics
  val trainingSummary = lrModel.summary
  println(s"numIterations: ${trainingSummary.totalIterations}")
  println(s"objectiveHistory: ${trainingSummary.objectiveHistory.toList}")
  trainingSummary.residuals.show()
  println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
  println(s"r2: ${trainingSummary.r2}")

  // $example off$
  spark.stop()
}
main()
