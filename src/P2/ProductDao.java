package P2;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public List<Product> getProducts() throws SQLException;
    public List<Product> getProductsByKaartNummer(int kaartnummer) throws SQLException;
}
