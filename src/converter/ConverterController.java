package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * UI controller for events and initializing components.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	private ComboBox<Length> unitbox1;
	@FXML
	private ComboBox<Length> unitbox2;

	/**
	 * Convert a distance from one unit to another.
	 */
	public void handleConvert(ActionEvent event) {
		// read values from textfield(s)
		String text1 = textfield1.getText().trim();
		String text2 = textfield2.getText().trim();
		// read the Length from combobox1
		double unit1 = unitbox1.getValue().getValue();
		// read the Length from combobox1
		double unit2 = unitbox2.getValue().getValue();
		// perform the conversion and output the result
		double input, sol;
		if (!textfield1.getText().equals("")) {
			try {
				input = Double.parseDouble(text1);
				sol = (input * unit1) / unit2;
			} catch (Exception ex) {
				textfield1.setStyle("-fx-text-inner-color: red;");
				textfield2.setText("invalid number");
				return;
			}
			textfield2.setText(String.format("%.4g", sol));
		} else if (!textfield2.getText().equals("")) {
			try {
				input = Double.parseDouble(text2);
				sol = (input * unit2) / unit1;
			} catch (Exception ex) {
				textfield2.setStyle("-fx-text-inner-color: red;");
				textfield1.setText("invalid number");
				return;
			}
			textfield1.setText(String.format("%.4g", sol));
		}
	}

	/**
	 * Clear the text.
	 */
	public void handleClear(ActionEvent event) {
		textfield1.setStyle("-fx-text-inner-color: black;");
		textfield1.setText("");
		textfield2.setText("");
	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates
	 * the UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	public void initialize() {
		if (unitbox1 != null) {
			unitbox1.getItems().addAll(Length.values());
			unitbox1.getSelectionModel().select(0);
		}
		if (unitbox2 != null) {
			unitbox2.getItems().addAll(Length.values());
			unitbox2.getSelectionModel().select(1);
		}
	}
}
