package uk.co.stevewellington.shoppinglist

import com.google.inject.Guice._
import org.junit.runner.RunWith
import org.scalatest.FunSpecLike
import org.scalatest.junit.JUnitRunner
import uk.co.stevewellington.shoppinglist.infrasctructure.ShoppingListServer
import uk.co.stevewellington.shoppinglist.testutils.{ExceptionExpectations, Guice}

@RunWith(classOf[JUnitRunner])
class JettyServerEndToEndTest extends FunSpecLike with Guice with ExceptionExpectations {

  val injector = createInjector(new JettyServerModule)

  describe("JettyServer instance") {    
    it("can be started") {
      expectNoExceptionsIn {
        val server = get[ShoppingListServer] from injector
        server.start()
      }
    }
  }

}
