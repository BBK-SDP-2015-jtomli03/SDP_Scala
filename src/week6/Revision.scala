package week6

/**
 * Created by Jo on 12/02/2015.
 */
object Revision  extends App{

  def factorial(n: Int) = {
    def helper(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else helper(n - 1, n * acc)

      helper(n, 1)
    }

    def abs(n:Int): Int =
      if(n < 0) -n
      else n

  /*private def prettyFactorialMsg(x: Int) = {
    s"The factorial of $x is ${factorial(x)}"
  }

  private def prettyAbsMsg(x: Int) = {
    s"The absolute value of $x is ${abs(x)}"
  }*/

  //higher order funtction
    private def prettyMsg(msg: String, x: Int, f: Int => Int ): String = {
      s"$msg $x is ${f(x)}"
  }

  //println(prettyFactorialMsg(5))
  //println(prettyAbsMsg(-1))
  println(prettyMsg("The factorial of ", 5, factorial))
  println(prettyMsg("The absolute value of ", -1, abs))

}
