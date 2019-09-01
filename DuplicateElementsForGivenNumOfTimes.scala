/*
(**) Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 */

object DuplicateElementsForGivenNumOfTimes {

  def duplicateForNumberOfTimes[T](n:Int,xs:List[T]) : List[T] =
    xs flatMap { List.fill(n)(_) }

  def main(args: Array[String]): Unit = {
    val beforeDup = List("a","b")

    println(duplicateForNumberOfTimes(4,beforeDup))

    println(List(1,2,3,4) flatMap( List.fill(5)(_)))
  }
}
