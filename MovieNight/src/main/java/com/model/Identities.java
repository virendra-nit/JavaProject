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
