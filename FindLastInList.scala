/*
(*) Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
 */
object FindLastInList {

  def main(args: Array[String]): Unit = {

    val last = List(1, 1, 2, 3, 5, 8)
    val lastString = List("dilip","gokul","amol")

    def findLast[A](x : List[A]) : A = x match {
      case h:: Nil => println(s"returning h and it is $h")
                      h
      case _ :: tail => println(s"didn't reach last of the list so returning $tail ")
                        findLast(tail)
      case _  => throw new NoSuchElementException
    }

    val answer  = findLast(lastString)
    println(s" last element of list $lastString is $answer")
  }
}
