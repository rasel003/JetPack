package com.rasel.jetpack.Model;

public class ProfileResponse {

    private String u_name;
    private String u_email;
    private String u_passport;

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public void setU_passport(String u_passport) {
        this.u_passport = u_passport;
    }

    public void setU_present_address(String u_present_address) {
        this.u_present_address = u_present_address;
    }

    public void setU_permanent_address(String u_permanent_address) {
        this.u_permanent_address = u_permanent_address;
    }

    private String u_present_address;
    private String u_permanent_address;

    public String getU_name() {
        return u_name;
    }

    public String getU_email() {
        return u_email;
    }

    public String getU_passport() {
        return u_passport;
    }

    public String getU_present_address() {
        return u_present_address;
    }

    public String getU_permanent_address() {
        return u_permanent_address;
    }
}
