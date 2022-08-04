package bootstrap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;

public class BootWindowTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        AnchorPane root=new AnchorPane();
        Scene scene = new Scene(root,600,300);
        stage.setScene(scene);
        stage.show();

    }
}