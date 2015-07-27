package uk.co.stevewellington.shoppinglist.actions;

import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.stevewellington.shoppinglist.infrasctructure.ItemStore;
import uk.co.stevewellington.shoppinglist.model.ItemName;

import static com.google.inject.Guice.createInjector;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddItemByNameToShoppingListTest {

	@Mock ItemStore itemStore;
	@Mock ItemName itemName; //TODO: JFixture?
	
	private AddItemByNameToShoppingList addItemByNameToShoppingList;

	@Before
	public void setUp() throws Exception {
		Injector injector = createInjector(binder -> binder.bind(ItemStore.class).toInstance(itemStore));
		addItemByNameToShoppingList = injector.getInstance(AddItemByNameToShoppingList.class);
	}

	@Test public void
	should_create_item_in_store_when_adding_new_item_by_name() {
		addItemByNameToShoppingList.addItemByNameToShoppingList(itemName);
		verify(itemStore).createItemName(itemName);
	}
}