package lectures.part2oop

object Generics extends App{

  class MyList[+A]{
    // use the type A

    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
    */
  }

  class MyMap[Key, Value]

  val listOfIntegers =  new MyList[Int]
  val listOfStrings =  new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A]= ???
  }
  val emptyListOfInteger = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes List[Cat] extends List[Animal = COVARIANCE [IHERITANCE]
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION. => RETURN  A LIST OF ANIMALS
  // turns a cat list to animal list

  //2. NO = INVARIANCE [ CAN NOT INHERIT]
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, no! CONTRAVARIANCE [INVERSE INHERITANCE]
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types
  //subtype
  class Cage [A <: Animal](animal : A)
  val cage = new Cage(new Dog)


  //Expand MyList to be generic
}
