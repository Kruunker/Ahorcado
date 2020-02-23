package co.edu.unbosque.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Jugador {

	/**
	 * Atributos del jugador a asignar
	 */
	private String nick;
	private String correo;
	private int puntaje = 10;

	public Jugador(String nick, String correo, DataInputStream in, DataOutputStream out) {
		this.nick = nick;
		this.correo = correo;
	}

	/**
	 * Constructor vacio de jugador
	 */
	public Jugador() {

	}

	/**
	 * <br>
	 * Obtener NickName</br>
	 * Obtiene el nickname del jugador
	 * 
	 * @return
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * <br>
	 * Cambiar NickName</br>
	 * Metodo que recibe por parametro un String para sustituir el nickname por el
	 * ya existente
	 * 
	 * @param nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * <br>
	 * Obtener Correo</br>
	 * Obtiene el correo del jugador
	 * 
	 * @return
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * <br>
	 * Cambiar Correo</br>
	 * Metodo que recibe por parametro un String para sustituir el correo por el ya
	 * existente
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * <br>
	 * Obtener Puntaje</br>
	 * Obtiene el puntaje del jugador
	 * 
	 * @return
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * <br>
	 * Puntaje Correo</br>
	 * Metodo que recibe por parametro un int para sustituir el puntaje por el ya
	 * existente
	 * 
	 * @param puntaje
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * <br>
	 * Cambiar Puntaje</br>
	 * Metodo que va a permitir cambiar el numero de puntos del jugador
	 * 
	 * @param puntaje
	 */

}
