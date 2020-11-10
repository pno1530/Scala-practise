

object JumpingOnClouds {

  def jumpingOnClouds(c: Array[Int]): Int = {
    def iterate(remain: List[Int], count: Int): Int = {
      remain match {
        case Nil => count

        case h1 :: h2 :: t =>{
          if(h2 == 0) iterate(t, count+1)
          else if((h1 == 1) && (h2 == 1)) iterate(t, count-1)
          else iterate(h2 :: t, count +1)
        }
        case h :: t =>{
          if(h == 0) iterate(Nil, count+1)
          else iterate(Nil, count-1)
        }
      }
    }
    val first = if(c.head == 0) 0 else -1
    iterate(c.tail.toList, first)

  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    println(result)

  }
}
