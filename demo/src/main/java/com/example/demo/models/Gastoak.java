import jakarta.persistence.*;

@Entity
@Data
public class Gastoak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deskripzioa;
    private double kantitatea;
    
    @ManyToOne
    @JoinColumn(name = "pagador_id")
    private Erabiltzailea pagatzailea;
    
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupoa grupoa;
    
    @OneToMany(mappedBy = "gasto")
    private List<Zorra> zorrak;
}