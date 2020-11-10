

object CutSticks {

  def cutTheSticks(arr: Array[Int]): List[Int] = {

    def iterate(array: List[Int], res: List[Int]): List[Int] = {
      array match {
        case  Nil => res
        case _ => {
          val min = array.min
          val result = array.foldLeft(List[Int]())((a, e) => {
            val newValue  = e-min
            if(newValue != 0) a:+newValue else a
          })
          if(result.isEmpty) iterate(Nil, res)
          else iterate(result, res :+ result.size)
        }
      }

    }

    iterate(arr.toList, List(arr.count(_ >= arr.min)))

  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = cutTheSticks(arr)

    println(result.mkString("\n"))
  }
}
