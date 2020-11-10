

object SequenceEquation {

  def permutationEquation(p: Array[Int]): Array[Int] = {
    var indexOfI = 0
    var indexOfSecI = 0
    var arr = Array[Int]()
    val pp = p.zipWithIndex
    for( i <- 1 to p.length){
      indexOfI = pp.find(t => t._1 == i).getOrElse((0, -1))._2 + 1
      var secondNo = indexOfI
      indexOfSecI = pp.find(t => t._1 == secondNo).getOrElse((0, -1))._2 + 1
      arr = arr:+indexOfSecI
    }
    arr
  }



  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val p = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = permutationEquation(p)

    println(result.mkString("\n"))


  }





}
