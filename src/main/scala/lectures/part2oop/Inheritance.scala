package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  // private - method can't ne inherited
  // protected - method can be used in subclass but it can not be used directly("car.eat")
  sealed class Animal {
    val creatureType ="wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch // inherits only non private fields of its superclass (Animal)


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name) //extending class with parametgers

  // overriding
  class Dog (override val creatureType: String = "domestic") extends Animal {
    // override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution (broad : polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat


  // overRiding vs overLoading

  // super

  //preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE. prevents extention in other files

}
