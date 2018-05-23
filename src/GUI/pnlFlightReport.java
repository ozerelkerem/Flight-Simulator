package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Lib.Center;
import Lib.Flight;
import Lib.FlightException;

public class pnlFlightReport extends JFrame {
	private JTable tbFlights;
	private JScrollPane tbContainer;
	private final TableRowSorter<TableModel> sorter;
	private DefaultTableModel model;
	private Center CNTR;
	public  pnlFlightReport(Center CNTR) {
		this.CNTR = CNTR;
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(750,750);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		String[] columnNames = {"UçuşID","Kalkış Şehri","Kalkış Havalimanı","Hedef Şehir","Hedef Havalimanı","Kalkış saati","Gerçek Kalkış Saati","Varış saati","Durumu"};
		model= new DefaultTableModel(columnNames,0);
		getData(CNTR);
		JPanel pnl=new JPanel();
		JMenuBar menuBar=new JMenuBar();
		JMenuItem suspend=new JMenuItem("Seçili Uçuşu ertele");
		JMenuItem cancel=new JMenuItem("Uçuşu iptal et");
		cancel.setBackground(Color.RED);
		suspend.setBackground(Color.DARK_GRAY);
		suspend.setForeground(Color.WHITE);
		JMenuItem refreshData=new JMenuItem("Verileri Yenile");
		refreshData.setBackground(Color.BLUE);
		refreshData.setForeground(Color.WHITE);
		tbFlights= new JTable(model);
		tbFlights.setFillsViewportHeight(true);
		tbFlights.setFocusable(false);
		tbFlights.setRowSelectionAllowed(true);
		tbFlights.setRowSorter(new TableRowSorter<>(model));
		DefaultCellEditor editor = (DefaultCellEditor) tbFlights.getDefaultEditor(Object.class);
		editor.setClickCountToStart(5);
		sorter=(TableRowSorter<TableModel>)tbFlights.getRowSorter();
		tbContainer=new JScrollPane(tbFlights);
		pnl.add(tbContainer);
		pnl.setLayout(new GridLayout());
		
		menuBar.add(suspend);
		menuBar.add(cancel);
		menuBar.add(refreshData);
		setJMenuBar(menuBar);
		add(pnl);
suspend.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                if(tbFlights.getSelectedRow()==-1) {
                        JOptionPane.showMessageDialog(null, "Lütfen tablo üzerinden satır seçimi yapınız.");
                        return;
                }

                String    dialogResult = JOptionPane.showInputDialog(null, "Seçili satırdaki uçuşu kaç dakika ertelemek istersiniz?");
                Flight f = Flight.getFlightFromID(CNTR.getFlights(), (String) tbFlights.getValueAt(tbFlights.getSelectedRow(), 0));
                try {
                    CNTR.addDelayToFlight(f, Integer.valueOf(dialogResult));
                    JOptionPane.showMessageDialog(null, tbFlights.getValueAt(tbFlights.getSelectedRow(), 0) + " nolu uçuş ertelendi");
                } catch (FlightException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }

            }
        });
        cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tbFlights.getSelectedRow()==-1) {
                    JOptionPane.showMessageDialog(null, "Lütfen tablo üzerinden satır seçimi yapınız.");
                    return;
                }
                int dialogResult= JOptionPane.showConfirmDialog(null, "Seçili satırdaki uçuşu iptal etmek istediğinize emin misiniz?","UYARI!",JOptionPane.YES_NO_OPTION);
                Flight f = Flight.getFlightFromID(CNTR.getFlights(), (String) tbFlights.getValueAt(tbFlights.getSelectedRow(), 0)); 
                if(dialogResult==0 && f!=null)
                {
                    
                    try {
                        CNTR.cancelFlight(f);
                        JOptionPane.showMessageDialog(null, tbFlights.getValueAt(tbFlights.getSelectedRow(), 0) + " nolu uçuş iptal edildi");
                    } catch (FlightException e1) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                    
                }
                else
                    JOptionPane.showMessageDialog(null, "İşlemden Vazgeçildi");
                
            }
        });
		refreshData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				getData(CNTR);
				
			}
		});
		
	}
	public void getData(Center CNTR) {
		if(CNTR.getFlights().size()!=0)
			for(Flight f:CNTR.getFlights()) {
				model.addRow(f.toVector());
			}
	}

}