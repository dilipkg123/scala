/*
(**) Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */

object ModifiedRunLenghtDecoing {


  //TODO: Re-Visit as the solution is not working.
/*  def decode[A](ls: List[(Int, A)]): List[A] =
    ls flatMap {e=> List.make(e._1,e._2)}*/

  def main(args: Array[String]): Unit = {

    val encodedValue = ModifiedRunLengthEncoding.lenghtEncoding(List("a","a","A","b","b","B","c","c","d") map {e => e.toLowerCase})
    println(encodedValue)
//    println(decode())
  }
}
