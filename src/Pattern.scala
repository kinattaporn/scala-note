import scala.util.Random

object Pattern extends App {
  println("constants -------------------------------------- ")
  val x: Any = "Scala" // Use Any because case has all data types
  val constants1 = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case Pattern => "A singleton object"
  }
  println(constants1)
  val y: Any = true
  val constants2 = y match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "THE Truth"
    case Pattern => "A singleton object"
  }
  println(constants2)

  val z: Int = 4
  val isEven = z match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  println(isEven)
  val isEvenCond = if (z % 2 == 0) true else false
  println(isEvenCond)
  val isEvenNormal = z % 2 == 0
  println(isEvenNormal)

  println("if no case match, error -> require wildcard ---- ")
//  val matchAnything1 = x match {
//    case "Scalaaaa" => "matchScalaaaa"
//  }
//  println(matchAnything1)

  val matchAnything2 = x match {
    case "Scalaaaa" => "matchScalaaaa"
    case _ => "match_"
  }
  println(matchAnything2)

  println("something -------------------------------------- ")
  val matchAVariable = x match {
    case something => s"something $something"
  }
  println(matchAVariable)

  println("tuples ----------------------------------------- ")
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"something $something"
  }
  println(matchATuple)

  // PMs can be NESTED!
  val nestedTuple = (1, (2, 3))
  val matchANestedTuple1 = nestedTuple match {
    case (5, (2, v)) => "match5"
    case (_, (2, v)) => "match_"
  }
  println(matchANestedTuple1)

  val matchANestedTuple2 = nestedTuple match {
    case (1, (2, 3)) => "match3"
    case (_, (2, v)) => "match_"
  }
  println(matchANestedTuple2)

  println("list patterns ---------------------------------- ")
  val aStandardList = List(1,2,3,42)
  val standardListMatching1 = aStandardList match {
    case List(1, _, _, _) => "match"
  }
  println(standardListMatching1)

  val standardListMatching2 = aStandardList match {
    case 1 :: List(_) => "match"
    case _ => "not match"
  }
  println(standardListMatching2)

  val standardListMatching3 = aStandardList match {
    case 1 :: List(_, _, _) => "match"
    case _ => "not match"
  }
  println(standardListMatching3)

  val standardListMatching4 = aStandardList match {
    case List(1,2,3) :+ 42 => "match"
  }
  println(standardListMatching4)

  val standardListMatching5 = aStandardList match {
    case List(1, _*) => "match"
  }
  println(standardListMatching5)

  println("list mapping ----------------------------------- ")
  val mappedList = aStandardList.map {
    case v if v % 2 == 0 => v + "_is_even"
    case 1 => "one"
    case _ => "something_else"
  } // partial function literal
  println(mappedList)
  val mappedList2 = aStandardList.map { x => x match { // mappedList2 same as mappedList above
    case v if v % 2 == 0 => v + "_is_even"
    case 1 => "one"
    case _ => "something_else"
  }}
  println(mappedList2)

  println("type matching ---------------------------------- ")
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "explicit type specifier"
    case _ => "not match"
  }
  println(unknownMatch)

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }
  println(numbersMatch)
  // JVM trick question

  println("cases are matched in order --------------------- ")
  val numbersMatch2 = numbers match {
    case listOfNumbers: List[Int] => "a list of numbers"
    case listOfStrings: List[String] => "a list of strings"
    case _ => ""
  }
  println(numbersMatch2)

  println("class ------------------------------------------ ")
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"name $n age $a (< 21)"
    case Person(n, a) => s"name $n age $a (>= 21)"
    case _ => "no name no age"
  }
  println(greeting)

  val cat = Person("Cat", 30)
  val greeting2 = cat match {
    case Person(n, a) if a < 21 => s"name $n age $a (< 21)"
    case Person(n, a) => s"name $n age $a (>= 21)"
    case _ => "no name no age"
  }
  println(greeting2)

  val dan = Person("Dan", 40)
  val greeting3 = dan match {
    case Person(n, _) => s"name $n age any"
  }
  println(greeting3)
}
