package uk.co.stevewellington.shoppinglist

import org.scalatra.ScalatraServlet
import uk.co.stevewellington.shoppinglist.actions.AddItemByNameToShoppingList
import uk.co.stevewellington.shoppinglist.model.ItemName

class RestServer(addItemByNameToShoppingListAction: AddItemByNameToShoppingList) extends ScalatraServlet {

    post("/items/:itemName") {
        val itemName = new ItemName(params("itemName"))
        addItemByNameToShoppingListAction.addItemByNameToShoppingList(itemName)
    }

}
