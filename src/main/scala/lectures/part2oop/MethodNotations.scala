package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age : Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def unary_! : String = s"$name" // space between ! and  : is important

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and my favorite movie is $favoriteMovie"
    def apply(n : Int) : String = s"$name watched $favoriteMovie $n times"

    def learns(subject : String) : String = s"$name learns $subject"
    def learnsScala : String = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation ONLY WHEN METHOD HAS SINGLE PARAMETER (SYNTACTIC SUGAR)

  //"operators" i
  // n Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom) // hangOutWith works as "OPERATOR" (IT IS POSSIBLE TO RENAME IT TO +)
  println(mary.+(tom))

  println(1 + 2) //OPERATORS ARE METHODS IN SCALA
  println(1.+(2))

  // ALL OPERATORS ARE METHODS in SCALA
  // Akka actors have ! ?

  //PREFIX notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !


  println(!mary)
  println(mary.unary_!)


  //POSTFIX notation [FUNCTION DOES NOT RECEIVE ANY PARAMETERS]
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
  1. OVERLOAD the + operator
  mary + "the rocktars" => new person "Mary (the rockstar)"

  2. Add an age to the Persom class
  Add a unary + operator => new person with the age + 1
  +mary => mary with the age incrementer

  ++
  3. Add a "learns" method in the Person class => "Mary learns Scala"
     Add a learnsScala method, calls learns method with "Scala".
    Use it in postfix notation.

  4. Overload the apply method
    mary.apply(2) => "Mary watched Inception 2 times"
  */

  println((mary + "The Rockstar")())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(10))

}
