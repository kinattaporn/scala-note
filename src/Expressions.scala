object Expressions extends App{
  println("--------------------- x")
  val x = 1 + 2
  println(x)

  println(1 == x)
  println(1 != x)
  println(!(1 == x))

  println("--------------------- aVariable")
  var aVariable = 2
  println(aVariable)
  aVariable += 2
  println(aVariable)

  println("--------------------- aWeirdValue")
  println(aVariable == 4)
  val aWeirdValue4 = (aVariable = 4) // Unit === void (don't return anything)
  println(aWeirdValue4)

  println("--------------------- aCondition")
  val aCondition = false
  val aConditionedVal = if(aCondition) 5 else 3 // IF is EXPRESSION
  println("aCondition " + aCondition)
  println("aConditionedVal " + aConditionedVal)

  println("--------------------- aCodeBlock")
  val aCodeBlock1 = {
    if (aCondition) 55
    33
  }
  println(aCodeBlock1)

  val aCodeBlock2 = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock2)

  println("--------------------- someValue")
  val someValue = {
    2 < 3 // type = Boolean
  }
  println(someValue)

  println("--------------------- someOtherValue")
  val someOtherValue = {
    if(someValue) 239 else 986
    42 // result = the last one, type = Int
  }
  println(someOtherValue)

  println("--------------------- while")
  var i = 0
  //  while (i < 10) { // Do NOT use while in Scala
  val aWhile = while (i < 10) { // EVERYTHING in Scala is an Expression!
    println(i)
    i += 1
  }
  // Expression - Give me a value of something
  // Instruction - Do something
  // The difference between "hello world" vs println("hello world")?
  // "hello world" is a value of type String -> type = String
  // println("hello world") is expression -> type = Unit
}
