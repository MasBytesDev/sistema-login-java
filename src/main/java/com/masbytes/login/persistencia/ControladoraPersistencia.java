package com.masbytes.login.persistencia;

import com.masbytes.login.logica.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {
    
        return usuJpa.findUsuarioEntities();
        
    }
    
}
