import java.sql.Timestamp
import java.time.Instant

/*
 (**) Group the elements of a set into disjoint subsets.
a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
Example:

scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

Example:

scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...). However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).

You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".

// P27 (**) Group the elements of a set into disjoint subsets.
//     a) In how many ways can a group of 9 people work in 3 disjoint subgroups
//        of 2, 3 and 4 persons?  Write a function that generates all the
//        possibilities.
//
//        Example:
//        scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//        res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
//
//     b) Generalize the above predicate in a way that we can specify a list
//        of group sizes and the predicate will return a list of groups.
//
//        Example:
//        scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
//        res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
//
//     Note that we do not want permutations of the group members;
//     i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
//     However, we make a difference between ((Aldo, Beat), (Carla, David), ...)
//     and ((Carla, David), (Aldo, Beat), ...).
//
//     You may find more about this combinatorial problem in a good book on
//     discrete mathematics under the term "multinomial coefficients".
 */

// TODO : revisit.
object DisjointSubset {

/*  def group3[A](ls: List[A]): List[List[List[A]]] =
    for {
      a <- CombinationOfKthDistinctObject.combinations(2, ls)
      noA = ls -- a
      b <- CombinationOfKthDistinctObject.combinations(3, noA)
    } yield List(a, b, noA -- b)

  def group[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
    case Nil     => List(Nil)
    case n :: ns => CombinationOfKthDistinctObject.combinations(n, ls) flatMap { c =>
      group(ns, ls -- c) map {c :: _}
    }
  }*/

  def main(args: Array[String]): Unit = {

    import java.time.{LocalDateTime, ZoneId, ZonedDateTime}

    val now = Instant.ofEpochMilli("1552446880000".toLong)
    val nowI = Instant.now.toEpochMilli
    val ldt = LocalDateTime.now
    val zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault)

    println(ldt)
    println(zdt)
    println(s"now is $now")
    println(" time is "+Instant.now.toEpochMilli)
    println(new Timestamp(nowI))

//    val c = new Timestamp(ldt.getLong())
  }

}
