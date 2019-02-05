package database;

import items.Sword;
import materials.Iron;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.StorageItemRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StorageItemRepositoryTest {

    private Connection con;
    private StorageItemRepository itemRepository;

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/am?useSSL=false", "root", "root");
        itemRepository = new StorageItemRepository();
    }

    @Test
    public void whenValidObjectRepositoryShouldReturnTrue() {

        Sword trainingSword = new Sword();
        trainingSword.setName("Training Sword");

        boolean result = itemRepository.create(trainingSword, con);

        Assert.assertTrue(result);
    }

    @Test
    public void whenNotValidObjectRepositoryShouldReturnFalse() {

        Iron iron = new Iron(10);

        boolean result = itemRepository.create(iron, con);

        Assert.assertFalse(result);
    }

}
