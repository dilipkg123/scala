/*
(*) Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */
object IsPalindrome {

  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

  def main(args: Array[String]): Unit = {
    val palindromeCheck = List(1,2,3,5,6,7,6,5,3,2,1)

    println(isPalindrome(palindromeCheck))
  }
}
