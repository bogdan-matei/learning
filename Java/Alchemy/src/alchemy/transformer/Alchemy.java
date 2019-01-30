package alchemy.transformer;

import alchemy.exception.ConversionException;
import alchemy.general.StorageItem;
import alchemy.inventory.BasicStorage;
import alchemy.items.BasicWeapon;
import alchemy.items.Sword;
import alchemy.items.Wand;
import alchemy.materials.ArcaneDust;
import alchemy.materials.BasicMaterial;
import alchemy.materials.Iron;

public class Alchemy {

    private FighterAlchemy fighterAlchemy;
    private MageAlchemy mageAlchemy;

    public Alchemy() {
        fighterAlchemy = new FighterAlchemy();
        mageAlchemy = new MageAlchemy();
    }

    public void transmute(AlchemyTransformerObject transformerObject) {
        try {

            StorageItem item = transformerObject.getItem();
            BasicStorage<BasicWeapon> weaponStorage = transformerObject.getItemStorage();
            BasicStorage<BasicMaterial> materialStorage = transformerObject.getMaterialStorage();

            if (transformerObject.getItem() instanceof BasicMaterial && materialStorage.hasItem((BasicMaterial) item)) {
                ((BasicMaterial) item).setQuantity(materialStorage.getItemInventory().get(item.toString()));
                BasicWeapon weapon = convertToWeapon((BasicMaterial) item);
                materialStorage.removeItemFromStorage((BasicMaterial) item);
                weaponStorage.addItemToStorage(weapon);
            } else if (transformerObject.getItem() instanceof BasicWeapon && weaponStorage.hasItem((BasicWeapon) item)) {
                BasicMaterial material = convertToMaterials((BasicWeapon) transformerObject.getItem());
                weaponStorage.removeItemFromStorage((BasicWeapon) item);
                materialStorage.addItemToStorage(material);
            } else {
                throw new ConversionException();
            }

        } catch (ConversionException e) {
            System.out.println(e.getMessage());
        }
    }

    private BasicMaterial convertToMaterials(BasicWeapon item) {

        BasicMaterial material;
        if (item instanceof Sword) {
            material = fighterAlchemy.convertToMaterials((Sword) item);
        } else {
            material = mageAlchemy.convertToMaterials((Wand) item);
        }

        return material;
    }

    private BasicWeapon convertToWeapon(BasicMaterial item) throws ConversionException {
        BasicWeapon weapon;

        if (item instanceof Iron) {
            weapon = fighterAlchemy.convertFromMaterials((Iron) item);
        } else {
            weapon = mageAlchemy.convertFromMaterials((ArcaneDust) item);
        }

        if (weapon == null)
            throw new ConversionException();

        return weapon;
    }

}
