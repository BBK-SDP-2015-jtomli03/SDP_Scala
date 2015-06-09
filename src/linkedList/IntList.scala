package linkedList

/**
 * Created by Jo on 03/02/2015.
 */
sealed trait IntList{

  def map(fn: Int => Int): IntList =
    this match {
      case EndOfList => EndOfList
      case Node(hd, tl) => Node(fn(hd), tl.map(fn))
    }

 /*def length: Int =
   this match{
     case EndOfList => 0
     case Node(hd, tl) => 1 + tl.length
   }

 def double: IntList =
   this match{
     case EndOfList => EndOfList
     case Node(hd, tl) => Node(hd * 2, tl.double)
   }

 def sum: Int =
   this match {
     case EndOfList => 0
     case Node(hd, tl) => hd + tl.sum
   }*/

  def length: Int =
    abstraction[Int](0, (_, tl) => 1 + tl) //note here the placeholder _ can be used instead of hd as hd is not used

  def sum: Int =
    abstraction[Int](0, (hd, tl) => hd + tl)

  def double: IntList =
    abstraction[IntList](EndOfList, (hd, tl) => Node(hd * 2, tl))


 /* (params) -> body  //these are lambda expressions in java, in scala they are called function literals
     NOTE; this method of abstraction is known as fold. It is a standard pattern of functional programming
            there's fold left and fold right, eg.

   def fold[T](end: T, f: (Int, T) => T): T =
    this match {
    case EndOfList => end
    case Node(hd, tl) => f(hd, tl.abstraction(end, f))
 }

 NOTE; folding, mapping, reducing and zipping are all standard patterns of fold*/
 def abstraction[T](end: T, f: (Int, T) => T): T =
 this match {
   case EndOfList => end
   case Node(hd, tl) => f(hd, tl.abstraction(end, f))
 }
}

 final case object EndOfList extends IntList
 final case class Node(head: Int, tail: IntList) extends IntList

object Test extends App {
 val l = Node(1, Node(2, Node(3, EndOfList)))
  //println(sum(l))
  println(l.sum)
  println(l.length)
  println(l.double)
  println(l.map((x => x * 2)))

 /*def sum(list: IntList): Int =
   list match {
     case EndOfList => 0
     case Node(hd, tl) => hd + sum(tl)    //unapply method takes what makes the component and turns it into songle components
   }                                     //not tail recursive -> has to stack things therefore over a long time ++stack!*/

 import scala.annotation.tailrec //can put import here so only imported for this method

 @tailrec //note imports scala.annotation.tailrec
 def sum(list: IntList, total: Int = 0): Int =
   list match {
     case EndOfList => total
     case Node(hd, tl) => sum(tl, hd + total) //can usually change a non-tail recursive function to tail recursive with addition of a helper function
   }



}




