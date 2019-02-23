//While loop 

import util.control.Breaks._

var x = 0

while(x < 5){
    println(s"x is currently $x")
    println(s"x is still less then 5, adding 1 to x ")
    x = x + 1
}

var y = 0

while(y < 10){
    println(s"y is currently $y")
    println(s"y is still less then 10, add 1 to y")
    y = y+1
    if(y==3) break 

}
println("###########")

// Functions 

def simple(): Unit = {
    println("simple print")
}

simple()

def adder(num1:Int, num2:Int): Int = {
    return num1 + num2
}

adder(5, 5)

def greetName(name:String): String={
    return s"Hello $name"
}

val fullgreet = greetName("Christian")
println(fullgreet)

def isPrime(num:Int): Boolean = {
    for(n <- Range(2, num)){
        if(num%n == 0){
            return false
        }
    }
    return true
}

println(isPrime(10))
println(isPrime(23))

val numbers = List(1,2,3,7)

def check(nums:List[Int]): List[Int]={
    return nums
}

println(check(numbers))