object binarySearchOnRange {

  def medianLessThanElemOrUpperIndex(list: List[Int], key: Int) : Int = {
    def iterate(insideList: Boolean, median: Int, low: Int, high: Int): Int = {
      if(!insideList || (key != list(median) && (median == 0 && low == 0 && high == 0))) -1
      else{
        if(key == list(median) || (key > list(median) && list.length == median+1) ) median
        else if(key > list(median-1) && key < list(median)) median-1
        else if(key > list(median) && key < list(median+1)) median
        else if(list(median) > key) {
          val high = median -1
          iterate(low <= high, (low + high)/2, low, high)
        }
        else{
            val low = median + 1
            iterate(low <= high, (low + high)/2, low, high)
        }
      }
    }
    iterate(0 <= list.length, (0 + list.length)/2, 0, list.length)
  }

  def medianGreaterThanElemOrLowerIndex(list: List[Int], key: Int) : Int = {
    def iterate(insideList: Boolean, median: Int, low: Int, high: Int): Int = {
      if(!insideList) -1
      else{
        if(key == list(median) || (key < list(median) && median == 0)) median
        else if((key > list(median) && list.length == median+1) || (key > list(median) && key < list(median+1))) median+1
        else if(key > list(median-1) && key < list(median)) median
        else if(list(median) > key) {
          val high = median -1
          iterate(low <= high, (low + high)/2, low, high)
        }
        else{
            val low = median + 1
            iterate(low <= high, (low + high)/2, low, high)
        }
      }
    }
    iterate(0 <= list.length, (0 + list.length)/2, 0, list.length)
  }

  def range(list: List[Int], min: Int, max: Int)  = {
    val lowerIndex = medianGreaterThanElemOrLowerIndex(list, min)
    val upperIndex = medianLessThanElemOrUpperIndex(list, max)
    var arr = Array[Int]()
    for(i <- lowerIndex to upperIndex){
      arr = arr :+ list(i)
    }
    arr.toList
  }

  def main(args: Array[String]): Unit = {
    println(medianGreaterThanElemOrLowerIndex(List( 7, 12,  18, 19), 10))
  }
}
