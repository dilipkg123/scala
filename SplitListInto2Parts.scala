/*
(*) Split a list into two parts.
The length of the first part is given. Use a Tuple for your result.
Example:

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 */
object SplitListInto2Parts {

  def splitInto2Part[A] (splitSize:Int,xs:List[A]) : (List[A],List[A]) = (splitSize,xs) match {
    case (_,Nil) => (Nil,Nil)
    case (0,dilip) => (Nil,dilip)
    case (n,h::tail) => {
      val (pre,post) = splitInto2Part(n-1,tail)
      (h::pre,post)
    }

  }

  def splitTailRecursive[A](splitSize:Int,xs:List[A]) : (List[A],List[A]) = {
    def splitR[A](curN: Int,curL: List[A],pre: List[A]) : (List[A],List[A]) = {
      (curN,curL) match {
        case (_,Nil) => (pre.reverse,Nil)
        case (0,list) => (pre.reverse,list)
        case (n,h::tail) => splitR(n-1,tail,h::pre)
      }
    }
    splitR(splitSize,xs,Nil)
  }

  /*
     tail recursion:
       first time: 3rd case will be executed and the splitR(1,List(3,4),2)
       second time: 3rd case will be executed and the splitR(0,List(4),3)
       thrid time: 2nd case will be executed (UNWIND happens here) and the pre(3,2).reverse will be called and result List(2,3) and List(4) will be returned
   */

  def main(args: Array[String]): Unit = {
    val beforeSplit = List(2,3,4)
    println(s"after split "+splitInto2Part(2,beforeSplit))
    println(s"after tail split"+splitTailRecursive(2,beforeSplit))
    // Functional
    println(s"after split functional "+(beforeSplit.take(2),beforeSplit.drop(2)))
  }

}
