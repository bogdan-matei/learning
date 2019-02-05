package repository;

import java.sql.Connection;

public interface CrudRepository<T> {

    boolean create(T object, Connection con);

    T read(Integer id, Connection con);

    boolean update(Integer id, T object, Connection con);

    boolean delete(Integer id, Connection con);

}
