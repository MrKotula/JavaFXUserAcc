package com.homework.useraccount;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {

    DB db = new DB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn;

    @FXML
    private TextField email;

    @FXML
    private TextField log;

    @FXML
    private PasswordField pass;

    @FXML
    void initialize() {
       log.setText("Admin");
       email.setText("race1001@ukr.net");
       btn.setOnAction(event ->
                changeData());
    }

    private void changeData() {
        String login = log.getCharacters().toString();
        String uEmail = email.getCharacters().toString();
        String password = pass.getCharacters().toString();

    if(db.isExistUser(login))
    btn.setText("User not found");
    else{
            db.setValue(login, uEmail, md5String(password));
            btn.setText("All right!");
            log.setText("");
            email.setText("");
            pass.setText("");
        }
    }

    public static String md5String(String pass) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(pass.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger = new BigInteger(1, digest);
        String m5dHex = bigInteger.toString(16);

        while (m5dHex.length() < 32)
            m5dHex = "0" + m5dHex;
        return m5dHex;
    }

}
