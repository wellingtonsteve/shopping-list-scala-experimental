package uk.co.stevewellington.shoppinglist

import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore
import uk.co.stevewellington.shoppinglist.model.ItemName

import scala.collection.mutable

class InMemoryItemStore extends ItemStore {

  val itemNames: mutable.HashSet[ItemName] = mutable.HashSet()

  override def createItemName(itemName: ItemName) = itemNames.add(itemName)

}
