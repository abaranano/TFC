import jakarta.persistence.*;

@Entity
@Data
public class Grupoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String izena;
    
    @ManyToMany
    @JoinTable(
        name = "usuario_grupo",
        joinColumns = @JoinColumn(name = "grupo_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Erabiltzailea> usuarios;
    
    @OneToMany(mappedBy = "grupo")
    private List<Gastoak> gastos;
}
