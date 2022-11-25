package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuario {



	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNac;
	private String passward;
	private String Url;
	
	private byte[] imagen;

	public DtUsuario() {
		super();
	}
	

	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fechaNac, byte[] imagen,String passward, String Url) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.imagen = imagen;
		this.passward = passward;
		this.Url = Url;
	}
	public String getNickname() {
		return nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public Date getFechaNac() {
		return fechaNac;
	}

	public String getUrl() {
		return Url;
	}

	public String getPassward() {
		return passward;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	@Override
	public String toString() {
		return "NickName = " + nickname + "\nNOMBRE = " + nombre + "\nApellido = " + apellido + "\nEmail = " + email +"\nfechaNac =" + fechaNac +"" ;
	}
}
