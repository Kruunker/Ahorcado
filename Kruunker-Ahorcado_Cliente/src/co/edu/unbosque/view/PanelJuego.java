package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

public class PanelJuego extends JPanel {

	private JLabel fondo;
	private VentanaPrincipal vp;
	private Controller c;

	public PanelJuego(VentanaPrincipal vp, Controller c) {
		this.vp = vp;
		this.c = c;
		inicializar();
		setSize(1300, 682);
		setLayout(null);
		setVisible(false);
	}

	public void inicializar() {
		ImageIcon fond = new ImageIcon("data/jugador.jpeg");
		fondo = new JLabel(fond);
		fondo.setBounds(0, 0, 1300, 682);
		add(fondo);
	}
}
