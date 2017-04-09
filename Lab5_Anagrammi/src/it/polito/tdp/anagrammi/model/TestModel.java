package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ModelAnagrammatore model=new ModelAnagrammatore();
		model.ImpostaParola("aoo");
		System.out.println(model.SoluzioniCorrette().toString());
		System.out.println(model.SoluzioniErrate().toString());
		
	}

}
