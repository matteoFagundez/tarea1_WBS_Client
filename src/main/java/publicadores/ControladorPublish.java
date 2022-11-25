package publicadores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import javax.xml.ws.Endpoint;
import configuraciones.WebServiceConfiguracion;
import datatypes.DtActDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionD;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.ActividadRepetidaExcepcion;
import excepciones.ClaseRepetidaExcepcion;
import excepciones.ExisteRegistroAClase;
import excepciones.InstitucionRepetidaExcepcion;
import excepciones.NoExisteClase;
import excepciones.NoExisteProfesor;
import excepciones.NoExisteUsuario;
import excepciones.NoesxisteSocio;
import excepciones.NoexsiteIntDep;
import excepciones.SinActDep;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublish {
	private Fabrica fabrica;
	private IControlador icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControlador();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:8082/Controlador", this);
		//endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador", this);
		//System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controlador");
		System.out.println("publicado");
		System.out.println("http://127.0.0.1:8082/Controlador");
	
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	//LOS MÉTODOS QUE VAMOS A PUBLICAR
		@WebMethod
		public DtUsuario login(String nombre,String passward){
			return icon.login( nombre, passward);
		}
		
		@WebMethod
		public DtUsuario[] ListarDtUsuario (){
			List<DtUsuario> lst = icon.ListarDtUsuario();
			DtUsuario[] arr = new DtUsuario[lst.size()];
			arr = lst.toArray(arr);
			return arr;
		}
		@WebMethod
		public void altaClase(DtClase clase, String nombreIns, String nomAct, String nombreP) {
			try {
				icon.altaClase(clase, nombreIns, nomAct, nombreP);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@WebMethod
		public Boolean existeRegistro(String nombre, String clase) {
			return icon.existeRegistro(nombre, clase);			
		}
	
		@WebMethod
		public void registroDictadoClases(String nombreClase, String nombreAct, String nombreInstitucion, String socio) throws ExisteRegistroAClase {
			try {
				icon.registroDictadoClases(nombreClase, nombreAct, nombreInstitucion, socio);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@WebMethod
		public void modificarUsuario(String nick, String nombre, String apellido, Date fechaN, String passward, String Url) {
			icon.modificarUsuario(nick, nombre, apellido, fechaN, passward, Url);
		}
		
		@WebMethod
		public DtActDeportiva elegirActividad(String nombreAct, String nombreInstitucion) {
			return icon.elegirActividad(nombreAct, nombreInstitucion);
		}
	
		@WebMethod
		public DtActDeportiva[] obtenerActividadesDdeUnaInt(String nombreI){
			List<DtActDeportiva> dtAct = null;
			try {
				dtAct = icon.obtenerActividadesDdeUnaInt(nombreI);
			} catch (NoexsiteIntDep e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			DtActDeportiva[] ret = new DtActDeportiva[dtAct.size()];
	        for(DtActDeportiva d : dtAct) {
	            ret[i]=d;
	            i++;
	        }
	        return ret;
		}
		
		@WebMethod
		public DtUsuario obtenerUsuario(String nombreU) {
			return icon.obtenerUsuario(nombreU);
		}
	
		@WebMethod
		public DtClase[] listarDatoClasedeS(DtSocio socio){
			List<DtClase> dt = null;
			try {
				dt = icon.listarDatoClasedeS(socio);
			} catch (NoExisteClase e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			DtClase[] ret = new DtClase[dt.size()];
	        for(DtClase c : dt) {
	            ret[i]=c;
	            i++;
	        }
	        return ret;
		} 
	
		@WebMethod
		public DtClase[] listarDatoClasedeP(DtProfesor profe){
	
			List<DtClase> lst = null;
			try {
				lst = icon.listarDatoClasedeP(profe);
			} catch (NoExisteClase e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DtClase[] arr = new DtClase[lst.size()];
			arr = lst.toArray(arr);
			return arr;
		}
	
		@WebMethod
		public DtClase elegirClase(String nombreClase, String nombreAct, String nombreInstitucion){
			return icon.elegirClase(nombreClase, nombreAct, nombreInstitucion);
		}

		@WebMethod
		public DtClase[] listarDatoClase(String nombreAct, String nombreInstitucion){
			List<DtClase> lst = icon.listarDatoClase(nombreAct, nombreInstitucion);
			DtClase[] arr = new DtClase[lst.size()];
			arr = lst.toArray(arr);
			return arr;
		}
		
		@WebMethod
		public DtActDeportiva[] listarDatoActdepP(DtProfesor profe) {
			List<DtActDeportiva> lst = null;
			try {
				lst = icon.listarDatoActdepP(profe);
			} catch (SinActDep e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DtActDeportiva[] arr = new DtActDeportiva[lst.size()];
			arr = lst.toArray(arr);
			return arr;
		}
		
		@WebMethod
		public DtActDeportiva[] rankingDeActividadesD(){
			List<DtActDeportiva> dt = icon.rankingDeActividadesD();
			DtActDeportiva[] arr = new DtActDeportiva[dt.size()];
			arr = dt.toArray(arr);
			return arr;
		}
		
		@WebMethod
		public DtClase[] rankingDeClases(){
			List<DtClase> dt = icon.rankingDeClases();
			DtClase[] arr = new DtClase[dt.size()];
			arr = dt.toArray(arr);
			return arr;
		}
		
		@WebMethod
		public DtInstitucionD[] listadoDtIntiDtInstitucion(){
			List<DtInstitucionD> dt = null;
			try {
				dt = icon.listadoDtIntiDtInstitucion();
			} catch (NoexsiteIntDep e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DtInstitucionD[] arr = new DtInstitucionD[dt.size()];
			arr = dt.toArray(arr);
			return arr;
		}
		
		@WebMethod
		public DtClase buscarclase(String nombre) {
			return icon.buscarclase(nombre);
		}
		
		@WebMethod
		public DtActDeportiva buscaractividad(String nombre) {
			return icon.buscaractividad(nombre);
		}
		
		@WebMethod
		public String[] listarInstituciones(){
			String[] lst = null;
			try {
				lst = icon.listarInstituciones();
			} catch (NoexsiteIntDep e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] data = new String[lst.length];
	        int position = 0;
	        
	        for (String e: lst ) {
	        	data[position] = e;
	        	position++;
	        }
	        return data;
		}
		
		@WebMethod
		public String[] listarActividades(String institucion) {
			String[] lst = null;
			try {
				lst = icon.listarActividades(institucion);
			} catch (SinActDep e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] data = new String[lst.length];
	        int position = 0;
	        
	        for (String e: lst ) {
	        	data[position] = e;
	        	position++;
	        }
	        return data;
		}
		
		@WebMethod
		public String[] listarProfesoresInt(String institucion) {
			String[] lst = null;
			try {
				lst = icon.listarProfesoresInt(institucion);
			} catch (NoExisteProfesor e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] data = new String[lst.length];
	        int position = 0;
	        
	        for (String e: lst ) {
	        	data[position] = e;
	        	position++;
	        }
	        return data;
		}
		
		@WebMethod
		public String[] listarClase(String institucion, String actividadDep) {
			String[] lst = null;
			try {
				lst = icon.listarClase(institucion, actividadDep);
			} catch (NoExisteClase e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] data = new String[lst.length];
	        int position = 0;
	        
	        for (String e: lst ) {
	        	data[position] = e;
	        	position++;
	        }
	        return data;
		}
		
		@WebMethod
		public String[] listarSocios() {
			String[] lst = null;
			try {
				lst = icon.listarSocios();
			} catch (NoesxisteSocio e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] data = new String[lst.length];
	        int position = 0;
	        
	        for (String e: lst ) {
	        	data[position] = e;
	        	position++;
	        }
	        return data;	
		}
		
		@WebMethod
		public String[] ListarUsuario(){
			String[] lst = null;
			try {
				lst = icon.ListarUsuario();
			} catch (NoExisteUsuario e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String[] data = new String[lst.length];
	        int position = 0;
	        
	        for (String e: lst ) {
	        	data[position] = e;
	        	position++;
	        }
	        return data;		
		}
		
		@WebMethod
		public String[] listarInstitucionesM(){
	    	String[] instituciones = null;
			try {
				instituciones = icon.listarInstitucionesM();
			} catch (NoexsiteIntDep e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        String[] ins = new String[instituciones.length];
	        int position = 0;
	        
	        for (String e: instituciones ) {
	        	ins[position] = e;
	        	position++;
	        }
	        return ins;		
		}
	
}
