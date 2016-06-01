package GUI;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public ModeloTabla(Object[][] filas, Object[] columnas)
	{
		super(filas,columnas);
	}
	
	public boolean isCellEditable(int row, int column){  
		return false;  
	}

}
