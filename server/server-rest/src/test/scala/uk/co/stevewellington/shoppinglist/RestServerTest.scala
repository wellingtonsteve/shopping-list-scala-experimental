package uk.co.stevewellington.shoppinglist

import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.scalatest.junit.JUnitRunner
import uk.co.stevewellington.shoppinglist.actions.AddItemByNameToShoppingList
import uk.co.stevewellington.shoppinglist.model.ItemName

@RunWith(classOf[JUnitRunner])
class RestServerTest extends ScalatraSpec {

  val addItemByNameToShoppingListAction = mock[AddItemByNameToShoppingList]

  addServlet(new RestServer(addItemByNameToShoppingListAction), "/*")

  describe("When adding an Item by name") {
    it("an Item should be created in the Store") {
      post("/items/Banana") {
        verify(addItemByNameToShoppingListAction).addItemByNameToShoppingList(new ItemName("Banana"))
      }
    }

    it("the response code should be 200") {
      post("/items/Banana") {
        status should equal(200)
      }
    }
  }

}
