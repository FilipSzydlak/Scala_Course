package lectures.part2oop

object ScalaObjects{

  //SCALA DOE NOT HAVE CLASS-LEVEL FUNCTIONALITY ("STATIC")
  //WE HAVE OBJECTS INSTEAD
  //objects do not receive parameters
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john) 

    // Scala object = SINGLETON INSTANCE
    val person1 = Person
    val person2 = Person
    println(person1 == person2)// the same object

    val bobbie = Person(mary, john)
  }
  object Person { // type + its only instance SINGLETON "single instance"
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
