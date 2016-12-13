package m.l.cook;


import java.util.List;

class Ingrediencia {
   
    private Long id;
    
    private String nazov;
    
 
    
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nazov;
    }
    
    
    
    
    
    
}
