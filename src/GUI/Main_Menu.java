package GUI;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextPane;


public final class Main_Menu extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected JButton jButton1;
	protected JButton jButton2;
	protected JButton jButton3;
	protected JButton jButton4;
	protected JButton jButton5;
	protected JButton jButton6;
	protected JButton jButton7;
	protected JButton jButton8;
	protected JButton jButton9;
	protected JButton jButton10y11;
	protected JButton jButton12;
	protected JTextPane jTextArea1;
	protected JButton btnNewButton;
	protected Conexion con;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
			
		Main_Menu main = new Main_Menu("Promat Corp.");
		main.getContentPane().setLayout(null);
		main.setVisible(true);
				
	}
	
	//Constructor de la clase NewJFrame
	public Main_Menu(String e) {
		super(e);
		con = new Conexion();
		initGUI();
	}
	
	/**
	 * InitGUI()
	 * inicializa la ventana
	 */
	private void initGUI() {
				
			OyenteMouse oy = new OyenteMouse();
		
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Nuevo pedido");
				jButton1.setBounds(17, 5, 263, 27);
				jButton1.addMouseListener(oy);
				jButton1.addActionListener(new OyenteNuevoPedido());
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("A�adir producto nuevo");
				jButton2.setBounds(17, 37, 263, 27);
				jButton2.addMouseListener(oy);
				jButton2.addActionListener(new OyenteNuevoProducto());
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Consultar producto");
				jButton3.setBounds(17, 69, 263, 27);
				jButton3.addMouseListener(oy);
				jButton3.addActionListener(new OyenteConsultarProducto(con));		
			}
//			{
//				jButton4 = new JButton();
//				getContentPane().add(jButton4);
//				jButton4.setText("Mostrar r�tulos en Posorden");
//				jButton4.setBounds(17, 101, 263, 27);
//				jButton4.setEnabled(false);
//				jButton4.addMouseListener(oy);
//				jButton4.addActionListener(new OyenteEjerc4());	
//			}
//			{
//				jButton5 = new JButton();
//				getContentPane().add(jButton5);
//				jButton5.setText("Mostrar r�tulos por niveles");
//				jButton5.setBounds(17, 133, 263, 27);
//				jButton5.setEnabled(false);
//				jButton5.addMouseListener(oy);
//				jButton5.addActionListener(new OyenteEjerc5());	
//			}
//			{
//				jButton6 = new JButton();
//				getContentPane().add(jButton6);
//				jButton6.setText("Mostrar r�tulos en orden descendente");
//				jButton6.setBounds(17, 165, 263, 27);
//				jButton6.setEnabled(false);
//				jButton6.addMouseListener(oy);
//				jButton6.addActionListener(new OyenteEjerc6());	
//			}
//			{
//				jButton7 = new JButton();
//				getContentPane().add(jButton7);
//				jButton7.setText("Eliminar nodos de altura dada");
//				jButton7.setBounds(17, 197, 263, 27);
//				jButton7.setEnabled(false);
//				jButton7.addMouseListener(oy);
//				jButton7.addActionListener(new OyenteEjerc7());
//			}
//			{
//				jButton8 = new JButton();
//				getContentPane().add(jButton8);
//				jButton8.setText("Mostrar camino entre dos r�tulos");
//				jButton8.setBounds(17, 229, 263, 27);
//				jButton8.setEnabled(false);
//				jButton8.addMouseListener(oy);
//				jButton8.addActionListener(new OyenteEjerc8());
//			}
//			{
//				jButton9 = new JButton();
//				getContentPane().add(jButton9);
//				jButton9.setText("�rbol espejo");
//				jButton9.setBounds(17, 261, 263, 27);
//				jButton9.setEnabled(false);
//				jButton9.addMouseListener(oy);
//				jButton9.addActionListener(new OyenteEjerc9());
//			}
//			{
//				jButton10y11 = new JButton();
//				getContentPane().add(jButton10y11);
//				jButton10y11.setText("Crear Mapeo y Diccionario");
//				jButton10y11.setBounds(17, 293, 263, 27);
//				jButton10y11.setEnabled(false);
//				jButton10y11.addMouseListener(oy);
//				jButton10y11.addActionListener(new OyenteEjer10y11());
//			}
			{
				jButton12 = new JButton();
				getContentPane().add(jButton12);
				jButton12.setText("Imprimir Pollo");
				jButton12.setBounds(17, 325, 263, 27);
				jButton12.addMouseListener(oy);
				jButton12.addActionListener(new OyentePollo());
			}
			{
				jTextArea1 = new JTextPane();
				getContentPane().add(jTextArea1);
				jTextArea1.setBounds(17, 357, 263, 146);
				jTextArea1.setEditable(false);
				jTextArea1.setOpaque(false);
				jTextArea1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			}
			
			btnNewButton = new JButton("CA");
			btnNewButton.setBounds(17, 506, 26, 23);
			getContentPane().add(btnNewButton);
			btnNewButton.setEnabled(true);
			btnNewButton.addMouseListener(oy);
			btnNewButton.addActionListener(new OyenteCA());
			
			this.setSize(305, 568);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			
	}
	
	
	/*
	 * OyenteCA
	 */
	class OyenteCA implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			
//			try
//			{
//				ejercicios.punto1(1);
//				ejercicios.punto2(2, 1);
//				ejercicios.punto2(3, 1);
//				ejercicios.punto2(4, 1);
//				ejercicios.punto2(5, 2);
//				ejercicios.punto2(6, 2);
//				ejercicios.punto2(7, 4);
//				JOptionPane.showMessageDialog(null,"El �rbol por defecto fue creado correctamente.");
//				jButton1.setEnabled(false);
//				jButton2.setEnabled(true);
//				jButton3.setEnabled(true);
//				jButton4.setEnabled(true);
//				jButton5.setEnabled(true);
//				jButton6.setEnabled(true);
//				jButton7.setEnabled(true);
//				jButton8.setEnabled(true);
//				jButton9.setEnabled(true);
//				jButton10y11.setEnabled(true);
//				btnNewButton.setEnabled(false);
			
//			catch (ErrorExcecutionException e1)
//			{
//			e1.printStackTrace();// el programa anda de lujo!
//			}
			
		}
		
	}
	
	/*
	 * OYENTE Nuevo Pedido
	 */
	class OyenteNuevoPedido implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			Frame_Pedidos pedido = new Frame_Pedidos("Pedido",con);
			
		}
		
	}
	
	/*
	 * OYENTE Nuevo Producto
	 */
	class OyenteNuevoProducto implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			Frame_Producto Producto = new Frame_Producto("Producto",con);
		}
	
	}

	/*
	 * OYENTE EJERCICIO 3
	 */
	class OyenteConsultarProducto implements ActionListener{
		
		private Conexion con;
		
		public OyenteConsultarProducto(Conexion _con) {
			con = _con;
		}
		
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unused")
			Frame_Consulta consulta = new Frame_Consulta("Consultar producto",con);
		}
	}
	
//	/*
//	 * OYENTE EJERCICIO 4
//	 */
//	class OyenteEjerc4 implements ActionListener{
//		
//		
//	}
	
//	/*
//	 * OYENTE EJERCICIO 5
//	 */
//	class OyenteEjerc5 implements ActionListener{
//		
//		
//	}
	
//	/*
//	 * OYENTE EJERCICIO 6
//	 */
//	class OyenteEjerc6 implements ActionListener{
//				
//	}
	
//	/*
//	 * OYENTE EJERCICIO 7
//	 */
//	class OyenteEjerc7 implements ActionListener{
//	
//		
//	}
	
//	/*
//	 * OYENTE EJERCICIO 8
//	 */
//	class OyenteEjerc8 implements ActionListener{			
//		}
//		
//		/*
//		 * OYENTE BOTON ACEPTAR EJERCICIO 8
//		 */
//		class OyenteBotonAceptar implements ActionListener{
//		}	
//			
//		
//	}
	
//	/*
//	 * OYENTE EJERCICIO 9
//	 */
//	class OyenteEjerc9 implements ActionListener{
//				
//		
//	}
	
//	/*
//	 * OYENTE EJERCICIO 1O Y 11
//	 */
//	class OyenteEjer10y11 implements ActionListener{
//
//		
//	}
	
	/*
	 * OYENTE EJERCICIO 12
	 */
	class OyentePollo implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
		
		
	
	/*
	 * OYENTE DE MOUSE. MUESTRA LA EXPLICACION DEL EJERCICIO EN EL JLABEL
	 */
	class OyenteMouse implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			
			Object boton = e.getSource();
			String info = "";
			
			if (boton==jButton1)
			{
				info = 	"Nuevo pedido:\n\n"+
						"Permite ingresar nuevos pedidos a la base de datos.";
			}
			
			if (boton==jButton2)
			{
				info = 	"Agregar nuevo producto:\n\n"+
				"Permite agregar un nuevo producto a la base de datos.";
			}
			
			if (boton==jButton3)
			{
				info = 	"Consultar producto:\n\n"+
				"Permite consultar datos sobre un producto.";
			}
			
//			if (boton==jButton4)
//			{
//				jTextArea1.setText("Ejercicio 4:\n\nMuestra los r�tulos de los nodos al recorrer el �rbol en posorden.");
//			}
//			
//			if (boton==jButton5)
//			{
//				jTextArea1.setText("Ejercicio 5:\n\nMuestra los r�tulos de los nodos al recorrer el �rbol por niveles.");
//			}
//			
//			if (boton==jButton6)
//			{
//				jTextArea1.setText("Ejercicio 6:\n\nMuestra los r�tulos de los nodos en orden descendente. Un nodo N1 es menor que otro nodo N2 si la cantidad de hijos de N1 es menor que la cantidad de hijos de N2.");
//			}
//			
//			if (boton==jButton7)
//			{
//				jTextArea1.setText("Ejercicio 7:\n\nEliminar todos los nodos de una altura dada. La altura se recibe como par�metro. Retorna los r�tulos de los nodos eliminados.");
//			}
//			
//			if (boton==jButton8)
//			{
//				jTextArea1.setText("Ejercicio 8:\n\nDados dos r�tulos R1 y R2, retorna y muestra el camino del nodo N1 que tiene como r�tulo a R1 al nodo  N2 que tiene como r�tulo a R2.");
//			}
//			
//			if (boton==jButton9)
//			{
//				jTextArea1.setText("Ejercicio 9:\n\nCrea un '�rbol espejo' invirtiendo el orden de los hijos de cada nodo.");
//			}
//			
//			if (boton==jButton10y11)
//			{
//				jTextArea1.setText("Ejercicio 10 y 11:\n\nDado el �rbol cargado con las opciones 1 y 2, obtiene un mapeo M con las entradas (R,p) y obtiene un diccionario D con las entradas (p,R) donde  p la  profundidad del nodo cuyo r�tulo es R.");
//			}
			
			if (boton==jButton12)
			{
				info = 	"Imprimir Pollo:\n\n"+
				"imprime una planilla para el Pollo.";
			}
			
			jTextArea1.setText(info);
			
//			if (boton==btnNewButton)
//			{
//				jTextArea1.setText("Carga automaticamente un arbol por defecto.");
//			}
		}
			
		
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
	
