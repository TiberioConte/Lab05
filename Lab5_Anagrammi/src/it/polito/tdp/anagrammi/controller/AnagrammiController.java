/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.ModelAnagrammatore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	ModelAnagrammatore model;
	
	public void setModel(ModelAnagrammatore model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textInput"
    private TextField textInput; // Value injected by FXMLLoader

    @FXML // fx:id="bottoneCalcolaAnagrammi"
    private Button bottoneCalcolaAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="textOutputCorretti"
    private TextArea textOutputCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="textOutputErrati"
    private TextArea textOutputErrati; // Value injected by FXMLLoader

    @FXML // fx:id="bottoneReset"
    private Button bottoneReset; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	model.ImpostaParola(textInput.getText());
    	HashSet<String> corrette=model.SoluzioniCorrette();
    	HashSet<String> errate=model.SoluzioniErrate();
    	
    	for(String s:corrette){
    		textOutputCorretti.appendText(s+"\n");
    	}
    	
    	for(String s:errate){
    		textOutputErrati.appendText(s+"\n");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	textInput.setText("");
    	textOutputCorretti.setText("");
    	textOutputErrati.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bottoneCalcolaAnagrammi != null : "fx:id=\"bottoneCalcolaAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert textOutputCorretti != null : "fx:id=\"textOutputCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert textOutputErrati != null : "fx:id=\"textOutputErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert bottoneReset != null : "fx:id=\"bottoneReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}

