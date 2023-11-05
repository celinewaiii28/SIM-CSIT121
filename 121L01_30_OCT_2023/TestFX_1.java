// What is a stage?
//
// File name: TestFX_1.java

import javafx.application.Application;
import javafx.stage.Stage;

public class TestFX_1 extends Application
{
	@Override
	public void start (Stage primaryStage)
	{
		primaryStage.setTitle ("A stage");
		primaryStage.show ();
	}
	
	public static void main (String [ ] args)
	{
		launch (args);
	}
}