/*
 (*) Lotto: Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 */

object NDifferentRandomNumbers {

  // my solution
  //TODO : want to write it efficiently. Will try it.
  def genNDiffRandomNumber(numberOfRandomNumber:Int) : List[Any] = {
    def genRan(cnt:Int,result: List[Any]) : List[Any] = {
      if (cnt < numberOfRandomNumber) genRan(cnt+1,(new util.Random).nextInt()::result)
      else result
    }
    genRan(0,Nil)
  }

  // between Range my solution
  def genRandomNumbersInRange(s:Int,e:Int,no:Int) : List[Any] = {
    def genRan(cnt:Int,result: List[Any]) : List[Any] = {
      if (cnt < no) genRan(cnt+1,(new util.Random).nextInt(e)::result)
      else result
    }
    genRan(0,Nil)
  }

  // Correct solution using ExtractRandomValues
  def lotto(count: Int, max: Int): List[Int] =
    ExtractRandomValuesFromList.randomSelect(count, List.range(1, max + 1))


  def main(args: Array[String]): Unit = {
    println(genNDiffRandomNumber(6))
    println(genRandomNumbersInRange(2,10,6))
    println(lotto(6,10))

  }
}
