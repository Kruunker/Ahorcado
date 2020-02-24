package co.edu.unbosque.controller;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;

import co.edu.unbosque.model.*;

public class Servidor {
	
	private String[] palabras = new String[8];
	private final int puerto = 2027;
    //Numero maximo de conexiones (el tictactoe es un juego para 2)
    private final int noConexiones = 2;
    //Creamos una lista de sockets para guardar el socket de cada jugador
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    //Variable para controlar el turno de cada jugador
    private Boolean turno = true;
    private int turnos = 1;
    String Palabra;
    public void Escuchar() {
    	try {
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
		Palabra = palabras[alea];
		
    ServerSocket servidor = new ServerSocket(puerto,noConexiones);
    //Ciclo infinito para estar escuchando por nuevos jugadores
    System.out.println("Esperando jugadores....");
    while (true) {
    	
    	 Socket cliente = servidor.accept();
    	 System.out.println(Palabra);
         //Se agrega el socket a la lista
         usuarios.add(cliente);
         //Se le genera un turno X o O 
         int mn = turnos % 2 == 0 ? 1 : 0;
         turnos++;
         Thread  hilo = new Partida(cliente,usuarios,mn,Palabra);
         hilo.start();
    }
    }catch (Exception e) {
        e.printStackTrace();
    }
    
    	}
    }
