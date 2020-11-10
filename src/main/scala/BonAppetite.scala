object BonAppetite {

  def bonAppetit(bill: Array[Int], k: Int, b: Int) =  {
     val sum = bill.zipWithIndex.foldLeft(0)((a,e) => if(e._2 == (k)) a else a + e._1)
      if(sum/2 == b) "Bon Appetit" else  s"${b - sum/2}"
  }

  def main(args: Array[String]): Unit = {
//    val n = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    val list = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
//    for(i <- 0 until n){
//      perfect(scala.io.StdIn.readInt())
//    }
    val nk = scala.io.StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = nk(0).toInt

    val k = nk(1).toInt

    val bill = scala.io.StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val b = scala.io.StdIn.readLine.trim.toInt


    println(bonAppetit(bill, k, b))
  }
}
