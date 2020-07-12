object ObjectOriented extends App {
  println("-------------------------------------- Person")
  val person = new Person("John", 26)
  //  println(person.name) // Error because NOT specific val in the class header
  println(person.age)
  println(person.x)
  person.greet("Danial")
  person.greet()
  println("-------------------------------------- Writer Novel")
  val author = new Writer("Ant", "Bird", 1991)
  val author2 = new Writer("Ant", "Bird", 1991)
  val novel = new Novel("Book1", 1997, author)
  println(author.fullName())
  println(novel.authorAge)
  println(novel.isWrittenBy(author))  // true
  println(novel.isWrittenBy(author2)) // false - even though the same data, author and author2 are not the same.
  println(novel.copy(1998))
  println("-------------------------------------- Counter")
  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(4).print
}

class Person(name: String, val age: Int) { // constructor
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = // method
    println(s"name defines at method header     -> this.name = ${this.name} / name = $name")
  def greet(): Unit = // overloading
    println(s"name NOT defines at method header -> this.name = ${this.name} / name = $name")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
class Writer(firstName: String, surName: String, val yearOfBirth: Int) {
  def fullName(): String = firstName + " " + surName
}
class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}
class Counter(val count: Int = 0) {
  def increment = {
    println("incrementing")
    new Counter(count + 1)
  }
  def decrement = {
    println("decrementing")
    new Counter(count - 1)
  }
  def increment(n: Int): Counter= {
    if (n <= 0) this
    else increment.increment(n-1)
    new Counter(count + n)
  }
  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n-1)
    new Counter(count - n)
  }
  def print = println(count)
}
