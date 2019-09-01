/*
(*) Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 */

object GenerateListForGivenRange {

  def rangeRecursive(start:Int,end:Int) : List[Int] =
    if (start > end) Nil
    else start :: rangeRecursive(start+1,end)

  // Tail recursive.
  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    def rangeR(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else rangeR(end - 1, end :: result)
    }
    rangeR(end, Nil)
  }

  /*
   1. else => rangeR(7,8::Nil)
   2. else => ranceR(6,(7,8))
   3. else => ranceR(5,(6,7,8)
   4. else => ranceR(4,(5,6,7,8)
   5. else => rangeR(3,(4,5,6,7,8))
   6. if => return (4,5,6,7,8)
   */

  // The classic functional approach would be to use `unfoldr`, which Scala
  // doesn't have.  So we'll write one and then use it.

  //TODO: revisit... I have brush up currying and option in scala.
  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
    f(s) match {
      case None         => Nil
      case Some((r, n)) => r :: unfoldRight(n)(f)
    }
  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }

  /*
    1. unfold(Some((4,5)))
    2.
   */

  def main(args: Array[String]): Unit = {
    println(" rance recursive"+ rangeRecursive(4,8))
    println(" tail recursive "+ rangeTailRecursive(4,8))
    println(" functional "+ rangeFunctional(4,8))
}


}