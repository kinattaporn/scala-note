object Collection extends App {
  println("-------------------------------- Seq")
  val aSequence = Seq(1,3,2,4)
  println("aSequence original " + aSequence)
  println("aSequence sorted   " + aSequence.sorted)
  println("aSequence reverse  " + aSequence.reverse)
  println("aSequence[2]       " + aSequence(2)) // index 2 -> begin with index 0
  println("aSequence concat")
  println(aSequence ++ Seq(7,5,6))
  println("Seq -> String")
  println(aSequence.mkString(" "))

  println("-------------------------------- List")
  val aList = List(1,3,2,4)
  println("aList original " + aList)
  println("aList sorted   " + aList.sorted)
  println("aList reverse  " + aList.reverse)
  println("aList[2]       " + aList(2)) // index 2 -> begin with index 0
  println("aList concat")
  println(5 +: aList :+ 6)
  println("List -> String")
  println(aList.mkString(" "))
  println("head           " + aList.head)
  println("tail           " + aList.tail)
  println("create list with length 3")
  val apples3 = List.fill(3)("apple")
  println(apples3)

  println("-------------------------------- Vector")
  val aVector: Vector[Int] = Vector(1,3,2,4)
  println(aVector)

  println("-------------------------------- Tuple = finite ordered list")
  val aTuple = (2, "hello Scala")
  println("aTuple      " + aTuple)
  println("aTuple._1   " + aTuple._1)
  println("aTuple._2   " + aTuple._2)
  println("aTuple copy " + aTuple.copy(_1 = 3))
  println("aTuple copy " + aTuple.copy(_2 = "goodbye Java"))
  println("aTuple      " + aTuple)
  println("aTuple swap " + aTuple.swap)

  println("-------------------------------- Map: keys -> values")
  val aMap = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)) // a -> b is sugar for (a, b)
  println("aMap                  " + aMap)
  println("aMap contains         " + aMap.contains("Jim"))
  println("aMap NOT contains     " + aMap.contains("Mary"))
  println("aMap in keys          " + aMap("Jim"))
//  println("aMap NOT in keys      " + aMap("Mary")) // error key not found: Mary
  val aMap2 = aMap + ("Mary" -> 678)
  println("aMap2                 " + aMap2)
  println("aMap2 edit            " + aMap2.map(x => x._1 + "aaa" -> x._2))
  println("aMap2 keys cannot dup " + aMap2.map(x => x._1.toLowerCase -> x._2))
  println("aMap2 are IMmutable   " + aMap2)
  println("Map -> List           " + aMap2.toList)
  println("List -> Map           " + List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(x => x.charAt(0)))

  println("-------------------------------- Array")
  val anArray = Array(1,3,2,4)
  println("anArray " + anArray)
  println("anArray original")
  anArray.foreach(println)
  println("anArray sorted")
  anArray.sorted.foreach(println)
  println("anArray reverse")
  anArray.reverse.foreach(println)
  println("anArray[2] " + anArray(2)) // index 2 -> begin with index 0
  println("anArray concat")
  (anArray ++ Array(7,5,6)).foreach(println)
  println("anArray update - arrays are mutable")
  anArray.update(2, 11)
  anArray.foreach(println)
  println("anArray update - arrays are mutable")
  anArray(3) = 15 // syntax sugar for anArray.update(3, 15)
  anArray.foreach(println)
  println("Array -> String")
  println(anArray.mkString(" "))
  println("create array with length 3")
  val threeElementsString = Array.ofDim[String](3)
  threeElementsString.foreach(println)
  val threeElementsInt = Array.ofDim[Int](3)
  threeElementsInt.foreach(println)

  println("-------------------------------- Arrays -> ArraySeq conversion")
  println("aSequence    " + aSequence)
  println("anArray")
  println(anArray)
  anArray.foreach(println)
  val anArrayToSeq: Seq[Int] = anArray  // implicit conversion
  println("anArrayToSeq " + anArrayToSeq)

  println("-------------------------------- Range")
  val aRange: Seq[Int] = 1 until 10
  println("aRange original " + aRange)
  aRange.foreach(println)
  println("aRange until - NOT include last")
  (1 until 5).foreach(x => println("Hello" + "-" + x))
  println("aRange to - include last")
  (1 to 5).foreach(x => println("Hello" + "-" + x))

}
