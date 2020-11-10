package org.com.ct.service.interpreter

class CompareTriplets extends FileParser with FileReader with PlayerComparator{

  def comapareTriplets(source: String) = for{
    lines <- read(source)
    inputs <- parse(lines)
    res = compare(inputs.player1, inputs.player2)
  } yield res

}
object CompareTriplets extends CompareTriplets


object Common{
  type Input = List[String]
  type PlayerReviewList = List[Int]

  case class Result(player1: Int, player2: Int)
}
