package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computing factorial of " + n)
      result

    }


  }

  println(factorial(10))
  //println(factorial(500000000)) STACK OVERFLOW

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION = rescursive call as the LAST expression


    }

    factorialHelper(n, 1)
  }
  //println(anotherFactorial(50000))

  /*
  anotherFactorial (10) = factHelper(10 , 1)
  = factHelper(9 , 10 * 1)
  = factHelper(8 , 9 * 10 * 1)
  = factHelper(7 , 8 * 9 * 10 * 1)
  ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
  = 1 * 2 * 3 * 4 * ... * 10

  */

  //WHEN YOU NEED LOOPS, USE_TAIL_RECURSION.

  /*
  1. Concate a string n times
  2. IsPrime function tail recursive
  3. Fibonacci function, tail recursive
  */
@tailrec
  def concatenateTailrec(aString: String, n : Int, accumulator: String): String = {
  if(n <= 0) accumulator
  else concatenateTailrec(aString, n-1, aString + accumulator)

  }
  println(concatenateTailrec("hello", 3,""))

  def isPrime(n: Int): Boolean = {
    def isPrimeTailrec(t:Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if(t<=1) true
      else isPrimeTailrec(t-1, n % t != 0  ) // && isStillPrime is not need

    }
    isPrimeTailrec(n/2, true)

  }

  println(isPrime(2003))
  println(isPrime(629))
  println(isPrime(13))
  println(isPrime(24))
  println(isPrime(200300000))
  println(isPrime(15))

  def fibonacci(n : Int): Int = {
    def fiboTailrec(i : Int, last: Int, nextToLast: Int): Int ={
      if(i >= n) last
      else fiboTailrec(i+ 1, last + nextToLast, last)
    }
    if(n<=2) 1
    else fiboTailrec(2,1,1)
  }

  println(fibonacci(8))
}



