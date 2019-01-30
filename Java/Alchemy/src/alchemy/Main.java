package alchemy;

import alchemy.general.Type;
import alchemy.inventory.MagicPouch;
import alchemy.inventory.WarriorBackpack;
import alchemy.items.Sword;
import alchemy.items.Wand;
import alchemy.materials.ArcaneDust;
import alchemy.materials.Iron;
import alchemy.transformer.Alchemy;
import alchemy.transformer.AlchemyTransformerObject;

/*
It was written with Java6.
The purpose of this package is to offer an example of collections, generic and exceptions (and more to be added)
for people that are learning Java.
 */
public class Main {

    public static void main(String[] args) {

        Alchemy alchemy = new Alchemy();
        MagicPouch pouch = new MagicPouch();
        WarriorBackpack backpack = new WarriorBackpack();
        AlchemyTransformerObject alchemyTransformer = new AlchemyTransformerObject(backpack, pouch);

        //Check the comment from populate
        populate(pouch, backpack);

        //Trying to use alchemy to create a sword
        alchemyTransformer.setItem(Type.SWORD);
        alchemy.transmute(alchemyTransformer);
        System.out.println(inventoryOverview(alchemyTransformer));

        //Trying to exchange one Sword for Iron
        alchemyTransformer.setItem(Type.IRON);
        alchemy.transmute(alchemyTransformer);

        System.out.println(inventoryOverview(alchemyTransformer));

        //We currently have two Swords, if 3 are trying to be crafted the custom exception will be printed
        alchemyTransformer.setItem(Type.SWORD);
        alchemy.transmute(alchemyTransformer);
        alchemy.transmute(alchemyTransformer);

        System.out.println(inventoryOverview(alchemyTransformer));

        alchemy.transmute(alchemyTransformer);

    }


    private static void populate(MagicPouch pouch, WarriorBackpack backpack) {
        /*
        We start with:
        - Iron x15
        - Arcane Dust x10
        - Sword x2
        - Wand x1
        * */
        Sword trainingSword = new Sword();
        Sword knightSword = new Sword();
        Wand apprenticeWand = new Wand();

        pouch.addItemToStorage(new ArcaneDust(10));
        pouch.addItemToStorage(new Iron(15));

        backpack.addItemToStorage(trainingSword);
        backpack.addItemToStorage(knightSword);
        backpack.addItemToStorage(apprenticeWand);

    }

    public static String inventoryOverview(AlchemyTransformerObject transformerObject) {

        return "Trying to transmute: " + transformerObject.getItem() + "\n" +
                "\n\n" + transformerObject.getMaterialStorage() + "\n" +
                transformerObject.getItemStorage() + "\n\n";
    }


}
