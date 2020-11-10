object MinimizingWindowString {


    def main(args: Array[String]) {
      println("op--"+MinWindowSubstring(Array("ahffaksfajeeubsne", "jefaa")));
    }

    // code goes here
    def FindIntersection(strArr: Array[String]) = {
      strArr(0).split(", ").filter(c => strArr(1).split(", ").contains(c)).mkString(", ");
    }

  def MinWindowSubstring(strArr: Array[String]) = {
//    val res1 = strArr(1).toList.foldLeft(List[(Char, List[Int])]())(
//      (a,e) =>  a :+ ( e, searchString.filter(t => t._1 == e).map(_._2)) )
//
//    for{
//      res1(strArr(1).toList())
//    }


    def iterate(string: List[Char], t: List[Char], res: List[Int]): List[Int] = {
      string match {
        case a if string.length < t.length => res
        case _ => {
          val indexes = t.foldLeft((string.zipWithIndex, List[Int]()))((a,e) => {
//            println(a, e)
            (a._1 diff(List(a._1.find(t => t._1 == e).getOrElse(' ', 0)) ), a._2 :+ a._1.find(_._1==e).getOrElse(' ', 0)._2)
          })._2
          val count = indexes.max - indexes.min
//          println("buffer--"+(res:+count))
          if(count >= t.length)
            iterate(string.tail, t, res:+count)
          else iterate(string.tail, t, res)
        }
      }

    }
    iterate(strArr(0).toList, strArr(1).toList, List.empty).min


//    res1


  }


}
