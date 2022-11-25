package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Lob;

import logica.ActividadDeportiva;
import logica.Profesor;
import logica.Registro;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtClase {

	private String nombre;
	private Date fecha;
	private Date horaInicio;
	private String url;
	private Date fechaReg;
	private String urlI;
	
	@Lob
	private byte[] imagen;
	
	private List<DtRegistro> registros = new ArrayList<>();
	
	private String profe;
	
	private DtActDeportiva act;
	
	
	public DtClase() {
		super();
	}

	public DtClase(String nombre, Date fecha, Date horaInicio, String url, Date fechaReg,String urlI, byte[] imagen, List<DtRegistro> registros,
			String profe, DtActDeportiva act) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaReg = fechaReg;
		this.registros = registros;
		this.profe = profe;
		this.act = act;
		this.urlI = urlI;
		this.imagen = imagen;
	}
	
	public byte[] getImagen() {
		return imagen;
	}


	public String getNombre() {
		return nombre;
	}
		
	public Date getFecha() {
		return fecha;
	}
	
	public Date getHoraInicio() {
		return horaInicio;		
	}
	
	public String getUrl() {
		return url;
	}
	
	public Date getFechaReg() {
		return fechaReg;	
	}

	public String getUrlI() {
		return urlI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public void setUrlI(String urlI) {
		this.urlI = urlI;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setRegistros(List<DtRegistro> registros) {
		this.registros = registros;
	}

	public void setProfe(String profe) {
		this.profe = profe;
	}

	public void setAct(DtActDeportiva act) {
		this.act = act;
	}


	@Override
	public String toString() {
		return "DtClase [nombre=" + nombre + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", url=" + url
				+ ", fechaReg=" + fechaReg + "]";
	}

	public List<DtRegistro> getRegistros() {
		return registros;
	}

	public DtActDeportiva getAct() {
		return act;
	}

	public String getProfe() {
		return profe;
	}
	
	
	
}
	
