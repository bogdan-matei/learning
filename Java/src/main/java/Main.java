import database.DbConnection;
import general.Type;
import inventory.MagicPouch;
import inventory.WarriorBackpack;
import items.Sword;
import items.Wand;
import materials.ArcaneDust;
import materials.Iron;
import repository.StorageItemRepository;
import transformer.Alchemy;
import transformer.AlchemyTransformerObject;

import java.sql.Connection;
import java.sql.SQLException;

/*
It was written with Java6.
The purpose of this package is to offer an example of collections, generic and exceptions (and more to be added)
for people that are learning Java.
 */
public class Main {

    public static void main(String[] args) {

        Connection con = DbConnection.getConnection();

        itemRepositoryExample(con);

        try {
            DbConnection.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static void itemRepositoryExample(Connection con) {
        StorageItemRepository itemRepository = new StorageItemRepository();

        Sword trainingSword = new Sword();
        trainingSword.setName("AM Sword");

        itemRepository.create(trainingSword, con);

        trainingSword.setName("Dev Sword");
        itemRepository.update(2, trainingSword, con);

        Sword sword = (Sword) itemRepository.read(2, con);
        System.out.println(sword.toString() + sword.getName());

        itemRepository.delete(3, con);
    }

    public void genericExample() {
        // From previous 'module'

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


}
