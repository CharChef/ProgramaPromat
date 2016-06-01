package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.mysql.jdbc.Statement;

import Atxy2k.CustomTextField.RestrictedTextField;


public class Frame_Consulta extends javax.swing.JFrame
{
	//Atributos
	private static final long serialVersionUID = 1L;
	private JTextArea ta_detalle;
	private JScrollPane jScrollPane2;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JTextField tf_id_producto;
	private JLabel lb_descripcion;
	private JLabel lb_id_producto;
	private JButton bt_buscar;
	private JTextField tf_descripcion;
	private ModeloTabla tb_productosModel;
	private Vector<String> lista_detalles;
	private Conexion con;
	private ButtonGroup buttonGroup1;
	private JRadioButton rb_nombre;
	private JRadioButton rb_id;

	/**
	 * Constructor de la clase
	 * 
	 * @param _arg titulo ventana
	 * @param _con Conexion
	 */
	public Frame_Consulta(String _arg,Conexion _con)
	{
		super(_arg);
		setResizable(false);
		con = _con;
		initGUI();
	}

	/**
	 * InitGUI()
	 * inicializa la ventana
	 */
	private void initGUI() {
		try 
		{
			OyenteKeyListener okn = new OyenteKeyListener();
			{
				tf_id_producto = new JTextField();
				tf_id_producto.addKeyListener(okn);
				getContentPane().add(tf_id_producto);
				RestrictedTextField rtf_id_producto = new RestrictedTextField(tf_id_producto);
				rtf_id_producto.setOnlyNums(true);
				tf_id_producto.setBounds(43, 26, 230, 23);
			}
			{
				tf_descripcion = new JTextField();
				tf_descripcion.addKeyListener(okn);
				getContentPane().add(tf_descripcion);
				tf_descripcion.setBounds(44, 70, 512, 23);
			}
			{
				bt_buscar = new JButton();
				getContentPane().add(bt_buscar);
				OyenteBotonBuscar obb = new OyenteBotonBuscar();
				bt_buscar.addActionListener(obb);
				bt_buscar.setText("Buscar");
				bt_buscar.setBounds(568, 25, 115, 69);
			}
			{
				lb_id_producto = new JLabel();
				getContentPane().add(lb_id_producto);
				lb_id_producto.setText("ID producto");
				lb_id_producto.setBounds(44, 9, 106, 16);
			}
			{
				lb_descripcion = new JLabel();
				getContentPane().add(lb_descripcion);
				lb_descripcion.setText("Descripci�n");
				lb_descripcion.setBounds(44, 51, 431, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 99, 671, 215);
				{
					tb_productosModel = 
						new ModeloTabla(
								new String[][] {},
								new String[] { "Id", "Descripci�n", "Precio ($)", "Marca", "Categoria", "Stock"});
					
					jTable1 = new JTable();
					jTable1.addMouseListener(new OyenteFilaSeleccionada());
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(tb_productosModel);
					
				}
			}
			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(12, 320, 671, 77);
				{
					ta_detalle = new JTextArea();
					jScrollPane2.setViewportView(ta_detalle);
					ta_detalle.setEditable(false);
					ta_detalle.setWrapStyleWord(true);
					ta_detalle.setLineWrap(true);
				}
			}
			{				
				rb_id = new JRadioButton();
				rb_id.setSelected(true);
				OyenteId oid = new OyenteId();
				rb_id.addActionListener(oid);
				getButtonGroup1().add(rb_id);
				getContentPane().add(rb_id);
				rb_id.setBounds(19, 28, 24, 17);
			}
			{
				rb_nombre = new JRadioButton();
				OyenteNombre onb = new OyenteNombre();
				rb_nombre.addActionListener(onb);
				tf_descripcion.setOpaque(true);
				tf_descripcion.setEditable(false);
				getButtonGroup1().add(rb_nombre);
				getContentPane().add(rb_nombre);
				rb_nombre.setBounds(20, 72, 24, 17);
			}

			this.setSize(703, 442);
			getContentPane().setLayout(null);
			this.setLocationRelativeTo(null);
			this.setVisible(true);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	protected ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private class OyenteKeyListener implements KeyListener
	{

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				accionBuscar();
            }
			else
			{
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	            {
					dispose();
	            }
			}
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class OyenteNombre implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			tf_descripcion.setOpaque(true);
			tf_descripcion.setEditable(true);
			tf_id_producto.setOpaque(true);
			tf_id_producto.setText("");
			tf_id_producto.setEditable(false);		
		}
		
	}
		
	private class OyenteId implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			tf_id_producto.setOpaque(true);
			tf_id_producto.setEditable(true);
			tf_descripcion.setOpaque(true);
			tf_descripcion.setText("");
			tf_descripcion.setEditable(false);
		}
	}
	
	/**
	 * OyenteBotonBuscar
	 */
	private class OyenteBotonBuscar implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
						
			accionBuscar();
		}
		
	}
	
	private void accionBuscar()
	{
		ResultSet resultado;
		int cant_filas = tb_productosModel.getRowCount();
		for(int i=0;i<cant_filas;i++)
		{
			tb_productosModel.removeRow(0);
		}
		ta_detalle.setText("");
		
		try 
		{
			Statement estado = (Statement) con.getConnection().createStatement();
			resultado = estado.executeQuery("select * from productos;");
			lista_detalles = new Vector<String>();
			
			if(!tf_id_producto.getText().equals(""))
			{
				while(resultado.next()&&(resultado.getRow()>0))
				{
					if(resultado.getInt("id_producto")==Integer.parseInt(tf_id_producto.getText()))
					{
						String aux[] = {Integer.toString(resultado.getInt("id_producto")), resultado.getString("nombre_producto"),Integer.toString(resultado.getInt("precio")),
								resultado.getString("marca"),resultado.getString("categoria"),Integer.toString(resultado.getInt("stock"))};
						lista_detalles.add(resultado.getString("detalle"));
						tb_productosModel.addRow(aux);
						break;
					}
				}

			}
			else
			{
				if(!tf_descripcion.getText().equals(""))
				{
					while(resultado.next()&&(resultado.getRow()>0))
					{
						if(resultado.getString("nombre_producto").indexOf((tf_descripcion.getText()))!=-1)
						{
							String aux[] = {Integer.toString(resultado.getInt("id_producto")), resultado.getString("nombre_producto"),Integer.toString(resultado.getInt("precio")),
									resultado.getString("marca"),resultado.getString("categoria"),Integer.toString(resultado.getInt("stock"))};
							lista_detalles.add(resultado.getString("detalle"));
							tb_productosModel.addRow(aux);
						}
					}
				}
			}
						
			if(lista_detalles.isEmpty())
			{
				ta_detalle.setText("No se han encontrado resultados.");
			}
			
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			for(int j=0;j<jTable1.getColumnCount();j++)
			{
				jTable1.getColumnModel().getColumn(j).setCellRenderer(tcr);
			}
		
		} 
		catch (SQLException e1)
		{	
			e1.printStackTrace();
		}
	}
	
	/**
	 * OyenteFilaSeleccionada
	 */
	private class OyenteFilaSeleccionada implements MouseListener
	{

		public void mouseClicked(MouseEvent e) {
			String detalle = lista_detalles.elementAt(jTable1.getSelectedRow()).toString();
			ta_detalle.setText(detalle.substring(1,detalle.length()-1));
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}
}

