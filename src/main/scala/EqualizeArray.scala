

object EqualizeArray {

  def equalizeArray(arr: Array[Int]) = {
    val map = arr.groupBy(e => e).view.mapValues(_.size)
    val n = map.toList.sortWith(_._2>_._2)
    println(n)
    map.valuesIterator.toList

  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = equalizeArray(arr)

    println(result)

  }
}
