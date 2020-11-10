package org.com.ct.main

import org.com.ct.service.interpreter.CompareTriplets

object App {
  def main(args: Array[String]): Unit = {
    val filePath = "resources/Input.txt"

    println("hi-----"+  CompareTriplets.comapareTriplets(filePath))

  }
}