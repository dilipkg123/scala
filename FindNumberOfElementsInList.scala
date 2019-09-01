/*
(*) Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6
 */
object FindNumberOfElementsInList {

   def main (a : Array[String]): Unit = {

     val list = List(1, 5, 3, 4, 6, 8, 10)
     val s = Stack(1,2,34,4)
     val listString = List("India", "China", "Srilanka", "Pakistan", "Bangaladesh")

     def findNumberOfElementsInList[Z](xs: List[Z]): Int = {
       xs match {
         case Nil => 0
         case _::tail => 1+findNumberOfElementsInList(tail)
         case _ => throw new NoSuchElementException
       }
     }

     def lengthTailRecursive[A](ls: List[A]): Int = {
       def lengthR(result: Int, curList: List[A]): Int = curList match {
         case Nil       => result
         case _ :: tail => lengthR(result + 1, tail)
       }
       lengthR(0, ls)
     }

     def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

     val answer = findNumberOfElementsInList(list)
     val answerTail = lengthTailRecursive(list)
     val answerFolds = lengthFunctional(list)
     println(s"answer is $answer and answerTail is $answerTail and functionalAnswer is $answerFolds")
   }
}

