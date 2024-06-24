package cep;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("SOBRE");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maycon\\eclipse-workspace\\BuscarCEP\\src\\img\\home.png"));
		setBounds(150, 150, 441, 302);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar CEP - Versão 1.0");
		lblNewLabel.setBounds(43, 46, 190, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblauthorMayconDouglas = new JLabel("@Author maycdog");
		lblauthorMayconDouglas.setBounds(43, 71, 190, 14);
		getContentPane().add(lblauthorMayconDouglas);
		
		JLabel lblWebService = new JLabel("republicavirtual.com.br");
		lblWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br/");
			}
		});
		lblWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebService.setForeground(SystemColor.textHighlight);
		lblWebService.setBounds(136, 96, 190, 14);
		getContentPane().add(lblWebService);
		
		JLabel lblauthorMayconDouglas_1_1 = new JLabel("WEB Service:");
		lblauthorMayconDouglas_1_1.setBounds(43, 96, 190, 14);
		getContentPane().add(lblauthorMayconDouglas_1_1);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/maycdog");
			}
		});
		btnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGithub.setBorder(null);
		btnGithub.setIcon(new ImageIcon("C:\\Users\\Maycon\\eclipse-workspace\\BuscarCEP\\src\\img\\github.png"));
		btnGithub.setToolTipText("github");
		btnGithub.setBackground(SystemColor.control);
		btnGithub.setBounds(42, 158, 48, 48);
		getContentPane().add(btnGithub);

	} //fim do construtor
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e){
			System.out.println(e);
		}
	}

}
