import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends JFrame implements ActionListener {
    private JFrame jf = new JFrame();
    private JMenuBar jmb;
    private JMenu jm, jm1;
    private JMenuItem item1, item2, item3, item4;
    private JTable tb;

    public Main() {
        jf = new JFrame("CSE360 Final Project");
        jf.setLayout(new BorderLayout());
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
                JLabel i = new JLabel("Created by: Cody Currie, Maddie Potts, Sarah Ferenczi, " +
                        "Dominic Alejandro, Taylor Kelly");
                j.add(i);
                j.setLayout(new FlowLayout());
                j.setSize(550, 200);
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
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Load a Roster")) {
            final JFileChooser j = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Comma separated values(csv)", "csv");
            j.addChoosableFileFilter(filter);
            j.setFileFilter(filter);
            int result = j.showOpenDialog(new JFrame());
            if (result == JFileChooser.APPROVE_OPTION) {
                File myFile = j.getSelectedFile();                
                CSVReader csv = new CSVReader();               
                tb = new JTable(new Table());                
                Table myTable = new Table();
                tb.setModel(myTable);                
                ArrayList<String[]> rs = csv.reader(myFile.getAbsolutePath());
                myTable.setHeaders(myTable.getHeaders());

                for (int i = 0; i < rs.size(); i++) {
                    myTable.setData(rs.get(i));
                }                
                
                JScrollPane tablePanel = new JScrollPane(tb);
                JPanel container = new JPanel();
                container.add(tablePanel);
                tb.setTableHeader(null);
                jf.add(container);
                jf.setVisible(true);
            }

        } else if (s.equals("Add Attendance")) {
        	
            if(tb == null){
                JOptionPane.showMessageDialog(jf, "No data in table currently");
            } else {
                JFrame frame = new JFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();

                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");

                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                setLayout(new GridBagLayout());
                frame.add(datePicker);

                Date selectedDate = (Date) datePicker.getModel().getValue();
                
            }
            
        } else if (s.equals("Save")) {
            if (tb == null) {
                JOptionPane.showMessageDialog(jf, "No data to be saved");
            } else {
                final JFileChooser j = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Comma separated values", "csv");
                j.addChoosableFileFilter(filter);
                j.setFileFilter(filter);
                int result = j.showOpenDialog(new JFrame());
                if (result == JFileChooser.APPROVE_OPTION) {

                    File myFile = j.getSelectedFile();
                    ArrayList<String[]> saved = new ArrayList<>();

                    for(int i = 0; i < tb.getRowCount(); i++){
                        String [] row = new String[tb.getColumnCount()];
                        for(int k = 0; k < tb.getColumnCount(); k++){
                            row[k] = tb.getValueAt(i,k).toString();
                        }
                        saved.add(row);
                    }
                    String destination = myFile.getAbsolutePath();
                    CSVWriter csv = new CSVWriter();
                    try {
                        csv.writer(saved, destination);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        } else if (s.equals("Plot Data")) {
            if(tb == null) {
                JOptionPane.showMessageDialog(jf, "No data to be graphed");
            } else {
                Chart chart = new Chart();
            }
        }
    }


    public static void main(String[] args) {

        Main main = new Main();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}