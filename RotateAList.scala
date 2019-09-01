/*
(**) Rotate a list N places to the left.
Examples:
scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 */
object RotateAList {

  def rotate[A](positionToRotate:Int,xs: List[A]) : List[A] = {
    val nBounded = if (xs.isEmpty) 0 else positionToRotate % xs.length
    if (nBounded < 0) rotate(nBounded + xs.length, xs)
    else (xs drop nBounded) ::: (xs take nBounded)
  }


  /*
    execution steps:
   in case of positive rotate
    1. nBounded = 0
    2. else split the list into 2 and :::
   in case of negative rotate (-2)
    1. nBounded = -2
    2. rotate(-2+6,"a,b,c,d,e,f")
    3. else will be called to split xs drop 4 (e,f) xs take 2 (a,b,c,d) = c,d,e,f,a,b
   */

  def main(args: Array[String]): Unit = {
    val beforeRotate = List("a","b","c","d","e","f")
    println(" after rotate "+rotate(2,beforeRotate))
    println(" after rotate "+rotate(-2,beforeRotate))

  }

}
