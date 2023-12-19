/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv22library.gui.home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import jktv22library.gui.LibraryGui;

/**
 * FXML Controller class
 *
 * @author Melnikov
 */
public class HomeController implements Initializable {

    private LibraryGui libraryGui;

    @FXML
    private AnchorPane content;
    
    @FXML
    private void showListBooks(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HomeController.class.getResource("/jktv22library/gui/listbooks/listBooks.fxml"));
            AnchorPane rootListBooks = loader.load();
            content.getChildren().clear();
            content.getChildren().add(rootListBooks);
            //libraryGui.getPrimaryStage().setTitle("Библиотека группы JKTV22 - список книг");
        } catch (Exception e) {
             System.out.println("Не найден файл \"/jktv22library/gui/listbooks/listBooks.fxml\"");
        }
    }
    
    @FXML
    private void showListReaders(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HomeController.class.getResource("/jktv22library/gui/listreaders/listReaders.fxml"));
            AnchorPane rootListReaders = loader.load();
            content.getChildren().clear();
            content.getChildren().add(rootListReaders);
            //libraryGui.getPrimaryStage().setTitle("Библиотека группы JKTV22 - список книг");
        } catch (Exception e) {
             System.out.println("Не найден файл \"/jktv22library/gui/listreaders/listReaders.fxml\"");
        }
    }
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setLibraryGui(LibraryGui libraryGui) {
       this.libraryGui = libraryGui;
    }
    
}
