package week6

import scala.annotation.tailrec

/**
 * Created by Jo on 12/02/2015.
 */
// T extends xxxx
// T extends ?     <:   <-- notations instead of comparable (in java)
// T super ?       >:
// Student extends Person
// Pair[Student] <=> Pair[Person]
// <% known as a view bound

//polymorphic functions
object Polymorphic extends App{

  /*def findFirst(as: Array[String], value: String): Int = {
    @tailrec
    def helper(n: Int): Int =
      if(n >= as.length) -1
      else if(as(n) == value) n
      else helper(n + 1)

    helper(0)
  }*/

//above function made generic (polymorphic) --> DISADVANTAGE of generics -- compiled at runtime
  def findFirst[T](as: Array[T], value: T): Int = {
    @tailrec
    def helper(n: Int): Int =
      if(n >= as.length) -1
      else if(as(n) == value) n
      else helper(n + 1)

    helper(0)
  }

  //T <: Comparable[T] <-- here we're saying that our type T has to implement comparable
  //  def isSorted[T <: Comparable[T]](as: Array[T], gt: (T,T) => Boolean): Boolean = {
  // T <% Comparable[T] this means follow the implicit trail
  def isSorted[T <% Comparable[T]](as: Array[T], gt: (T,T) => Boolean): Boolean = {
    def helper(n: Int): Boolean =
    if (n >= as.length -1) true
    else if (gt(as(n), as(n+1))) false
    else helper(n+1)

    helper(0)
  }

  //def gt(x: Int, y: Int): Boolean =
  //  x > y

  //genericised
  //def gt[T](x: T, y: T): Boolean =
  //  x > y


  println(findFirst(Array("1", "23", "4", "5", "6"), "12"))
  println(findFirst(Array(1, 23, 4, 5, 6), 5))

  println(isSorted(Array(3, 2, 1), gt))
  println(isSorted(Range(1, 10).toArray, gt))
  println(isSorted(Array(3, 2, 1), (a: Int, b: Int) => a > b))





}
