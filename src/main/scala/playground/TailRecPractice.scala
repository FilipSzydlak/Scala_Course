package playground

object TailRecPractice extends App {


  //1 factorial

  def factorialRec(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else factorialRec(n - 1, n * acc)
  }

  println(factorialRec(3))

  def stringConcatRec(s: String, acc: String, n: Int): String = {
    if (n < 1) acc
    else stringConcatRec(s, acc + s, n - 1)
  }

  println(stringConcatRec("hello ", "", 10))

  def isPrime(n: Int): Boolean = {
    def isPrimeRec(t: Int, acc: Boolean = true): Boolean = {
      if (!acc) false
      else if (t <= 1) true
      else isPrimeRec(t - 1, n % t != 0)
    }

    isPrimeRec(n / 2)
  }

  println(isPrime(15))

  def fibonacci(n: Int): Int = {
    def fibonacciRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciRec(2, 1, 1)
  }

  println(fibonacci(8))


}

