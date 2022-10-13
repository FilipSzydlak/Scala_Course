package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person:Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name" // space between ! and  : is important
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and my favorite movie is $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")// equivalent
  // infix notation = operator notation ONLY WHEN METHOD HAS SINGLE PARAMETER (SYNTACTIC SUGAR)

  //"operators" i
  // n Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom) // hangOutWith works as "OPERATOR" (IT IS POSSIBLE TO RENAME IT TO +)
  println(mary.+ (tom))

  println(1 + 2)//OPERATORS ARE METHODS IN SCALA
  println(1.+ (2))

  // ALL OPERATORS ARE METHODS in SCALA
  // Akka actors have ! ?

  //PREFIX notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !


  println(!mary)
  println(mary.unary_!)


  //POSTFIX notation [FUNCTION DOES NOT RECEIVE ANY PARAMETERS
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())// equivalent


}
