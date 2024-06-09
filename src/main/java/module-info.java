module com.library.application {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.library.application to javafx.fxml;
    exports com.library.application;
}