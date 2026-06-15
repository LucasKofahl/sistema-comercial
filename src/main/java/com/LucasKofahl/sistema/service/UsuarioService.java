package com.LucasKofahl.sistema.service;

import com.LucasKofahl.sistema.model.Usuario;
import com.LucasKofahl.sistema.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new RuntimeException("O e-mail é obrigatório!");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new RuntimeException("A senha é obrigatória!");
        }
        return usuarioRepository.save(usuario);
    }
}