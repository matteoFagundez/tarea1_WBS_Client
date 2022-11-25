package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import datatypes.DtActDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionD;
import excepciones.ClaseRepetidaExcepcion;
import excepciones.NoExisteProfesor;
import excepciones.NoexsiteIntDep;
import excepciones.SinActDep;
import interfaces.Fabrica;
import interfaces.IControlador;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SpinnerModel;

public class AltaClase extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;

	private JComboBox<String> cbxInstitucion;
	private JComboBox<String> cbxAd;
	private JComboBox<String> cbxProfesor;
	private JTextField txtNombre;
	private JTextField txtUrl;
	private JTable tActividades;
	

	private static DefaultTableModel tablaAD;
	private JSpinner spinFieldFecha;
	private JSpinner spinFieldHora;
	
	private IControlador iC;
	private JTextField txtUrlI;



	public AltaClase(IControlador iC) {
		this.iC=iC;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Clase");
        
    	setBounds(100, 100, 519, 411);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBounds(0, 0, 503, 381);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);		
		
		cbxInstitucion = new JComboBox();	
		cbxInstitucion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
	        		if(cbxInstitucion.getSelectedIndex()>0) {
	        			try {
	        				resetTable(tActividades, tablaAD);
	        				setComboBoxAd();
	        				listarAD();
	        				
						} catch (SinActDep e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	        			try {
							setComboBoxP();
						} catch (NoExisteProfesor e1) {
							// TODO Bloque catch generado automáticamente
							e1.printStackTrace();
						}
	        		}			
	        	
			}
		});
		cbxInstitucion.setBounds(91, 36, 100, 22);
		contentPane.add(cbxInstitucion);
		
		cbxAd = new JComboBox();	
		cbxAd.setBounds(337, 36, 105, 22);
		contentPane.add(cbxAd);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(91, 81, 100, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(91, 125, 100, 20);
		contentPane.add(txtUrl);
		txtUrl.setColumns(10);
		
		JLabel lblInstituciones = new JLabel("Institucion:");
		lblInstituciones.setBounds(27, 40, 80, 14);
		contentPane.add(lblInstituciones);
		
		JLabel lblActividades = new JLabel("Actividades:");
		lblActividades.setBounds(261, 40, 100, 14);
		contentPane.add(lblActividades);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(27, 84, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblUrl = new JLabel("Url");
		lblUrl.setBounds(27, 128, 36, 14);
		contentPane.add(lblUrl);
		
		JLabel lblProfosor = new JLabel("Profesor");
		lblProfosor.setBounds(27, 170, 80, 14);
		contentPane.add(lblProfosor);
		tablaAD = new DefaultTableModel();
		
		JLabel lblFecha = new JLabel("Fecha ");
		lblFecha.setBounds(27, 215, 54, 14);
		contentPane.add(lblFecha);
		
		JLabel lblNewLabel = new JLabel("Hora");
		lblNewLabel.setBounds(27, 259, 46, 14);
		contentPane.add(lblNewLabel);		

		spinFieldFecha = new JSpinner(new SpinnerDateModel(new Date(1641006000000L), null, null, Calendar.DAY_OF_YEAR));
		JSpinner.DateEditor jsfg = new JSpinner.DateEditor(spinFieldFecha, "dd-MM-yyyy");
		spinFieldFecha.setEditor(jsfg);
		spinFieldFecha.setBounds(86, 212, 105, 20);        
        contentPane.add(spinFieldFecha);
        
        spinFieldHora = new JSpinner(new SpinnerDateModel(new Date(10800000L), null, null, Calendar.HOUR));
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinFieldHora, "HH:mm");
		spinFieldHora.setEditor(de);
		spinFieldHora.setBounds(91, 256, 54, 20);
		contentPane.add(spinFieldHora);            

		JScrollPane spAct = new JScrollPane();
		spAct.setBounds(305, 96, 178, 226);
		contentPane.add(spAct);
		
		tActividades = new JTable();
		spAct.setViewportView(tActividades);
		tablaAD = new DefaultTableModel();	
		tActividades.setModel(tablaAD);
		
		tablaAD.addColumn("Nombre");		
		
		 JButton btnCancelar = new JButton("Cancelar");
		 btnCancelar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		setVisible(false);
		 		limpiarCampos();
		 	}
		 });
        btnCancelar.setBounds(91, 347, 89, 23);
        contentPane.add(btnCancelar);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {    
        		String nom = txtNombre.getText();
        		String url = txtUrl.getText();
        		String urlI= txtUrlI.getText();
        		        		        		
        		if(!nom.isEmpty() && !url.isEmpty() && cbxInstitucion.getSelectedIndex()>0 && cbxAd.getSelectedIndex()>0 && cbxProfesor.getSelectedIndex()>0) {
	        		try {
	        			Date fechaSis = new Date();	 
	            		Fabrica fab = Fabrica.getInstancia();
	            		IControlador icon = fab.getIControlador();        		
	            		
	            		Date fech =(Date) spinFieldFecha.getValue();   
	            		Date hor= (Date) spinFieldHora.getValue();
	            		
	            		DtClase dtClasi= new DtClase(txtNombre.getText(), fech, hor, txtUrl.getText(),fechaSis,urlI, null, null, null, null);
						icon.altaClase(dtClasi, cbxInstitucion.getSelectedItem().toString(), cbxAd.getSelectedItem().toString(),cbxProfesor.getSelectedItem().toString());
						JOptionPane.showMessageDialog(null, "Se agregó satisfactoriamente una Clase");
						limpiarCampos();
					} catch (ClaseRepetidaExcepcion e1) {
			 			JOptionPane.showMessageDialog(null, "No puede crear Clase. \n" + e1.getMessage()+ "", "Alta Clase", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}        
        		}else {        			
        			JOptionPane.showMessageDialog(null, "No a completado todos los campos");        			
        		}
        	}
        });             
        btnAceptar.setBounds(225, 347, 89, 23);
        contentPane.add(btnAceptar);
        
        cbxProfesor = new JComboBox();
        cbxProfesor.setBounds(91, 166, 100, 22);
        contentPane.add(cbxProfesor);
        
        JLabel lblUrlI = new JLabel("Imagen:");
        lblUrlI.setBounds(27, 305, 80, 14);
        contentPane.add(lblUrlI);
        
        txtUrlI = new JTextField();
        txtUrlI.setColumns(10);
        txtUrlI.setBounds(91, 302, 157, 20);
        contentPane.add(txtUrlI);

	}

	public void iniciarlizarComboBoxes() {;
		
		try {
			DefaultComboBoxModel<String> modelinstitucion = new DefaultComboBoxModel<String>(iC.listarInstituciones());
			cbxInstitucion.setModel(modelinstitucion);
		} catch (NoexsiteIntDep e) {
			// TODO Bloque catch generado automáticamente
			JOptionPane.showMessageDialog(null, "No puede crear Clase. \n" + e.getMessage()+ "", "Alta Clase", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}	
		
	}	
	
	public void setComboBoxAd() throws SinActDep {
		
		try {
			DefaultComboBoxModel<String>modelactividades = new DefaultComboBoxModel<String>(iC.listarActividades(cbxInstitucion.getSelectedItem().toString()));
			cbxAd.setModel(modelactividades);
		} catch (SinActDep e) {
			JOptionPane.showMessageDialog(null, "No puede crear Clase. \n" + e.getMessage()+ "", "Alta Clase", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	public void setComboBoxP() throws NoExisteProfesor{
		try {
			DefaultComboBoxModel<String> modelinstitucion1 = new DefaultComboBoxModel<String>(iC.listarProfesoresInt(cbxInstitucion.getSelectedItem().toString()));
			cbxProfesor.setModel(modelinstitucion1);
		} catch (NoExisteProfesor e) {
			JOptionPane.showMessageDialog(null, "No puede crear Clase. \n" + e.getMessage()+ "", "Alta Clase", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void listarAD() throws SinActDep {
		String[] imp;
		try {
			imp = iC.listarActividades(cbxInstitucion.getSelectedItem().toString());
			for (String a : imp) {
				Object[] columna = new Object[1];
				columna[0]= a;
				tablaAD.addRow(columna);
			}
			tablaAD.removeRow(0);
		} catch (SinActDep e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}  
		
		
	}
	
	public void limpiarCampos() {
		txtNombre.setText("");
		txtUrl.setText("");
		cbxInstitucion.setSelectedIndex(0);
		cbxProfesor.setSelectedIndex(0);
		cbxAd.setSelectedIndex(0);
		resetTable(tActividades, tablaAD);
				
	}
	
	private void resetTable(JTable tabla, DefaultTableModel modelo){
		for (int i = 0; i < tabla.getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
	}
}
