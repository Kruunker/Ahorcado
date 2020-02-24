package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import co.edu.unbosque.controller.Controller;

public class PanelPrincipal extends JLabel implements ActionListener{
	private VentanaPrincipal vp;
	private Controller c;
	private JTextField tpalabra;
	private JTextArea j1, j2;
	private JLabel fondo, info;
	public PanelPrincipal(VentanaPrincipal vp, Controller c) {
		this.vp = vp;
		this.c = c;
		setSize(1280, 682);
		setLayout(null);
		inicializar();
		setVisible(true);
	}
	public void inicializar()
	{
		j1 = new JTextArea(16,58);
		j1.setFont(new Font("ArialBlack",1,20));
		j1.setLineWrap(true);
		j1.setEditable(false); 
		JScrollPane scroll1 = new JScrollPane(j1);
        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(85, 240, 310, 330);
        scroll1.setBorder(null);
        add(scroll1);

        j2 = new JTextArea(16,58);
		j2.setFont(new Font("ArialBlack",1,20));
		j2.setLineWrap(true);
		j2.setEditable(false); 
		JScrollPane scroll2 = new JScrollPane(j2);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(884, 240, 310, 330);
        scroll2.setBorder(null);
        add(scroll2);
        
		tpalabra = new JTextField("EjemploPalabra");
		tpalabra.setFont(new Font("ArialBlack",1,50));
		tpalabra.setBounds(80, 50, 1100, 60);
		tpalabra.setHorizontalAlignment(tpalabra.CENTER);
		tpalabra.addActionListener(this);
		add(tpalabra);	
		
		info = new JLabel("0");
		info.setFont(new Font("ArialBlack",1,50));
		info.setBounds(605, 300, 50, 50);
		info.setFont(new Font("ArialBLack",5,50));
		add(info);
		
		ImageIcon fond = new ImageIcon("data/servidor.jpeg");
		fondo = new JLabel(fond);
		fondo.setBounds(0, 0, 1280, 682);
		add(fondo);

		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
