package es.jepm.gestionAlquieleres.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.jepm.gestionAlquieleres.controller.InquilinoController;
import es.jepm.gestionAlquieleres.controller.LocalidadController;
import es.jepm.gestionAlquieleres.controller.ViviendaController;
import es.jepm.gestionAlquieleres.model.Inquilino;
import es.jepm.gestionAlquieleres.model.Localidad;
import es.jepm.gestionAlquieleres.model.Vivienda;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Label;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDNI;
	private JTextField jtfFullName;
	private JTextField jtfFirstDate;
	private JTextField jtfEndDate;
	private JTextField jtfCuota;
	private JComboBox jcLocalidad; 
	private JComboBox jcVivienda;
	private JCheckBox cbActiveAlquiler; 
	JLabel lbTotal; 
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainWindow() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{86, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Modificacion de alquileres");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcLocalidad = new JComboBox();
		jcLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addValueToVivienda(jcVivienda);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_jcLocalidad = new GridBagConstraints();
		gbc_jcLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcLocalidad.gridx = 1;
		gbc_jcLocalidad.gridy = 1;
		contentPane.add(jcLocalidad, gbc_jcLocalidad);
		
		addValueToLocalidad(jcLocalidad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vivienda:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcVivienda = new JComboBox();
		jcVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setValuesToInquilino();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_jcVivienda = new GridBagConstraints();
		gbc_jcVivienda.insets = new Insets(0, 0, 5, 0);
		gbc_jcVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcVivienda.gridx = 1;
		gbc_jcVivienda.gridy = 2;
		contentPane.add(jcVivienda, gbc_jcVivienda);
		
		addValueToVivienda(jcVivienda);
		
		JLabel lblDatosDelInquilino = new JLabel("Datos del inquilino");
		lblDatosDelInquilino.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblDatosDelInquilino = new GridBagConstraints();
		gbc_lblDatosDelInquilino.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatosDelInquilino.gridwidth = 2;
		gbc_lblDatosDelInquilino.gridx = 0;
		gbc_lblDatosDelInquilino.gridy = 3;
		contentPane.add(lblDatosDelInquilino, gbc_lblDatosDelInquilino);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Id:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 4;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		jtfId = new JTextField();
		jtfId.setColumns(10);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 4;
		contentPane.add(jtfId, gbc_jtfId);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("DNI:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 0;
		gbc_lblNewLabel_1_1_2.gridy = 5;
		contentPane.add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);
		
		jtfDNI = new JTextField();
		jtfDNI.setColumns(10);
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 5;
		contentPane.add(jtfDNI, gbc_jtfDNI);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Nombre completo:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3.gridx = 0;
		gbc_lblNewLabel_1_1_3.gridy = 6;
		contentPane.add(lblNewLabel_1_1_3, gbc_lblNewLabel_1_1_3);
		
		jtfFullName = new JTextField();
		jtfFullName.setColumns(10);
		GridBagConstraints gbc_jtfFullName = new GridBagConstraints();
		gbc_jtfFullName.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFullName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFullName.gridx = 1;
		gbc_jtfFullName.gridy = 6;
		contentPane.add(jtfFullName, gbc_jtfFullName);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Fecha inicio:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_4.gridx = 0;
		gbc_lblNewLabel_1_1_4.gridy = 7;
		contentPane.add(lblNewLabel_1_1_4, gbc_lblNewLabel_1_1_4);
		
		jtfFirstDate = new JTextField();
		jtfFirstDate.setColumns(10);
		GridBagConstraints gbc_jtfFirstDate = new GridBagConstraints();
		gbc_jtfFirstDate.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFirstDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFirstDate.gridx = 1;
		gbc_jtfFirstDate.gridy = 7;
		contentPane.add(jtfFirstDate, gbc_jtfFirstDate);
		
		cbActiveAlquiler = new JCheckBox("Alquiler en activo");
		cbActiveAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbActiveAlquiler.isSelected()) {
					jtfEndDate.setEditable(false);
					jtfEndDate.setText(null);
					
				}
				else {
					jtfEndDate.setEditable(true);
				}
			}
		});
		cbActiveAlquiler.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_cbActiveAlquiler = new GridBagConstraints();
		gbc_cbActiveAlquiler.insets = new Insets(0, 0, 5, 0);
		gbc_cbActiveAlquiler.gridwidth = 2;
		gbc_cbActiveAlquiler.gridx = 0;
		gbc_cbActiveAlquiler.gridy = 8;
		contentPane.add(cbActiveAlquiler, gbc_cbActiveAlquiler);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Fecha fin:");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3_1.gridx = 0;
		gbc_lblNewLabel_1_1_3_1.gridy = 9;
		contentPane.add(lblNewLabel_1_1_3_1, gbc_lblNewLabel_1_1_3_1);
		
		jtfEndDate = new JTextField();
		jtfEndDate.setColumns(10);
		GridBagConstraints gbc_jtfEndDate = new GridBagConstraints();
		gbc_jtfEndDate.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEndDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEndDate.gridx = 1;
		gbc_jtfEndDate.gridy = 9;
		contentPane.add(jtfEndDate, gbc_jtfEndDate);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Cuota mensual(€):");
		lblNewLabel_1_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3_2.gridx = 0;
		gbc_lblNewLabel_1_1_3_2.gridy = 10;
		contentPane.add(lblNewLabel_1_1_3_2, gbc_lblNewLabel_1_1_3_2);
		
		jtfCuota = new JTextField();
		jtfCuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbTotal.setText((Integer.parseInt(jtfCuota.getText()) * 1.21) + "");
			}
		});
		jtfCuota.setColumns(10);
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 1;
		gbc_jtfCuota.gridy = 10;
		contentPane.add(jtfCuota, gbc_jtfCuota);
		
		JLabel lblNewLabel_1_1_3_2_1 = new JLabel("Total mensual(IVA incluido)(€):");
		lblNewLabel_1_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1_3_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3_2_1.gridx = 0;
		gbc_lblNewLabel_1_1_3_2_1.gridy = 11;
		contentPane.add(lblNewLabel_1_1_3_2_1, gbc_lblNewLabel_1_1_3_2_1);
		
		lbTotal = new JLabel("Vivienda:");
		lbTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lbTotal = new GridBagConstraints();
		gbc_lbTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lbTotal.gridx = 1;
		gbc_lbTotal.gridy = 11;
		contentPane.add(lbTotal, gbc_lbTotal);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkDNI();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "La fecha no está en el formato correcto: yyyy-MM-dd");
				}
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.gridwidth = 2;
		gbc_btnModificar.gridx = 0;
		gbc_btnModificar.gridy = 12;
		contentPane.add(btnModificar, gbc_btnModificar);
		
		setValuesToInquilino();
	}
	
	/**
	 * 
	 * @param combo
	 */
	private void addValueToLocalidad(JComboBox combo) {
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		List<Localidad> values = LocalidadController.findAll();
		
		for(Localidad value : values) {
			model.addElement(value.toString());
		}
		
		combo.setModel(model);
		
	}
	
	/**
	 * 
	 * @param combo
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void addValueToVivienda(JComboBox combo) throws ClassNotFoundException, SQLException {
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		List<Vivienda> values = ViviendaController.findAll(LocalidadController.getLocalidadId((String) jcLocalidad.getSelectedItem()));
		
		for(Vivienda value : values) {
			model.addElement(value.toString());
		}
		
		combo.setModel(model);
		
	}
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void setValuesToInquilino() throws ClassNotFoundException, SQLException {
		Inquilino inquilino = InquilinoController.findAll(ViviendaController.getViviendaId((String) jcVivienda.getSelectedItem()));
		String fechaFin;
		
		if (inquilino.getFechaFinAlquiler() != null) {
			fechaFin = sdf.format(inquilino.getFechaFinAlquiler()) + "";
		}
		else {
			fechaFin = "";
		}
		
		
		jtfId.setText("" + inquilino.getId());
		jtfDNI.setText(inquilino.getDNI());
		jtfFullName.setText(inquilino.getNombreCompleto());
		jtfFirstDate.setText("" + sdf.format(inquilino.getFechaInicioAlquiler()));
		jtfEndDate.setText(fechaFin);
		jtfCuota.setText(inquilino.getCuotaAlquiler() + "");
		
		try {
			lbTotal.setText((inquilino.getCuotaAlquiler() * 1.21) + "");
		} catch (NumberFormatException e) {
			lbTotal.setText("Valor no válido");
		}
	}
	
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 * 
	 */
	private void realizeUpdate() throws ClassNotFoundException, SQLException, ParseException {
		Inquilino inquilino = new Inquilino();
		
		inquilino.setId(Integer.parseInt(jtfId.getText()));
		inquilino.setDNI(jtfDNI.getText());
		inquilino.setNombreCompleto(jtfFullName.getText());
		try {
			inquilino.setFechaInicioAlquiler(sdf.parse(this.jtfFirstDate.getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Esta fecha de inicio no puede estar vacía");
		}
		try {
			inquilino.setFechaFinAlquiler(sdf.parse(this.jtfEndDate.getText()));
		} catch (ParseException e) {
			inquilino.setFechaFinAlquiler(null);
		}
		inquilino.setCuotaAlquiler(Integer.parseInt(jtfCuota.getText()));
		inquilino.setIdVivienda(ViviendaController.getViviendaId((String) jcVivienda.getSelectedItem()));
		
		InquilinoController.updateInquilino(inquilino);
	}
	
	/**
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	private void checkDNI() throws ClassNotFoundException, SQLException, ParseException {
		int numLetras = 0, numNumeros = 0;
		
		for (int i = 0; i < jtfDNI.getText().length(); i++) {
			if (Character.isLetter(jtfDNI.getText().charAt(i))) {
				numLetras++;
			}
			else {
				if(Character.isDigit(jtfDNI.getText().charAt(i))) {
					numNumeros++;
				}
			}
		}
		
		if (numLetras == 1 && numNumeros == 8) {
			checkName();
		}
		else {
			JOptionPane.showMessageDialog(null, "El DNI no es correcto");
		}
		
	}
	
	private void checkName() throws ClassNotFoundException, SQLException, ParseException {
		if(jtfFullName.getText().length() > 0) {
			realizeUpdate();
		}
		else {
			JOptionPane.showMessageDialog(null, "El nombre no debe estar vacio");
		}
	}
	

}
