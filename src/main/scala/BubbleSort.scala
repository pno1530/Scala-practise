import scala.collection.mutable.ArrayBuffer

object BubbleSort {
  def sort(unsorted: Array[String]): List[String] = {
    for(i <- 0 until unsorted.length -1){
      for(j <- 0 until unsorted.length-1-i){
        if( BigInt(unsorted(j))   > BigInt(unsorted(j+1))){
          val temp = unsorted(j)
          unsorted(j) = unsorted(j+1)
          unsorted(j+1) = temp
        }
      }
    }
    unsorted.toList

  }

  def merge(list1: List[String], list2: List[String]): List[String] = {
    (list1, list2) match {
      case (Nil, _) => list2
      case (_, Nil) => list1
      case (h1:: t1, h2 :: t2) => {}
        if(BigInt(h1) < BigInt(h2)) h1 :: merge(t1, list2)
        else h2 :: merge(list1, t2)
    }
  }

  def mergeSort(unsorted: List[String]): List[String] = {
    unsorted.length match {
      case s if s < 2 => unsorted
      case _ => {
        val (l1, l2) = unsorted.splitAt(unsorted.length/2)
        merge(mergeSort(l1), mergeSort(l2))
      }
    }

  }

  def quickSort(list: List[String]): List[String] = list match {
    case Nil => Nil
    case h :: Nil => list
    case _ => {
      val p = list.head
      val (first, second) = list.partition(e => BigInt(e) < BigInt(p))
      quickSort(first) ++ (p :: quickSort(second))
    }
  }

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine.trim.toInt
    val unsorted = scala.collection.mutable.ArrayBuffer[String]()
    for(i <- 1 to n){
      val unsortedItem = scala.io.StdIn.readLine

        val index = unsorted.lastIndexWhere(e => BigInt(e) < BigInt(unsortedItem))
        if(index < 0) unsorted.insert(0, unsortedItem)
        else unsorted.insert(unsorted.lastIndexWhere(e => BigInt(e) < BigInt(unsortedItem))+1, unsortedItem)

    }
    println(unsorted.toList)
  }
}

