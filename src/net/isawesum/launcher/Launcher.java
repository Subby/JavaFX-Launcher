package net.isawesum.launcher;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Launcher extends Application {
	
	public static void main(String args[]) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("resources/style.css");
        HBox hBox = addTopBox();
        HBox buttonHBox = addButtonHBox();
        root.setTop(hBox);
        root.setCenter(buttonHBox);
        addStackPane(buttonHBox);
        addStackPane(hBox);
        stage.setTitle("Launcher");
        stage.getIcons().add(new Image("resources/icon.png"));
        stage.setScene(scene);
        stage.sizeToScene(); 
        stage.show();
		
	}
	/**
	 * Adds a horizontal box in the stack pane.
	 * @param hb the horizontal box to add
	 */
	private void addStackPane(HBox hb) {    
		StackPane stack = new StackPane();
		hb.getChildren().add(stack);
	}
	
	/**
	 * Adds a horizontal box for the logo
	 * @return hBox the horizontal box
	 */
    public HBox addTopBox() {
    	HBox hBox = new HBox();
    	ImageView logo = new ImageView(new Image("resources/logo.png"));
    	hBox.getChildren().add(logo);
    	return hBox;
    }
    /**
     * Adds a horizontal box with buttons.
     * @return haxBox the horizontal box
     */
	private HBox addButtonHBox() {
		HBox haxBox = new HBox();
		haxBox.setPadding(new Insets(0, 0, 20, 80));
		haxBox.setSpacing(30.0);
        Button playButton = new Button("Play");
        playButton.getStyleClass().add("button");
        playButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0)
            {
            	File execute = new File("resources/play.jar");
            	System.out.println(execute.getAbsolutePath());
            	try {
					Desktop.getDesktop().open(execute);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        Button contributeButton = new Button("Contribute");
        contributeButton.getStyleClass().add("button");
        contributeButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0)
            {
            	openUpWebSite("http://denver.fr");
            }
        }); 
        Button voteButton = new Button("Vote");
        voteButton.getStyleClass().add("button");
        voteButton.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0)
            {
            	openUpWebSite("http://isawesum.net");
            }
        });        
        haxBox.getChildren().addAll(playButton, contributeButton, voteButton);
		return haxBox;
	}
	
	/**
	 * Opens up a url in the browser.
	 * The API used by this method is not supported by some operating systems.
	 * @param url the url to open
	 */
	private static void openUpWebSite(String url) {
		Desktop d = Desktop.getDesktop();
		try {
			d.browse(new URI(url)); 	
		} catch (Exception e) {
		}
	}
	
	
}
