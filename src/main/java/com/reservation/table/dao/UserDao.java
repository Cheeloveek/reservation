package com.reservation.table.dao;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.reservation.table.models.User;

public class UserDao {

    private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USER = "postgres";
    private static final String PWD = "12345678";

    @SuppressWarnings("null")
    public static void addUser(User user) {
        Connection connection = null;
        
        try{
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            PreparedStatement statement =connection.prepareStatement("INSERT INTO public.user (name, surname, mail, password) VALUES (?, ?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getMail());
            statement.setString(4, user.getPassword());

            statement.executeUpdate();

            statement.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

    
