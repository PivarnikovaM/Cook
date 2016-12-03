package m.l.cook;


import java.util.List;

public class Recept {
    
    private Long id; 
    
    private String nazov;
    
    private String postup;
    
    private List<Ingrediencia> ingrediencie;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getPostup() {
        return postup;
    }

    public void setPostup(String postup) {
        this.postup = postup;
    }

    public List<Ingrediencia> getIngrediencie() {
        return ingrediencie;
    }

    public void setIngrediencie(List<Ingrediencia> ingrediencie) {
        this.ingrediencie = ingrediencie;
    }

    
    
    
    
    
    
    
    
}
