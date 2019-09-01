/*
(*) Run-length encoding of a list.
Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
Example:

scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

and

(**) Run-length encoding of a list (direct solution).
Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
Example:

scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
object LenghtEncodingOfList {


  def lenghtEncodingDirect[A](xs : List[A]) : List[(Int,Any)] = {

    if (xs.isEmpty) Nil
    else {
      val (packed, next) = xs span {
        _ == xs.head
      }
      (packed.length, packed.head) :: lenghtEncodingDirect(next)
    }
  }
/*
    def lenghtEnTailR(result: Int,input: List[A]) : List[A] = input match {
      case Nil => Nil
      case h::tail => lenghtEnTailR(result+1,tail)
    }

    lenghtEnTailR(0,xs)*/



  def lenghtEncoding[A](xs : List[A]) : List[(Int,Any)] = PackConsequitiveDup.pack(xs) map { e => (e.length,e.head )}

  def main(args: Array[String]): Unit = {
    val lenghtEnc = List("a","a","A","b","b","B","c","c")

    //TODO: Problamatic... look again as the case is not working. I know this is not a fruitful case, but want to test it
/*    println(lenghtEncoding(lenghtEnc match
      {
      case i: List[Int] => i
      case s: List[String] => s map{e=> e.toLowerCase()}
    }
    )
    )*/

    println(lenghtEncoding(lenghtEnc map (e=> e.toLowerCase())))
    println(lenghtEncodingDirect(lenghtEnc map (e=> e.toLowerCase())))

  }
}


