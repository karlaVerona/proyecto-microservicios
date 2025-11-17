package com.adb.ms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adb.ms.model.Usuario;
import com.adb.ms.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
    @Autowired
    private UsuarioRepository repo;
	
    public List<Usuario> listar() {
        return repo.findAll();
    }
    
    public Usuario guardar(Usuario u) {
        return repo.save(u);
    }
    
    public Optional<Usuario> buscarPorId(Integer id) {
        return repo.findById(id);
    }
    
    public List<Usuario> buscarPorNombre(String nombre) {
        return repo.buscarPorNombre(nombre);
    }
    
    /**
     * Login: busca usuario por correo y contraseña
     */
    public Usuario login(String correo, String contrasena) {
        Usuario resultado = repo.buscarPorCorreoYContrasena(correo, contrasena);
        
        if (resultado == null) {
            System.out.println("❌ No encontrado con credenciales");
            
            // Verificar si existe el correo
            /*
            Usuario porCorreo = repo.buscarPorCorreo(correo);
            if (porCorreo != null) {
                System.out.println("⚠️  El correo SÍ existe");
                System.out.println("   Contraseña en BD: [" + porCorreo.getContrasena() + "]");
                System.out.println("   Longitud en BD: " + porCorreo.getContrasena().length());
                System.out.println("   ¿Son iguales? " + contrasena.equals(porCorreo.getContrasena()));
            } else {
                System.out.println("⚠️  El correo NO existe");
            } */
        } else {
            System.out.println("✅ Usuario encontrado: " + resultado.getNombre());
        }
        
        return resultado;
    }
    
    /**
     * Registrar: crea un nuevo usuario
     */
    public Usuario registrar(Usuario usuario) {
        // 1. Verificar si el correo ya existe
        Usuario usuarioExistente = repo.buscarPorCorreo(usuario.getCorreo());
        
        if (usuarioExistente != null) {
            throw new RuntimeException("El correo ya está registrado");
        }
        
        // 2. Establecer fecha de registro
        usuario.setFechaRegistro(LocalDate.now());
        
        // 3. Guardar y retornar el usuario
        return repo.save(usuario);
    }
    
    
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}