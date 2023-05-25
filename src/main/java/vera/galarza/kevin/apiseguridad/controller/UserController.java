/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vera.galarza.kevin.apiseguridad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vera.galarza.kevin.apiseguridad.util.JWTUtil;

/**
 *
 * @author kgalarza
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping
    public String getUsuario() {
        return "hola mundo";
    }

    @RequestMapping(value = "api/login", method = RequestMethod.GET)
    public String login() {
//    public String login(@RequestBody Usuario usuario) {

        String usuario = "kgalarza";
        if (!usuario.isEmpty()) {
            String tokenJwt = jwtUtil.create(String.valueOf("ID"),
                    usuario);
            //en el token puede devolver más información, más inf del usuario y permisoso roles
            return tokenJwt;
        }
        return "FAIL";
    }

    @RequestMapping(value = "api/token", method = RequestMethod.POST)
    public String getUsuariosPost(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return "error token invalido";
        }

        return "token valido";
    }

    @RequestMapping(value = "api/token", method = RequestMethod.GET)
    public String getUsuarios(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return "error token invalido";
        }

        return "token valido";
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
