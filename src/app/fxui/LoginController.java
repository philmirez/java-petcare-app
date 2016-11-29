package app.fxui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	public void login()
	{
		System.out.println(username.getText());
	}

}
