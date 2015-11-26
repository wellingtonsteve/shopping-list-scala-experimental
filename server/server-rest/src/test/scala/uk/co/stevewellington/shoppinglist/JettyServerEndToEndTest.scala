package uk.co.stevewellington.shoppinglist

import java.net.{HttpURLConnection, URL}

import com.google.inject.Guice._
import org.apache.http.client.methods.HttpPut
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
        server.stop()
      }
    }
    
    it("listens on port 8080") {
      // Yeah I know the port should be config but that's a problem for later

      val server = get[ShoppingListServer] from injector
      server.start()

      val url = new URL("http://localhost:8080/")
      val connection = url.openConnection().asInstanceOf[HttpURLConnection]
      connection.setRequestMethod("GET")
      connection.connect()

      server.stop()
    }
  }

}
