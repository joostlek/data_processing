package P2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OVChipKaartOracleDaoImpl extends OracleBaseDao implements OVChipKaartDao {
    @Override
    public List<OVChipKaart> findAll() throws SQLException {
        Connection connection = getConnection();
        List<OVChipKaart> ovChipKaarts = new ArrayList<>();
        String query = "SELECT * FROM OV.OV_CHIPKAART";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ovChipKaarts.add(toOVChipKaart(resultSet));
        }
        statement.close();
        connection.close();
        return ovChipKaarts;
    }

    @Override
    public OVChipKaart save(OVChipKaart ovChipKaart) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO OV.OV_CHIPKAART (KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, ovChipKaart.getKaartNummer());
        statement.setDate(2, ovChipKaart.getGeldigTot());
        statement.setInt(3, ovChipKaart.getKlasse());
        statement.setDouble(4, ovChipKaart.getSaldo());
        statement.setInt(5, ovChipKaart.getReizigerID());
        return statement.executeUpdate() == 1 ? ovChipKaart : null;
    }

    @Override
    public OVChipKaart update(OVChipKaart ovChipKaart) throws SQLException {
        Connection connection = getConnection();
        String query = "UPDATE OV.OV_CHIPKAART SET GELDIGTOT = ?, KLASSE = ?, SALDO = ?, REIZIGERID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, ovChipKaart.getGeldigTot());
        statement.setInt(2, ovChipKaart.getKlasse());
        statement.setDouble(3, ovChipKaart.getSaldo());
        statement.setInt(4, ovChipKaart.getReizigerID());
        return statement.executeUpdate() == 1 ? ovChipKaart : null;
    }

    @Override
    public boolean delete(OVChipKaart ovChipKaart) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM OV.OV_CHIPKAART WHERE KAARTNUMMER = ?");
        statement.setInt(1, ovChipKaart.getKaartNummer());
        return statement.executeUpdate() == 1;
    }

    @Override
    public void closeConnection() throws SQLException {
        getConnection().close();
    }

    @Override
    public List<OVChipKaart> findByReiziger(int reizigerId) throws SQLException {
        Connection connection = getConnection();
        List<OVChipKaart> ovChipKaarts = new ArrayList<>();
        String query = "SELECT * FROM OV.OV_CHIPKAART WHERE REIZIGERID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, reizigerId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ovChipKaarts.add(toOVChipKaart(resultSet));
        }
        statement.close();
        closeConnection();
        return ovChipKaarts;
    }

    private  OVChipKaart toOVChipKaart(ResultSet resultSet) throws SQLException {
        return new OVChipKaart(
                resultSet.getInt("KAARTNUMMER"),
                resultSet.getDate("GELDIGTOT"),
                resultSet.getInt("KLASSE"),
                resultSet.getDouble("SALDO"),
                resultSet.getInt("REIZIGERID")
        );
    }
}
