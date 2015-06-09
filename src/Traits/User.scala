package Traits

import java.util.Date

/**
 * Created by Jo on 20/01/2015.
 */
//sealed trait with final classes once they extend the trait

sealed trait Visitor{ //note usual to use defs <-- use sealed trait (a bit like final)
  def id: String //unique id assigned to each user
  def createdAt: Date //date this user first visited the site

  //how long has the visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime

}

final case class User(
            id:String,
            email: String,
            createdAt: Date = new Date()) extends Visitor

final case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor


object Test{
  def main(args: Array[String]): Unit = {
    println(older(Anonymous("1"), User("2", "fred@goo")))
  }

  def older(v1: Visitor, v2: Visitor): Boolean =
    v1.createdAt.before(v2.createdAt)

  def missingCase(v: Visitor) =
    v match{
      case User(_,_,_) => "Got a user"
    }
}