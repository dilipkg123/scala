// P20 (*) Remove the Kth element from a list.
//     Return the list and the removed element in a Tuple.  Elements are
//     numbered from 0.
//
//     Example:
//     scala> removeAt(1, List('a, 'b, 'c, 'd))
//     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object RemoveKthElementFromList {

  def removeKth[A](indexToRemove:Int, xs: List[A]) : (List[A],A) = xs.splitAt(indexToRemove)
  match {
    case (Nil,_) if indexToRemove < 0 => throw new NoSuchElementException
    case (pre,e::post) => (pre ::: post,e)
    case (pre,Nil) => throw new NoSuchElementException
  }

  /*
    1. 2nd case => pre will be a,b,c and post will be d, which again splitted as d ( will be with val e),empty ( will be with post)
    2. return => (a,b,c,empty) and d
   */

  // Alternate, with fewer builtins.
  // no buildIn is used i.e. splitAt is not used.
  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => println(s"2nd case $tail and $h"); (tail, h)
      case (_, h :: tail) => {
        println(s"before val $h and $tail  "+n)
        val (t, e) = removeAt2(n - 1, ls.tail)
        println(s"after val $t and $e")
        (ls.head :: t, e)
      }
    }

  /*
    1. case 3 => removeAt2(2,"b,c,d")
    2. case 3 => removeAt2(1,"c,d")
    3. case 3 => removeAt2 (0,"d")
    4. case 2 => "d",empty will be returned to val and t will be d and e will be empty
    5. a::d
   */

  def main(args: Array[String]): Unit = {
    val beforeRemove = List('a, 'b, 'c, 'd)
    println(" After remove "+removeKth(3,beforeRemove))
    println(" After remove "+removeAt2(3,beforeRemove))
  }
}
