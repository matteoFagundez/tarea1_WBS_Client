package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtActDeportiva {
	


	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private Date fecha;
	private String UrlI;
	
	@Lob
	private byte[] imagen;
	
	//private List<String> clases=new ArrayList<>();
	public DtActDeportiva() {
		super();
	}
	
	public DtActDeportiva(String nombre, String descripcion, int duracion, float costo, Date fecha,String UrlI,byte[] imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
		this.imagen = imagen;
		this.UrlI = UrlI;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	public String getUrlI() {
		return UrlI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setUrlI(String urlI) {
		UrlI = urlI;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "Nombre = " + nombre + "\nDescripcion = " + descripcion + "\nDuracion = " + duracion +"\nCosto =" + costo + "\nFecha = " + fecha;
	}	

}
