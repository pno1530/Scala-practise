object PairOfSocks {

  def sockMerchant(n: Int, ar: Array[Int]) = {
    ar.groupBy(e => e).view.mapValues(_.size).toList.map(t => (t._2 /2).abs).sum

  }

  def main(args: Array[String]): Unit = {
//    val n = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    val list = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    for(i <- 0 until n){
//      perfect(scala.io.StdIn.readInt())
//    }
//    val stdin = scala.io.StdIn
//
////    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
//
//    val n = stdin.readLine.trim.toInt
//
//    val ar = stdin.readLine.split(" ").map(_.trim.toInt)


  }
}
