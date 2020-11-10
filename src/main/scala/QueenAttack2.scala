

object QueenAttack2 {

  def iterate(r: Int, c: Int, moves: List[(Int, Int)], fr: Int => Int, fc: Int => Int, lastR: Int, lastC: Int): List[(Int, Int)] = {
    if (r == lastR || c == lastC) moves
    else iterate(fr(r), fc(c), moves :+ (fr(r), fc(c)), fr, fc, lastR, lastC)
  }

  def queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array[Array[Int]]) = {

    def valiMoves =   {
        var rowDownMoves = List[(Int, Int)]()
        var topRowMoves = List[(Int, Int)]()
        var leftColumnsMoves = List[(Int, Int)]()
        var rightColumnsMoves = List[(Int, Int)]()
        var d1UpperMoves = List[(Int, Int)]()
        var d2UpperMoves = List[(Int, Int)]()
        var d1LowerMoves = List[(Int, Int)]()
        var d2LowerMoves = List[(Int, Int)]()
        for{ i <- 1 to r_q-1} rowDownMoves =  rowDownMoves :+ (i, c_q)
        for{ i <- r_q+1 to n} topRowMoves = topRowMoves :+ (i, c_q)
        for{ i <- 1 to c_q-1} leftColumnsMoves = leftColumnsMoves :+ (r_q, i)
        for{ i <- c_q+1 to n} rightColumnsMoves = rightColumnsMoves :+ (r_q, i)

        def iterateD1Upperr = iterate(r_q, c_q, List(), r => r-1, c => c-1, 1, 1)
        d1UpperMoves = d1UpperMoves ++ iterateD1Upperr

        def iterated1Lowerr = iterate(r_q, c_q, List(), r => r+1, c => c+1, n, n)
        d1LowerMoves = d1LowerMoves ++  iterated1Lowerr

        def iterateD2Upperr = iterate(r_q, c_q, List(), r => r+1, c => c-1, n, 1)
        d2UpperMoves = d2UpperMoves ++ iterateD2Upperr

        def iterateD2UpperLowerr = iterate(r_q, c_q, List(), r => r-1, c => c+1, 1, n)
        d2LowerMoves = d2LowerMoves ++ iterateD2UpperLowerr

      val rowDownObstacle = obstacles.filter(elem => rowDownMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(0) > e2(0))
      val topRowObstacle = obstacles.filter(elem => topRowMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(0) < e2(0))
      val columnLeftObstacle = obstacles.filter(elem => leftColumnsMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(1) > e2(1))
      val columnRightObstacle = obstacles.filter(elem => rightColumnsMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(1) < e2(1))
      val d1UpperObstacle = obstacles.filter(elem => d1UpperMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(0) > e2(0))
      val d1LowerObstacle = obstacles.filter(elem => d1LowerMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(0) < e2(0))
      val d2UpperObstacle = obstacles.filter(elem => d2UpperMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(0) < e2(0))
      val d2LowerObstacle = obstacles.filter(elem => d2LowerMoves.contains((elem(0), elem(1)))).sortWith((e1, e2) => e1(0) > e2(0))

      rowDownMoves =  (
        if(rowDownObstacle.nonEmpty) rowDownMoves.filter(e => e._1 > (rowDownObstacle.head)(0))
        else rowDownMoves
      )

      topRowMoves =  (
        if(topRowObstacle.nonEmpty) topRowMoves.filter(e => e._1 < (topRowObstacle.head)(0))
        else topRowMoves
      )
      leftColumnsMoves = (
        if(columnLeftObstacle.nonEmpty) leftColumnsMoves.filter(e => e._1 > (columnLeftObstacle.head)(0))
        else leftColumnsMoves
      )
      rightColumnsMoves= (
        if(columnRightObstacle.nonEmpty) rightColumnsMoves.filter(e => e._1 < (columnRightObstacle.head)(0))
        else rightColumnsMoves
      )
      d1UpperMoves  = (
        if(d1UpperObstacle.nonEmpty) d1UpperMoves.filter(e => e._1 > (d1UpperObstacle.head)(0))
        else d1UpperMoves
      )
      d1LowerMoves = (
        if(d1LowerObstacle.nonEmpty) d1LowerMoves.filter(e => e._1 > (d1LowerObstacle.head)(0))
        else d1LowerMoves
      )
      d2UpperMoves = (
        if(d2UpperObstacle.nonEmpty) d2UpperMoves.filter(e => e._1 < (d2UpperObstacle.head)(0))
        else d2UpperMoves
      )
      d2LowerMoves = (
        if(d2LowerObstacle.nonEmpty) d2LowerMoves.filter(e => e._1 > (d2LowerObstacle.head)(0))
        else d2LowerMoves
      )
      val moves = rowDownMoves ++ topRowMoves ++ leftColumnsMoves ++
        rightColumnsMoves ++ d1UpperMoves ++ d1LowerMoves ++ d2UpperMoves ++ d2LowerMoves
      moves
    }
    valiMoves.size

  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val r_qC_q = stdin.readLine.split(" ")

    val r_q = r_qC_q(0).trim.toInt

    val c_q = r_qC_q(1).trim.toInt

    val obstacles = Array.ofDim[Int](k, 2)

    for (i <- 0 until k) {
      obstacles(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)

  }
}
