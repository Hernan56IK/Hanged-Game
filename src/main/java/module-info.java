module com.example.hangedgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hangedgame to javafx.fxml;
    exports com.example.hangedgame;
    exports com.example.hangedgame.controller;
    opens com.example.hangedgame.controller to javafx.fxml;
    exports com.example.hangedgame.view;
    opens com.example.hangedgame.view to javafx.fxml;
}