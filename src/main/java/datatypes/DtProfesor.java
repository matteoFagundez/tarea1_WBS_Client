package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Clase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtProfesor extends DtUsuario {
	



	private String descripcion;
	private String biografia;
	private String sitioWeb;
	
	private List<DtClase> clases = new ArrayList<>();

	public DtProfesor() {
		super();
	}
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac,byte[] imagen, String passward, String Url, String descripcion,
			String biografia, String sitioWeb, List<DtClase> clases) {
		super(nickname, nombre, apellido, email, fechaNac, imagen, passward, Url);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.clases = clases;
	}

	public String getDescripcion() {
		return descripcion;
	} 

	public String getBiografia() {
		return biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	} 	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public void setClases(List<DtClase> clases) {
		this.clases = clases;
	}

	@Override
	public String toString() {
		return super.toString() + "\nDescripcion = " + descripcion + "\nBiografia = " + biografia +"\nSitioWeb = " +  sitioWeb;
	}

	public List<DtClase> getClases() {
		return clases;
	}
}
