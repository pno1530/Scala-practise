package org.com.ct.service

import org.com.ct.domain.Error

trait Comparator[PlayerReviewList, Result] {
  def compare(player1List: PlayerReviewList, player2List: PlayerReviewList): Result
}
