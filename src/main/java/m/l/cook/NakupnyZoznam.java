package m.l.cook;


public class NakupnyZoznam {
    
    private Long id;
    
    private Ingrediencia polozka;
    
    private boolean stav;

    public Ingrediencia getPolozka() {
        return polozka;
    }

    public void setPolozka(Ingrediencia polozka) {
        this.polozka = polozka;
    }

    public boolean isStav() {
        return stav;
    }

    public void setStav(boolean stav) {
        this.stav = stav;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        
    }
    
    
    
    
    
}
