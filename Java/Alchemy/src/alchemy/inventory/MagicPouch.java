package alchemy.inventory;

import alchemy.general.ConversionRate;
import alchemy.materials.BasicMaterial;
import alchemy.materials.Iron;

import java.util.Map;

//The methods of adding and removing were Overriden due to the quantity field in the BasicMaterials
public class MagicPouch extends BasicStorage<BasicMaterial> {

    @Override
    public void addItemToStorage(BasicMaterial material) {
        String key = material.toString();
        Map<String, Integer> itemInventory = super.getItemInventory();

        if (itemInventory.containsKey(key)) {
            itemInventory.put(key, itemInventory.get(key) + material.getQuantity());
        } else {
            itemInventory.put(key, material.getQuantity());
        }
    }

    @Override
    public void removeItemFromStorage(BasicMaterial material) {
        String key = material.toString();
        Integer conversion;
        Map<String, Integer> itemInventory = super.getItemInventory();

        if (material instanceof Iron) {
            conversion = ConversionRate.IRON_TO_SWORD;
        } else {
            conversion = ConversionRate.ARCANE_DUST_TO_WAND;
        }

        if (itemInventory.containsKey(key)) {
            itemInventory.put(key, (itemInventory.get(key) - conversion));
        } else {
            itemInventory.remove(key);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("------------------------------------------------------\n");
        builder.append("You now have in your magic pouch the following:\n");
        builder.append(super.toString());
        builder.append("------------------------------------------------------\n");
        return builder.toString();
    }
}
