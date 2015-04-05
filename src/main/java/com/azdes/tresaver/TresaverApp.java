package com.azdes.tresaver;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;

public class TresaverApp extends Application {
    private Stage primaryStage;
    private SplitPane rootLayout;
    private ToolBar toolBar;
    private SplitPane workArea;
    private URL mainWindowRes = TresaverApp.class.getResource("/views/MainWindow.fxml");
    private URL toolBarRes = TresaverApp.class.getResource("/views/TresaverToolBar.fxml");
    private URL workAreaRes = TresaverApp.class.getResource("/views/WorkArea.fxml");
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage ps) {
        primaryStage = ps;
        primaryStage.setTitle("Scratch");
        loadLayout();
    }
    
    /**
     * Initializes the root layout.
     */
    private void loadLayout() {
        try {
            // Load root layout from fxml file
            rootLayout = this.<SplitPane>loadResource(mainWindowRes);
            toolBar = this.<ToolBar>loadResource(toolBarRes);
            workArea = this.<SplitPane>loadResource(workAreaRes);
            rootLayout.getItems().add(toolBar);
            rootLayout.getItems().add(workArea);
            
            // Show the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Given a location of an fxml file, loads a JFX resource into the given class 
     * @param location of the fxml view
     * @return Loaded resource in specified class
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    private <T> T loadResource(URL location) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        return (T) loader.load();
    }
    
    /*
     * Getters
     */
    public Stage getPrimaryStage() {return primaryStage;}
    public SplitPane getRootLayout() {return rootLayout;}
    public ToolBar getToolBar() {return toolBar;}
    public SplitPane getWorkArea() {return workArea;}
}
