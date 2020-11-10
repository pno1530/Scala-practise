import scala.io.StdIn

object ClimbingLeaderBoard {

  def findRank(ranks: Seq[(Int, Int)], e: Int): Int = {
    def iterate(remainRanks: Seq[(Int, Int)], res: Int): Int = {
      remainRanks match {
        case Nil => ranks.last._2+1
        case h :: t => {
          if( e > h._1 && h._2 == 1)  h._2
          else if( e > h._1 ) h._2
          else if( e == h._1 ) h._2
          else iterate(t, res)
        }
      }
    }
    iterate(ranks, 0)
  }

  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]) = {
    val ranks: Seq[(Int, Int)] = ranked.foldLeft(List[(Int, Int)]())((a, e) => {
      if(a.isEmpty) a :+ (e, 1)
      else {
        if(e == a.last._1) a :+ (e, a.last._2)
        else a :+ (e, a.last._2+1)
      }
    })
    player.map(e => {
      findRank(ranks, e)
    }).toList
  }



  def main(args: Array[String]): Unit = {
    val rankedCount = StdIn.readLine.trim.toInt

    val ranked = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val playerCount = StdIn.readLine.trim.toInt

    val player = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = climbingLeaderboard(ranked, player)

    println(result.mkString("\n"))


  }
}
