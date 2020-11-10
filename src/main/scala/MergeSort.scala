//object MergeSort {
//
//  def merge(list1: List[Double], list2: List[Double]): List[Double] = {
//    (list1, list2) match {
//      case (Nil, _) => list2
//      case (_, Nil) => list1
//      case (h1:: t1, h2 :: t2) => {}
//        if(h1 < h2) h1 :: merge(t1, list2)
//        else h2 :: merge(list1, t2)
//     }
//  }
//
//  def mergeSort(unsorted: List[Double]): List[Double] = {
//    unsorted match {
//      case Nil => unsorted
//      case h :: Nil => unsorted
//      case _ => {
//        val (l1, l2) = unsorted.splitAt(unsorted.length/2)
//        merge(mergeSort(l1), mergeSort(l2))
//      }
//    }
//
//  }
//
//  def main(args: Array[String]): Unit = {
////    val n = scala.io.StdIn.readLine.trim.toInt
////    val unsorted = Array.ofDim[String](n)
////    for(i <- 0 until n-1){
////      val unsortedItem = scala.io.StdIn.readLine
////      unsorted(i) = unsortedItem
////    }
//    println(mergeSort(List.fill(10)(math.random())))
//  }
//
//
//  def mergeBigSorting(arr1: Array[String], arr2: Array[String]): Array[String] = {
//    (arr1, arr2) match {
//      case (_, s) if s.length == 0 => arr2
//      case (s, _) if s.length == 0  => arr2
//      case _ => {
//        if(arr1.head < arr2.head)  arr1.head ++ mergeBigSorting(arr1.tail, arr2)
//        else arr2.head :+ mergeBigSorting(arr1, arr2.tail)
//      }
//    }
//  }
//
//  def bigSorting(unsorted: Array[String]): Array[String] = {
//    unsorted.length match {
//      case s if s < 2 => unsorted
//      case _ => {
//        val (first, second) = unsorted.splitAt(unsorted.length/2)
//        mergeBigSorting(bigSorting(first), bigSorting(second))
//      }
//    }
//
//  }
//
//
//
//}
