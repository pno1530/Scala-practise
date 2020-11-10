import scala.io.StdIn

object NonDivisibleSubset {

  def nonDivisibleSubset(k: Int, s: Array[Int]) = {
    val pairs = for(i <- s.zipWithIndex; j <- s.zipWithIndex) yield (i,j)
    val filterPairs = pairs.foldLeft(List[(Int, Int)]())((a, t) => if ( t._2._2 > t._1._2) a :+ (t._1._1, t._2._1) else a)
    filterPairs.filter(t => (t._1+ t._2) % k != 0).foldLeft(List[Int]())((a, e) => (a :+ e._1) :+ e._2).toSet
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    var n = sc.nextInt();
    val k = sc.nextInt();
    var c = new Array[Int](k);
    var count =0
    for(c_i <- 0 to n-1) {
      c(sc.nextInt()%k) +=1
    }
    println(c.toList)
    for(c_i <- 1 to k/2) {
      if(c_i==k-c_i && c(c_i)!=0)
        count+=1
      else
        count += Math.max(c(c_i), c(k-c_i))
    }
    if(c(0)!=0) count +=1
    println(count)

  }

//  def main(args: Array[String]): Unit = {
//    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")
//
//    val n = firstMultipleInput(0).toInt
//
//    val k = firstMultipleInput(1).toInt
//
//    val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
//
//    val result = nonDivisibleSubset(k, s)
//
//    println(result)
//  }
}
