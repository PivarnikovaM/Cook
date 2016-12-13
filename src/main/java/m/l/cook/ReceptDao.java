package m.l.cook;


import java.util.List;

public interface ReceptDao {

    List<Recept> dajRecepty();
    
    void zmaz(Recept recept);
    
    void pridajRecept(Recept recept,String ingrediencie);
    
    List<Recept> vyhladajReceptyPodlaIngrediencii(String ingrediencie);
    
    List<String> ingrediencieVRecepte(Recept recept);
   
}
