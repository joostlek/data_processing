package P2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {

    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM OV.PRODUCT");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            products.add(toProduct(resultSet));
        }
        return products;
    }

    @Override
    public List<Product> getProductsByKaartNummer(int kaartnummer) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT PRODUCT.* FROM OV.OV_CHIPKAART_PRODUCT, OV.PRODUCT WHERE PRODUCT.PRODUCTNUMMER = OV_CHIPKAART_PRODUCT.PRODUCTNUMMER AND PRODUCT.PRODUCTNUMMER = ?");
        statement.setInt(1, kaartnummer);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            products.add(toProduct(resultSet));
        }
        return products;
    }

    private Product toProduct(ResultSet resultSet) throws SQLException {
        OVChipKaartOracleDaoImpl chipKaartOracleDao = new OVChipKaartOracleDaoImpl();
        return new Product(resultSet.getInt(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getDouble(4),
                chipKaartOracleDao.findByProduct(resultSet.getInt(1)));
    }
}
