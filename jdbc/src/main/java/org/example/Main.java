package org.example;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://database-campus.ce0gcctcek2p.ap-northeast-2.rds.amazonaws.com:3306/edu10",
                "edu10",
        "edu10p"
        );

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM member WHERE name LIKE ? AND age > ? ORDER BY age DESC");
        preparedStatement.setString(1, "%윤%");
        preparedStatement.setInt(2, 12);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            var user = new Member(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age")
            );

            System.out.println(user);
        }
    }
}