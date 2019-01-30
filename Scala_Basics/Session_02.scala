val st = "item1 item2 item3" 
st matches "item1 item2 item3" // res0: Boolean = false
st matches "item2" // res1: Boolean = true
st contains "item1" // res2: true
st contains "tem4" // res3: false

//Tuples
(1, 2.3, "Hello") // res4: (Int, Double, String) = (1, 2.3, Hello)
val my_tup = (1,2.2, "hello,", 23.2, true) 
// res4: (Int, Double, String, Double, Boolean) = (1,2.2,"Hello", 23.2, true)
(3,1,(2,3))
// res5: (Int, Int, (Int, Int)) = (3,1,(2,3))
my_tub._3 // res6: String = hello
my_tub._5 // res7: Boolean = true

// Assessment 1/Practica 1
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
//2. Desarrollar un algoritmo en scala que me diga si un numero es primo
//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"
//4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
//   secuencia "Luke"
//5. Cual es la diferencia en value y una variable en scala?
//6. Dada la tupla ((2,4,5),(1,2,3),(3.1416,23))) regresa el numero 3.1416 

// Collections Lists, arrays, 
val evens = List(2,4,6,8,10) //evens: List[Int] = List(2,4,6,8,10)

List(1,2.2,true)  // res8: List[AnyVal] = List(1, 2.2, true)
evens(0)  //res9: Int = 2
evens(4)  //res10: Int =10
evens.head //res11: Int = 2
evens.tail //res12: List[Int] = List(4, 6, 8, 10)
val my_list = List(List(1,2,3),List(3,2,1))
val my_list = List(("a",1), ("b",2),("c",3))
val my_list = List(1,5,3,7,6,109)
mylist.lift
my_list.sorted
my_list.size
my_list.max
my_list.min
my_list.sum
my_list.product

val z = List(4,5,6,7)
z.drop(2)
z.takeRight(1)
z.takeRight(3)

val x = List(1,2,3,4,5,6,7,8)
x slice (0,3)
x slice (3, 6)
