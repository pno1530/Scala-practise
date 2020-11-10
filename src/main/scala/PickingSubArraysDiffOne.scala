import scala.io.StdIn

object PickingSubArraysDiffOne {


  def pickingNumbers(a: Array[Int]) = {
    a.foldLeft(List[List[Int]]())((a,e) => {
      if (a.isEmpty) a :+ List(e)
      else {
        if((e - a.last.last) <= 1 && (e - a.last.head) <= 1)  a.dropRight(1) :+ (a.last :+ e)
        else a :+ List(e)
      }
    }).sortWith(_.size > _.size).head.size
  }


  def main(args: Array[String]): Unit = {

    val n = StdIn.readLine.trim.toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

//    val result = pickingNumbers(a.sorted)

    val sorted = a.sorted
    val distinct = sorted.distinct
    def thisAsCenter(k: Int) = {
      val numEqual = sorted.count(_ == k)
      val oneLess = sorted.count(_ == k-1)
      val oneMore = sorted.count(_ == k+1)

      numEqual + Math.max(oneLess, oneMore)
    }
    val solution = distinct.map(thisAsCenter(_)).max
    println(solution)

  }
}
