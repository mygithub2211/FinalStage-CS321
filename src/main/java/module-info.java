module com.example {
    requires javafx.controls;
    requires javafx.graphics;

    opens com.example to javafx.graphics, javafx.stage, javafx.scene;

    exports com.example;
}
