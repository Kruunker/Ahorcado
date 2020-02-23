package co.edu.unbosque.controller;

import java.util.Random;

import co.edu.unbosque.model.Jugador;

public class Partida {
	private String[] palabras = new String[8];
	private char[] partir;
	private char[] resultado;
	int intentos = 0;

	public Partida() {

		Random random = new Random();

		palabras[0] = "harrypotter";
		palabras[1] = "bettylafea";
		palabras[2] = "programacion";
		palabras[3] = "estructuradedatos ";
		palabras[4] = "republicadecolombia ";
		palabras[5] = "banbunny";
		palabras[6] = "coronavirus";
		palabras[7] = "sherk";

		int alea = random.nextInt(8);
		partir = partirPalabras(palabras[alea]);
		int palabra = partir.length;
//		pintar(palabra);
	}

	/**
	 * este metodo pinta la cantidad de veces que tiene que ingresar la letra
	 * dependiendo del tamaño de la palabra
	 * 
	 * @param palabra
	 */
//	public  String pintar(int palabra) {
//		
//		
//		resultado = new char[partir.length];
//		resultado = rayaBaja(resultado);
//
//		int cant = 0;
//		boolean ganar = false;
//		while (!ganar) {
//
//			for (int i = 0; i < palabra; i++) {
//				System.out.println("\nINGRESA LA LETRA: ");
//				char letraR = leer.next().charAt(0);
//
//				cant = validarLetra(letraR, resultado);
//				i = i + (cant - 1);
//				System.out.println(i);
//			}
//		}
//
//	}

	public char[] partirPalabras(String palabra) {
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
	 * 
	 * @param palabra
	 * @return
	 */

	public char[] rayaBaja(char[] palabra) {
		for (int i = 0; i < partir.length; i++) {

			if (palabra[i] == ' ') {
				palabra[i] = ' ';

			} else {
				palabra[i] = '_';

			}
		}

		return palabra;

	}

	public int validarLetra(char letraR, char[] resultado) {
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

	public boolean cincuentaPorciento() {
		int cont = 0;
		for (int i = 0; i < resultado.length; i++) {
			if (resultado[i] != '_') {
				cont++;
			}
		}
		if (cont - 1 == partir.length / 2) {
			return true;
		} else {
			return false;
		}
	}

	public int quitarPunto(Jugador jugador) {
		int puntaje = jugador.getPuntaje();
		puntaje--;
		jugador.setPuntaje(puntaje);

		return jugador.getPuntaje();
	}
}
