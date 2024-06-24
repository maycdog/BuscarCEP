package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

// Créditos: https://www.youtube.com/watch?v=52soIAnHDvk&list=PLbEOwbQR9lqxVuDWNIrG57_JGcbIL3FWP




@SuppressWarnings("serial")
public class Cep extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JLabel lblEndereo;
	private JTextField txtEndereco;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblEndereo_2;
	private JTextField txtCidade;
	private JLabel lblEndereo_1;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUf;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Cep() {
		setFont(null);
		setForeground(new Color(0, 0, 0));
		setTitle("BUSCAR CEP");
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Maycon\\eclipse-workspace\\BuscarCEP\\src\\img\\home.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(22, 32, 40, 20);
		contentPane.add(lblNewLabel);

		txtCep = new JTextField();
		txtCep.setForeground(Color.BLACK);
		txtCep.setBackground(new Color(132, 85, 255));
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCep.setBounds(108, 33, 110, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(Color.BLACK);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEndereo.setBounds(22, 71, 90, 30);
		contentPane.add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setForeground(Color.BLACK);
		txtEndereco.setBackground(new Color(132, 85, 255));
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(108, 77, 324, 20);
		contentPane.add(txtEndereco);

		lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(Color.BLACK);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblBairro.setBounds(22, 112, 90, 30);
		contentPane.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setForeground(Color.BLACK);
		txtBairro.setBackground(new Color(132, 85, 255));
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBairro.setColumns(10);
		txtBairro.setBounds(108, 118, 324, 20);
		contentPane.add(txtBairro);

		lblEndereo_2 = new JLabel("Cidade");
		lblEndereo_2.setForeground(Color.BLACK);
		lblEndereo_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEndereo_2.setBounds(22, 153, 90, 30);
		contentPane.add(lblEndereo_2);

		txtCidade = new JTextField();
		txtCidade.setForeground(Color.BLACK);
		txtCidade.setBackground(new Color(132, 85, 255));
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCidade.setColumns(10);
		txtCidade.setBounds(108, 159, 110, 20);
		contentPane.add(txtCidade);

		lblEndereo_1 = new JLabel("UF");
		lblEndereo_1.setForeground(Color.BLACK);
		lblEndereo_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEndereo_1.setBounds(271, 153, 40, 30);
		contentPane.add(lblEndereo_1);

		cboUf = new JComboBox();
		cboUf.setBackground(new Color(132, 85, 255));
		cboUf.setForeground(Color.WHITE);
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "...", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG",
						"PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(321, 149, 111, 34);
		contentPane.add(cboUf);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBackground(Color.BLACK);
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBounds(22, 211, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCep = new JButton("Buscar");
		btnCep.setBackground(Color.BLACK);
		btnCep.setForeground(Color.WHITE);
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					// Buscar CEP
					buscarCep();
				}
			}
		});
		btnCep.setBounds(228, 32, 90, 20);
		contentPane.add(btnCep);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon("C:\\Users\\Maycon\\eclipse-workspace\\BuscarCEP\\src\\img\\about.png"));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setBounds(384, 18, 48, 48);
		contentPane.add(btnSobre);

		/* Uso da biblioteca Atxy2k para validação do campo txtCep */
		RestrictedTextField validar = new RestrictedTextField(txtCep);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(341, 32, 16, 16);
		contentPane.add(lblStatus);
		validar.setOnlyNums(true);
		validar.setLimit(8);

	} // fim do construtor

	@SuppressWarnings("deprecation")
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}
			// setar o campo endereco
			txtEndereco.setText(tipoLogradouro + " " + logradouro);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void limpar() {
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem(null);
		txtCep.requestFocus();
		lblStatus.setIcon(null);
	}
}
