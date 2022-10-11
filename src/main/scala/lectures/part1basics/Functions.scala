package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  //println(aParameterlessFunction) only works in Scala 2


  def aRepeatedFunnction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunnction(aString, n - 1)
  }

  println(aRepeatedFunnction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)


  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
  1.A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  2. Factorial function
  3. A Fibonacci function
  f(1) = 1
  F(2) =1
  f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime
  */
  def aGreetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"

  }

  println(aGreetingFunction("Filip", 20))

  def factorialFunction(number: Int): Int = {
    if (number <= 0) 1
    else number * factorialFunction(number - 1)

  }

  println(factorialFunction(3))

  def fibonacci(number: Int): Int = {
    if(number <= 2) 1
    else fibonacci(number-1)+ fibonacci(number-2)
  }

  println(fibonacci(3))

  def isPrime(number : Int): Boolean= {
    def isPrimeUntil(t: Int): Boolean= {
      if (t <= 1) true
      else number % t != 0 && isPrimeUntil(t - 1);
    }
      isPrimeUntil(number/2)// because divisor can't greater than a half of the number
  }
  println(isPrime(13))

}
