package com.aurionpro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOperation {
	private Connection connection;

    public UserOperation(Connection connection) {
        this.connection = connection;
    }

    public boolean updateUserProfile(int userID, String firstName, String lastName, String password) throws SQLException {
        String sql = "UPDATE users SET FirstName = ?, LastName = ?, Password = ? WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, password);
            pstmt.setInt(4, userID);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}
