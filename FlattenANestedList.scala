/*
(**) Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

class FlattenANestedList {

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] =>
      println(s"$ms   $List[_].toString")
      flatten(ms)
    case e =>
      println(s"e is $e")
      List(e)
  }

}

object FlattenANestedList{
  def main(args: Array[String]): Unit = {
    val flattenANestedList = new FlattenANestedList()
    val nestedList = List(List(1,2,3),List(4,5,6))
    val flatList = flattenANestedList.flatten(nestedList)

    println(flatList)

  }
}
