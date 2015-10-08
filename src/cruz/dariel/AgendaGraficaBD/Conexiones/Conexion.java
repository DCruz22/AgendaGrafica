package cruz.dariel.AgendaGraficaBD.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cruz.dariel.AgendaGraficaBD.Entidades.ConfigManager;
import cruz.dariel.AgendaGraficaBD.Entidades.Contacto;

public class Conexion {
	private Connection con;
	private Statement statement;
	private ResultSet rs;
	private static Conexion instance;
	private ConfigManager conf;
	private ArrayList<Contacto> contactos;
	
	private Conexion(){
		conf = ConfigManager.getInstance();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+conf.getDBName()+"?user="+conf.getUser()+"&password="+conf.getPassword());
			statement = con.createStatement();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Conexion getInstance(){
		return instance == null ? instance = new Conexion():instance;
	}
	
	public ArrayList<Contacto> listarContacto(){	
	try {
		contactos = new ArrayList<Contacto>();
		rs = statement.executeQuery("Select * from contactos");
		while(rs.next()){
			contactos.add(new Contacto(rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Telefono")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return contactos;
	}
	
	public void insertarContacto(Contacto cont){
		try {
			statement.execute("INSERT into contactos(nombre,apellido,telefono) values('"+cont.getNombre()+"','"+cont.getApellido()+"','"+cont.getTelefono()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarContacto(int index){
		try {
			statement.execute("Delete from contactos where Contacto_ID="+index);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
