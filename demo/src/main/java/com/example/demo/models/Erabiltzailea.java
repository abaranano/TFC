import jakarta.persistence.*;

@Entity
@Data
public class Erabiltzailea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String izena;
    private String emaila;
    
    @ManyToMany(mappedBy = "usuarios")
    private List<Grupoa> grupos;
}