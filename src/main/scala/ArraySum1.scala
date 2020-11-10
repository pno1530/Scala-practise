

object Result {
  def medianLessThanElemOrUpperIndex(list: List[Long], key: Long) : Int = {
    def iterate(insideList: Boolean, median: Int, low: Long, high: Long): Int = {
      if(!insideList || (key != list(median) && (median == 0 && low == 0 && high == 0))) -1
      else{
        if(key == list(median) || (key > list(median) && list.length == median+1) ) median
        else if(key > list(median-1) && key < list(median)) median-1
        else if(key > list(median) && key < list(median+1)) median
        else if(list(median) > key) {
          val high = median -1
          iterate(low <= high, ((low + high)/2).toInt, low, high)
        }
        else{
          val low = median + 1
          iterate(low <= high, ((low + high)/2).toInt, low, high)
        }
      }
    }
    iterate(0 <= list.length, (0 + list.length)/2, 0, list.length)
  }

  def medianGreaterThanElemOrLowerIndex(list: List[Long], key: Long) : Int = {
    def iterate(insideList: Boolean, median: Int, low: Long, high: Long): Int = {
      if(!insideList) -1
      else{
        if(key == list(median) || (key < list(median) && median == 0)) median
        else if((key > list(median) && list.length == median+1) || (key > list(median) && key < list(median+1))) median+1
        else if(key > list(median-1) && key < list(median)) median
        else if(list(median) > key) {
          val high = median -1
          iterate(low <= high, ((low + high)/2).toInt, low, high)
        }
        else{
          val low = median + 1
          iterate(low <= high, ((low + high)/2).toInt, low, high)
        }
      }
    }
    iterate(0 <= list.length, (0 + list.length)/2, 0, list.length)
  }

  def range(list: List[Long], min: Long, max: Long)  = {
    val sortedlist = list.sorted
    val lowerIndex = medianGreaterThanElemOrLowerIndex(sortedlist, min)
    val upperIndex = medianLessThanElemOrUpperIndex(sortedlist, max)
    var arr = Array[Long]()
    for(i <- lowerIndex to upperIndex){
      arr = arr :+ sortedlist(i)
    }
    arr.toList
  }

  def manhattenPoints(z: Long, xcords: List[Long], ycords: List[Long]) = {
    val filtered = for(i <- xcords; j <- ycords) yield(i,j )
    filtered.count(t => (t._2+t._1).abs <= z)
  }

  def find(z: Long, category: String, arr: List[Long], xcords: List[Long], ycords: List[Long])={
    category match {
      case "A" => {
        val lowerLimitOnX = arr(0)
        val upperLimitOnX = arr(1)
        val expectedXoordinates = range(xcords, lowerLimitOnX, upperLimitOnX)
//          xcords.filter(e => e <= upperLimitOnX && e >= lowerLimitOnX)
        manhattenPoints(z, expectedXoordinates, ycords)
      }
      case "B" => {
        val lowerLimitOnY = arr(0)
        val upperLimitOnY = arr(1)
        val expectedYoordinates = range(ycords, lowerLimitOnY, upperLimitOnY)
//          ycords.filter(e => e <= upperLimitOnY && e >= lowerLimitOnY)
        manhattenPoints(z, xcords, expectedYoordinates)
      }
      case "C" => {
        val lowerLimitOnX = arr(0)
        val upperLimitOnX = arr(1)
        val lowerLimitOnY = arr(2)
        val upperLimitOnY = arr(3)
        val expectedXoordinates = range(xcords, lowerLimitOnX, upperLimitOnX)
        val expectedYoordinates = range(ycords, lowerLimitOnY, upperLimitOnY)
        manhattenPoints(z, expectedXoordinates, expectedYoordinates)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val line1 = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList
    val noOftest = line1(2)
    val xcords = scala.io.StdIn.readLine().split(" ").map(_.trim.toLong).toList
    val ycords = scala.io.StdIn.readLine().split(" ").map(_.trim.toLong).toList
    for (i<- 1 to noOftest){
      val line = scala.io.StdIn.readLine().split(" ").map(_.trim).toList
      val z = line(0)
      val category = line(1)
      val arr = line.drop(2).map(_.toLong)
      println(find(z.toLong, category, arr, xcords, ycords))
    }

  }
}


//
//
//case class Programmer(id: String, rating: Int)
//case class Result(takenProgrammersIds : List[String], biasedDiff: Int)
//
//val programmer = ratings.zipWithIndex.toList.map(t => Programmer((t._2 + 1).toString, t._1))
//
//val pairsTuple = for(x <- programmer; y <- programmer) yield (x,y)
//val pairs = pairsTuple.filter(t => (t._1.id != t._2.id) ).map(t => (t, t._1.rating - t._2.rating)).filterNot(t => t._2 < 0).sortWith((t1, t2) => t1._2 < t2._2)
//println(pairs)
//val res = pairs.foldLeft(Result(List(), 0))((acc, e) => {
//  if(acc.takenProgrammersIds.contains(e._1._1.id) || acc.takenProgrammersIds.contains(e._1._2.id)) acc
//  else Result(acc.takenProgrammersIds:+e._1._1.id :+ e._1._2.id, acc.biasedDiff + e._2)
//})
//res


//object Result {
//
//
//  def soldiersKilled(list: List[Int], power: Int) = {
//    val filtered = list.filter(_ <= power)
//    s"${filtered.size} ${filtered.sum}"
//  }
//
//  def main(args: Array[String]): Unit = {
//    val count = scala.io.StdIn.readInt()
//    var powers = List[Int]()
//    powers = scala.io.StdIn.readLine().split(" ").map(_.trim.toInt).toList.sorted
//    if(powers.length != count)
//      for(i <- 0 to count){
//        powers = powers :+ scala.io.StdIn.readInt()
//      }
//    powers = powers.sorted
//    val eleCount = scala.io.StdIn.readInt()
//    for(i <- 1 to eleCount){
//      val element = scala.io.StdIn.readInt()
//      println(soldiersKilled(powers.toList, element))
//    }
//
//  }
//}




