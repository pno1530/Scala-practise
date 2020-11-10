

object AcmTeam {

  def acmTeam(topic: Array[String]) = {
    var ansList = scala.collection.mutable.Map.empty[(Int, Int), Int]
    for(i <- 0 until topic.length){
      for(j <- i+1 until topic.length){
          var count = topic(i).zip(topic(j)).foldLeft(0)((a, t) => if(t._1 == '1' || t._2 == '1') a+1 else a)
           ansList += ((i+1,j+1) -> count)
        }
      }
      val maxNoOfTopics = ansList.values.max
      Array(maxNoOfTopics, ansList.count(_._2 == maxNoOfTopics)).toList
    }

  def main(args: Array[String]): Unit = {

    val stdin = scala.io.StdIn

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val topic = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val topicItem = stdin.readLine
      topic(i) = topicItem}

    val result = acmTeam(topic)

    println(result)


  }
}
