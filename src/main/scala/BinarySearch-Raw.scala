//object Result {
//
//  def binarySearch(low: Int, high: Int, key: Int, list: List[Int]): Int = {
//    def iterate(status: Boolean, low: Int, high: Int): Int = {
//      if(!status) -1
//      else {
//        val median = (low + high)/2
//        if(list(median) > key){
//          val high = median -1
//          iterate(low <= high, low, high)
//        }
//        else if(list(median) < key){
//          val low = median+1
//          iterate(low <= high, low, high)
//        }
//        else
//          median + 1
//      }
//    }
//    iterate(low <= high, low, high)
//  }
//
//  def lastOccurence(list: List[Int], item: Int): Int = {
//    binarySearch(0, list.length - 1, item, list)
//  }
//
//  def main(args: Array[String]): Unit = {
//    val count = scala.io.StdIn.readInt()
//    val list = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList.sortWith(_<_)
//    val eleCount = scala.io.StdIn.readInt()
//    for(i <- 1 to eleCount){
//      val element = scala.io.StdIn.readInt()
//      println(lastOccurence(list, element))
//    }
//
//  }
//}