

object ExtraLongFactorials {

  def appendAndDelete(s: String, t: String, k: Int) = {
    var matchedCount = 0

    def iterate(list: List[(Char, Char)], index: Int, count : Int): Int = {
      list match {
        case Nil if count > 0 => count
        case h :: t=> {
          if(h._1 == h._2) iterate(t, index, count+1)
          else iterate(Nil, count, count)
        }
      }
    }

    if(t.length > s.length) {
      matchedCount = iterate(s.toList.zip(t.toList.take(s.length)), 0, 0)
      val res = if(matchedCount == 0) (t.length - matchedCount - matchedCount) + (s.length- matchedCount)
      else (t.length - matchedCount) + (s.length- matchedCount)
      println(res)
      if(res == k) "Yes" else "No"
    }

    else if(t.length < s.length){
      matchedCount = iterate(s.take(t.length).zip(t).toList, 0, 0)
      println(matchedCount)
      val res = if(matchedCount == 0) (t.length - matchedCount - matchedCount) + (s.length- matchedCount)
      else (t.length - matchedCount) + (s.length- matchedCount)
      println(res)
      if(res == k) "Yes" else "No"
    }
    else {
      matchedCount = iterate(s.zip(t).toList, 0, 0)
      println(matchedCount)
      val movess = (t.length - matchedCount) + (s.length- matchedCount)
      val res = if(matchedCount == t.length)  (2*s.length)+1 else movess
      if(res == k) "Yes" else "No"
    }


  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn


    val s = stdin.readLine

    val t = stdin.readLine

    val k = stdin.readLine.trim.toInt

    val result = appendAndDelete(s, t, k)

    println(result)

  }

}
