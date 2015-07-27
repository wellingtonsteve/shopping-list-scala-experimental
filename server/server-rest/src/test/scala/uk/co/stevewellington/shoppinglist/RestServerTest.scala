package uk.co.stevewellington.shoppinglist

import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.scalatest.FunSpecLike
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatra.test.scalatest.ScalatraSuite

@RunWith(classOf[JUnitRunner])
class RestServerTest extends ScalatraSuite with FunSpecLike with MockitoSugar {

  val someBusinessLogicAction = mock[SomeBusinessLogicAction]
  
  addServlet(new RestServer(someBusinessLogicAction), "/*")
  
  describe("Rest Server") {
    it("should do some action") {
      post("do/some/action") {
        verify(someBusinessLogicAction).doAction()
      }
    }
    
    it("should do some other action") {
      post("do/some/otheraction") {
        verify(someBusinessLogicAction).doOtherAction()
      }
    }
  }

}
