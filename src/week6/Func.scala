package week6

/**
 * Created by Jo on 12/02/2015.
 */
object Func {

  def part[A,B,C](a: A, fn: (A,B) => C): B => C =
    (b: B) => fn(a, b)

  /*def compose[A,B,C](f: B => C, g: A => B ): A => C =
    (a:A) => f(g(a))*/

  def compose[A <% Comparable[A], B <% Comparable[B], C <% Comparable[C]](f: B => C, g: A => B ): A => C =
    (a:A) => f(g(a))



  val a = 3
  val x = part(a, (a: Int, b:Int) => a + b)
  val add6 = part(6, (a: Int, b:Int) => a + b) //here 6 is frozen in to add6, ie you can freeze arguments

  println(x(6)) // now this always adds 3
  println(add6(6))

  val double = (x: Double) => 2.0 * x
  val squared = (x: Double) => x * x

  val y = double compose squared
  println(y(3))
}
