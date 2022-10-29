package lectures.part2oop

object ScalaObjects{

  //SCALA DOE NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")
  //WE HAVE OBJECTS INSTEAD
  //objects do not receive parameters
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john) // the same object

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie = Person(mary, john)
  }
  object Person { // type + its only instance SINGLETON "single instancwe"
    // static/class - level functionality
    val N_EYES = 2

    def canFly: Boolean = false
    //FACTORY METHOD
    def apply(morther: Person, father: Person) : Person = new Person("Bobbie")
  }

  class Person (val name:  String){
    // instance-level functionality
  }
  //COMPANIONS


  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit



}
