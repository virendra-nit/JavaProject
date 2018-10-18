/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author viru
 */
public class Identities {
    private String[] phone;

    @Override
    public String toString() {
        return "Identities{" + "phone=" + phone + '}';
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }
    
}
