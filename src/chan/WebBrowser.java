/*
 * WebBrowser.java
 * ============
 * A class to create a stage and scene for the web browser
 * [Model] A class for logic part of application
 *  AUTHOR: SEUNG CHAN KIM (kimseu@sheridancollege.ca)
 * CREATED: 2018-03-16
 * UPDATED: 2018-03-30
 */

package chan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WebBrowser extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        // create scene
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Spring");    // Set the window title
        stage.getIcons().add(new Image("/image/flower.png")); // Set the icon on the title bar
        
        // apply CSS style
        scene.getStylesheets().add(getClass().getResource("/css/main.css").toExternalForm());
        
        // show stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
