package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.GenericArray;
import model.*;
import model.mealyMachine.MealyState;

public class FSMController {

	@FXML
	private Pane mainPane;

	@FXML
	private TextField statesAmount;

	@FXML
	private TextField symbolInput;

	@FXML
	private TextField symbolOutput;

	Machine a, b;

	GenericArray<MealyState<String, String>> mealyS;

	@FXML
	void mealyopt(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mealy.fxml"));
		fxmlLoader.setController(this);
		Parent mealy = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mealy);
	}

	@FXML
	private Button createMealyStatesButton;

	@FXML
	void createMealyStates(ActionEvent event) {
		mealyS = new GenericArray<MealyState<String, String>>(Integer.parseInt(statesAmount.getText()));

		loadSymbolsButton.setDisable(false);
		createMealyStatesButton.setDisable(true);
	}

	@FXML
	private Button loadSymbolsButton;

	@FXML
	void loadSymbols(ActionEvent event) {
		String[] symbols = symbolInput.getText().split(",");

		for (int i = 0; i < mealyS.length; i++) {
			mealyS.set(i, new MealyState<String, String>("q" + i, symbols.length));
			//System.out.println(mealyS.get(i).getName());
		}

	}

	@FXML
	void mooreopt(ActionEvent event) {

	}
}
