package com.masbytes.login.logica;

import com.masbytes.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis;

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

    public List<Usuario> traerUsuarios() {

        return controlPersis.traerUsuarios();

    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolRecibido) {

        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);

        Rol rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        int id = this.buscarUltimaIdUsuarios();
        usu.setId(id + 1);

        controlPersis.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();

        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuarios() {

        List<Usuario> listaUsuarios = this.traerUsuarios();
        Usuario usu = listaUsuarios.get(listaUsuarios.size() - 1);
        return usu.getId();

    }

    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);
    }

}
