package com.example.demo.VipUser;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.user.User;

@Document("VipUser")
public class VipUser extends User {

    private String vipStatus;
    private double IMC;

    public VipUser() {
    }

    public VipUser(String id, String name, Integer age, LocalDate dob, String email, double height, double weight, String vipStatus, double IMC) {
        super(id, name, age, dob, email, height, weight);
        this.vipStatus = vipStatus;
        this.IMC = IMC;
    }

    public VipUser(String name, Integer age, LocalDate dob, String email, double height, double weight, String vipStatus, double IMC) {
        super(name, age, dob, email, height, weight);
        this.vipStatus = vipStatus;
        this.IMC = IMC;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String vipStatus) {
        this.vipStatus = vipStatus;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    @Override
    public String toString() {
        return super.toString() + ", VipStatus=" + vipStatus + ", SpecialBenefits=" + IMC;
    }

}
