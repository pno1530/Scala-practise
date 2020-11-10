

object MagicSquare {


  def compare(a1: Array[Array[Int]], a2: Array[Array[Int]]) = {
    a1.zip(a2).map({case (a1,a2) => a1.zip(a2).map({case (e1, e2) => (e1-e2).abs }).sum}).sum
  }

  def formingMagicSquare(s: Array[Array[Int]]): Int = {
    val theMagicSquare = Array(Array(8,3,4),Array(1,5,9),Array(6,7,2))
    val theMagicSquares = Array(theMagicSquare, theMagicSquare.reverse, theMagicSquare.map(_.reverse),
      theMagicSquare.reverse.map(_.reverse), theMagicSquare.transpose, theMagicSquare.transpose.reverse,
      theMagicSquare.transpose.map(_.reverse), theMagicSquare.transpose.reverse.map(_.reverse))

    theMagicSquares.map(a => (compare(s, a))).min
  }


  def main(args: Array[String]): Unit = {

    val stdin = scala.io.StdIn
    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = formingMagicSquare(s)
    println(result)

  }
}
