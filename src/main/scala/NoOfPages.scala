object NoOfPages {


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
    val n = 5
    val p = 4
    val page = if(n%2==0 && p > n/2) n+1-p else if(n%2!=0 && p > n/2) n-p else p
    println((page/2).abs)
  }
}
