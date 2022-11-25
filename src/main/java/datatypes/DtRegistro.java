package datatypes;

import java.util.Date;

import logica.Clase;
import logica.Socio;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtRegistro {



	private Date fecha;
	
	private DtSocio socio;
	
	private DtClase clase;
	
	public DtRegistro() {
		super();
	}
	
	public DtRegistro(Date fecha) {
		super();
		this.fecha = fecha;
	}


	public Date getFecha() {
		return fecha;
	}


	public DtSocio getSocio() {
		return socio;
	}


	public DtClase getClase() {
		return clase;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setSocio(DtSocio socio) {
		this.socio = socio;
	}

	public void setClase(DtClase clase) {
		this.clase = clase;
	}
	
}
