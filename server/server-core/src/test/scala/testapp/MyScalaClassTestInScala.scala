package testapp

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, FlatSpec, FunSuite}

@RunWith(classOf[JUnitRunner])
class MyScalaClassTestInScala extends FunSpec {
  
  describe("MyScalaClass") {
    it("double a number correctly") {
      val answer: Int = new MyScalaClass().doubleNumber(2)
      println("Got an answer of " + answer)
      assert(answer == 4)
    }
  }

}
