object DataType extends App{
  println("--------------------------- String")
  val str: String = "Hello! I am learning Scala"
  // 01234567890123456789012345
  println(str.charAt(2))
  println(str.substring(7, 11)) // include 7, exclude 11
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.startsWith("hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.length)
  println(str.reverse)
  println(str.take(2))
  println("a" +: str :+ "z")
  println("aaa" +: str :+ "zzz")
  println('a' +: str :+ 'z')
  //  println('aaa' +: str :+ 'zzz') // error

  println("--------------------------- String -> Number")
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)

  println("--------------------------- Other Types")
  val aBoolean: Boolean = false
  println(aBoolean)
  val aChar: Char = 'a'
  println(aChar)
  val anInt: Int = 11
  println(anInt)
  val aShort: Short = 4613 // Number cannot too big.
  println(aShort)
  val aLong: Long = 5273985273895237L // Put L at the end.
  println(aLong)
  val aFloat: Float = 2.0f // Put f at the end.
  println(aFloat)
  val aDouble: Double = 3.14
  println(aDouble)
  val aUnit: Unit = println("hello, Scala") // Unit = void - not return anything just print or set variable

  println("--------------------------- S-interpolators")
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  println("--------------------------- F-interpolators")
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)
  // f is a format
  // %s is a String
  // %f is a float 2 characters total with min of 2 digits 1.2 -> 1.20

  println("--------------------------- raw-interpolators")
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
