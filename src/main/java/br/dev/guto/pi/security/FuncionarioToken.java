package br.dev.guto.pi.security;

public class FuncionarioToken {

    private String token;

    public FuncionarioToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
