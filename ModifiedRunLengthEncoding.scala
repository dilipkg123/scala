/*
(*) Modified run-length encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */

object ModifiedRunLengthEncoding {


 // Dilip's solution
  def lenghtEncoding[A](xs : List[A]) : List[Any] =
    {PackConsequitiveDup.pack(xs) map {
                            e => if (e.length > 1) (e.length,e.head )
                                 else e.head
                            }
    }

  def main(args: Array[String]): Unit = {
    val lenghtEnc = List("a","a","A","b","b","B","c","c","d")
    println(lenghtEncoding(lenghtEnc map (e=> e.toLowerCase())))
    val resultOfGoodSolution = encodeModified(lenghtEnc map (e=> e.toLowerCase()))
    println(s" good solution result $resultOfGoodSolution()")
    println(LenghtEncodingOfList.lenghtEncoding(lenghtEnc) )
  }

  // Good Solution

  def encodeModified[A](ls: List[A]): List[Any] =
    LenghtEncodingOfList.lenghtEncoding(ls) map { t => if (t._1 == 1) t._2 else t}

  // Just for fun, here's a more typesafe version.
/*  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
    LenghtEncodingOfList.lenghtEncoding(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }*/
}
