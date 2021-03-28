package pakkaajat.ui;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class PrimaryController {
    
    File file;
            
    @FXML
    private Label fileName;

    @FXML
    private Label fileSize;
    
    @FXML
    private void compress(ActionEvent event) throws Exception {
        compressHuffman(file);
    }
    
    @FXML
    private void fileSelector(ActionEvent event) throws Exception{
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(window);
        event.consume();
        fileName.setText(file.getName());
        fileSize.setText(Long. toString(file.length()));
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
