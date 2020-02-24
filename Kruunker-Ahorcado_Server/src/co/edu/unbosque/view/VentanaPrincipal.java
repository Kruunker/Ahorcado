package co.edu.unbosque.view;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class VentanaPrincipal extends JFrame{
	PanelPrincipal pp;
	Controller c;
	public VentanaPrincipal(Controller c)
	{
		this.c = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1280, 682);
		setResizable(true);
		setLocationRelativeTo(null);
		inicializar();
		setVisible(true);
		
	}
	
	public void inicializar()
	{
		pp = new PanelPrincipal(this, c);
		add(pp);
		
	}
}
	