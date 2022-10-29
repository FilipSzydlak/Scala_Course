package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  // traits -  can be inherited along the classes
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {//multiple iheritance
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and i'm eating ${animal.creatureType}")
  }

  val dog =  new Dog
  val croc =  new Crocodile
  croc.eat(dog)

  // traits vs AbstractClasses
  // abstract classes and traits can have abstract and non abstract member
  // 1- traits do not have constructor parameters
  // 2- multiple traits may be inherited by the same class
  // 3 - traits = BEHAVIOR, abtract class = THING
}
