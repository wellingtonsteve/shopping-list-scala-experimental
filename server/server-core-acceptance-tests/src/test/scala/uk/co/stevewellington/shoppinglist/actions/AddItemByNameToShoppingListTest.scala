package uk.co.stevewellington.shoppinglist.actions

import com.flextrade.jfixture.JFixture
import com.google.inject.Guice.createInjector
import com.google.inject.{AbstractModule, Guice}
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner
import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore
import uk.co.stevewellington.shoppinglist.model.ItemName

@RunWith(classOf[JUnitRunner])
class AddItemByNameToShoppingListTest extends UnitSpec with Fixture {

  val itemStore = mock[ItemStore]
  val itemName = fixture[ItemName]

  val injector = createInjector(new AbstractModule {
    override def configure() = bind(classOf[ItemStore]) toInstance itemStore
  })

  val addItemByNameToShoppingList = injector.getInstance(classOf[AddItemByNameToShoppingList])

  describe("When adding an item by name") {
    it("AddItemByNameToShoppingList should create an item in the store") {
      addItemByNameToShoppingList addItemByNameToShoppingList itemName
      verify(itemStore).createItemName(itemName)
    }
  }

}
