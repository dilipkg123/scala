/*
P25 (*) Generate a random permutation of the elements of a list.
Hint: Use the solution of problem P23.
Example:

scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 */
object RandomPermutation {

  // easy solution
  def randomPermute1[A](ls: List[A]): List[A] = ExtractRandomValuesFromList.randomSelect(ls.length, ls)

  // TODO: revisit
  // The canonical way to shuffle imperatively is Fisher-Yates.  It requires a
  // mutable array.  This is O(n).
/*  def randomPermute[A](ls: List[A]): List[A] = {
    val rand = new util.Random
    val a = ls.toArray
    for (i <- a.length - 1 to 1 by -1) {
      val i1 = rand.nextInt(i + 1)
      val t = a(i)
      a.update(i, a(i1))
      a.update(i1, t)
    }
    a.toList
  }*/

  // Efficient purely functional algorithms for shuffling are a lot harder.  One
  // is described in http://okmij.org/ftp/Haskell/perfect-shuffle.txt using
  // Haskell. Implementing it in Scala is left as an exercise for the reader.

  def main(args: Array[String]): Unit = {
    val beforePer = List("a","b","c","d","e","f","g")
    println(randomPermute1(beforePer))
//    println(randomPermute(beforePer))
  }

}
