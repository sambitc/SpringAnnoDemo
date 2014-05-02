/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.common.model;

/**
 *
 * @author sambitc
 */
public class User {

    String userName;
    String password;
    String remark;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
