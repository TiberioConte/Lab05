package it.polito.tdp.anagrammi.model;

import java.util.HashSet;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class ModelAnagrammatore {
	 private Character[] parolaDaAnagrammare;
	 //Character classe wrapper di char
	 private int lunghezza;
	 private HashSet<String> soluzioniCorrette;
	 private HashSet<String> soluzioniErrate;
	 private ParolaDAO dao;
	 
	 
	 
	 public ModelAnagrammatore() {
	dao=new ParolaDAO();
	}
	 //questo è il metodo interfaccia elaborato in quanto deve lavorare con il model
	public void ImpostaParola(String parola) {
		parolaDaAnagrammare=new Character[parola.length()];
		for(int i=0;i<parola.length();i++){
			parolaDaAnagrammare[i]=parola.toCharArray()[i];
		}
		
		this.lunghezza = parola.length();
		
		soluzioniCorrette=new  HashSet<String>();
		soluzioniErrate=new  HashSet<String>();
	
		Character[] soluzioneParziale=new Character[lunghezza];
		int livello=0;
		metodoRicorsivo(soluzioneParziale,livello);
		
	}

	public  HashSet<String> SoluzioniCorrette(){
		return soluzioniCorrette;
	}
	
	public  HashSet<String> SoluzioniErrate(){
		return soluzioniErrate;
	}
	
	

	private void metodoRicorsivo(Character[] soluzioneParziale, int livello) {
		//blocco a -condizione di terminazione
		if(livello==lunghezza){
			//se faccio cosi copio solo il riferimento della soluzione parziale completa
			//e questa risoluzione parziale completa varierà anche dopo che i ne ho 
			//salvato il riferimento
			//soluzioni.add(TrasformaArrayCharacterInString(soluzioneParziale));
			//return;
			String soluzione=new String(TrasformaArrayCharacterInString(soluzioneParziale));
			if(dao.isParolaCorretta(soluzione)){
				String s=new String(soluzione);
				soluzioniCorrette.add(s);
			}else{
				String s=new String(soluzione);
				soluzioniErrate.add(s);
			}
			return;
		}
		for(int i=0;i<lunghezza;i++){
			if(soluzioneParziale[i]==null){
				soluzioneParziale[i]=parolaDaAnagrammare[livello];
				metodoRicorsivo(soluzioneParziale,livello+1);
				soluzioneParziale[i]=null;
			}
		}
	}

	
	public String TrasformaArrayCharacterInString(Character[] soluzioneParziale){
		String stringa=new String();
		for(Character c:soluzioneParziale )
			stringa=stringa.concat(""+c);
		return stringa;
		
	}
}
