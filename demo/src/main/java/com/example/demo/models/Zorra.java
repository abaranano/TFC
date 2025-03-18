import jakarta.persistence.*;

@Entity
@Data
public class Zorra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montua;
    
    @ManyToOne
    @JoinColumn(name = "deudor_id")
    private Erabiltzailea deudatua;
    
    @ManyToOne
    @JoinColumn(name = "acreedor_id")
    private Erabiltzailea acreedor;
    
    @ManyToOne
    @JoinColumn(name = "gasto_id")
    private Gastoak gasto;
}