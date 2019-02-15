package repository;

import inventory.BasicStorage;

import java.sql.Connection;
import java.util.List;

public class BasicStorageRepository implements CrudRepository<BasicStorage> {

    @Override
    public boolean create(BasicStorage object, Connection con) {
        return false;
    }

    @Override
    public BasicStorage read(Integer id, Connection con) {
        return null;
    }

    @Override
    public boolean update(Integer id, BasicStorage object, Connection con) {
        return false;
    }

    @Override
    public boolean delete(Integer id, Connection con) {
        return false;
    }

    @Override
    public List<BasicStorage> getAll(Connection con) {
        return null;
    }
}
