package org.com.ct.service.interpreter

import org.com.ct.domain
import org.com.ct.domain.InputFile
import Common.{Input, PlayerReviewList}
import org.com.ct.service.Parser

import scala.util.Try

trait FileParser extends Parser[Input, Reviews]{

  override def parse(input: List[String]): Either[domain.Error, Reviews] =
    Try(input.map(str => str.split(" ").map(_.toInt).toList))
      .fold(_ => Left(InputFile), res => Right(Reviews(res.head, res(1))))

}
object FileParserInterpreter extends FileParser

case class Reviews(player1: PlayerReviewList, player2: PlayerReviewList){
  override def toString: String = s"Reviews($player1, $player2)"
}
