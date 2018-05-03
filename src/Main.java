import java.sql.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reiziger> reizigers = new ArrayList<>();
        for (int i =0; i < 31; i++) {
            reizigers.add(new Reiziger("jan jansen", new Date(2018, 8, i)));
        }
        ReizigerOracleDaoImpl reizigerOracleDao = new ReizigerOracleDaoImpl(reizigers);
    }
}