package exercises

abstract class MyList[+A] {

  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
  */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  //polymorphic call
  override def toString: String = "[" + printElements + "]"

  // higher-order functions - receive other functions as parameter or return them as result
  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def forEach(f: A => Unit): Unit

  def sort (compare: (A,A) => Int): MyList[A]

  def zipWith [B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()

  def tail: MyList[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  // hofs
  def forEach(f: Nothing => Unit): Unit = ()

  def sort (compare: (Nothing,Nothing) => Int) = Empty

  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if(!list.isEmpty) throw new RuntimeException(("List odes not have the same length"))
    else Empty
  }

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"


  /*
  [1,2,3].filter(n % 2 == 0) =
    [2,3].filter(n %2 == 0) =
    = new Cons(2, [3].filter(n % 2 == 0))
    = new Cons(2, Empty.filter(n % 2 == 0))
    = new Cons(2, Empty)
  */


  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
   [1,2,3].map(n * 2)
     = new Cons(2, [2,3].map(n * 2))
     = new Cons(2, new Cons (4, [3].map(n * 2)))
     = new Cons(2, new Cons (4, new Cons(6, Empty.map(n * 2))))
     = new Cons(2, new Cons (4, new Cons(6, Empty))
  */
  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  /*
  [1,2] ++ [3,4,5]
  = new Cons(1, [2] ++ [3,4,5])
  = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new cons(5)))))
  */

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /*
  [1,2].flatMap (n => [n, n+1])
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
  */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  //hofs
  def forEach(f: A => Unit): Unit = {
    f(h)
    tail.forEach(f)
  }

  //do the tail recursion next time!!!!!!
  def sort(compare: (A, A) => Int): MyList[A] = {

    def insert(x: A, sortedList: MyList[A]): MyList[A]= {
      if(sortedList.isEmpty) new Cons(x,Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
 /* override def sort( f: (A, A) => Int ): MyList[ A ] = {
    @tailrec
    def insert( sortedTail: MyList[ A ], currentList: MyList[ A ] ): MyList[ A ] = {
      if( sortedTail.isEmpty ) currentList ++ Node( head, EmptyList )
      else if( f( head, sortedTail.head ) > 0 ) insert( sortedTail.tail, currentList ++ Node( sortedTail.head, EmptyList ) )
      else currentList ++ Node( head, EmptyList ) ++ sortedTail
    }

    val sortedTail = tail.sort( f )
    insert( sortedTail, EmptyList )
  }
 */

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if(list.isEmpty) throw new RuntimeException(("List odes not have the same length"))
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  /*
   [1,2,3].fold(0)(+) =
   [2,3].fold(1)(+)=
    [3].fold(3)(+)=
    [].fold(6)(+)
    6
  */
  def fold[B](start: B)(operator: (B, A) => B): B ={
    t.fold(operator(start, h))(operator)
  }
}


object ListTest extends App {
  val listOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfInteger: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfInteger: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfInteger.toString)
  println(listOfStrings.toString)

  println(listOfInteger.map(_ * 2).toString)

  println(listOfInteger.filter(_ % 2 == 0).toString)

  println((listOfInteger ++ anotherListOfInteger).toString)
  println(listOfInteger.flatMap(elem =>  new Cons(elem, new Cons(elem + 1, Empty))).toString)

  println(cloneListOfInteger == listOfInteger)

  //hof
  listOfInteger.forEach(println)
  println(listOfInteger.sort((x, y) => y - x))
  println(anotherListOfInteger.zipWith(listOfStrings, _ + "-" + _))
  println(listOfInteger.fold(0)(_+_))

  //for comprehensions
 val combinations =  for{
    n<- listOfInteger
    string<- listOfStrings
  }yield n + "-" + string
  println(combinations)
}
