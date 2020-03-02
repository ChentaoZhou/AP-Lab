package threading;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

//import Counter.CountTask;

public class PrimeSwing extends JFrame implements ActionListener {
	private JButton start;
	private JButton stop;
	private JTextArea countText;
	private CounterWorker ct;
	
	public class CounterWorker extends SwingWorker<Void, Prime>{
		int i=0;
		int position =1;
		protected Void doInBackground() {
			while(!isCancelled()) {
				i++;
				if(PrimeNum.primeOrNot(i)) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
					Prime p = new Prime(i,position);
					position++;
					publish(p);
				}
			}
			return null;
		}
		protected void process(List<Prime> list) {
			Prime p = list.get(list.size()-1);
			String newLine = ""+p.position+":  "+p.number;
			String original = countText.getText();
			String newText = original+"\n"+newLine;
			countText.setText(newText);
			
		}
	}


	public PrimeSwing() {
		setTitle("Find Primes");
		setSize(505, 332);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		start = new JButton("start");
		start.setBounds(43, 31, 93, 37);
		start.setActionCommand("start");
		start.addActionListener(this);

		stop = new JButton("stop");
		stop.setBounds(168, 31, 81, 37);
		stop.setEnabled(false);
		stop.setActionCommand("stop");
		stop.addActionListener(this);

		countText = new JTextArea(50, 50);

		JScrollPane sp = new JScrollPane(countText);
		sp.setBounds(43, 89, 395, 151);
		getContentPane().setLayout(null);
		getContentPane().add(start);
		getContentPane().add(stop);
		getContentPane().add(sp);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			start.setEnabled(false);
			stop.setEnabled(true);
			(ct = new CounterWorker()).execute();
		}
		if(e.getSource() == stop) {
			start.setEnabled(true);
			stop.setEnabled(false);
			ct.cancel(true);
		}
		
	}
	public static void main(String[] args) {
		PrimeSwing ps = new PrimeSwing();
		ps.setVisible(true);
	}
}
