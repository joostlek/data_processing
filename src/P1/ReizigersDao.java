package P1;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface ReizigersDao {
    public List<Reiziger> findAll() throws SQLException;

    public List<Reiziger> findByGBdatum(Date date) throws SQLException;

    public Reiziger save(Reiziger reiziger) throws SQLException;

    public Reiziger update(Reiziger reiziger) throws SQLException;

    public boolean delete(Reiziger reiziger) throws SQLException;

    public void closeConnection() throws SQLException;
}
