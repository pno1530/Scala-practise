package org.com.ct.service.interpreter

import org.com.ct.service.Comparator
import org.com.ct.service.interpreter.Common.{PlayerReviewList, Result}

trait PlayerComparator extends Comparator[PlayerReviewList, Result]{

  override def compare(player1List: PlayerReviewList, player2List: PlayerReviewList): Result =
    player1List.zip(player2List)
      .foldLeft(Result(0, 0))(
        (a, p) =>
          if(p._1 < p._2) a.copy(player2 = a.player2 + 1)
          else if(p._1 > p._2) a.copy(player1 = a.player1 + 1)
          else a
      )
}
object PlayerComparatorInterpretor extends PlayerComparator