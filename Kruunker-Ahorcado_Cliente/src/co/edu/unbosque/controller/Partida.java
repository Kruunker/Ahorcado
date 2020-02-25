package co.edu.unbosque.controller;

import java.util.Random;

import co.edu.unbosque.model.Jugador;

public class Partida {

	private String[] palabras = new String[8];
	private char[] partir; // es el arreglo de char que obtiene la palabra caracter a caracter ;
	private char[] resultado;// es el arreglo de char que obtiene la palabra actualizandola con las rayas
	private int intentos = 0;

	int cant = 0; // variable que tiene la cantidad de veces que se repiten los espacios

	public Partida() {
		palabras[0] = "harry potter";
		palabras[1] = "betty la fea";
		palabras[2] = "programacion";
		palabras[3] = "estructura de datos ";
		palabras[4] = "republica de colombia ";
		palabras[5] = "ban bunny";
		palabras[6] = "coronavirus";
		palabras[7] = "sherk";

		Random random = new Random();
		int alea = random.nextInt(8);// la palabra aleatoria que se pondra a adivinar
		partir = partirPalabras(palabras[alea]);// se obtiene caracter a caracter la palabra

		cantidadEspacios(palabras[alea]);// la cantidad de espacios que tiene la palabra

		// Cree un metodo que cuente si la palabra tiene espacios

		int palabra = (partir.length - getCant()); // se toma el tamaño de la palabra y se le resta la cantidad de
												// palabras
	}

	public char[] partirPalabras(String palabra) {
		char[] texto;
		texto = new char[palabra.length()];
		for (int i = 0; i < palabra.length(); i++) {
			texto[i] = palabra.charAt(i);
			System.out.print(texto[i]);
		}

		return texto; // retorna la palabra caracter a caracter
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

		return cant; // retorna la cantidad de veces que se repite la letra
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

	/**
	 * Metodo que retorna un entero siendo el numero de puntos del jugador pasado
	 * por parametro
	 * 
	 * @param jugador
	 * @return
	 */
	public int quitarPunto(Jugador jugador) {
		int puntaje = jugador.getPuntaje();
		puntaje--;
		jugador.setPuntaje(puntaje);
		return puntaje;
	}

	/**
	 * este metodo le asigna a el tamaño de la palabra raya al piso
	 * 
	 * @param palabra
	 * @return
	 */
	public int cantidadEspacios(String palabra) {
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == ' ') {
				cant++;
			}
		}

		return cant;// retorna la cantidad de espacios que tiene la letra

	}

	public char[] rayaBaja(char[] palabra) {
		for (int i = 0; i < partir.length; i++) {
			palabra[i] = '_';
		}
		return palabra; // retorna la palabra con raya baja
	}

	public int getCant() {
		return cant;
	}

	public static void setCant(int cant) {
		Main_Metodos.cant = cant;
	}
}
