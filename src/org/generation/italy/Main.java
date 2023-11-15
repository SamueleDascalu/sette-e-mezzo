package org.generation.italy;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int numeroGenerato;
		String risposta;
		
		String[] segni = {"Denari", "Bastoni", "Coppe", "Spade"};
        String[] valoriStringa = {"1", "2", "3", "4", "5", "6", "7", "cavallo", "donna", "re"};
        float[] valoriNumerici = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f};
        
        float valoreCorrente=0;
        
        // creo il mazzo
        int n = segni.length * valoriStringa.length;
        
        String[] mazzo = new String[n];
        
        for (int i = 0; i < valoriStringa.length; i++) {
            for (int j = 0; j < segni.length; j++) {
                mazzo[segni.length*i + j] = valoriStringa[i] + " di " + segni[j];
            }
        }

//        for(int i=0; i<mazzo.length; i++) {
//        	System.out.println(mazzo[i]);
//        }
        
        System.out.print("E' iniziato il gioco ");
        
        do {
        	System.out.println("la tua carta é: ");
        	
        	numeroGenerato = random.nextInt(40)+1;
        	System.out.println();
        	System.out.println(mazzo[numeroGenerato]);
        	
        	System.out.print("Il suo valore é: "+valoriNumerici[numeroGenerato]);
        	valoreCorrente+=valoriNumerici[numeroGenerato];
        	System.out.println();
        	System.out.println();
        	
        	if(valoreCorrente<=7.5) {
        		System.out.println("Il valore raggiunto é: "+valoreCorrente);
        	} else {
        		System.out.println("Il valore raggiunto é: "+valoreCorrente);
        		System.out.println("Hai sballato!");
        		break;
        	}
        	
        	System.out.print("Vuoi un'altra carta? (si/no) ");
        	risposta = scanner.nextLine();
        }while(risposta.equals("si"));
        
		scanner.close(); 
	}

}
