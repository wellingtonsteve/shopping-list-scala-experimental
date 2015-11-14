package uk.co.stevewellington.shoppinglist

import com.google.inject.servlet.ServletModule

class ApplicationServletModule extends ServletModule {

  override def configureServlets() = {
    serve("/*") `with` classOf[ItemsServlet]
  }

}
