package Factorial

import scala.annotation.tailrec

/**
 * Created by Jo on 24/02/2015.
 */
class Factorial extends App {

  //RECURSIVE VERSION: NOT TAIL RECURSIVE
  //def factorial(n: Int): Int =
  //  if (n == 0) 1
  //  else n * factorial(n - 1)

  def factorial(i: Int) = {
    @tailrec
    def fact(i: Int, acc:Int): Long = {
      if(i <= 1) acc
      else fact(i - 1, i * acc)
    }
    fact(i, 1)
  }

  (0 to 5) foreach (n => println(factorial(n)))
}
