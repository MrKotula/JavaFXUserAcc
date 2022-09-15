module com.homework.useraccount {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.homework.useraccount to javafx.fxml;
    exports com.homework.useraccount;
}