package org.com.ct.service

import org.com.ct.domain.Error

trait Reader[A] {
  def read(source: String): Either[Error, A]
}
