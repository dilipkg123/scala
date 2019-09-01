/*
(*) Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */
object ReverseAList {

  def main (a: Array[String]) : Unit ={

    val reverse = List(9,8,7,6,5,4,3,2,1)
    val reverseString = List("Sri Thulasi","Anuj","Amol","Dilip","Gokul")

    // buildIn
    def buildInReverse[T](xs: List[T]) : List[T] = xs.reverse

    //simple recursion
    def reverseAList[T](xs : List[T]) : List[T] = xs match {
      case Nil => Nil
      case h :: tail => println(s"List($h)  $tail")
                        reverseAList(tail) ::: List(h)
    }

    def tailRecReverseAList[T](xs : List[T]) : List[T] = {
      def tailR(result: List[T],input : List[T]) : List[T] = input match {
        case Nil => result
        case h::tail => tailR(h::result,tail)
      }
        tailR(Nil,xs)
    }

    def pureFunctionalGeneric[A](xs : List[A]) : List[A] = {
      xs.foldLeft(List[A]()) {(r,h) => h::r}
    }

    val buildinReversedList = buildInReverse(reverse)
    val recursiveReverse = reverseAList(reverseString)
    val tailRecursive = tailRecReverseAList(reverseString)
    val pureFunctional = reverseString.foldLeft(List[String]()) {(r,h) => h :: r}
    val funtioanlGeneric = pureFunctionalGeneric(reverse)
    println(s"BuiltIn reversed list is $buildinReversedList and recursiveReverse is $recursiveReverse; tail recursive is $tailRecursive")
    println(s"pure funcitonal is $pureFunctional")
    println(s"pure funcitonal generic is $funtioanlGeneric")
  }

}
