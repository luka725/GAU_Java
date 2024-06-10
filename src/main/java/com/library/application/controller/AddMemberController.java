package com.library.application.controller;

import com.library.application.dao.DatabaseManager;
import com.library.application.dao.MemberDAO;
import com.library.application.dto.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

public class AddMemberController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactField;

    private final MemberDAO memberDAO;

    public AddMemberController() {
        this.memberDAO = new MemberDAO(DatabaseManager.getConnection()); // Initialize your DAO
    }

    @FXML
    private void addMember() {
        String name = nameField.getText();
        String contact = contactField.getText();

        // Validate input
        if (name.isEmpty() || contact.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        // Save member
        try {
            Member member = new Member(name, contact,  new Date());
            memberDAO.addMember(member);
            showAlert("Success", "Member added successfully.");
        } catch (SQLException e) {
            showAlert("Error", "Failed to add member: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
