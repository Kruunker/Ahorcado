package co.edu.unbosque.view;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class VentanaPrincipal extends JFrame {

	PanelInicial pi;
	PanelJuego pj;
	PanelMenu pm;
	Controller c;

	public VentanaPrincipal(Controller c) {
		this.c = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(505, 535);
		setResizable(true);
		setLocationRelativeTo(null);
		inicializar();
		setVisible(true);

	}

	public void inicializar() {
		pi = new PanelInicial(this, c);
		add(pi);
		pj = new PanelJuego(this, c);
		add(pj);
		pm = new PanelMenu(this, c);
		add(pm);
	}

	public PanelInicial getPi() {
		return pi;
	}

	public void setPi(PanelInicial pi) {
		this.pi = pi;
	}

	public PanelJuego getPj() {
		return pj;
	}

	public void setPj(PanelJuego pj) {
		this.pj = pj;
	}

	public PanelMenu getPm() {
		return pm;
	}

	public void setPm(PanelMenu pm) {
		this.pm = pm;
	}

}
