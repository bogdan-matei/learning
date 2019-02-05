package inventory;

import java.util.HashMap;
import java.util.Map;

//Generic class for storage
//MagicPouch will store only Materials while WarriorBackpack will store weapons
public class BasicStorage<T> {
    private Map<String, Integer> itemInventory;

    public BasicStorage() {
        itemInventory = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getItemInventory() {
        return itemInventory;
    }

    //Method used for checking if the item exists in order to be consumed for transmutation
    public boolean hasItem(T item) {
        return itemInventory.containsKey(item.toString());
    }

    public void addItemToStorage(T item) {
        String key = item.toString();
        if (itemInventory.containsKey(key)) {
            itemInventory.put(key, itemInventory.get(key) + 1);
        } else {
            itemInventory.put(key, 1);
        }
    }

    public void removeItemFromStorage(T item) {
        String key = item.toString();
        if (itemInventory.containsKey(key) && itemInventory.get(key) > 1) {
            itemInventory.put(key, itemInventory.get(key) - 1);
        } else if (itemInventory.get(key) == 1) {
            itemInventory.remove(key);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String i : itemInventory.keySet()) {
            stringBuilder.append(" - ").append(i).append(" x").append(itemInventory.get(i)).append('\n');
        }
        return stringBuilder.toString();
    }
}
