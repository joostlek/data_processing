import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigersDao {
    private List<Reiziger> reizigers;
    public ReizigerOracleDaoImpl(List<Reiziger> reizigers) {
        this.reizigers = reizigers;
    }

    @Override
    public List<Reiziger> findAll() {
        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String GBdatum) {
        List<Reiziger> reizigerList = new ArrayList<>();
        for(Reiziger reiziger: this.reizigers) {
            if (reiziger.getGbdatum().toString().equals(GBdatum)) {
                reizigerList.add(reiziger);
            }
        }
        return reizigerList;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        this.reizigers.add(reiziger);
        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        for(Reiziger reiziger1: this.reizigers) {
            if (reiziger1.equals(reiziger)) {
                reiziger1.setGbdatum(reiziger.getGbdatum());
                reiziger1.setNaam(reiziger.getNaam());
            }
        }
        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        this.reizigers.remove(reiziger);
        return true;
    }

    @Override
    public void closeConnection() {

    }
}
