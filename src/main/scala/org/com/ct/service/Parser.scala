package org.com.ct.service

import org.com.ct.domain.Error

trait Parser[A, B] {
  def parse(input: A): Either[Error, B]
}
