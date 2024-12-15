package model;

import jakarta.persistence.*;

@Entity
@Table(name = "consulta")
public class consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consulta_id")
    private Long id;

    @Column(name = "nombre_consulta")
    private String nombreConsulta;

    @ManyToOne
    @JoinColumn(name = "planta_ubicada_id")
    private Planta planta;


    public consulta() {}

    public consulta(String nombreConsulta, Planta planta) {
        this.nombreConsulta = nombreConsulta;
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public String getNombreConsulta() {
        return nombreConsulta;
    }

    public void setNombreConsulta(String nombreConsulta) {
        this.nombreConsulta = nombreConsulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", nombreConsulta='" + nombreConsulta + '\'' +
                ", planta=" + planta +
                '}';
    }
}
