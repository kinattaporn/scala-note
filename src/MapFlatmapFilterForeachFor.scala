object MapFlatmapFilterForeachFor extends App{
  val aList = List(1,2,3,4,5)
  println(aList)

  println("-------------------------------- List.map")
  println(aList.map(x => x + 10))
  println(aList.map(_ + 10))
  println(aList.map(x => x + " is a number"))
  println(aList.map(_ + " is a number"))
  val aList2 = aList.map { x =>
    x * 2 // not do this - syntax overload
    x * 3
  }
  println(aList2)

  println("-------------------------------- List.flatMap")
  println(aList.flatMap(x => List(x)))
  println(aList.flatMap(x => List(x, x+10, x+100)))

  println("-------------------------------- List.filter")
  println(aList.filter(x => x % 2 == 0))
  println(aList.filter(_ % 2 == 0))

  println("-------------------------------- List.foreach")
  aList.foreach(println)

  println("-------------------------------- List for-comprehensions")
  val forNoYield = for {
    x <- aList
  } println(x)
  println("forNoYield            " + forNoYield)
  val forWithYield = for {
    x <- aList
  } yield x
  println("forWithYield          " + forWithYield)
  val forWithYieldFilter = for {
    x <- aList if x % 2 == 0
  } yield x
  println("forWithYieldFilter    " + forWithYieldFilter)

  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")
  val forCombinations = for {
    n <- numbers
    c <- chars
    co <- colors
  } yield "" + c + n + "-" + co
  println("forCombinations       " + forCombinations)
  val forCombinationsFilter = for {
    n <- numbers if n % 2 == 0
    c <- chars
    co <- colors
  } yield "" + c + n + "-" + co
  println("forCombinationsFilter " + forCombinationsFilter)
}
