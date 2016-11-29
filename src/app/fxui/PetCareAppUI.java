package app.fxui;

import app.utilities.AppProcess;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PetCareAppUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Kroll Pet Care");
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		primaryStage.setScene(new Scene(root, 300, 450));
		primaryStage.setResizable(false);
		primaryStage.show();
		//AppProcess app = new AppProcess();
		//app.readDataProcess();
		//app.loginProcess();
		//app.reportProcess();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
