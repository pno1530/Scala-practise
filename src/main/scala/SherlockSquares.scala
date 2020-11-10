

object SherlockSquares {

  def squares(a: Int, b: Int) = {
    val startSqrtVar = scala.math.sqrt(a).ceil
    def iterate(status: Boolean, res: List[Int], num: Int): Int = {
      if(status) {
        println("---"+ res)
        res.size
      }
      else {
        if(num*num > b) iterate(true, res, num)
        else iterate(false, res:+num, num+1)
      }
    }
    if(startSqrtVar*startSqrtVar > b) 0
    else iterate(false, List(), startSqrtVar.toInt)
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val ab = stdin.readLine.split(" ")

      val a = ab(0).trim.toInt

      val b = ab(1).trim.toInt

      val result = squares(a, b)

      println(result)
    }

  }

}
