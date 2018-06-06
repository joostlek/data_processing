package P1;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigersDao {
    @Override
    public List<Reiziger> findAll() throws SQLException {
        Connection connection = getConnection();
        List<Reiziger> reizigers = new ArrayList<>();
        String query = "SELECT * FROM OV.REIZIGER";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            reizigers.add(new Reiziger(resultSet.getString("ACHTERNAAM"), resultSet.getDate("GEBORTEDATUM")));
        }
        statement.close();
        connection.close();
        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(Date date) throws SQLException {
        Connection connection = getConnection();
        List<Reiziger> reizigers = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OV.REIZIGER WHERE GEBORTEDATUM = ?");
        preparedStatement.setDate(1, date);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            reizigers.add(new Reiziger(resultSet.getString("ACHTERNAAM"), resultSet.getDate("GEBORTEDATUM")));
        }
        preparedStatement.close();
        connection.close();
        return reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO OV.REIZIGER (ACHTERNAAM, VOORLETTERS, GEBORTEDATUM) VALUES (?, J, ?)");
        preparedStatement.setString(1, reiziger.getNaam());
        preparedStatement.setDate(2, reiziger.getGbdatum());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return reiziger;

    }

    @Override
    public Reiziger update(Reiziger reiziger) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OV.REIZIGER SET ACHTERNAAM = ? AND GEBORTEDATUM = ? WHERE GEBORTEDATUM = ? AND ACHTERNAAM = ?");
        preparedStatement.setString(1, reiziger.getNaam());
        preparedStatement.setDate(2, reiziger.getGbdatum());
        preparedStatement.setString(4, reiziger.getNaam());
        preparedStatement.setDate(3, reiziger.getGbdatum());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM OV.REIZIGER WHERE ACHTERNAAM = ? AND GEBORTEDATUM = ?");
        preparedStatement.setString(1, reiziger.getNaam());
        preparedStatement.setDate(2, reiziger.getGbdatum());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return true;
    }

    @Override
    public void closeConnection() throws SQLException {
        getConnection().close();
    }
}
