package Threading;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Counter extends JFrame implements ActionListener {
	public JTextField numberField;
	public JButton startButton, stopButton;
	public CounterWorker worker;

	public class CounterWorker extends SwingWorker<Void, Integer> {
		private Integer startNum;
		public JTextField outputField;

		public CounterWorker(Integer s, JTextField tf) {
			this.startNum = s;
			this.outputField = tf;
		}

		@Override
		protected Void doInBackground() throws Exception {
			Integer i = this.startNum;
			while(!isCancelled()) {
				try {
					i--;
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				publish(i);
			}
			return null;
		}

		protected void process(List<Integer> num) {
			int len = num.size();
			this.outputField.setText("" + num.get(len - 1));
		}
	}

	public Counter() {
		this.setSize(500, 100);
		this.setLocation(500, 200);
		this.setTitle("Backer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		numberField = new JTextField();
		numberField.setLocation(72, 6);
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		numberField.setText("50");
		

		startButton.setBounds(222, 5, 74, 23);
		stopButton = new JButton("Stop");
		stopButton.setBounds(306, 5, 74, 23);
		stopButton.addActionListener(this);
		getContentPane().setLayout(null);
		numberField.setSize(140, 20);
		//startButton.setEnabled(false);
		stopButton.setEnabled(false);

		getContentPane().add(numberField);
		getContentPane().add(startButton);
		getContentPane().add(stopButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == numberField) {
			if (Integer.parseInt(numberField.getText()) > 0) {
				startButton.setEnabled(true);
			}
		}

		if (e.getSource() == startButton) {
			stopButton.setEnabled(true);
			startButton.setEnabled(false);
			int startVal = Integer.parseInt(this.numberField.getText());
			worker = new CounterWorker(startVal, this.numberField);
			worker.execute();
		}
		if(e.getSource() == stopButton) {
			startButton.setEnabled(true);
				worker.cancel(true);

		}
	}

	public static void main(String[] args) {
		Counter c = new Counter();
		c.setVisible(true);
	}

}
