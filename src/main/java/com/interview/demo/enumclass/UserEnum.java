package com.interview.demo.enumclass;

/**
 * Test enum
 */

public enum UserEnum {

    ordinary(1,"普通用户","普通用户rem"),
    admin(2,"管理员","管理员rem");

    public int type;
    public String name;
    public String remarks;

    UserEnum(int type, String name, String remarks) {
        this.type = type;
        this.name = name;
        this.remarks = remarks;
    }
}
