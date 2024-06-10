package com.library.application.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {

    private final String name;
    private final String contact;
    private final Date membershipDate;
    Date date = new Date(System.currentTimeMillis());
    public Member( String name, String contact, Date membershipDate) {
        this.name = name;
        this.contact = contact;
        this.membershipDate = membershipDate;
    }
    public String getName(){
        return this.name;
    }
    public String getContact(){
        return this.contact;
    }

    public String getMembershipDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(membershipDate);
    }
}
