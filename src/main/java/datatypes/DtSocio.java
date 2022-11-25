package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Registro;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtSocio extends DtUsuario {
	
	private List<DtRegistro> registros = new ArrayList<>();
	
	
	

	public DtSocio() {
		super();
	}
	
	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac,byte[] imagen,String passward, String Url,
			List<DtRegistro> registros) {
		super(nickname, nombre, apellido, email, fechaNac, imagen, passward, Url);

		this.registros = registros;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public List<DtRegistro> getRegistros() {
		return registros;
	}
	
	public void setRegistros(List<DtRegistro> registros) {
		this.registros = registros;
	}
	
	
	

}
