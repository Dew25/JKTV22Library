/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package jktv22library.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jktv22library.gui.home.HomeController;

/**
 *
 * @author Melnikov
 */
public class LibraryGui extends Application {
    
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(LibraryGui.class.getResource("/jktv22library/gui/home/home.fxml"));
            VBox root = loader.load();
            HomeController homeController = loader.getController();
            homeController.setLibraryGui(this);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setTitle("Библиотека группы JKTV22");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println("Не найден файл \"/jktv22library/gui/home/home.fxml\"");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
}
