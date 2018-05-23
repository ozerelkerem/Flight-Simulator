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

public class pnlFlightReport extends JFrame {
	private JTable tbFlights;
	private JScrollPane tbContainer;
	private final TableRowSorter<TableModel> sorter;
	public  pnlFlightReport(Center CNTR) {
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(750,750);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		String[] columnNames = {"UçuþID","Kalkýþ Þehri","Kalkýþ Havalimaný","Hedef Þehir","Hedef Havalimaný","Kalkýþ saati","Varýþ saati","Durumu"};
		DefaultTableModel model= new DefaultTableModel(columnNames,0);
		if(CNTR.getFlights().size()!=0)
			for(Flight f:CNTR.getFlights()) {
				model.addRow(f.toVector());
			}
		JPanel pnl=new JPanel();
		JMenuBar menuBar=new JMenuBar();
		JMenuItem suspend=new JMenuItem("Seçili Uçuþu durdur");
		suspend.setBackground(Color.RED);
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
		setJMenuBar(menuBar);
		add(pnl);
		suspend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int dialogResult = JOptionPane.showConfirmDialog(null, "Seçili satýrdaki uçuþu ertelemek istediðinize emin misiniz?","UYARI!", JOptionPane.YES_NO_OPTION);
				if (dialogResult == 0) {
				   JOptionPane.showMessageDialog(null, tbFlights.getValueAt(tbFlights.getSelectedRow(), 0)+" numaralý uçuþ ertelendi.");
				} else {
					 JOptionPane.showMessageDialog(null, "Vazgeçildi");
				}

			}
		});
		
		
	}

}
