package m.l.cook;


import java.time.LocalDate;
import java.util.Date;

public class Jedalnicek {

    private Long id;
    
    private LocalDate datum;
    
    private Recept recept;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }

    @Override
    public String toString() {
        return recept.getNazov();
    }
    
    
}
