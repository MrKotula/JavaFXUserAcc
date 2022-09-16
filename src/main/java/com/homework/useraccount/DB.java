package com.homework.useraccount;

import com.mysql.cj.xdevapi.SqlSingleResult;

import java.sql.*;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "user_account";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String str = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConn = DriverManager.getConnection(str, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected() throws ClassNotFoundException, SQLException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }
    public boolean isExistUser(String login, String email, String password){
        String sql = "SELECT `id` FROM `users` WHERE `login` = ? AND `email` = ? AND `password` = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, login);
            prSt.setString(2, email);
            prSt.setString(3, password);
            ResultSet res = prSt.executeQuery();
            return res.next();
        } catch (SQLException | RuntimeException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setValue(String login, String email, String password){
        String sql = "UPDATE `users` SET `login` =  ?, `email` = ?, `password` = ? WHERE `id` = 1";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, login);
            prSt.setString(2, email);
            prSt.setString(3, password);
            prSt.executeUpdate();
        } catch (SQLException | RuntimeException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isExistUser(String login){
        String sql = "SELECT `id` FROM `users` WHERE `login` = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, login);
            ResultSet res = prSt.executeQuery();
            return res.next();
        } catch (SQLException | RuntimeException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
          }

 }
