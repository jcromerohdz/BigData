// 100 REPL res0: Int = 100
// 2.5 REPL res1: Double = 2.5
// 1 + 1
// 2 - 1
// 2 * 5
// 1 / 2  Int = 0
// 1.0 / 2 Double = 0.5
// 1 / 2.0
// 1.0 / 2.0

// Exponentials
math.pow(4, 2)  //Double = 16.0
res0 // Int = 100
res0 + res11 // Int = 200
1 + 2 * 3 + 4 //Int = 11
(1+2) * (3+4) //Int = 21

//Feet to meters
3 * 0.3048  //Double = 0.914400

// Variables in scala
// Values (val) are immutable, once they are assigned they
// can not be changed.
// Variables (var) can be reassigned.
// Note, when reassigning you must used the same data type!

// Data Types
// Int
// Double 
// String
// Boolean
// Collections

// val <name> : <type> = <literal>
// var <name> : <type> = <literal>

var myvar: Int = 10
val myval: Double = 2.5

myvar = "hello" //error: type mistmatch
myvar = 100
myval = "hello" //error: reassignment to val
myval = 10.1 //error: reassigment to val

val c = 12 //Scala reassing Int 12
val my_string = "Hello"

// Can not do this val 23my_string nor my.string

//Booleans and comparison operators
true
false
1 > 2 // false
1 < 2 // true
1 <= 30 // true
2 == 2 // true
2 != 4 // true

4 % 2 // 0 mod operator
5  % 2 // 1
6 % 2 // if 0 the number is even

//Strings
println("Hello")
println('Hello') //Error unclosed character literal
val greeting = "Hello " + "there!"
"dance"*5
val st = "hello"
val name = "Christian"
val greet = s"Hello ${name}"
val greet = s"Hello $name"

printf("A string %s, an integer %d, a float %f", "Hi",10,3.1416)
printf("A float %1.2f", 1.2345)
printf("A float %1.2f", 1.2395)

val st = "This a long string"
st.charAt(0)
st.charAt(3)
st.indexOf("a")
st slice  (0,4)
// Grab the word long of st
