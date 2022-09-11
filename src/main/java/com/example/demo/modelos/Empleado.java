
package com.example.demo.modelos;

    public class Empleado {
        private String nombre;
        private String correo;
        private String empresa;
        private String rolEmpleado;

        public Empleado(){

        }

        public Empleado(String nombre, String correo, String empresa, String rolEmpleado) {
            this.nombre = nombre;
            this.correo = correo;
            this.empresa = empresa;
            this.rolEmpleado = rolEmpleado;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getEmpresa() {
            return empresa;
        }

        public void setEmpresa(String empresa) {
            this.empresa = empresa;
        }

        public String getRolEmpleado() {
            return rolEmpleado;
        }

        public void setRolEmpleado(String rolEmpleado) {
            this.rolEmpleado = rolEmpleado;
        }

        @Override
        public String toString() {
            return "Empleado{" +
                    "nombre='" + nombre + '\'' +
                    ", correo='" + correo + '\'' +
                    ", empresa='" + empresa + '\'' +
                    ", rolEmpleado='" + rolEmpleado + '\'' +
                    '}';
        }

    }

