package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "planta")
    private List<consulta> consultas;

    public Planta() {}

    public Planta(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Planta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", consultas=" + consultas +
                '}';
    }
}
