package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {//EVALUATED ONE TIME
    println("by value" + x)
    println("by value" + x)
  }
  def calledByName(x: => Long): Unit ={//EVALUATED EVERY TIME
    println("by name" + x)
    println("by name" + x)
  }


  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite() :Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  //printFirst(infinite(),34)
  printFirst(34, infinite())
}
