import javax.rmi.CORBA.Util

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.util.{Random, Try}

//
//object FutureSync {
//
//  def pause(duration: Int, str: String, num: Int) = {
//    println("str---"+str)
//    Thread.sleep(duration)
//    println("num---"+num)
//    Future(num)
//  }
//
//  val a = pause(10000, "a", 123)
//  val b = pause(1000, "b", 222)
//
//  def main(args: Array[String]): Unit = {
////    for{
////      a <- a
//////      c <- Future(throw new Exception)
////      bb <- b
////      bc <- b
////    } yield println("res---" + (a+bb))
//  }
//}

import java.time.LocalDateTime

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object Example extends App {
  //
  //  def taskHello: Future[Unit] = {
  //    Future{
  //      printInfo("Starting Task-Hello")
  //      println("Hello")
  //      printInfo("Finished Task-Hello")
  //    }
  //
  //  }
  //
  //  def main(args: Array[String]): Unit = {
  //    printInfo("Start Program")
  //    val task: Future[Unit] = taskHello
  //    printInfo("Continue")
  //    Await.result(task, Duration.Inf)
  //  }
  //  def printInfo(txt: String): Unit = {
  //    val thread = Thread.currentThread.getName
  //    println(s"${LocalDateTime.now} [$thread] $txt")
  //  }






//  import scala.concurrent.duration._
//
//  def futureT(str: String) = Future {
//    println("-----"+Thread.currentThread().getName + ":"+ str)
//    Thread.sleep(1000)
//    println(str)
//  }
//
//  println("b")
//
//  val futureTT = for {
//    a <- futureT("bb")
////    println("----"+a)
//    q <- futureT("qq")
//    aa <- futureT("aa")
////    println("c" + Await.result("", 1 second))
//  } yield "done"
//  Await.result(futureTT, 4 second)
}

object Result1 extends App {

//  println("Step 1: Define a method which returns a Future")
//  import scala.concurrent.Future
//  import scala.concurrent.ExecutionContext.Implicits.global
//
//  def donutStock(donut: String): Future[Int] = Future {
//    // assume some long running database operation
//    println("checking donut stock")
//    Thread.sleep(10000)
//    10
//  }
//
//  println("\nStep 2: Non blocking future result")
//  import scala.util.{Failure, Success}
//  donutStock("vanilla donut").onComplete {
//    case Success(stock) => println(s"Stock for vanilla donut = $stock")
//    case Failure(e) => println(s"Failed to find vanilla donut stock, exception = $e")
//  }
//  Thread.sleep(1000)

//  val a = println("hi")


//  val a =

  val l = List(Some(1), Some(2), None)

  val res = l.foldLeft(List.empty[Int])((a,option) =>  if(option.isDefined) a :+ option.get else a)

  try()

  println(res)

  val res1 = for{
    a <- l
    b <- a
  } yield b

  println(res1)


// def factorials(num: Int, res: Int) : Int = {
//   def iterate(status: Boolean, res: Int, count: ) : Int = {
//     status match {
//       case true => res
//       case _ => {
//         if()
//         iterate()
//       }
//     }
//   }
// }
//  UserAlerts("", "")
//
//  case class UserAlerts(id)
//
//  object
//
//  /drugs/



}
