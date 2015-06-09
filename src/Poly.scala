/**
 * Created by Jo on 27/01/2015.
 */

//structural recursion with polymorphism
sealed trait A {
  def foo: String = "It's an A!!!"
}

final case class B() extends A{
  override def foo: String = "It's a B!!!"
}

final case class C() extends A{
  override def foo: String = "It's a C!!!"
}

