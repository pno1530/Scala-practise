package org.com.ct.service.interpreter

import org.com.ct.domain
import org.com.ct.domain.InputFilePath
import Common.Input
import org.com.ct.service.Reader

import scala.io.Source
import scala.util.Try

trait FileReader extends Reader[Input]{

  override def read(source: String): Either[domain.Error, Input] =
    Try{
      Source.fromFile(source).getLines().toList
    }.fold(_ => Left(InputFilePath),
      lines => Right(lines)
    )

}
object FileReaderInterpreter extends FileReader
