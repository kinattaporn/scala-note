object ValVar extends App{
  println("----------------------- val")
  val l = 1
  println(l)
  //  l = 2 // error - val canNOT reassigned value.
  val l2 = 2
  println(l2) // Types of val are optional.
  println("----------------------- var")
  var r = 1
  println(r)
  r = 2 // var can reassigned value with side effects (display something on the screen).
  println(r)
  println("----------------------- 2 lines")
  val x = 1; val y = 2; // ; NOT require in 1 line of code BUT require when connect many lines of code together.
  println(x)
  println(y)
}
