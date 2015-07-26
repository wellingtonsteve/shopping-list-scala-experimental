package uk.co.stevewellington.shoppinglist

import org.scalatra.ScalatraServlet

class RestServer(someBusinessLogicAction: SomeBusinessLogicAction) extends ScalatraServlet {

  post("/do/some/action") {
    someBusinessLogicAction.doAction()
  }
  
  post("/do/some/otheraction") {
    someBusinessLogicAction.doOtherAction()
  }
  
}
