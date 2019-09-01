/*
Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
 */

object Substring {

  def substringRec[A](cutStart:Int, cutEnd:Int, xs:List[A]) : List[A] = (cutStart,cutEnd,xs) match {

    case (_,_,Nil) => Nil
    case (_,e,_) if e<=0 =>  Nil
    case (s,e,h::tail) if s<=0 => h::substringRec(0,e-1,tail)
    case (s,e,h::tail) => substringRec(s-1,e-1,tail)
  }

  /*
  1. 4th case => substringRec(1,3,"b,c,d,e,f")
  2. 4th case => substringRec(0,2,"c,d,e,f")
  3. 3rd case => "c"+substringRec(0,1,"d,e,f")
  4. 3rd case => "d"+substringRec(0,0,"e,f")
  5. 2nd case => return null and unwind happends "c,d" will be returned.
   */

  def substringTailRec[A](cutStart:Int, cutEnd: Int,xs:List[A]) : List[A] = {
     def subTailR(count: Int, curList: List[A], result: List[A]) : List[A] = {
       (count, curList) match {
         case (_, Nil)                     => result.reverse
         case (c, h :: tail) if cutEnd <= c   => result.reverse
         case (c, h :: tail) if cutStart <= c => subTailR(c + 1, tail, h :: result)
         case (c, _ :: tail)               => subTailR(c + 1, tail, result)
       }
     }
    subTailR(0, xs, Nil)
  }

  /*
     1. 4th case => subTailR(1,"b,c,d,e,f",empty)
     2. 4th case => subTailR(2,"c,d,e,f",empty)
     3. 3rd case => subTailR(3,"c,d,e,f","c")
     4. 3rd case => subTailR(4,"d,e,f","d,c")
     5. 2nd case => result i.e. "d,c".reverse = c,d will be returned.
     The big advantage of tail recursion is; there is no UNWIND... so performance will be good. But reember, you have to reverse it.
   */

  // Since several of the patterns are similar, we can condense the tail recursive
  // Optimised tail recursion

  def sliceTailRecursive2[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = {
      if (curList.isEmpty || count >= end) result.reverse
      else sliceR(count + 1, curList.tail,
        if (count >= start) curList.head :: result
        else result)
    }
    sliceR(0, ls, Nil)
  }

  /*
    1. else will be executed: sliceR(1,"b,c,d,e,f",empty
    2. else will be executed: sliceR(2,"c,d,e,f", empty
    3. else will be executed: sliceR(3,"d,e,f","c"
    4. else will be executed: sliceR(4,"e,f"","d,c")
    5. if will be executed: "d,c".reverse will be returned.
    // This is awesome solution... no case only Tail Recursion.

   */

  def main(args: Array[String]): Unit = {
    val beforeSlice = List("a","b","c","d","e","f")

    println(s"slice after recursive call is "+substringRec(2,4,beforeSlice))
    println(" fuctional solution "+ beforeSlice.drop(2).take(4- (2 max 0))) // beforeSlice drop cutStart take (cutEnd - (cutStart max 0))
    println(" build in "+ beforeSlice.slice(2,4))
  }
}
