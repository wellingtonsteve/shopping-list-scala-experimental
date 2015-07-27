package uk.co.stevewellington.shoppinglist

import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.scalatest.FunSpecLike
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatra.test.scalatest.ScalatraSuite
import uk.co.stevewellington.shoppinglist.actions.AddItemByNameToShoppingList
import uk.co.stevewellington.shoppinglist.model.ItemName

@RunWith(classOf[JUnitRunner])
class RestServerTest extends ScalatraSuite with FunSpecLike with MockitoSugar {

  val addItemByNameToShoppingListAction = mock[AddItemByNameToShoppingList]
  
  addServlet(new RestServer(addItemByNameToShoppingListAction), "/*")
  
  describe("Rest Server") {
    it("should add item by name to list") {
      post("items/Banana") {
        verify(addItemByNameToShoppingListAction).addItemByNameToShoppingList(new ItemName("Banana"))
      }
    }
    
    // TODO: test response codes, errors
    
  }

}
