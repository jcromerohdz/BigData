// Arrays
// Arrays are mutable, List are not
val arr = Array(3,4,5)
val arr = Array("a","b","c")
val arr = Array("a","b", true, 1.2)

//Create arrays  with range method
Array.range(0, 10)
Array.range(0, 10, 2)

Range(0,5)

//Sets not cotains duplicate elements
val s = Set()
val s = Set(1,2,3)

val s = Set(2,2,2,3,3,3,5,5,5)

val s = collection.mutable.Set(1,2,3)
s += 4

val ims = collection.mutable.Set(2,3,4)
ims += 5
ims.add(6)
ims

ims.max
ims.min

val mylist = List(1,2,3,1,2,3)
mylist.toSet

val newset = mylist.toSet
newset

//Maps key value pair storage

val mymap = Map(("saludo", "Hola"), ("pi", 3.1416), ("z", 1.3))
mymap("pi")
mymap("saludo")
mymap("ja")
mymap get "pi"
mymap get "z"
mymap get "o"

val mutmap = collection.mutable.Map(("z", 123), ("a", 5), ("b", 7))

mutmap += ("lucky" -> 777)
mutmap
mutmap.keys
mutmap.values

//Practice 2
// 1. Crea una lista llamad "lista" con los elementos "rojo", "blanco", "negro"
// 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
// 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
// 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
// 6. Crea una mapa mutable llamado nombres que contenga los siguiente
//     "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
// 6 a . Imprime todas la llaves del mapa
// 7 b . Agrega el siguiente valor al mapa("Miguel", 23)