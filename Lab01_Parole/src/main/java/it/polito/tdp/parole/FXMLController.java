package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;
import it.polito.tdp.parole.model.ParoleBis;
import java.util.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco = new Parole() ;
	ParoleBis elencoBis = new ParoleBis();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtStatus;
    
    long start,end;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	start = System.nanoTime();
    	String parola = this.txtParola.getText();
    	this.elenco.addParola(parola);
    	this.txtResult.setText(elenco.toString());
    	this.txtParola.clear();
    	end = System.nanoTime();
    	this.txtStatus.setText("Tempo di esecuzione dell'Insert, usando una LinkedList, pari a: "+(end-start)+" ns");
    	
    	start = System.nanoTime();
    	String parolaBis = this.txtParola.getText();
    	this.elencoBis.addParolaBis(parola);
    	this.txtResult.setText(elencoBis.toStringBis());
    	this.txtParola.clear();
    	end = System.nanoTime();
    	this.txtStatus.appendText("\nTempo di esecuzione dell'Insert, usando un ArrayList, pari a: "+(end-start)+" ns");
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	start = System.nanoTime();
    	this.elenco.reset();
    	this.txtResult.setText(elenco.toString());
    	this.txtParola.clear();
    	end = System.nanoTime();
    	this.txtStatus.setText("Tempo di esecuzione del Reset, usando una LinkedList, pari a: "+(end-start)+" ns");
    	
    	start = System.nanoTime();
    	this.elencoBis.resetBis();
    	this.txtResult.setText(elencoBis.toStringBis());
    	this.txtParola.clear();
    	end = System.nanoTime();
    	this.txtStatus.appendText("\nTempo di esecuzione del Reset, usando un ArrayList, pari a: "+(end-start)+" ns");
    }
    

    @FXML
    void doCancella(ActionEvent event) {
      // TODO
      start = System.nanoTime();
      String parolaDaEliminare = this.txtParola.getText();
      this.elenco.delete(parolaDaEliminare);
      this.txtResult.setText(elenco.toString());
      this.txtParola.clear();
      end = System.nanoTime();
      this.txtStatus.setText("Tempo di esecuzione del Delete, usando una LinkedList, pari a: "+(end-start)+" ns");
      
      start = System.nanoTime();
      String parolaDaEliminareBis = this.txtParola.getText();
      this.elencoBis.deleteBis(parolaDaEliminareBis);
      this.txtResult.setText(elencoBis.toStringBis());
      this.txtParola.clear();
      end = System.nanoTime();
      this.txtStatus.appendText("\nTempo di esecuzione del Delete, usando un ArrayList, pari a: "+(end-start)+" ns");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
        elencoBis = new ParoleBis();
    }
}
