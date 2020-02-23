package co.edu.unbosque.controller;

import java.util.Random;
import java.util.Scanner;

public class Jugador {

	static String[] palabras = new String[8];
	static char[] partir;
	static char[] resultado;
	static Scanner leer;
	public static void main(String[] args) {
		leer = new Scanner(System.in);
		

		Random random = new Random();

		palabras[0] = "harrypotter";
		palabras[1] = "betty la fea";
		palabras[2] = "programacion";
		palabras[3] = "estructura de datos ";
		palabras[4] = "republica de colombia ";
		palabras[5] = "ban bunny";
		palabras[6] = "coronavirus";
		palabras[7] = "sherk";

		int alea = random.nextInt(8);
		partir = partirPalabras(palabras[alea]);
		int palabra = partir.length;
		pintar(palabra);
	}
		/**
		 * este metodo pinta la cantidad de veces que tiene que ingresar la letra dependiendo del tamaño de la palabra 
		 * @param palabra
		 */
	   public static void pintar(int palabra) {
		resultado = new char[partir.length];
		resultado = rayaBaja(resultado);	
		
		int cant =0;
		
		for (int i = 0; i < palabra; i++) {
			System.out.println("\nINGRESA LA LETRA: ");
			char letraR = leer.next().charAt(0);
			cant = validarLetra(letraR, resultado);
			i = i +(cant-1);
			System.out.println(i);
		}

	}
	

	public static char[] partirPalabras(String palabra) {
		char[] texto;
		texto = new char[palabra.length()];
		for (int i = 0; i < palabra.length(); i++) {
			texto[i] = palabra.charAt(i);
			System.out.print(texto[i]);
		}
		
		return texto;
	}
	/**
	 * este metodo le asigna a el tamaño de la palabra raya al piso 
	 * @param palabra
	 * @return
	 */
	
	public static char[] rayaBaja(char [] palabra) {		
		for (int i = 0; i < partir.length; i++) {
			palabra[i] ='_';			
		}
		
		return palabra;
		
	}

	public static int validarLetra(char letraR, char [] resultado) {
		int cant = 0;
		for (int i = 0; i < partir.length; i++) {
		
			if (partir[i] == letraR) {
				resultado[i] = letraR;
				cant++;
			}			
		}
		
		System.out.println(resultado);	

		return cant;
	}

}
