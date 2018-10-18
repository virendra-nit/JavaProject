/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author viru
 */
public class TokenDataPojo {

    @JsonProperty("auth_time")
    private String authtime;
    @JsonProperty("exp")
    private String exp;
    @JsonProperty("sub")
    private String sub;
    @JsonProperty("phone_number")
    private String phonenumber;
    @JsonProperty("iss")
    private String iss;
    @JsonProperty("aud")
    private String aud;
    @JsonProperty("firebase")
    private FirebasePojo firebasePojo;
    @JsonProperty("user_id")
    private String userid;
    @JsonProperty("iat")
    private String iat;

    @JsonIgnore

    public String getAuthtime() {
        return authtime;
    }

    public void setAuthtime(String authtime) {
        this.authtime = authtime;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public FirebasePojo getFirebasePojo() {
        return firebasePojo;
    }

    public void setFirebasePojo(FirebasePojo firebasePojo) {
        this.firebasePojo = firebasePojo;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    @Override
    public String toString() {
        return "[auth_time = " + authtime + ", exp = " + exp + ", sub = " + sub + ", phone_number = " + phonenumber + ", iss = " + iss + ", aud = " + aud + ", firebasePojo = " + firebasePojo + ", user_id = " + userid + ", iat = " + iat + "]";
    }
}
