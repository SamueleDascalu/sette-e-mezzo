package org.generation.italy;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int numeroGenerato, contatore=0, banco=0;
		String risposta;
		
		String[] segni = {"Denari", "Bastoni", "Coppe", "Spade"};
        String[] valoriStringa = {"1", "2", "3", "4", "5", "6", "7", "cavallo", "donna", "re"};
        float[] valoriNumerici = new float[40];
        
        float valoreCorrente=0;
        
        HashSet<Integer> carteEstratte = new HashSet<Integer>();
        
        // creo il mazzo
        int lunghezzaTotaleMazzo = segni.length * valoriStringa.length; //lunghezza di segni * lunghezza di valoriStringa
        
        String[] mazzo = new String[lunghezzaTotaleMazzo];
        
        for (int i = 0; i < valoriStringa.length; i++) {
            for (int j = 0; j < segni.length; j++) {
                mazzo[segni.length*i + j] = valoriStringa[i] + " di " + segni[j];
            }
        }
        
        //inserisco i valori in valoriNumerici
        for (int i = 0; i < valoriStringa.length; i++) {
            for (int j = 0; j < segni.length; j++) {
            	if(i<7) {
            		valoriNumerici[segni.length*i + j] = i+1;
            	} else {
            		valoriNumerici[segni.length*i + j] = 0.5f;
            	}
            }
        }
        
        System.out.print("E' iniziato il gioco ");
        
        do {
        	//genero un numero random
        	numeroGenerato = random.nextInt(40);
        	
        	//finche il numeroGenerato si trova nel set carteEstratte continua a generare un random
        	while(carteEstratte.contains(numeroGenerato)) {
        		//ho rimosso il +1 dato che random parte da 0 esattamente come l'array
        		numeroGenerato = random.nextInt(40);
        	}
        	
        	/*
        	 * se il numeroGenerato non e presente all'interno del set carteEstratte lo aggiungo in modo da
        	 * escludere la carta nell'iterazione successiva
        	 * */
    		carteEstratte.add(numeroGenerato);
    		
    		System.out.println("la tua carta é: ");
        	
        	System.out.println();
        	System.out.println(mazzo[numeroGenerato]);
        	
        	valoreCorrente+=valoriNumerici[numeroGenerato];
        	System.out.println();
        	
        	if(contatore>0) {
        		System.out.println("Il valore raggiunto é: "+valoreCorrente);
        	}
        	
        	if(valoreCorrente>7.5) {
        		System.out.println("Hai sballato!");
        		break;
        	}
        	
        	contatore++;
        	
        	System.out.print("Vuoi un'altra carta? (si/no) ");
        	risposta = scanner.nextLine();;
        	
        }while(risposta.equals("si"));
        
        while(banco<=valoreCorrente && banco<=7.5) {
        	numeroGenerato = random.nextInt(40);
        	
        	while(carteEstratte.contains(numeroGenerato)) {
        		numeroGenerato = random.nextInt(40);
        	}
        	
        	carteEstratte.add(numeroGenerato);
        	
        	banco+=valoriNumerici[numeroGenerato];
        	
        	if(banco>=valoreCorrente && banco<=7.5) {
        		break;
        	}
        }
        
        if(banco<=7.5&&banco>=valoreCorrente) {
        	System.out.println("Il banco ha fatto "+banco);
        	System.out.println("Ha vinto il banco");
        }
        
        if(banco>7.5) {
        	System.out.println("Il banco ha fatto "+banco);
        	System.out.println("Il banco ha sballato.");
        }
        
		scanner.close();
	}

}
