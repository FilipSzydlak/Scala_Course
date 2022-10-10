package lectures.part1basics

object ValuesVariablesTypes extends App{

  val x = 42
  println(x)

  //  VALS ARE IMMUTABLE
  // compiler can infer types

  val aString: String = "Hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short= 46
  val aLong: Long = 12312312
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables
  var aVariable: Int = 4

  aVariable = 5 // side effects

}
