package uk.co.stevewellington.shoppinglist.testutils

import org.scalatest.FunSpecLike

trait ExceptionExpectations extends FunSpecLike {

  def expectNoExceptionsIn(runnable: => Unit) = {
    try {
      runnable
    } catch {
      case cause: Throwable => fail("Unexpected " + cause.getClass.getSimpleName + " was thrown", cause)
    }
  }

}
