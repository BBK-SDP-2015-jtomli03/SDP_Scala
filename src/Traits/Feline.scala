package Traits

/**
 * Created by Jo on 27/01/2015.
 */

// Feline --> Lion, tiger, Panther, or Cat
sealed trait Feline {
  def dinner: Food
}
final case class Lion() extends Feline{
  def dinner: Food = Antelope
}
final case class Tiger() extends Feline{
  def dinner: Food = TigerFood
}
final case class Panther() extends Feline{
  def dinner: Food = TigerFood
}
final case class Cat(favFood: String) extends Feline{
  def dinner: Food = CatFood(favFood)
}

sealed trait Food
final case object Antelope extends Food
final case object TigerFood extends Food
final case class CatFood(food: String) extends Food

//advantages of polymorphic approach --> easy to extend the available classes, but repetitive

