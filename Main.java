import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
public class Main extends JFrame implements ActionListener {
	private JFrame jf = new JFrame();
	private JMenuBar jmb;
	private JMenu jm, jm1;
	private JMenuItem item1, item2, item3, item4;
	public Main() {
		jf = new JFrame("CSE360 Final Project");
		jmb = new JMenuBar();
		jm = new JMenu("File");
		jm1 = new JMenu("About");
		item1 = new JMenuItem("Load a Roster");
		item2 = new JMenuItem("Add Attendance");
		item3 = new JMenuItem("Save");
		item4 = new JMenuItem("Plot Data");
		jm.add(item1);
		jm.add(item2);
		jm.add(item3);
		jm.add(item4);		
		jmb.add(jm);
		jmb.add(jm1);
		
		jm1.addMenuListener(new MenuListener() {
			@Override
	        public void menuSelected(MenuEvent e) {				
				JFrame j = new JFrame("About");
				JLabel i = new JLabel("asdfasdfasdf");
				j.add(i);
				j.setLayout(new FlowLayout());
				j.setSize(200,200);
				j.setLocationRelativeTo(null); 
				j.setAlwaysOnTop(true); 
				j.setVisible(true);
	        }

	        @Override
	        public void menuDeselected(MenuEvent e) {

	        }

	        @Override
	        public void menuCanceled(MenuEvent e) {
	   

	        }
	    });
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		
		jf.setJMenuBar(jmb);
		jf.setJMenuBar(jmb);
		jf.setSize(750,750);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Load a Roster")) {
			JFileChooser j = new JFileChooser();
			j.showSaveDialog(null);
		}
		else if (s.equals("Add Attendance")) {
			
		}
		else if(s.equals("Save")) {
			
		}
		else if (s.equals("Plot Data")) {
			
		}
	}
	

	public static void main(String[] args) {
		
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
