package modelo;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.PersonaCollection;
import dto.PersonaDTO;;

public class PersonaTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<PersonaDTO> lista;
	
	protected String[] columnNames = new String[] { "DNI", "Apellido", "Nombre", "Sindicalizado", "FNAC", "Sueldo"}; 
	protected Class[] columnClasses = new Class[] { String.class, String.class, String.class, boolean.class, String.class, float.class}; 


	public String getColumnName(int col) { return columnNames[col]; } 
	public Class getColumnClass(int col) { return columnClasses[col]; } 
	
	public PersonaTableModel(PersonaCollection coleccionPersona)
	{
		lista = coleccionPersona.getPersonasList();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	
    @Override
    public boolean isCellEditable(int row, int column)
    {
    	return false;
    }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) 
		{ 
			case 0: return lista.get(rowIndex).getDni(); 
			case 1: return lista.get(rowIndex).getApellido();
			case 2: return lista.get(rowIndex).getNombre();
			case 3: return lista.get(rowIndex).isSindicalizado();
			case 4: return lista.get(rowIndex).getFchNacimiento();
			case 5: return lista.get(rowIndex).getSueldo();
			default: return null; 
		}
	}
	
	public void agregar(PersonaDTO persona)
	{
		lista.add(persona);
		fireTableDataChanged();
	}
	
	public void refresh() {
		fireTableDataChanged();
	}
	
	public void eliminar(int fila)
	{
		lista.remove(fila);
		fireTableDataChanged();
	}
	
	public void eliminar(PersonaDTO persona)
	{
		eliminar(lista.indexOf(persona));
	}	

}
