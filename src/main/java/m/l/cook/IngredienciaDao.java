package m.l.cook;

import java.util.List;

public interface IngredienciaDao {
        
    List<Ingrediencia> dajIngrediencie();
    
    void pridajIngrediencie(Ingrediencia ingrediencia);
}
