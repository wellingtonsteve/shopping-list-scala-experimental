package uk.co.stevewellington.shoppinglist.actions

import com.google.inject.Inject
import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore
import uk.co.stevewellington.shoppinglist.model.ItemName

class AddItemByNameToShoppingList @Inject()(itemStore: ItemStore) {

  def addItemByNameToShoppingList(itemName: ItemName) = itemStore.createItemName(itemName)

}
