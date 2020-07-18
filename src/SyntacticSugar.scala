import scala.language.postfixOps

object SyntacticSugar extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie) // overloading
    def unary_! : String = s"$name" // unary need to have space before :
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
    def learns(things: String) = s"$name is learning $things"
    def learnsScala = this learns "Scala"
  }

  println("-------------------------------------- Person.likes // infix notation")
  val mary = new Person("Marry", "Inception")
  // infix notation = operator notation (syntactic sugar) - only work with method with 1 parameter
  // object   method    parameter
  // mary     likes     "Inception"
  println(mary.likes("Inception"))
  println(mary likes "Inception") // Equivalent to above

  println("-------------------------------------- Person.hangOutWith Person.+(Person) // infix notation")
  val tom = new Person("Tom", "Flight Club")
  println(mary.hangOutWith(tom))
  println(mary hangOutWith tom)   // Equivalent to above
  println(mary.+(tom))
  println(mary + tom)             // Equivalent to above

  println("-------------------------------------- Person.+(String) // infix notation")
  println(mary.+("the Rockstar"))
  println(mary + "the Rockstar")             // Equivalent to above
  println((mary.+("the Rockstar")).apply())
  println((mary + "the Rockstar").apply())   // Equivalent to above

  println("-------------------------------------- General.+ // infix notation")
  // ALL OPERATORS ARE METHODS.
  println(1.+(2))
  println(1 + 2)                  // Equivalent to above

  println("-------------------------------------- Person.unary_- // prefix notation")
  // prefix only works with - + ~ !
  val y = 1.unary_-
  val x = -1                      // Equivalent to above
  println(y)
  println(x)

  println("-------------------------------------- General.unary_! // prefix notation")
  println(mary.unary_!)
  println(!mary)                  // Equivalent to above

  println("-------------------------------------- General.unary_+ // prefix notation")
  println(mary.unary_+)
  println(+mary)                  // Equivalent to above
  println((mary.unary_+).age)
  println((+mary).age)            // Equivalent to above

  println("-------------------------------------- Person.isAlive // postfix notation")
  // method with no parameter
  println(mary.isAlive)
  println(mary isAlive)           // Equivalent to above

  println("-------------------------------------- Person.apply()")
  println(mary.apply())
  println(mary())                 // Equivalent to above

  println("-------------------------------------- Person.apply(Int)")
  println(mary.apply(2))
  println(mary(2))                // Equivalent to above

  println("-------------------------------------- Person.learns Person.learnsScala")
  println(mary learns "Scala")
  println(mary learnsScala)
}
