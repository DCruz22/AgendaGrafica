package cruz.dariel.AgendaGraficaBD.Entidades;

public class Contacto {
	private String nombre;
	private String telefono;
	private String apellido;

	public Contacto(String _nombre,String _apellido, String _telefono){
		nombre = _nombre;
		apellido = _apellido;
		telefono = _telefono;
	}
	
	public String getNombre(){
		return nombre;
		}

	public void setNombre(String _nombre){
		nombre= _nombre;
		}

	public String getTelefono(){
		return telefono;
		}

	public void setTelefono(String _telefono){
		telefono = _telefono;
		}
	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
