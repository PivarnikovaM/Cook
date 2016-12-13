package m.l.cook;

import java.util.List;

public interface JedalnicekDao {

    public List<Jedalnicek> dajJedalnicek();
    
    public void saveOrUpdate(Jedalnicek jedalnicek);
    
    public void vymazAkJePo();
    
    
    
}
