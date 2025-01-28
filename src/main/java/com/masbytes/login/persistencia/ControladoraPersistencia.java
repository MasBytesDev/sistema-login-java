package com.masbytes.login.persistencia;

import com.masbytes.login.logica.Rol;
import com.masbytes.login.logica.Usuario;
// import com.masbytes.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
// import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController(); 

    public List<Usuario> traerUsuarios() {    
        List<Usuario> listaUsuario = usuJpa.findUsuarioEntities();
        return listaUsuario;
    }
    
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();        
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        usuJpa.destroy(id_usuario);        
    }
    
}
