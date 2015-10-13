package uk.co.stevewellington.shoppinglist

import com.google.inject.Guice.createInjector
import com.google.inject.servlet.GuiceServletContextListener

//noinspection JavaAccessorMethodOverridenAsEmptyParen
class MyGuiceServletConfig extends GuiceServletContextListener {

  override def getInjector() = createInjector(new ApplicationServletModule)

}
