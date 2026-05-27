package dao;

import database.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // REGISTER USER

    public void registerUser(User user) {

        String query =
                "INSERT INTO users(name, email, password, role) " +
                        "VALUES(?,?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            ps.executeUpdate();

            System.out.println("\n✅ User Registered Successfully!\n");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // LOGIN USER

    public boolean loginUser(String email,
                             String password) {

        String query =
                "SELECT * FROM users " +
                        "WHERE email = ? AND password = ?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                        "\n✅ Login Successful!"
                );

                System.out.println(
                        "Welcome " +
                                rs.getString("name")
                );

                System.out.println(
                        "Role: " +
                                rs.getString("role") +
                                "\n"
                );

                return true;
            }

            else {

                System.out.println(
                        "\n❌ Invalid Email or Password!\n"
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}