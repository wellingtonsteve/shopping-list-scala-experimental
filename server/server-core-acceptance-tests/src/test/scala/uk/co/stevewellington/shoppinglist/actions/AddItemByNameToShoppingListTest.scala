package uk.co.stevewellington.shoppinglist.actions

import com.flextrade.jfixture.JFixture
import com.google.inject.{AbstractModule, Guice}
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FunSpecLike, Suite}
import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore
import uk.co.stevewellington.shoppinglist.model.ItemName

@RunWith(classOf[JUnitRunner])
class AddItemByNameToShoppingListTest extends Suite with FunSpecLike with MockitoSugar {
    
    val fixture = new JFixture
    
    val itemStore = mock[ItemStore]
    val itemName = fixture.create(classOf[ItemName])
    
    val injector = Guice.createInjector(new AbstractModule {
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
