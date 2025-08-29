package org.acme;

import java.util.logging.Logger;

public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private Logger logger;

    public Cliente(String n, String e, int i) {
        this.nome = n;
        this.email = e;
        this.idade = i;
        this.logger = Logger.getLogger(getClass().getName());
    }

    public boolean valida() {
        if (nome == null || email == null) {
           logger.info("Dados inválidos");
            return false;
        }
        if ("".equals(nome)) {
           this.logger.info("nome vazio");
        }
        if (idade < 0 || idade > 200) {
            this.logger.info("Idade estranha");
        }
        return true;
    }

    public String getNome() {
        return this.nome;
    }

    public int getInt() {
        return this.idade;
    }

    public String getEmail() {
        if (email == null) {
            email = "";
        }
        return email.trim();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Cliente c) {
            return this.email == c.email;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 42;
    }
}

