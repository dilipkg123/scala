/*
(**) Eliminate consecutive duplicates of list elements.
If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
Example:

scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */

class EliminateConsequitiveDuplicates {

def eliminateDupRecursive[T](xs: List[T]) : List[T] = xs match {
  case Nil => Nil
  case h::tail =>h::eliminateDupRecursive(tail.dropWhile(_ == h))
}

  def tailRecusiveEliDup[A] (xs: List[A]) : List[A] = {

    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, xs)
  }

  def functionalStyle[A] (xs: List[A]) : List[A] = xs.foldRight(List[A]()) { (h, r) =>
    if (r.isEmpty || r.head != h) h :: r
    else r
  }
}



object EliminateConsequitiveDuplicates{

  def main(args: Array[String]): Unit = {
    def eliminateConsequitiveDuplicates = new EliminateConsequitiveDuplicates();

    val beforeEliminatingDup = List(1,1,2,2,3,3,4,4)
    val beforeEliminatingDupString = List("Dilip","Dilip","Gokul","Gokul")

    val afterEliminatingDup = eliminateConsequitiveDuplicates.eliminateDupRecursive(beforeEliminatingDup)
    val afterEliminatingDupTail = eliminateConsequitiveDuplicates.tailRecusiveEliDup(beforeEliminatingDupString)
    val functionalStyle = eliminateConsequitiveDuplicates.functionalStyle(beforeEliminatingDup)
    println(s"afterEliminatingDup = $afterEliminatingDup and afterEliminatingDupTail = $afterEliminatingDupTail and functionalStyle = $functionalStyle")
  }
}
