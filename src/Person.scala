/**
 * Created by Jo on 20/01/2015.
 */
case class Person(firstName: String, lastName: String)

object Stormtrooper{
  def inspect(p: Person): String =
    p match {
      case Person("Luke", "Skywalker") => "Stop!!!"
      case Person("Han", "Solo") => "Stop Solo"
      case Person(first, last) => s"Move along, $first"
    }
}
