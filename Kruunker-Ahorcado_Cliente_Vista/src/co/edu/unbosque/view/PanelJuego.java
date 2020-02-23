package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.controller.Controller;

public class PanelJuego  extends JPanel implements ActionListener{
	
	private JLabel fondo;
	private JTextField tapalabra, tchat;
	private JTextArea thistorial, tletras;
	private JLabel lahorcado;
	private JButton benviar, badivinar, brendirse;
	private VentanaPrincipal vp;
	private Controller c;
	
	private String palabra;
	
	public PanelJuego(VentanaPrincipal vp, Controller c) {
		this.vp = vp;
		this.c = c;
		inicializar();
		setSize(1300, 682);
		setLayout(null);
		setVisible(false);
	}
	
	public void inicializar()
	{
		
		thistorial = new JTextArea();
		thistorial.setFont(new Font("ArialBlack",1,20));
		thistorial.setBounds(60, 200, 265, 330);
		thistorial.setLineWrap(true);
		add(thistorial);
		
		tletras = new JTextArea();
		tletras.setFont(new Font("ArialBlack",1, 20));
		tletras.setBounds(950, 295, 250, 190);
		tletras.setLineWrap(true);
		add(tletras);
		
		tapalabra = new JTextField("EjemploPalabra");
		tapalabra.setFont(new Font("ArialBlack",5,50));
		tapalabra.setBounds(70, 20, 1100, 60);
		tapalabra.setHorizontalAlignment(tapalabra.CENTER);
		tapalabra.addActionListener(this);
		add(tapalabra);
		
		tchat = new JTextField("");
		tchat.setFont(new Font("ArialBlack",5,20));
		tchat.setBounds(60, 537, 265, 40);
		tchat.addActionListener(this);
		add(tchat);
		
		benviar = new JButton();
		benviar.setBounds(331, 535, 102, 43);
		benviar.setContentAreaFilled(false);
		benviar.setBorderPainted(false);
		benviar.addActionListener(this);
		benviar.setActionCommand("Enviar");
		add(benviar);
		
		badivinar = new JButton();
		badivinar.setBounds(327, 490, 107, 43);
		badivinar.setContentAreaFilled(false);
		badivinar.setBorderPainted(false);
		badivinar.addActionListener(this);
		badivinar.setActionCommand("Adivinar");
		add(badivinar);
		
		brendirse = new JButton();
		brendirse.setBounds(309, 150, 130, 43);
		brendirse.setContentAreaFilled(false);
		brendirse.setBorderPainted(false);
		brendirse.addActionListener(this);
		brendirse.setActionCommand("Rendirse");
		add(brendirse);
		
		ImageIcon fond = new ImageIcon("data/JuegoCliente.png");
		lahorcado = new JLabel(fond);
		lahorcado.setBounds(490, 130, 400, 500);
		add(lahorcado);
		
		fondo = new JLabel(fond);
		fondo.setBounds(0, 0, 1280, 632);
		add(fondo);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

			String accion = e.getActionCommand();
			System.out.println(accion);
			if (accion.contentEquals("Rendirse")) {
				JOptionPane.showMessageDialog(null, "Te has rendido, perdiste");
				System.exit(1);
			}
			
			if (accion.contentEquals("Adivinar")) {
				thistorial.setText(thistorial.getText()+"Intento de adivinar: "+"\n"+tchat.getText()+"\n");
			}
			
			if (accion.contentEquals("Enviar")) {
				thistorial.setText(thistorial.getText()+"Escribiste: "+"\n"+tchat.getText().toCharArray()[0]+"\n");
				boolean repetido = false;
				for (int i = 0; i < tletras.getText().length(); i++) {
					if (tchat.getText().toCharArray()[0]==tletras.getText().toCharArray()[i]) {
						repetido = true;
					}
				}
				if(!repetido)
				{
					tletras.setText(tletras.getText()+tchat.getText().toCharArray()[0]+"   ");
				}
			}
	}
	
}
