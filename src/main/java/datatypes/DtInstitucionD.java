package datatypes;

import java.util.ArrayList;
import java.util.List;

import logica.ActividadDeportiva;
import logica.Profesor;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtInstitucionD {



	private String nombre;
	private String descripcion;
	private String url;
	private List<DtActDeportiva> actividadesD = new ArrayList<>();
	private List<DtProfesor> profesores = new ArrayList<>();

	
	public DtInstitucionD() {
		super();
	}
	
	public DtInstitucionD(String nombre, String descripcion, String url, List<DtActDeportiva> actividadesD,List<DtProfesor>profesores) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.url=url;
		this.actividadesD=actividadesD;
		this.profesores=profesores;
	}
	
	private List<DtActDeportiva> getActividadesD() {
		return actividadesD;
	}


	private List<DtProfesor> getProfesores() {
		return profesores;
	}

	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getUrl() {	
		return url;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setActividadesD(List<DtActDeportiva> actividadesD) {
		this.actividadesD = actividadesD;
	}

	public void setProfesores(List<DtProfesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "DtInstitucion [nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + ",profesores=" + "]";
	}

}

