package com.masbytes.login.logica;

import com.masbytes.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis; // = new ControladoraPersistencia();

    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }

    public String validarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        // Recorremos toda la lista de usuarios
        for (Usuario usu : listaUsuarios) {
            // Si el nombre de usuario coincide
            if (usu.getNombreUsuario().equals(usuario)) {
                // Verificamos la contraseña
                if (usu.getContrasenia().equals(contrasenia)) {
                    return "Usuario y Contraseña Válidos. ¡Bienvenido!";
                } else {
                    return "Contraseña Incorrecta!!";
                }
            }
        }
        // Si terminamos el bucle y no encontramos coincidencias
        return "Usuario Incorrecto!!";
    }

}
