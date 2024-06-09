package com.library.application.dto;

import java.util.Date;

public class Member {
    private int memberId;
    private String name;
    private String contact;
    private Date membershipDate;
    public Member(int memberId, String name, String contact, Date membershipDate) {
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
        this.membershipDate = membershipDate;
    }
}
