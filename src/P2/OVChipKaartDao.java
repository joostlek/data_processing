package P2;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface OVChipKaartDao {
    public List<OVChipKaart> findAll() throws SQLException;

    public OVChipKaart save(OVChipKaart ovChipKaart) throws SQLException;

    public OVChipKaart update(OVChipKaart ovChipKaart) throws SQLException;

    public boolean delete(OVChipKaart ovChipKaart) throws SQLException;

    public void closeConnection() throws SQLException;

    public List<OVChipKaart> findByReiziger(int reizigerId) throws SQLException;

    public List<Integer> findByProduct(int productNummer) throws SQLException;
}
