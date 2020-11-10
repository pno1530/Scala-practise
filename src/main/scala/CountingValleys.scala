import scala.io.StdIn

object CountingValleys {

  def step(str: Char) =  str match {
    case 'D' => -1
    case 'U' => 1
  }

  case class Result(sum: Int, valleys: Int, lastEle: Char)

  def countingValleys(steps: Int, path: String) = {
    // Write your code here
    if(steps == path.length){
      path.foldLeft(Result(0, 0, ' '))((a, e) => {
          println(s"a: ${a}, e: ${e} ")
          if(a.sum + step(e) == 0 && !((e == 'D' && a.lastEle == 'U') || (e == 'U' && a.lastEle == 'D'))) Result(0, a.valleys+1, e)
          else Result(a.sum+step(e), a.valleys, e)
      })
    }
  }

  def getMoneySpent(keyboards: Array[Int], drives: Array[Int], b: Int): Int = {
    val a = for(k <- keyboards; d <- drives) yield (k+d)

    a.filter(_<b).max
//    def iterate(a: Array[Int], res: Int): Int = {
//     if(a.length == 0) -1
//      else{
//        if(a.head > b) iterate(a.tail, res)
//        else a.head
//      }
//    }
//    iterate(a.sortWith(_>_), 0)


  }


  def main(args: Array[String]): Unit = {

//  val steps = StdIn.readLine.trim.toInt

//    val path = StdIn.readLine
    val bnm = scala.io.StdIn.readLine.split(" ")
    val b = bnm(0).trim.toInt
    val keyboards = scala.io.StdIn.readLine.split(" ").map(_.trim.toInt)

    val drives = scala.io.StdIn.readLine.split(" ").map(_.trim.toInt)

    println(getMoneySpent(keyboards, drives, b))
//    println(getMoneySpent(steps, path))
  }
}
