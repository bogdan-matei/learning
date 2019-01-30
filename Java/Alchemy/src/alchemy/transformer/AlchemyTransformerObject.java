package alchemy.transformer;

import alchemy.general.StorageItem;
import alchemy.general.Type;
import alchemy.inventory.BasicStorage;
import alchemy.items.BasicWeapon;
import alchemy.items.Sword;
import alchemy.items.Wand;
import alchemy.materials.ArcaneDust;
import alchemy.materials.BasicMaterial;
import alchemy.materials.Iron;

//This the object that will be passed to Alchemy class in order to exchange weapon into materials and vice-versa
public class AlchemyTransformerObject {

    private BasicStorage<BasicWeapon> itemStorage;
    private BasicStorage<BasicMaterial> materialStorage;
    private StorageItem item;

    public AlchemyTransformerObject(BasicStorage<BasicWeapon> itemStorage,
                                    BasicStorage<BasicMaterial> materialStorage) {
        this.itemStorage = itemStorage;
        this.materialStorage = materialStorage;
    }

    public BasicStorage<BasicWeapon> getItemStorage() {
        return itemStorage;
    }

    public BasicStorage<BasicMaterial> getMaterialStorage() {
        return materialStorage;
    }

    public StorageItem getItem() {
        return item;
    }

    //Setting which type to exchange
    //If Iron is selected, Alchemy will try to transmute it to a sword
    public void setItem(Type item) {
        if ("SWORD".equals(item.name())) {
            this.item = new Sword();
        } else if ("WAND".equals(item.name())) {
            this.item = new Wand();
        } else if ("IRON".equals(item.name())) {
            this.item = new Iron();
        } else if ("ARCANE_DUST".equals(item.name())) {
            this.item = new ArcaneDust();
        }
    }

}
