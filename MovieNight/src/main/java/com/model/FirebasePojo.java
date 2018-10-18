/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author viru
 */
public class FirebasePojo {

    private Identities identities;
    @JsonProperty("sign_in_provider")
    private String signInProvider;

    public Identities getIdentities() {
        return identities;
    }

    public void setIdentities(Identities identities) {
        this.identities = identities;
    }

    public String getSign_in_provider() {
        return signInProvider;
    }

    public void setSign_in_provider(String sign_in_provider) {
        this.signInProvider = sign_in_provider;
    }

    @Override
    public String toString() {
        return "[identities = " + identities + ", sign_in_provider = " + signInProvider + "]";
    }

}
