object Inheritance extends App {
  class Animal { // Super-class
    val creatureType = "wild"
    def eat = println("animal-eat")
    private def eat_private = println("animal-eat-private")
    protected def eat_protected = println("animal-eat-protected")
  }
  println("-------------------------------------- Inheritance")
  class Cat extends Animal { // Sub-class
    // single class inheritance - can extends 1 class at a time
    def crunch = {
      eat
      println("cat-eat")
    }
  }
  val cat = new Cat
  cat.eat
  //  cat.eat_private    // cannot call like this since method is private
  //  cat.eat_protected  // cannot call like this since method is protected but can call inside class
  cat.crunch           // can call eat inside class Cat which extends Animal

  println("-------------------------------------- Constructors")
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult1(name: String, age: Int, idCard: String) extends Person(name, age)
  class Adult2(name: String, age: Int, idCard: String) extends Person(name) // Because age default = 0

  println("-------------------------------------- Overriding Way1")
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat = println("dog-eat")
  }
  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  println("-------------------------------------- Overriding Way2")
  class Dog2(override val creatureType: String) extends Animal {
    override def eat = println("dog2-eat")
  }
  val dog2 = new Dog2("K9")
  dog2.eat
  println(dog2.creatureType)

  println("-------------------------------------- Overriding Way3")
  class Dog3(dogType: String) extends Animal {
    override val creatureType = dogType
    override def eat = println("dog3-eat")
  }
  val dog3 = new Dog3("K10")
  dog3.eat
  println(dog3.creatureType)

  println("-------------------------------------- type substitution (broad: polymorphism)")
  val unknownAnimal: Animal = new Dog3("K10")
  unknownAnimal.eat           // From Dog3
  println(dog3.creatureType)  // From Dog3

  println("-------------------------------------- Super")
  class AnimalSuper {
    def eat_super = println("animal-super-eat")
  }
  class DogSuper(dogType: String) extends AnimalSuper {
    override def eat_super = super.eat_super
  }
  val dog_super = new DogSuper("K11")
  dog_super.eat_super

  println("-------------------------------------- Preventing overrides1 - use final on member")
  class AnimalSuper1 {
    final def eat_super = println("animal-super-eat")
  }
  class DogSuper1(dogType: String) extends AnimalSuper1 {
    //    override def eat_super = super.eat_super // cannot override final member
  }
  val dog_super1 = new DogSuper1("K11")
  dog_super1.eat_super

  println("-------------------------------------- Preventing overrides2 - use final on the entire class")
  final class AnimalSuper2 {
    def eat_super = println("animal-super-eat")
  }
  //  class DogSuper2(dogType: String) extends AnimalSuper2 { // cannot extend from final class
  //    override def eat_super = super.eat_super
  //  }
  val dog_super2 = new AnimalSuper2
  dog_super2.eat_super

  println("-------------------------------------- Preventing overrides3 - seal the class = can extend classes in THIS FILE, prevent extension in other files")
  sealed class AnimalSuper3 {
    def eat_super = println("animal-super-eat")
  }
  class DogSuper3(dogType: String) extends AnimalSuper3 {
    override def eat_super = super.eat_super
  }
  val dog_super3 = new DogSuper3("K11")
  dog_super3.eat_super
}
