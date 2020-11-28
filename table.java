import javax.swing.table.*;
import java.util.ArrayList;
public class table extends AbstractTableModel {
	private String[] columnNames = {"ID", "First Name", "Last Name", "Program", "Level", "ASURITE"};
	private ArrayList<String[]> data = new ArrayList<String[]>();
	
	public void addData(ArrayList<String[]> list) {
		this.data = list;
		this.fireTableDataChanged();
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return data.size();
	}
	
	public String getColumnNames(int column) {
		return columnNames[column];
	}
	public Object getValueAt(int row, int column) {
		return data.get(row)[column];
	}
}
