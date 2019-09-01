/*
 P23 (**) Extract a given number of randomly selected elements from a list.
     Example:
     scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
     res0: List[Symbol] = List('e, 'd, 'a)
 */

object ExtractRandomValuesFromList {

  def randomSelect1[A](n: Int, ls: List[A]): List[A] =
    if (n <= 0) Nil
    else {
      val (rest, e) = RemoveKthElementFromList.removeKth((new util.Random).nextInt(ls.length), ls)
      e :: randomSelect1(n - 1, rest)
    }


  // It can be expensive to create a new Random instance every time, so let's
  // only do it once.
  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    def randomSelectR(n: Int, ls: List[A], r: util.Random): List[A] =
      if (n <= 0) Nil
      else {
        val (rest, e) = RemoveKthElementFromList.removeKth(r.nextInt(ls.length), ls)
        e :: randomSelectR(n - 1, rest, r)
      }
    randomSelectR(n, ls, new util.Random)
  }


  def main(args: Array[String]): Unit = {
    val beforeRemove = List("a","b","c","d","e","f","g","h")

    println(" after remove is "+randomSelect1(3,beforeRemove))
    println((" after rm is "+randomSelect(3,beforeRemove)))
  }


}
