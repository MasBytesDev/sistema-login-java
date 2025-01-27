package com.masbytes.login.persistencia;

import com.masbytes.login.logica.Rol;
import com.masbytes.login.logica.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController(); 

    public List<Usuario> traerUsuarios() {    
        return usuJpa.findUsuarioEntities();        
    }
    
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }
    
}
