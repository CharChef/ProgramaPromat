package GUI;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Victor.Espindola
 */
public class tabla extends javax.swing.JFrame {

    public tabla() {
        initComponents();
        setTabla();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEjemplo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTableEjemplo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE));

        pack();
    }

    private void setTabla() {
        Calendar c1 = GregorianCalendar.getInstance();
        c1.set(1980, 11, 23);
        Date fecha1 = c1.getTime();
        c1.set(1987, 07, 11);
        Date fecha2 = c1.getTime();
        c1.set(1971, 02, 01);
        Date fecha3 = c1.getTime();

        // Esta lista contiene los nombres que se mostrar�n en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{
            "Activo",
            "Nombre",
            "Direcci�n",
            "Fecha de nacimiento",
            "Hijos",
            "Bot�n"};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.Boolean.class,
            java.lang.String.class,
            java.lang.String.class,
            Date.class,
            int.class,
            JButton.class // <- noten que aqu� se especifica que la �ltima columna es un bot�n
        };

        // Agrego los registros que contendr� la grilla.
        // Observen que el �ltimo campo es un bot�n
        Object[][] datos = new Object[][]{
            {true, "V�ctor", "Su casa", fecha1, 1, new JButton("Clic aqu�")},
            {false, "Fernanda", "calle sin nombre #501", fecha2, 0, new JButton("Clic aqu�")},
            {true, "Julian", "Orilla del rio #014", fecha3, 0, new JButton("Clic aqu�")}
        };

        // Defino el TableModel y le indico los datos y nombres de columnas
        jTableEjemplo.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este m�todo es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este m�todo para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });

        // El objetivo de la siguiente l�nea es indicar el CellRenderer que ser� utilizado para dibujar el bot�n
        jTableEjemplo.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en �ste m�todo es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujar� en la celda el objeto que devuelva el TableModel. Tambi�n 
                 * significa que este renderer nos permitir�a dibujar cualquier objeto gr�fico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });

        /**
         * Por �ltimo, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el bot�n.
         * Noten que estamos capturando el clic sobre JTable, no el clic sobre el JButton. Esto tambi�n implica que en 
         * lugar de poner un bot�n en la celda, simplemente pudimos definir un CellRenderer que hiciera parecer que la 
         * celda contiene un bot�n. Es posible capturar el clic del bot�n, pero a mi parecer el efecto es el mismo y 
         * hacerlo de esta forma es m�s "simple"
         */
        jTableEjemplo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTableEjemplo.rowAtPoint(e.getPoint());
                int columna = jTableEjemplo.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el bot�n, si tuvi�ramos m�s de un bot�n 
                 * por fila tendr�amos que adem�s preguntar por el contenido del bot�n o el nombre de la columna
                 */
                if (jTableEjemplo.getModel().getColumnClass(columna).equals(JButton.class)) {
                    /**
                     * Aqu� pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un bot�n.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jTableEjemplo.getModel().getColumnCount(); i++) {
                        if (!jTableEjemplo.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(jTableEjemplo.getModel().getColumnName(i)).append(": ").append(jTableEjemplo.getModel().getValueAt(fila, i));
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabla().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEjemplo;
    // End of variables declaration                   
}
