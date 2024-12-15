package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Enfermero extends Person {

    private String consultaAsignada;

    @OneToOne
    @JoinColumn(name = "medicoasignado_id")
    private Medico medicoasignado;

    @ElementCollection
    private List<String> turnos;

    public Enfermero() {
    }

    public Enfermero(String dni, String numeroSeguridadSocial, String nombre, String direccion, String telefono, String consultaAsignada, Medico medicoasignado, List<String> turnos) {
        super(dni, numeroSeguridadSocial, nombre, direccion, telefono);
        this.consultaAsignada = consultaAsignada;
        this.medicoasignado = medicoasignado;
        this.turnos = turnos;
    }

    public String getConsultaAsignada() {
        return consultaAsignada;
    }

    public void setConsultaAsignada(String consultaAsignada) {
        this.consultaAsignada = consultaAsignada;
    }

    public Medico getMedicoasignado() {
        return medicoasignado;
    }

    public void setMedicoasignado(Medico medicoasignado) {
        this.medicoasignado = medicoasignado;
    }

    public List<String> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<String> turnos) {
        this.turnos = turnos;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Enfermero: " + getNombre());
        System.out.println("Consulta asignada: " + consultaAsignada);
        System.out.println("Turnos: " + turnos);
    }
}
