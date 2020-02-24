package co.edu.unbosque.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Partida extends Thread{
	private String[] palabras = new String[8];
	private char[] partir;
	private char[] resultado;
	private Socket socket;
	private Scanner leer;
    private DataOutputStream out;
    private DataInputStream in;
    private int MN;
	int intentos = 0;
	String entrada;
	String paalabras;
	private boolean iacazhi;
	 private boolean turno;
	    //Lista de los usuarios conectados al servidor
	    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
	
	
	public Partida(Socket soc,LinkedList users,int mn, String Palabras) {
		iacazhi=false;
	leer = new Scanner (System.in);
		socket = soc;
        usuarios = users;
        MN = mn;
		 this.paalabras = Palabras;

		
		
	}
	public void run() {
		 try {
	            //Inicializamos los canales de comunicacion y mandamos el turno a cada jugador
			 	
	            in = new DataInputStream(socket.getInputStream());
	            out = new DataOutputStream(socket.getOutputStream());
	            entrada = in.readUTF();
	            turno = MN == 1;
	            String msg = "";
	            msg += "JUEGAS: " + (turno ? "M;":"N;");
	            msg += turno;
	            out.writeUTF(msg);
	            System.out.println(msg);
	            
	            //Ciclo infinito que estara escuchando por los movimientos de cada jugador
	            //Cada que un jugador pone una X o O viene aca y le dice al otro jugador que es su turno
	            while(true){
	               
	                String recibidos = in.readUTF();
	                String recibido [] = recibidos.split(";");
	                partir = partirPalabras(paalabras);
	        		int palabra = partir.length;
	        		pintar(palabra);
	        		char letra = recibido[0].charAt(0);
	        		String palabraas= recibido[1];
	        	    
	        		String cad ="";
	        		cad+=MN+";";
	        		cad += letra+";";
	        		cad += palabraas+";";
	        		boolean ganador = validarPalabra(palabraas, paalabras);
	        			
	            }   
	            }
	            catch (Exception e) {
	                
	                //Si ocurre un excepcion lo mas seguro es que sea por que algun jugador se desconecto asi que lo quitamos de la lista de conectados
	                for (int i = 0; i < usuarios.size(); i++) {
	                    if(usuarios.get(i) == socket){
	                        usuarios.remove(i);
	                        break;
	                    } 
	                }
	               
	            }
		
	}

	/**
	 * este metodo pinta la cantidad de veces que tiene que ingresar la letra
	 * dependiendo del tamaño de la palabra
	 * 
	 * @param palabra
	 */
	public void iniciarPartida() {
		
	}
	public  void pintar(int palabra) {
		
		
		resultado = new char[partir.length];
		resultado = rayaBaja(resultado);

		int cant = 0;
		boolean ganar = false;
		while (!ganar) {

			for (int i = 0; i < palabra; i++) {
				System.out.println("\nINGRESA LA LETRA: ");
				char letraR = leer.next().charAt(0);

				cant = validarLetra(letraR, resultado);
				i = i + (cant - 1);
				System.out.println(i);
			}
		}

	}

	public  char[] partirPalabras(String palabra) {
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

	public  char[] rayaBaja(char[] palabra) {
		for (int i = 0; i < partir.length; i++) {

			if (palabra[i]== ' ') {
				palabra[i]=' ';
				
				
			}else {
				palabra[i]='_';

			}
		}

		return palabra;

	}

	public  int validarLetra(char letraR, char[] resultado) {
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
	
	public boolean validarPalabra(String in, String palabra)
	{
		return in.equalsIgnoreCase(palabra);
	}

	public  boolean cincuentaPorciento() {
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
}