/*
 (*) Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5
 */

object FindLastButOneInList {

  def main(args: Array[String]): Unit = {

    val last = List(1, 1, 2, 3, 5, 8)
    val lastString = List("dilip", "gokul", "amol","anuj")

        def findLastButOne[A](x : List[A]) : A = x match {
      case h:: _ :: Nil => println(s"returning h and it is $h")
                           h
      case _ :: tail => println(s"didn't reach last of the list so returning $tail ")
                        findLastButOne(tail)
      case _  => throw new NoSuchElementException
    }

    def lastNthRecursive[A](n: Int, ls: List[A]): A = {
      def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
        curList match {
          case Nil if count > 0 => throw new NoSuchElementException
          case Nil => println(s"the list is Nil returning ${resultList.head} ")
                      resultList.head
          case _ :: tail =>
            println(s"resultList = $resultList -- resultList.tail = ${resultList.tail} -- and tail = $tail")
            lastNthR(count - 1, if (count > 0) resultList else resultList.tail, tail)
        }

      if (n <= 0) throw new IllegalArgumentException
      else lastNthR(n, ls, ls)
    }

//    val answer = lastNthRecursive(1, lastString)
    val answer = findLastButOne(lastString)
    println(s" last element of list $lastString is $answer")
  }
}
