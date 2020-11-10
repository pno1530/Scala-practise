object DivisibleSumPairs {

  def findHighest(l : List[(Int, Int)]) = {
    l.foldLeft((0,0))((a, e) => {
      if(e._2 == a._2 && e._1 < a._1) (e._1, e._2)
      else if(e._2 > a._2) (e._1, e._2)
      else a
    })
  }

  def migratoryBirds(arr: Array[Int]) = {
    val aa = arr.groupBy(e => e).view.mapValues(_.length).toList
    findHighest(aa)._1
  }

  def main(args: Array[String]): Unit = {
//    val n = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    val list = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    for(i <- 0 until n){
//      perfect(scala.io.StdIn.readInt())
//    }
    println(migratoryBirds(Array(1, 4, 4, 4, 5, 3)))
  }
}
