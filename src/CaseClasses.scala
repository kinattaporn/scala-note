object CaseClasses extends App {
  case class Person(name: String, age: Int)
  class PersonClass1(name: String, age: Int)
  class PersonClass2(val name: String, age: Int)

  println("---------------------------- 1. class parameters are fields")
  val jim = new Person("Jim", 34)
  println(jim.name)

  val jim_class1 = new PersonClass1("Jim", 34)
  //  println(jim_class1.name) // error need val
  val jim_class2 = new PersonClass2("Jim", 34)
  println(jim_class2.name)

  println("---------------------------- 2. sensible toString")
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  println("---------------------------- 3. equals and hashCode implemented Out Of The Box")
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // case class - true

  val jim_class3 = new PersonClass1("Jim", 34)
  println(jim_class1 == jim_class3) // class - false
  val jim_class4 = new PersonClass2("Jim", 34)
  println(jim_class2 == jim_class4) // class - false

  println("---------------------------- 4. Case Classes have handy copy method")
  val jim3 = jim.copy(age = 45)
  println(jim3)

  println("---------------------------- 5. Case Classes have companion objects")
  val thePerson = Person
  val mary = Person("Mary", 23) // no need to have new
  println(mary)

  println("---------------------------- 6. Case Classes are serializable")

  println("---------------------------- 7. Case Classes have extractor patterns = CCs can be used in PATTERN MATCHING")

  println("---------------------------- 8. Case Object")
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
