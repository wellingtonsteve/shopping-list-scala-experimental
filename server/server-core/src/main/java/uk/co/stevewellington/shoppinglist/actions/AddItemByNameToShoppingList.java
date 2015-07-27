package uk.co.stevewellington.shoppinglist.actions;

import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore;
import uk.co.stevewellington.shoppinglist.model.ItemName;

import javax.inject.Inject;

public class AddItemByNameToShoppingList {
	
	private final ItemStore itemStore;
	
	@Inject public AddItemByNameToShoppingList(ItemStore itemStore) {
		this.itemStore = itemStore;
	}

	public void addItemByNameToShoppingList(ItemName itemName) {
		itemStore.createItemName(itemName);
		// TODO: something smells here. The business logic never touches the name inside ItemName
	}

}
