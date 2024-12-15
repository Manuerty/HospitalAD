package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico extends Person {

    @OneToOne
    @JoinColumn(name = "consulta_consulta_id")
    private consulta consulta;

    @ElementCollection
    private List<Visita> historicoVisitas = new ArrayList<>();

    public Medico(model.consulta consulta, List<Visita> historicoVisitas) {
        this.consulta = consulta;
        this.historicoVisitas = historicoVisitas;
    }

    public Medico(String dni, String numeroSeguridadSocial, String nombre, String direccion, String telefono, model.consulta consulta, List<Visita> historicoVisitas) {
        super(dni, numeroSeguridadSocial, nombre, direccion, telefono);
        this.consulta = consulta;
        this.historicoVisitas = historicoVisitas;
    }

    public consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(consulta consulta) {
        this.consulta = consulta;
    }

    public List<Visita> getHistoricoVisitas() {
        return historicoVisitas;
    }

    public void setHistoricoVisitas(List<Visita> historicoVisitas) {
        this.historicoVisitas = historicoVisitas;
    }

    public void agregarHistoricoVisita(Visita visita) {
        historicoVisitas.add(visita);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Medico: " + getNombre());
        System.out.println("Consulta: " + consulta);
        System.out.println("Historico de operaciones: " + historicoVisitas);
    }
}
