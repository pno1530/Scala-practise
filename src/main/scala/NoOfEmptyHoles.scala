object NoOfEmptyHoles {

  def main(args: Array[String]): Unit = {
    val first = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
    val n = first(0)
    var arr = Array.ofDim[Int](n, n)
    val tests = first(1)
    val total = n*n
    var sum = 0
    var res  = List[Int]()
    for(k <- 0 until tests){
      val nums = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
      val ith = nums(0)
      val jth = nums(1)
      for(i <- 0 until n){
        for(j <- 0 until n ){
          if(arr(i)(j) != 1 && (i == ith-1 || j == jth-1)) {
            sum =  sum + 1
            arr(i)(j) = 1
          }
          }
        }
      res = res :+ (total-sum)
    }
    println(res.toList.mkString(" "))
  }
}
