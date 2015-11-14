package uk.co.stevewellington.shoppinglist

import com.google.inject.AbstractModule
import uk.co.stevewellington.shoppinglist.infrasctructure.ShoppingListServer

class JettyServerModule extends AbstractModule {
  override def configure() = bind(classOf[ShoppingListServer]) to classOf[JettyServer]
}
