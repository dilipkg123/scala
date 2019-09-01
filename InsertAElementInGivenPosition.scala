/*
// P21 (*) Insert an element at a given position into a list.
//     Example:
//     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
//     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

 */

object InsertAElementInGivenPosition {

  def insertAElement[A](positionToInsert:Int,elementToInsert:A,xs:List[A]) : List[A] = xs.splitAt(positionToInsert) match {
    case (pre, post) => pre ::: elementToInsert :: post
  }


  def main(args: Array[String]): Unit = {
    val beforeInsert = List("a","b","c","d")
    println(insertAElement(2,"new",beforeInsert))
  }

}
