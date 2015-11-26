package uk.co.stevewellington.shoppinglist

import org.eclipse.jetty.server.Server
import uk.co.stevewellington.shoppinglist.infrasctructure.ShoppingListServer

class JettyServer extends ShoppingListServer {
  
  val portNumber = 8080
  val server = new Server(portNumber)
  
  override def start(): Unit = server.start()
  override def stop(): Unit = server.stop()
  
}
