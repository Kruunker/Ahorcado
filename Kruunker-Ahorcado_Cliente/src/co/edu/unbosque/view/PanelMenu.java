package co.edu.unbosque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

public class PanelMenu extends JPanel implements ActionListener {
	private JButton bjugar, bopciones, bayuda, bsalir;
	private JLabel fondo;
	private VentanaPrincipal vp;
	private Controller c;

	public PanelMenu(VentanaPrincipal vp, Controller c) {
		this.vp = vp;
		this.c = c;
		inicializar();
		setSize(500, 800);
		setLayout(null);
		setVisible(false);
	}

	public void inicializar() {
		ImageIcon fond = new ImageIcon("data/menu.jpeg");
		fondo = new JLabel(fond);
		fondo.setBounds(0, 0, 500, 800);
		add(fondo);

		bjugar = new JButton();
		bjugar.setBounds(155, 251, 205, 60);
		bjugar.setContentAreaFilled(false);
		bjugar.setBorderPainted(false);
		bjugar.addActionListener(this);
		bjugar.setActionCommand("Jugar");
		add(bjugar);

		bopciones = new JButton();
		bopciones.setBounds(151, 351, 216, 60);
		bopciones.setContentAreaFilled(false);
		bopciones.setBorderPainted(false);
		bopciones.addActionListener(this);
		bopciones.setActionCommand("Opciones");
		add(bopciones);

		bayuda = new JButton();
		bayuda.setBounds(151, 451, 224, 60);
		bayuda.setContentAreaFilled(false);
		bayuda.setBorderPainted(false);
		bayuda.addActionListener(this);
		bayuda.setActionCommand("Ayuda");
		add(bayuda);

		bsalir = new JButton();
		bsalir.setBounds(156, 551, 215, 60);
		bsalir.setContentAreaFilled(false);
		bsalir.setBorderPainted(false);
		bsalir.addActionListener(this);
		bsalir.setActionCommand("Salir");
		add(bsalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		System.out.println(accion);
		if (accion.contentEquals("Jugar")) {
			vp.setSize(1300, 682);
			this.setVisible(false);
			vp.setLocationRelativeTo(null);
			vp.getPj().setVisible(true);
		}
		if (accion.contentEquals("Salir")) {
			System.exit(1);
		}
	}

}
