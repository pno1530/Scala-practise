import java.text.SimpleDateFormat

object LibraryFine {

  def libraryFine(d1: Int, m1: Int, y1: Int, d2: Int, m2: Int, y2: Int): Int = {
    if(y1 > y2) 10000
    else if(y1 == y2){
      if(m1 < m2) 0
      else if(m1 != m2) 500*(m1-m2)
      else
         if(d1 < d2) 0
        else
          15 * (d1-d2)
    }
    else 0

  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val d1M1Y1 = stdin.readLine.split(" ")

    val d1 = d1M1Y1(0).trim.toInt

    val m1 = d1M1Y1(1).trim.toInt

    val y1 = d1M1Y1(2).trim.toInt

    val d2M2Y2 = stdin.readLine.split(" ")

    val d2 = d2M2Y2(0).trim.toInt

    val m2 = d2M2Y2(1).trim.toInt

    val y2 = d2M2Y2(2).trim.toInt

    val result = libraryFine(d1, m1, y1, d2, m2, y2)

    println(result)
  }
}
