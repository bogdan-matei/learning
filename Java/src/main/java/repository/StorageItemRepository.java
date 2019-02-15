package repository;

import database.DbConnection;
import general.StorageItem;
import general.Type;
import items.Sword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StorageItemRepository implements CrudRepository<StorageItem> {

    @Override
    public boolean create(StorageItem object, Connection con) {
        boolean result = true;
        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement("INSERT INTO storage_item VALUES (?,?,?)");
            stmt.setInt(1, 0);
            stmt.setString(2, object.getName());

            String type = String.valueOf(object instanceof Sword ? Type.SWORD : Type.WAND);
            stmt.setString(3, type);

            stmt.execute();
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    @Override
    public StorageItem read(Integer id, Connection con) {
        Sword sword;
        ResultSet rs = null;
        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement("SELECT * FROM storage_item WHERE id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            rs.next();
            sword = new Sword();
            sword.setName(rs.getString("name"));

        } catch (SQLException e) {
            sword = null;
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sword;
    }

    @Override
    public boolean update(Integer id, StorageItem object, Connection con) {
        boolean result;
        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement("UPDATE storage_item SET name=? WHERE id=?");
            stmt.setString(1, object.getName());
            stmt.setInt(2, id);

            result = stmt.execute();
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(Integer id, Connection con) {
        boolean result;
        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement("DELETE FROM storage_item WHERE id=?");
            stmt.setInt(1, id);

            result = stmt.execute();
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    @Override
    public List<StorageItem> getAll(Connection con) {
        List<StorageItem> swordList = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement stmt = DbConnection.getConnection().prepareStatement("SELECT * FROM storage_item");
            rs = stmt.executeQuery();

            while(rs.next()){
                Sword sword = new Sword();
                sword.setName(rs.getString("name"));
                swordList.add(sword);
            }

        } catch (SQLException e) {
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return swordList;
    }
}
