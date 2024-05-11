package br.com.zonamods.zonaMods.security;

public class Token {
    private String token;

    public Token(String token){
        super();
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
