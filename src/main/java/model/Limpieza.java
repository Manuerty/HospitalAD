    package model;

    import jakarta.persistence.*;


    import java.util.List;

    @Entity
    public class Limpieza extends Person {

        @ElementCollection
        private List<String> plantasResponsables;

        @ElementCollection
        private List<String> turnos;

        public Limpieza() {
        }

        public Limpieza(String dni, String numeroSeguridadSocial, String nombre, String direccion, String telefono, List<String> plantasResponsables, List<String> turnos) {
            super(dni, numeroSeguridadSocial, nombre, direccion, telefono);
            this.plantasResponsables = plantasResponsables;
            this.turnos = turnos;
        }

        public List<String> getPlantasResponsables() {
            return plantasResponsables;
        }

        public void setPlantasResponsables(List<String> plantasResponsables) {
            this.plantasResponsables = plantasResponsables;
        }

        public List<String> getTurnos() {
            return turnos;
        }

        public void setTurnos(List<String> turnos) {
            this.turnos = turnos;
        }

        @Override
        public void mostrarDetalles() {
            System.out.println("Personal de limpieza: " + getNombre());
            System.out.println("Plantas responsables: " + plantasResponsables);
            System.out.println("Turnos: " + turnos);
        }
    }
