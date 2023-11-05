// What is a stage?
//
// What is a scene? 
//  -> place a label inside the scene
//
// File name: TestFX_2.java

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TestFX_2 extends Application
{
	@Override
	public void start (Stage primaryStage)
	{
		// Define a label
		Label aLabel = new Label ("This is a label");
		
		// Create a scene to place a label inside
		Scene s = new Scene (aLabel, 200, 250);
		
		// Place the scene inside a stage
		primaryStage.setTitle ("Label in scene");
		primaryStage.setScene (s);
		primaryStage.show ();
	}
	
	public static void main (String [ ] args)
	{
		launch (args);
	}
}