package Traits

/**
 * Created by Jo on 20/01/2015.
 */
sealed trait Shape {
  //sides - returns the number of sides
  def sides: Int
  //perimeter - returns the total length of the sides
  def perimeter: Double
  // area returns area
  def area: Double
}
//implement Shape with three classes Circle, Rectangle, Square
//appropriate parameters in cons eg, radius for a circle
//pi -> math.Pi

final case class Circle(radius: Double) extends Shape{
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

/*case class Rectangle(width: Double,
                  height: Double) extends Shape {
  val sides = 4
  val perimeter = 2 * (width + height)
  val area = width * height
}

case class Square(size: Double) extends Shape{
  val sides = 4
  val perimeter = 4 * size
  val area = size * size
} --> rectangle and square similar therefore use trait below*/

trait Rectangular extends Shape{
  def width: Double
  def height: Double
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Square(size: Double) extends Rectangular{
  val width = size
  val height = size
}

case class Rectangle(width: Double, height: Double) extends Rectangular
//seal Shape
//singleton Draw apply method which takes Shape -> prints out description

object Draw{
  def apply(s: Shape) =
    s match {
      case Rectangle(width, height) => println(s"A rectangle with width ${width}")
      case Square(size) => println(s"A square with side ${size}")
      case Circle(radius) => println(s"A circle with radius ${radius}")
      case _ => println("Some other shape")
    }
}