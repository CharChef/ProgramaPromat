package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import Atxy2k.CustomTextField.RestrictedTextField;


public class Frame_Pedidos extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField tf_dia;
	private JTextField tf_mes;
	private JTextField tf_anio;
	private JTextField tf_hora;
	private JTextField tf_minutos;
	private JTextField tf_cuil;
	private JTextField tf_remito;
	private JTextField tf_iva;
	private JTextField tf_responsable;
	private JTextField tf_cliente;
	private JTextField tf_direccion;
	private JTextField tf_telefono;
	private Conexion con;
	private DefaultTableModel dfm;

	public Frame_Pedidos(String _arg, Conexion _con)
	{
		super(_arg);
		con = _con;
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelArriba = new JPanel();
		getContentPane().add(panelArriba, BorderLayout.NORTH);
		panelArriba.setLayout(new BorderLayout(5, 5));
		
		JPanel panelLogo = new JPanel();
		FlowLayout fl_panelLogo = (FlowLayout) panelLogo.getLayout();
		fl_panelLogo.setVgap(50);
		fl_panelLogo.setHgap(175);
		panelArriba.add(panelLogo, BorderLayout.WEST);
				
		JPanel panelTipo = new JPanel();
		panelArriba.add(panelTipo, BorderLayout.CENTER);
		panelTipo.setLayout(null);
		
		JComboBox cb_factura = new JComboBox();
		cb_factura.setBounds(3, 23, 68, 54);
		cb_factura.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "E", "X", "R"}));
		cb_factura.setFont(new Font("Tahoma", Font.BOLD, 50));
		panelTipo.add(cb_factura);
		
		tf_dia = new JTextField();
		tf_dia.setBounds(250, 23, 26, 30);
		panelTipo.add(tf_dia);
		RestrictedTextField rtf_dia = new RestrictedTextField(tf_dia);
		rtf_dia.setOnlyNums(true);
		rtf_dia.setLimit(2);
		tf_dia.setHorizontalAlignment(SwingConstants.CENTER);
		tf_dia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lb_separador2 = new JLabel("/");
		lb_separador2.setBounds(315, 29, 6, 19);
		panelTipo.add(lb_separador2);
		lb_separador2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tf_mes = new JTextField();
		tf_mes.setBounds(286, 23, 26, 30);
		panelTipo.add(tf_mes);
		RestrictedTextField rtf_mes = new RestrictedTextField(tf_mes);
		rtf_mes.setOnlyNums(true);
		rtf_mes.setLimit(2);
		tf_mes.setHorizontalAlignment(SwingConstants.CENTER);
		tf_mes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lb_separador1 = new JLabel("/");
		lb_separador1.setBounds(278, 29, 6, 19);
		panelTipo.add(lb_separador1);
		lb_separador1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tf_anio = new JTextField();
		tf_anio.setBounds(323, 23, 69, 30);
		panelTipo.add(tf_anio);
		RestrictedTextField rtf_anio = new RestrictedTextField(tf_anio);
		rtf_anio.setOnlyNums(true);
		rtf_anio.setLimit(4);
		tf_anio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_anio.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(160, 28, 86, 21);
		panelTipo.add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_hora = new JTextField();
		tf_hora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RestrictedTextField rtf_hora = new RestrictedTextField(tf_hora);
		rtf_hora.setOnlyNums(true);
		rtf_hora.setLimit(2);
		tf_hora.setHorizontalAlignment(SwingConstants.CENTER);
		tf_hora.setBounds(330, 59, 26, 30);
		panelTipo.add(tf_hora);
		tf_hora.setColumns(10);
		
		tf_minutos = new JTextField();
		tf_minutos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RestrictedTextField rtf_minutos = new RestrictedTextField(tf_minutos);
		rtf_minutos.setOnlyNums(true);
		rtf_minutos.setLimit(2);
		tf_minutos.setHorizontalAlignment(SwingConstants.CENTER);
		tf_minutos.setColumns(10);
		tf_minutos.setBounds(366, 59, 26, 30);
		panelTipo.add(tf_minutos);
		
		JLabel lb_hora = new JLabel(":");
		lb_hora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_hora.setBounds(358, 62, 6, 19);
		panelTipo.add(lb_hora);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHora.setBounds(238, 64, 86, 21);
		panelTipo.add(lblHora);
		
		JPanel panel = new JPanel();
		panelArriba.add(panel, BorderLayout.SOUTH);
		
		JRadioButton rb_contado = new JRadioButton("Contado");
		
		JRadioButton rdbtnCtaCte = new JRadioButton("Cta. Cte.");
		
		JLabel lb_Venta = new JLabel("Condiciones de Venta:");
		lb_Venta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_Venta.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JSeparator separador1 = new JSeparator();
		
		tf_cuil = new JTextField();
		tf_cuil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RestrictedTextField rtf_cuil = new RestrictedTextField(tf_cuil);
		rtf_cuil.setOnlyCustomCharacters(true);
		rtf_cuil.setAcceptCharacters("1234567890-");
		tf_cuil.setHorizontalAlignment(SwingConstants.CENTER);
		tf_cuil.setColumns(10);
		
		JLabel lbl_cuil = new JLabel("C.U.I.T.:");
		lbl_cuil.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_cuil.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_remito = new JTextField();
		tf_remito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RestrictedTextField rtf_remito = new RestrictedTextField(tf_remito);
		rtf_remito.setOnlyNums(true);
		tf_remito.setHorizontalAlignment(SwingConstants.CENTER);
		tf_remito.setColumns(10);
		
		JLabel lblRemitoN = new JLabel("Remito N\u00B0:");
		lblRemitoN.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemitoN.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIva = new JLabel("I.V.A.:");
		lblIva.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_iva = new JTextField();
		tf_iva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RestrictedTextField rtf_iva = new RestrictedTextField(tf_iva);
		rtf_iva.setOnlyNums(true);
		tf_iva.setHorizontalAlignment(SwingConstants.CENTER);
		tf_iva.setColumns(10);
		
		JLabel lblRespondableIncr = new JLabel("Respondable incr.:");
		lblRespondableIncr.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_responsable = new JTextField();
		tf_responsable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_responsable.setHorizontalAlignment(SwingConstants.CENTER);
		tf_responsable.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblSeniores = new JLabel("Se\u00F1or(es):");
		lblSeniores.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_cliente = new JTextField();
		tf_cliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_cliente.setHorizontalAlignment(SwingConstants.CENTER);
		tf_cliente.setColumns(10);
		
		JSeparator separator2 = new JSeparator();
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_direccion = new JTextField();
		tf_direccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tf_direccion.setHorizontalAlignment(SwingConstants.CENTER);
		tf_direccion.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel.:");
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		tf_telefono = new JTextField();
		tf_telefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RestrictedTextField rtf_telefono = new RestrictedTextField(tf_telefono);
		rtf_telefono.setOnlyNums(true);
		tf_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		tf_telefono.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 769, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(21, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lb_Venta)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rb_contado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnCtaCte)
							.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
							.addComponent(lbl_cuil)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tf_cuil, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addGap(21))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(lblDireccion)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tf_direccion, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tf_telefono, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSeniores)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tf_cliente, 695, 695, 695)))
							.addGap(20))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(separador1, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(21, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblIva)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tf_iva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRespondableIncr)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tf_responsable, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRemitoN, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tf_remito, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(separator2, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeniores)
						.addComponent(tf_cliente, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(tf_direccion, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion)
								.addComponent(lblTel)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tf_telefono, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_Venta)
						.addComponent(rb_contado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnCtaCte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lbl_cuil)
						.addComponent(tf_cuil, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separador1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIva)
						.addComponent(tf_iva, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRemitoN)
						.addComponent(lblRespondableIncr)
						.addComponent(tf_responsable, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_remito, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelAbajo = new JPanel();
		getContentPane().add(panelAbajo, BorderLayout.SOUTH);
		panelAbajo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(50);
		panelAbajo.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAadirProducto = new JButton("A\u00F1adir Producto");
		btnAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto p = new Producto(0, null, 0, null, null, 0, null);
				MostrarProductos mp = new MostrarProductos("A�adir",p,con);
				while(mp.isVisible())
				{
					
				};
//				String row [] = {"0", p.getDescripcion(),Float.toString(p.getPrecio()),"0",null};
//				dfm.addRow(row);
			}
		});
		panel_1.add(btnAadirProducto);
		
		JButton btnEliminarproducto = new JButton("Eliminar Producto");
		btnEliminarproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnEliminarproducto);
		
		JPanel panelDerecho = new JPanel();
		FlowLayout fl_panelDerecho = (FlowLayout) panelDerecho.getLayout();
		fl_panelDerecho.setHgap(20);
		getContentPane().add(panelDerecho, BorderLayout.EAST);
		
		JPanel panelIzquierdo = new JPanel();
		FlowLayout fl_panelIzquierdo = (FlowLayout) panelIzquierdo.getLayout();
		fl_panelIzquierdo.setHgap(20);
		getContentPane().add(panelIzquierdo, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dfm = new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Cantidad", "Descripci\u00F3n", "Precio Unitario ($)", "Importe", "Tipo"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, JTextField.class, Float.class, Float.class, JTextField.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		table.setModel(dfm);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(3).setPreferredWidth(68);
		
		//JComboBox Descripcion
//		String prod[] = {"llave 1mm","llave 2mm","llave 6mm","llave 3mm","llave 4mm","llave 5mm","palangana naranja", "McArena","Maiaameee"};
//		JComboBox<String> cb_productos = new JComboBox<String>(prod);
//		cb_productos.setEditable(true);
//		TableCellEditor tce = new DefaultCellEditor(cb_productos);
//		TableColumn tc = table.getColumnModel().getColumn(1);
////		tc.setCellEditor(tce);
//		
		//JComboBox tipo
		String[] tipos = {"Tipo 1","Tipo 2"};
		JComboBox<String> cb_tipo = new JComboBox<String>(tipos);
		cb_tipo.setEditable(false);
		TableCellEditor tce2 = new DefaultCellEditor(cb_tipo);
		TableColumn tc = table.getColumnModel().getColumn(4);
		tc.setCellEditor(tce2);
		
		table.setRowHeight(20);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		for(int j=0;j<table.getColumnCount();j++)
		{
			table.getColumnModel().getColumn(j).setCellRenderer(tcr);
		}
		table.addKeyListener(new OyenteFilaSeleccionada());
		scrollPane.setViewportView(table);
		initGUI();
	}
	
	private class OyenteFilaSeleccionada implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) {
			
//			try
//			{
//				ResultSet resultado;
//				
//				int fila = table.getSelectedRow();
//				if(table.getValueAt(fila, 1)!=null)
//				{
//					Statement estado;
//					estado = (Statement) con.getConnection().createStatement();
//					resultado = estado.executeQuery("select nombre_producto from productos;");
//					while(resultado.next()&&(resultado.getRow()>0))
//					{
//						if(resultado.getString("nombre_producto").indexOf((table.getValueAt(fila, 1)).toString())!=-1)
//						{
//							System.out.print(resultado.getString("nombre_producto")+" - ");
////							lista_detalles.add(resultado.getString("detalle"));
////							tb_productosModel.addRow(aux);
////							break;
//						}
//					}
//					
//					System.out.println();
//					
//				}
//			}
//			catch (SQLException e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(805, 669);
				this.setVisible(true);
				this.setResizable(false);
//				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
