package uk.co.stevewellington.shoppinglist

import java.util.EnumSet._
import javax.servlet.DispatcherType

import com.google.inject.servlet.GuiceFilter
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler

object JettyLauncher {

  val portNumber = 8080
  val server = new Server(portNumber)
  val handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)

  handler.addFilter(classOf[GuiceFilter], "/*", allOf(classOf[DispatcherType]))
  handler.addEventListener(new MyGuiceServletConfig)
  server.setHandler(handler)

  def main(args: Array[String]) {
    server.start()
    server.join()
  }

}
