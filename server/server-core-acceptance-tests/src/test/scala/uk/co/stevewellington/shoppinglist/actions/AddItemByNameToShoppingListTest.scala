package uk.co.stevewellington.shoppinglist.actions

import com.google.inject.AbstractModule
import com.google.inject.Guice.createInjector
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore
import uk.co.stevewellington.shoppinglist.model.ItemName
import uk.co.stevewellington.shoppinglist.testutils.{Fixture, Guice, UnitSpec}

@RunWith(classOf[JUnitRunner])
class AddItemByNameToShoppingListTest extends UnitSpec with MockitoSugar with Fixture with Guice {

  val itemStore = mock[ItemStore]
  val itemName = fixture[ItemName]

  val injector = createInjector(new AbstractModule {
    override def configure() = bind(classOf[ItemStore]) toInstance itemStore
  })

  val addItemByNameToShoppingList = get[AddItemByNameToShoppingList] from injector

  describe("When adding an item by name") {
    it("AddItemByNameToShoppingList should create an item in the store") {
      addItemByNameToShoppingList.addItemByNameToShoppingList(itemName)
      verify(itemStore).createItemName(itemName)
    }
  }
}
