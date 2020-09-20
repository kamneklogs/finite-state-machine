package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.GenericArray;
import model.*;
import model.mealyMachine.MealyMachine;
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

	private Machine a;

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
		symbolInput.setEditable(true);
	}

	@FXML
	private Button loadSymbolsButton;
	private String[] symbolsInput;

	@FXML
	private Label alphInLabel;

	@FXML
	private Label alphOutLabel;
	private String setStates;

	@FXML
	void loadSymbols(ActionEvent event) {
		symbolsInput = symbolInput.getText().split(",");
		setStates = "";

		String setinSymbols = "";
		for (String in : symbolsInput) {

			if (in.equals(symbolsInput[symbolsInput.length - 1])) {
				setinSymbols += " " + in;
			} else {
				setinSymbols += " " + in + ",";
			}

		}

		alphInLabel.setText(alphInLabel.getText() + setinSymbols + "}");

		for (int i = 0; i < mealyS.length; i++) {
			mealyS.set(i, new MealyState<String, String>("q" + i, symbolsInput.length));
			if (i < mealyS.length - 1) {
				setStates += " q" + i + ",";
			} else {
				setStates += " q" + i;
			}

		}
		setStates += "}";
		alphInLabel.setVisible(true);

		symbolOutput.setEditable(true);
		symbolOutputButton.setDisable(false);

	}

	@FXML
	private Button symbolOutputButton;
	String[] symbolsOutput;

	@FXML
	void symbolOutputButton(ActionEvent event) {
		symbolsOutput = symbolOutput.getText().split(",");

		linkPaneMealy.setBackground(
				new Background(new BackgroundFill(Color.rgb(204, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
		linkPaneMealy.setVisible(true);

		labelInfoLink.setText(labelInfoLink.getText() + setStates);

		currentInSymbolToLink.setText(symbolsInput[0]);
		setStates = "";

		String setoutSymbols = "";
		for (String out : symbolsOutput) {

			if (out.equals(symbolsInput[symbolsInput.length - 1])) {
				setoutSymbols += " " + out;
			} else {
				setoutSymbols += " " + out + ",";
			}

		}

		alphOutLabel.setText(alphOutLabel.getText() + setoutSymbols + "}");
		currentInSymbolToLink.setText(symbolsInput[0]);
		alphOutLabel.setVisible(true);
	}

	@FXML
	private Label labelInfoLink;

	@FXML
	private Pane linkPaneMealy;

	@FXML
	private TextField currentInSymbolToLink;

	@FXML
	private TextField currentOutSymbolToLink;

	@FXML
	private TextField indexDestinyState;

	@FXML
	private TextField indexCurrentStateToLink;

	public int counterSymbols;
	public int counterStates;

	@FXML
	void link(ActionEvent event) throws IOException {

		// desarrollar try catch para que ingrese valores permitidos existentes en los
		// conjuntos de salidas y estados

		if (currentOutSymbolToLink.getText().equals("") || indexDestinyState.getText().equals("")) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Advertencia");
			alert.setHeaderText("Informacion incompleta");

		}
		if (counterStates + 1 == mealyS.length && counterSymbols + 1 == symbolsInput.length) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmacion");
			alert.setHeaderText("Enlazamiento completado");
			alert.setContentText(
					"El enlazamiento de los estados de la maquina fue completado, clic en aceptar para iniciar el analisis");
			alert.showAndWait();

			GenericArray<String> myInputAlphabet = new GenericArray<String>(symbolsInput.length);
			for (int i = 0; i < symbolsInput.length; i++) {
				myInputAlphabet.set(i, symbolsInput[i]);
			}

			GenericArray<String> myOutputAlphabet = new GenericArray<String>(symbolsOutput.length);
			for (int i = 0; i < symbolsOutput.length; i++) {
				myOutputAlphabet.set(i, symbolsOutput[i]);
			}

			a = new MealyMachine<>(mealyS.get(0), "Mealy Machine", myInputAlphabet, myOutputAlphabet);

			loadAnalyzerWindow();
		} else {

			mealyS.get(counterStates).link(mealyS.get(Integer.parseInt(indexDestinyState.getText())),
					currentInSymbolToLink.getText(), currentOutSymbolToLink.getText());

			counterSymbols++;
			if (!(counterSymbols == symbolsInput.length)) {
				currentInSymbolToLink.setText(symbolsInput[counterSymbols]);
				currentOutSymbolToLink.setText("");
				indexDestinyState.setText("");
			}
			if (counterSymbols == symbolsInput.length) {
				counterStates++;
				indexCurrentStateToLink.setText("" + counterStates);
				counterSymbols = 0;
				currentInSymbolToLink.setText(symbolsInput[0]);
				currentOutSymbolToLink.setText("");
				indexDestinyState.setText("");

			}
		}

	}

	public void loadAnalyzerWindow() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Analyzer.fxml"));
		fxmlLoader.setController(this);
		Parent mealy = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(mealy);
	}

	@FXML
	void mooreopt(ActionEvent event) {

	}
}
