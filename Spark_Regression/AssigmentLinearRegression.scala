////////////////////////////////////////////
//// LINEAR REGRESSION EXERCISE ///////////
/// Coplete las tareas comentadas ///
/////////////////////////////////////////

// Import LinearRegression

// Opcional: Utilice el siguiente codigo para configurar errores
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)


// Inicie una simple Sesion Spark

// Utilice Spark para el archivo csv Clean-Ecommerce .

// Imprima el schema en el DataFrame.


// Imprima un renglon de ejemplo del DataFrane.



//////////////////////////////////////////////////////
//// Configure el DataFrame para Machine Learning ////
//////////////////////////////////////////////////////

// Transforme el data frame para que tome la forma de
// ("label","features")

// Importe VectorAssembler y Vectors

// Renombre la columna Yearly Amount Spent como "label"
// Tambien de los datos tome solo la columa numerica 
// Deje todo esto como un nuevo DataFrame que se llame df

// Que el objeto assembler convierta los valores de entrada a un vector


// Utilice el objeto VectorAssembler para convertir la columnas de entradas del df
// a una sola columna de salida de un arreglo llamado  "features"
// Configure las columnas de entrada de donde se supone que leemos los valores.
// Llamar a esto nuevo assambler.

// Utilice el assembler para transform nuestro DataFrame a dos columnas: label and features


// Crear un objeto para modelo de regresion linea.


// Ajuste el modelo para los datos y llame a este modelo lrModelo


// Imprima the  coefficients y intercept para la regresion lineal

// Resuma el modelo sobre el conjunto de entrenamiento imprima la salida de algunas metricas!
// Utilize metodo .summary de nuestro  modelo para crear un objeto
// llamado trainingSummary

// Muestre los valores de residuals, el RMSE, el MSE, y tambien el R^2 .


// Buen trabajo!
