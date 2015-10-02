package uk.co.stevewellington.shoppinglist

import javax.inject.{Inject, Singleton}

import org.scalatra.ScalatraServlet
import uk.co.stevewellington.shoppinglist.actions.AddItemByNameToShoppingList
import uk.co.stevewellington.shoppinglist.model.ItemName

@Singleton
class RestServer @Inject()(addItemByNameToShoppingListAction: AddItemByNameToShoppingList) extends ScalatraServlet {

    post("/items/:itemName") {
        val itemName = new ItemName(params("itemName"))
        addItemByNameToShoppingListAction.addItemByNameToShoppingList(itemName)
    }
    
}
