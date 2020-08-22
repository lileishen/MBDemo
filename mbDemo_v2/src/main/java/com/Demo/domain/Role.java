package com.Demo.domain;

/**
 * @author nono
 * @Package com.Demo.domain
 * @ClassName Role.java
 * @Description TODO
 * @createTime 2020年08月21日 20:58:00
 */
public class Role {
    private int id;
    private  String rolename;
    private String roledesc;

    public Role() {
    }

    public Role(int id, String rolename, String roledesc) {
        this.id = id;
        this.rolename = rolename;
        this.roledesc = roledesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roledesc='" + roledesc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }
}
