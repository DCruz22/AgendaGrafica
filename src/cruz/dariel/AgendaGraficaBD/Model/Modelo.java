package cruz.dariel.AgendaGraficaBD.Model;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import cruz.dariel.AgendaGraficaBD.Conexiones.Conexion;
import cruz.dariel.AgendaGraficaBD.Entidades.Contacto;

public class Modelo extends AbstractTableModel {

	private String[] headers = {"Nombre","Apellido","Telefono"};
	private ArrayList<Contacto> contactos;
	private Conexion con;
	private static Modelo instance;
	
	private Modelo(){
		con = Conexion.getInstance();
		contactos = con.listarContacto();
	}
	
	public static Modelo getInstance(){
		return instance == null ? instance = new Modelo() : instance;
	}
	
	public void insertarContacto(Contacto cont){
		contactos.add(cont);
		con.insertarContacto(cont);
		fireTableDataChanged();
	}	
	
	public void eliminarContacto(int index){
		contactos.remove(index);
		fireTableRowsDeleted(index, index);
		con.eliminarContacto(index);
	}
	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public String getColumnName(int column) {
		return headers[column];
	}

	@Override
	public int getRowCount() {
		return contactos.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		String ret="";
		
		Contacto contacto = contactos.get(x);
		
		switch(y){
			case(0):
				ret = contacto.getNombre();
				break;
			case(1):
				ret = contacto.getApellido();
				break;
			case(2):
				ret= contacto.getTelefono();
			}
		return ret;
		}
}

