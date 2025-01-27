package com.masbytes.login.logica;

import com.masbytes.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis; // = new ControladoraPersistencia();

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        
        Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        // Recorremos toda la lista de usuarios
        for (Usuario usu : listaUsuarios) {
            // Si el nombre de usuario coincide
            if (usu.getNombreUsuario().equals(usuario)) {
                // Verificamos la contraseña
                if (usu.getContrasenia().equals(contrasenia)) {
                    usr = usu;
                    return usr;
                } else {
                    usr = null;
                    return usr;
                } 
            }
        }
        // Si terminamos el bucle y no encontramos coincidencias
        return usr;
    }    

}
