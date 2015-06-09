package structural.pm

/**
 * Created by Jo on 27/01/2015.
 */

// Feline --> Lion, tiger, Panther, or Cat
// PATTERN MATCHING

sealed trait Feline {
  def dinner: Food =
  this match{
    case Lion() => Antelope
    case Tiger() => TigerFood
    case Panther() => TigerFood
    case Cat(favFood) => CatFood(favFood)
  }
}

// 3. see below
object Diner{
  def dinner(feline: Feline): Food =
    feline match{
      case Lion() => Antelope
      case Tiger() => TigerFood
      case Panther() => TigerFood
      case Cat(favFood) => CatFood(favFood)
    }
}

final case class Lion() extends Feline
final case class Tiger() extends Feline
final case class Panther() extends Feline
final case class Cat(favFood: String) extends Feline

sealed trait Food
final case object Antelope extends Food
final case object TigerFood extends Food
final case class CatFood(food: String) extends Food


// 1. polymorphism
// 2. pattern matching on the base trait --> gives same result as no. 1.
// 3. take out of base trait and use an external object to do the matching

// So rule of thumb when choosing between methods 1 and 2;
//                Add a new method          Add new data
// Obj Oriented   change existing code      existing code is unchanged
// Funct Prog     existing code unchanged   change existing code
//                (cos sits outside of
//                  the class)

