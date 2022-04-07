package com.example.pontoeletronico.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
/*
* Gera um hash utilizando o BCrypt.
*
* @param senha
* @return String
* */
    public static String gerarBcrypt(String senha){
        if(senha == null) {
            return senha;
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(senha);
    }

    /*
    * Verifica se a senha é válida
    *
    * @param senha
    * @param senhaEncoded
    * @return boolean
    * */
    public static Boolean senhavalida(String senha, String senhaEncoded){
        BCryptPasswordEncoder  bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.matches(senha, senhaEncoded);
    }
}