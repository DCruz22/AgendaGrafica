package cruz.dariel.AgendaGraficaBD.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cruz.dariel.AgendaGraficaBD.Entidades.Contacto;
import cruz.dariel.AgendaGraficaBD.Model.Modelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInsertar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JButton btnInsertar;
	private Modelo model;

	public VentanaInsertar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 209);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		model = Modelo.getInstance();
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 40, 56, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 71, 56, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 99, 56, 14);
		contentPane.add(lblTelefono);
		
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(100, 40, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(100, 71, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		bindButton();
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(100, 99, 86, 20);
		contentPane.add(txtTelefono);
	}
	private void bindButton(){
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateTextBox(txtNombre,txtApellido,txtTelefono)){
				model.insertarContacto(new Contacto(txtNombre.getText(),txtApellido.getText(),txtTelefono.getText()));
				VentanaInsertar.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Debe Llenar todos los Campos!","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnInsertar.setBounds(50, 147, 89, 23);
		contentPane.add(btnInsertar);
	}
	
	private boolean validateTextBox(JTextField txt,JTextField txt2,JTextField txt3){
		
		if(txt.getText().isEmpty() || txt2.getText().isEmpty() || txt3.getText().isEmpty()){
			return false;
		}
		return true;
	}
	
}
