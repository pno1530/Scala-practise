

object CatsAndMouse {

  def catAndMouse(x: Int, y: Int, z: Int): String = {
    if(Math.abs(z-x) < Math.abs(z-y)) "Cat A"
    else if(Math.abs(z-y) < Math.abs(z-x)) "Cat B"
    else "Mouse C"

  }


  def main(args: Array[String]): Unit = {

    val stdin = scala.io.StdIn
    val q = stdin.readLine.trim.toInt
    for (qItr <- 1 to q) {
      val xyz = stdin.readLine.split(" ")

      val x = xyz(0).trim.toInt

      val y = xyz(1).trim.toInt

      val z = xyz(2).trim.toInt

      val result = catAndMouse(x, y, z)

      println(result)
    }
  }
}
