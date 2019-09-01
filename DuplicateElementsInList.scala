/*
(*) Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */
object DuplicateElementsInList {

  def duplicateElementInList[T](xs: List[T]) : List[T] =
    xs flatMap { e=> List(e,e)}

  def main(args: Array[String]): Unit = {
    val beforeDuplicate = List("a","b","c","d")

    println(duplicateElementInList(beforeDuplicate))

    println(List(1,2,3,4) flatMap(e=> List(e,e)))
  }
}
