package com.library.application.dao;

import com.library.application.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
    private final Connection connection;
    public MemberDAO(Connection connection){
        this.connection = connection;
    }

    public void addMember(Member member) throws SQLException {
        String sql = "INSERT INTO Members (Name, Contact, MembershipDate) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, member.getName());
            statement.setString(2, member.getContact());
            statement.setDate(3, java.sql.Date.valueOf(member.getMembershipDate()));
            statement.executeUpdate();
        }
    }
}
