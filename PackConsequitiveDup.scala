/*
(**) Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */

object PackConsequitiveDup {

  def pack[A](xs: List[A]) : List[List[A]] = {
    if (xs.isEmpty) List(List())
    else{
      val (packed,next) = xs span {_ == xs.head}
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def main(args: Array[String]): Unit = {
    val packInput = List(1,1,1,2,2,3,3,3,4,4,5,5,5,6,7,1)
    println(pack(packInput))

  }
}
