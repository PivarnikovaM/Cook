package m.l.cook;

import java.util.List;


public interface NakupnyZoznamDao {
    
     List<NakupnyZoznam> dajNakupnyZoznam();
    
    void pridaj(NakupnyZoznam nakupnyZoznam);
    
    
    
}
