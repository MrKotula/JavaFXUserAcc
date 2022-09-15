module com.homework.useraccount {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens com.homework.useraccount to javafx.fxml;
    exports com.homework.useraccount;
}