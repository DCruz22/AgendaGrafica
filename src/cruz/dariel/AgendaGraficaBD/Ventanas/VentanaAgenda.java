package cruz.dariel.AgendaGraficaBD.Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import cruz.dariel.AgendaGraficaBD.Model.Modelo;

import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class VentanaAgenda extends JFrame {

	private JPanel contentPane;
	private Modelo model;
	private JTable tableContactos;
	private JScrollPane Jsp;

	public VentanaAgenda() {
		setTitle("Agenda Grafica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 238);
		setResizable(false);
		
		bindMenu();
		bindButton();
		bindTable();
	}
	
	private void bindTable(){
		model = Modelo.getInstance();
		
		
		tableContactos = new JTable();
		tableContactos.setModel(model);
		Jsp = new JScrollPane(tableContactos);
		Jsp.setBounds(10,11,414,142);
		tableContactos.setBounds(0, 30, 414, 204);
		contentPane.add(Jsp);
		
	}
	
	private void bindMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);
		
		JMenuItem mntmNuevoContacto = new JMenuItem("Nuevo Contacto..");
		mntmNuevoContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInsertar insert = new VentanaInsertar();
				insert.setVisible(true);
			}
		});
		mnAcciones.add(mntmNuevoContacto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void bindButton(){
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableContactos.getSelectedRow();
				if(tableContactos.isRowSelected(index)){
				model.eliminarContacto(index);
				}else{
					JOptionPane.showMessageDialog(null,"Debe Seleccionar un Contacto!","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEliminar.setBounds(10, 160, 89, 23);
		contentPane.add(btnEliminar);
	}
}
