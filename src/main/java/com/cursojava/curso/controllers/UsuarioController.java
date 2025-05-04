package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Felipe");
        usuario.setApellido("Garcia");
        usuario.setEmail("felipegar@gmail.com");
        usuario.setTelefono("342 678-9001");
       return usuario;
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader (value = "Authorization") String token) {

        if (!validarToken(token)) {
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }


    @RequestMapping(value = "usuario11")
    public Usuario editar() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Felipe");
        usuario.setApellido("Garcia");
        usuario.setEmail("felipegar@gmail.com");
        usuario.setTelefono("342 678-9001");
        return usuario;
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader (value = "Authorization") String token ,@PathVariable Long id) {

        if (!validarToken(token)) {
            return;
        }

        usuarioDao.eliminar(id);
    }

}
