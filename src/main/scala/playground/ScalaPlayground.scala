package playground

object ScalaPlayground extends App {

  //SCALA DOE NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")
  //WE HAVE OBJECTS INSTEAD
  //objects do not receive parameters

  object Person{ // type + its only instance SINGLETON
    val N_EYES = 2
    def canFly: Boolean = false
  }
  class Person

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john)// the same object
}
