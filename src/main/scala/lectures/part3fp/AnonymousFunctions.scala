package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function (LAMBDA) mustbe called with ()
  val doubler: Int => Int = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething)// prints function itself
  println(justDoSomething())// prints value returns - CALL

  // curly braces with lambdas
  val stringToInt = { (str: String)=>
    str.toInt
  }

  //MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1// equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ +  _// equivalent to (a,b) => a + b

  /*
  1. MyList: replace all FunctionX calls with lambdas
  2. Rewrite the " special" adder as an anomymous function
  */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
