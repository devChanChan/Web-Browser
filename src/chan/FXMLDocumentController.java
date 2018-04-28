/*
 * FXMLDocumentController.java
 * ============
 * A class to bridge between user and application, handling events
 * When the user type in URL or click prev and next button, 
 * the url is passed into the ArrayList in Model class
 * [Controller] A class for receiving user event & passing it to Model/View
 *  AUTHOR: SEUNG CHAN KIM (kimseu@sheridancollege.ca)
 * CREATED: 2018-03-16
 * UPDATED: 2018-03-30
 */
package chan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class FXMLDocumentController implements Initializable {
    
    // UI controls using JavaFX Scene Builder 
    @FXML
    private TextField textUrl;
    @FXML
    private WebView webView;
    @FXML
    private Button prev;
    @FXML
    private Button next;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    // Declare and initiate Model class for the ArrayList to hold the URLs
    Model nav = new Model();
    
    // event handler to load a web page when a user click 'Go' button,
    // or press the enter key on the URL tet field
    @FXML
    private void handleGo(ActionEvent event) {
        
        // try to open web page here
        String url = textUrl.getText();
        
        // Validate the URL before loading the page
        if(url.isEmpty()) {
            return;
        } else if(url.startsWith("http://") || url.startsWith("https://")) {
            
        } else {
            textUrl.setText("http://" + url);
            url = textUrl.getText();
        }
        // Invoke getEnegine().load() to load the requested URL
        webView.getEngine().load(url);
        
        // reset the opacity of the webView to the value 1
        webView.setStyle("-fx-opacity: 1;");
        
        // store the requested URL string into the ArrayList in the Model class
        nav.push(url);
        
        // if the elements from ArrayList is greater than 10, 
        // remove first element of the ArrayList
        if(nav.getCurrentIndex() >= 10) {
            nav.subList();
        }
        changeColor(); // change color of prev or next button
    }

    // event handler to load a previous web page when a user click '<' button
    @FXML
    private void prev(ActionEvent event) {
        // enable the previous button only if it is possible to navigate
        if(nav.getCurrentIndex() <= 0) {
        } else {
            // load a previous web page
            webView.getEngine().load(nav.getList().get(nav.getCurrentIndex()-1));
            
            // update url text
            textUrl.setText(nav.getList().get(nav.getCurrentIndex()-1));
            
            // decrement the currentIndex
            nav.setCurrentIndex(nav.getCurrentIndex() - 1);
        }
        changeColor(); // change color of prev or next button
    }

    // event handler to load a next web page when a user click '>' button
    @FXML
    private void next(ActionEvent event) {
        // enable the next button only if it is possible to navigate
        if(nav.getList().size() <= nav.getCurrentIndex() + 1) {    
        } else {
            // load a next web page
            webView.getEngine().load(nav.getList().get(nav.getCurrentIndex()+1));
            
            // update url text
            textUrl.setText(nav.getList().get(nav.getCurrentIndex()+1));
            
            // decrement the currentIndex
            nav.setCurrentIndex(nav.getCurrentIndex() + 1);
        }
        changeColor();  // change color of prev or next button
    }
    
    // change color of prev, next buttons so that the user can know if they can use it
    private void changeColor() {
        // validate prev button
        if(nav.getCurrentIndex() <= 0) 
            prev.setStyle("-fx-background-color: grey;");
        else 
            prev.setStyle("-fx-background-color: #f2f2f2;");
        
        // validate next button
        if(nav.getList().size() <= nav.getCurrentIndex() + 1)
            next.setStyle("-fx-background-color: grey;");      
        else
            next.setStyle("-fx-background-color: #f2f2f2;");
    }
}