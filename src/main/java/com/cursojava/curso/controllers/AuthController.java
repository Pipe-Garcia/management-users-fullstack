package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
            if (usuarioLogueado != null) {
                String tokenJwt = jwtUtil.create(
                        String.valueOf(usuarioLogueado.getId()),
                        usuarioLogueado.getEmail()
                );
                return ResponseEntity.ok(tokenJwt);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace(); // 👈 importante para ver qué está fallando
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
        }
    }

}
