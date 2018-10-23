package com.model;

/**
 *
 * @author viru
 */
public class RegisterTokenPojo {

    private String jwtToken;
    private String name;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[jwtToken = " + jwtToken + "]";
    }

 

}
