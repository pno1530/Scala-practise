

object saveThePrisoner {

  def saveThePrisoner(n: Int, m: Int, s: Int): Int = {
    def iterate(status: Boolean, prisonerNo: Int, res: Int, loopCount: Int): Int = {
      if(status) res
      else {
        val  p = if(prisonerNo >= n) 1 else prisonerNo+1
        iterate(loopCount+1 == m, p, p, loopCount+1 )
      }
    }
    iterate(m == 1, s, 0, 1)
  }


  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val nms = stdin.readLine.split(" ")

      val n = nms(0).trim.toInt

      val m = nms(1).trim.toInt

      val s = nms(2).trim.toInt

      val result = saveThePrisoner(n, m, s)

      println(result)
    }


  }





}
