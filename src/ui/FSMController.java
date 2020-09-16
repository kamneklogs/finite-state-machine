package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class FSMController {

	@FXML
	private Pane mainPane;

	@FXML
	void mealyopt(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mealy.fxml"));
		fxmlLoader.setController(this);
		Parent mealy = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mealy);
	}

	@FXML
	void mooreopt(ActionEvent event) {

	}
}
