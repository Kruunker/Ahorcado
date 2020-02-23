package co.edu.unbosque.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

public class PanelInicial extends JPanel implements ActionListener {

	private JLabel fondo;
	private JButton bcontinuar, biniciarSesion, bregistrarse, bsalir;
	private VentanaPrincipal vp;
	private Controller c;

	public PanelInicial(VentanaPrincipal vp, Controller c) {
		this.vp = vp;
		this.c = c;
		inicializar();
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
	}

	public void inicializar() {
		ImageIcon fond = new ImageIcon("data/inicio2.jpeg");
		fondo = new JLabel(fond);
		fondo.setBounds(0, 0, 500, 500);
		add(fondo);

		bcontinuar = new JButton();
		bcontinuar.setBounds(120, 30, 240, 240);
		bcontinuar.setContentAreaFilled(false);
		bcontinuar.setBorderPainted(false);
		bcontinuar.addActionListener(this);
		bcontinuar.setActionCommand("Continuar");
		add(bcontinuar);

		biniciarSesion = new JButton();
		biniciarSesion.setBounds(125, 300, 230, 50);
		biniciarSesion.setContentAreaFilled(false);
		biniciarSesion.setBorderPainted(false);
		biniciarSesion.addActionListener(this);
		biniciarSesion.setActionCommand("IniciarSesion");
		add(biniciarSesion);

		bregistrarse = new JButton();
		bregistrarse.setBounds(126, 358, 232, 45);
		bregistrarse.setContentAreaFilled(false);
		bregistrarse.setBorderPainted(false);
		bregistrarse.addActionListener(this);
		bregistrarse.setActionCommand("Registrarse");
		add(bregistrarse);

		bsalir = new JButton();
		bsalir.setBounds(150, 418, 186, 43);
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
		if (accion.contentEquals("Continuar")) {
			vp.setSize(500, 800);
			this.setVisible(false);
			vp.setLocationRelativeTo(null);
			vp.getPm().setVisible(true);
		}
		if (accion.contentEquals("IniciarSesion")) {
			ImageIcon fond = new ImageIcon("data/inicio1.jpeg");
			fondo.setIcon(fond);
			fondo.setBounds(0, 0, 500, 500);
		}
		if (accion.contentEquals("Salir")) {
			System.exit(1);
		}
	}
}
