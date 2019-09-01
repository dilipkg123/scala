/*
 (*) Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2
 */
object FindKthElementInList {

  def main(args: Array[String]): Unit = {
    val last = List(1, 2, 3, 4, 5, 6)
    val lastString = List("america", "africa", "asia", "australia")

    def findKthElementInList[T](k: Int, list: List[T]): T = (k, list) match {
      case (0, h :: _) => h
      case (n, _ :: tail) => findKthElementInList(n - 1, tail)
      case (_, Nil) => throw new NoSuchElementException
    }

    val result = findKthElementInList(2, lastString)
    println(result)
  }


}
