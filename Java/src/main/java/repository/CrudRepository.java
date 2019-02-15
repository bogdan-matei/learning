package repository;

import java.sql.Connection;
import java.util.List;

public interface CrudRepository<T> {

    boolean create(T object, Connection con);

    T read(Integer id, Connection con);

    boolean update(Integer id, T object, Connection con);

    boolean delete(Integer id, Connection con);

    List<T> getAll(Connection con);
}
