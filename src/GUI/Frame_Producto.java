package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.mysql.jdbc.Statement;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Frame_Producto extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tf_id_producto;
	private JLabel lb_Id_producto;
	private JTextField tf_marca;
	private JLabel lb_producto;
	private JTextField tf_pesos;
	private JTextField tf_producto;
	private JButton bt_cerrar;
	private JButton bt_limpiar;
	private JButton bt_insertar;
	private JTextField tf_stock;
	private JTextField tf_categoria;
	private JLabel lb_stock;
	private JLabel lb_categoria;
	private JLabel lb_marca;
	private JLabel lb_precio;
	private JTextArea ta_detalle;
	private JTextField tf_precio;
	private JLabel lb_detalle;
	private Conexion con;
	
	public Frame_Producto(String _arg,Conexion _con)
	{
		super(_arg);
		con = _con;
		initGUI();
	}

	/**
	 * InitGUI()
	 * inicializa la ventana
	 */
	private void initGUI() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setResizable(false);
		
		OyenteTF otf = new OyenteTF();
		
		{
			tf_id_producto = new JTextField();
			tf_id_producto.addKeyListener(otf);
			RestrictedTextField rtf_id_producto = new RestrictedTextField(tf_id_producto);
			rtf_id_producto.setOnlyNums(true);
			getContentPane().add(tf_id_producto);
			tf_id_producto.setBounds(12, 43, 321, 23);
			tf_id_producto.setHorizontalAlignment(JTextField.RIGHT);
		}
		{
			lb_Id_producto = new JLabel();
			getContentPane().add(lb_Id_producto);
			lb_Id_producto.setText("Id Producto*");
			lb_Id_producto.setBounds(12, 27, 321, 16);
		}
		{
			tf_producto = new JTextField();
			tf_producto.addKeyListener(otf);
			getContentPane().add(tf_producto);
			tf_producto.setBounds(12, 91, 321, 23);
			tf_producto.setHorizontalAlignment(JTextField.RIGHT);
		}
		{
			lb_producto = new JLabel();
			getContentPane().add(lb_producto);
			lb_producto.setText("Producto*");
			lb_producto.setBounds(12, 74, 321, 16);
		}
		{
			tf_precio = new JTextField();
			tf_precio.addKeyListener(otf);
			RestrictedTextField rtf_precio = new RestrictedTextField(tf_precio);
			rtf_precio.setOnlyCustomCharacters(true);
			rtf_precio.setAcceptCharacters("1234567890.");
			tf_precio.setHorizontalAlignment(JTextField.RIGHT);
			getContentPane().add(tf_precio);
			tf_precio.setBounds(42, 140, 291, 23);
		}
		{
			lb_precio = new JLabel();
			getContentPane().add(lb_precio);
			lb_precio.setText("Precio*");
			lb_precio.setBounds(14, 122, 319, 16);
		}
		{
			tf_pesos = new JTextField();
			tf_pesos.addKeyListener(otf);
			getContentPane().add(tf_pesos);
			tf_pesos.setText("$");
			tf_pesos.setEditable(false);
			tf_pesos.setFocusable(false);
			tf_pesos.setHorizontalAlignment(JTextField.CENTER);
			tf_pesos.setBounds(16, 139, 26, 23);
		}
		{
			tf_marca = new JTextField();
			tf_marca.addKeyListener(otf);
			getContentPane().add(tf_marca);
			tf_marca.setBounds(14, 186, 319, 23);
			tf_marca.setHorizontalAlignment(JTextField.RIGHT);
		}
		{
			lb_marca = new JLabel();
			getContentPane().add(lb_marca);
			lb_marca.setText("Marca");
			lb_marca.setBounds(14, 170, 319, 16);
		}
		{
			tf_categoria = new JTextField();
			tf_categoria.addKeyListener(otf);
			getContentPane().add(tf_categoria);
			tf_categoria.setBounds(14, 237, 319, 21);
			tf_categoria.setHorizontalAlignment(JTextField.RIGHT);
		}
		{
			lb_categoria = new JLabel();
			getContentPane().add(lb_categoria);
			lb_categoria.setText("Categoria");
			lb_categoria.setBounds(14, 218, 319, 16);
		}
		{
			tf_stock = new JTextField();
			tf_stock.addKeyListener(otf);
			RestrictedTextField rtf_stock = new RestrictedTextField(tf_stock);
			rtf_stock.setOnlyNums(true);
			getContentPane().add(tf_stock);
			tf_stock.setBounds(14, 281, 319, 24);
			tf_stock.setHorizontalAlignment(JTextField.RIGHT);
		}
		{
			lb_stock = new JLabel();
			getContentPane().add(lb_stock);
			lb_stock.setText("Stock*");
			lb_stock.setBounds(14, 265, 319, 16);
		}
		{
			bt_insertar = new JButton();
			getContentPane().add(bt_insertar);
			Oyente_insertar_producto oip = new Oyente_insertar_producto();
			bt_insertar.addActionListener(oip);
			bt_insertar.setText("Insertar");
			bt_insertar.setBounds(13, 449, 81, 23);
			bt_insertar.setMnemonic(java.awt.event.KeyEvent.VK_I);
		}
		{
			bt_limpiar = new JButton();
			getContentPane().add(bt_limpiar);
			Oyente_Limpiar_producto olp = new Oyente_Limpiar_producto();
			bt_limpiar.addActionListener(olp);
			bt_limpiar.setText("Limpiar");
			bt_limpiar.setBounds(158, 449, 90, 23);
			bt_limpiar.setMnemonic(java.awt.event.KeyEvent.VK_L);
		}
		{
			bt_cerrar = new JButton();
			getContentPane().add(bt_cerrar);
			bt_cerrar.setText("Cerrar");
			Oyente_Cerrar_producto ocp = new Oyente_Cerrar_producto();
			bt_cerrar.addActionListener(ocp);
			bt_cerrar.setBounds(253, 449, 81, 23);
			bt_cerrar.setMnemonic(java.awt.event.KeyEvent.VK_C);
		}
		{
			lb_detalle = new JLabel();
			getContentPane().add(lb_detalle);
			lb_detalle.setText("Detalle*");
			lb_detalle.setBounds(14, 313, 319, 16);
		}
		{
			ta_detalle = new JTextArea();
			getContentPane().add(ta_detalle);
			ta_detalle.setWrapStyleWord(true);
			ta_detalle.setLineWrap(true);
			JScrollPane scroll = new JScrollPane(ta_detalle);
			getContentPane().add(scroll);
			scroll.setBounds(12, 332, 321, 92);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		}
		
		this.setSize(351, 520);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}
	
	/**
	 * 
	 */
	private class Oyente_Cerrar_producto implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			accionCerrar();
		}
		
	}
	
	private void accionCerrar()
	{
		int salida = JOptionPane.showConfirmDialog(null, "Salir?");
		if(salida == 0)
		{
			dispose();
		}
	}
	
	/**
	 * 
	 */
	private class Oyente_Limpiar_producto implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			tf_id_producto.setText("");
			ta_detalle.setText("");
			tf_precio.setText("");
			tf_producto.setText("");
			tf_marca.setText("");
			tf_categoria.setText("");
			tf_stock.setText("");
		}
	}
	
	private class OyenteTF implements KeyListener
	{

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
				accionInsertar();
            }
			else
			{
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	            {
					accionCerrar();
	            }
			}
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 */
	private class Oyente_insertar_producto implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
		
			accionInsertar();
		}
	}
	
	private void accionInsertar()
	{
		if (!verificarCeldas())
		{
			JOptionPane.showMessageDialog(null, "Complete los campos obligatorios (*).");
		}
		else
		{
			try {
				int id = Integer.parseInt(tf_id_producto.getText());
				String nombre = tf_producto.getText();
				float precio = Float.parseFloat(tf_precio.getText());
				Statement estado = (Statement) con.getConnection().createStatement();
				String marca = tf_marca.getText();
				String categoria = tf_categoria.getText();
				int stock = Integer.parseInt(tf_stock.getText());
				String detalle = "'"+ta_detalle.getText()+"'";
				estado.execute("INSERT INTO productos VALUES ("+id+", \""+nombre+"\", "+precio+", \""+marca+"\", \""+categoria+"\", "+stock+",\""+detalle+"\");");
				JOptionPane.showMessageDialog(null, "Insertado con exito.");
				tf_id_producto.setText("");
				tf_producto.setText("");
				ta_detalle.setText("");
				tf_precio.setText("");
				tf_producto.setText("");
				tf_marca.setText("");
				tf_categoria.setText("");
				tf_stock.setText("");
				//Aca inserta producto en la base de datos
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		
	}

	private boolean verificarCeldas() 
	{
		if (tf_id_producto.getText().equals("")||
		tf_producto.getText().equals("")||
		ta_detalle.getText().equals("")||
		tf_precio.getText().equals("")||
		tf_stock.getText().equals(""))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
}
