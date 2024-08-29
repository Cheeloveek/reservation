package com.reservation.table;


import com.reservation.table.dao.UserDao;
import com.reservation.table.models.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("A", "B", "C@gmail.com", "12345678");
        UserDao.addUser(user);
    }
}
