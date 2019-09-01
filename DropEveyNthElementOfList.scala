/*
(**) Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */

object DropEveyNthElementOfList {

  // recursive
  def dropEveryNthEleRec[T](elementToDrop: Int,xs:List[T]) : List[T] =
  {
    def dropR(c: Int,curList: List[T]) : List[T] = (c,curList) match {
      case (_,Nil) => println(s"in 1st pattern and curlist = $curList and xs = $xs")
                      Nil
      case (1,h::tail) => println(s"in 2nd pattern $tail and curlist = $curList  and xs = $xs")
                          dropR(elementToDrop,tail)
      case (_,h::tail) => println(s"in 3rd pattern $tail and $h and curlist = $curList  and xs = $xs")
                          h :: dropR(c-1,tail)
    }
//    println(s"before calling xs = $xs")
    val a = dropR(elementToDrop,xs)
//    println(s"after calling xs = $a")
    a
  }

  // Tail Recursive 12/28/19 7:17 AM
  def dropEveryNthElemTailRec[T](elementToDrop:Int, xs: List[T]) : List[T] = {
    def dropTailR(result: List[T],c:Int, curList: List[T]) : List[T] = (c,curList) match {
      case (_,Nil) => println(s"in 1st pattern and curlist = $curList and xs = $xs");result.reverse
      case (1, _::tail) => println(s"in 2nd pattern $tail and curlist = $curList  and xs = $xs"); dropTailR(result,elementToDrop,tail)
      case (_,h::tail) => println(s"in 3rd pattern $tail and $h and curlist = $curList  and xs = $xs"); dropTailR(h::result,c-1,tail)
    }
    dropTailR(Nil,elementToDrop,xs)
  }

  // Functional
  def dropFunctional[A](n: Int, ls: List[A]): List[A] =
    ls.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }

  def main(args: Array[String]): Unit = {
    val beforeDrop = List(1,2,3,4,5,6,7,8,9)
    println(dropEveryNthEleRec(3,beforeDrop))
    println("tail recursive result"+ dropEveryNthElemTailRec(3,beforeDrop))
    println("functional result is "+dropFunctional(3,beforeDrop))
  }

}
