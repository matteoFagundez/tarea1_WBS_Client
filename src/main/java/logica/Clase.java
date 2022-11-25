package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtActDeportiva;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import persistencia.Conexion;
@Entity
public class Clase {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nombre;
	private Date fecha;
	private Date horaInicio;
	private String url;
	private Date fechaRegistro;
	private String urlI;
	
	@Lob
	private byte[] imagen;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Registro> registros = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Profesor profe;
	
	@ManyToOne
	@JoinColumn(name = "A_nombre")
	private ActividadDeportiva act;


	public Clase() {
		super();
	}
	
	public Clase(String nombre, Date fecha, Date horaInicio, String url, Date fechaRegistro,String urlI, byte[] imagen) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.url = url;
		this.fechaRegistro = fechaRegistro;
		this.imagen = imagen;
		this.urlI = urlI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Profesor getProfe() {
		return profe;
	}
	
	public ActividadDeportiva getAct() {
		return act;
	}

	public void setAct(ActividadDeportiva act) {
		this.act = act;
	}
	

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getUrlI() {
		return urlI;
	}

	public void setUrlI(String urlI) {
		this.urlI = urlI;
	}

	public void setProfe(String nprofes) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Profesor profe;
		if(mU.esunProfesor(nprofes)) {
			profe= (Profesor) mU.buscarUsuario(nprofes);
			this.profe=profe;		}

	}
	
	public List<DtRegistro> getDtregistros() {
		ArrayList<DtRegistro> reguis = new ArrayList<DtRegistro>();
		
		
		if(this.registros.isEmpty()) {
			reguis=null;
		}
		else {
			List<Registro> reg=registros;
		
			for (Registro R : reg) {
				reguis.add(R.getDtReguistro());
			}
		}
		return reguis;
	}
	
	public String getNicknameProfe() {
		Profesor p= this.getProfe();
		if(p==null) {
			return "";
		}else {
			return p.getNickname();
		}	
	}
	
	public DtActDeportiva getDtActdep() {
		ActividadDeportiva a= this.getAct();
		if(a==null) {
			return null;
		}else {
			return a.getDtActDeportiva();
		}	
	}
	
	public DtClase getDtClase() {
		return new DtClase(this.getNombre(), this.getFecha(), this.getHoraInicio(), this.getUrl(),this.getFechaRegistro(),this.getUrlI(), this.getImagen(), this.getDtregistros(),this.getNicknameProfe(),this.getDtActdep());
	}
	
	public List<Registro> listarRegistros() {
		return registros;
	}
	
	public void setRegistro(Date fecha, Socio socio) {
		Registro r = new Registro(fecha,socio, this);
		registros.add(r);
		socio.listarRegistros().add(r);
		
		
	}
	
}
