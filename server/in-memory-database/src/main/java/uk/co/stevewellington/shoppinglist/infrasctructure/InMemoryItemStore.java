package uk.co.stevewellington.shoppinglist.infrasctructure;

import com.google.common.collect.Sets;
import uk.co.stevewellington.shoppinglist.model.ItemName;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class InMemoryItemStore implements ItemStore {

    private final Set<ItemName> itemNames = newHashSet();

    @Override
    public void createItemName(ItemName itemName) {
        itemNames.add(itemName);
    }
}
