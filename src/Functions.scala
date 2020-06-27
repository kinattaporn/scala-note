object Functions extends App{
  def aFunction(a: String, b: Int): String = { // return String | ": String" can be omit when NOT recursive
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = {
    42
  }
  println(aParameterlessFunction()) // Can call in both way
  println(aParameterlessFunction)   // Can call in both way

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString)
  }
  aFunctionWithSideEffects("test")

  println("----------------------------- 2 functions")
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = {
      println("a:" + a + "   b:" + b)
      a + b
    }
    aSmallerFunction(n, n-1)
  }
  println(aBigFunction(8))

  println("----------------------------- Use recursive functions instead of loop in scala")
  def aRepeatedFunction(aString: String, n: Int): String = { // ": String" can NOT be omit when recursive
    if (n == 1) {
      println(aString + n) // need to be in a line before "aString + n" otherwise will return Unit
      aString + n
    }
    else {
      println(aString + n)
      aString + n + aRepeatedFunction(aString, n-1)
    }
  }
  aRepeatedFunction("hello",3)
}
