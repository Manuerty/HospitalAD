package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Turnos {

    @Column(name = "Turnos")
    private String horario;
    private String planta;

    public Turnos() {}

    public Turnos(String horario, String planta) {
        this.horario = horario;
        this.planta = planta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }
}
