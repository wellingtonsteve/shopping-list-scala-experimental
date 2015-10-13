package uk.co.stevewellington.shoppinglist.infrasctructure

import uk.co.stevewellington.shoppinglist.model.ItemName

trait ItemStore {
    
    def createItemName(itemName: ItemName)

}
