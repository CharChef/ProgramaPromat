package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Conexion {

	//Atributos
	protected boolean conectado;
	protected Statement estado;
	protected ResultSet resultado;
	protected Connection con;
	
	/*
	 * Constructor de la clase Conexion
	 */
	public Conexion()
	{
		conectado = false;
		ConectarServ();
	}
	
	/**
	 * ConectarServ()
	 */
	private void ConectarServ() {
		try {
			System.out.println("Conectando con la base de datos.");
			Class.forName("com.mysql.jdbc.Driver");
			
			//Conexi�n con la Base de Datos promat
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/promat","root","");
			conectado = true;
			System.out.println("Conexion exitosa.");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "No se ha podido conectar a la Base de Datos");
			System.out.println("Error con mysql.");
			System.exit(-1);
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * isConected()
	 * 
	 * @return verdaderi si se conecto satisfactoriamente, falso caso contrario
	 */
	public boolean isConected()
	{
		return conectado;
	}
	
	/**
	 * getConnection()
	 * 
	 * @return el atributo Connection de la conexion
	 */
	public Connection getConnection()
	{
		return con;
	}
	
	/**
	 * getEstado()
	 * 
	 * @return el atributo Statement de la conexion
	 */
	public Statement getEstado()
	{
		return estado;
	}
	
	/**
	 * getResultado()
	 * 
	 * @return el atributo ResultSet de la conexion
	 */
	public ResultSet getResultado()
	{
		return resultado;
	}
	
	/**
	 * closeConnection()
	 * 
	 * Cierra la conexion con la Base de Datos
	 */
	public void closeConnection()
	{
		try {
			con.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
