import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.Timer; //for timer

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StopWatch extends JPanel 
    implements ActionListener {

    JButton button;
    int min = 0; 
    int sec = 0; 
    

    public StopWatch() {
        super(new BorderLayout());
        button = new JButton(min + ":" + sec);
        button.setPreferredSize(new Dimension(200, 80));
        add(button, BorderLayout.CENTER);

	Timer timer = new Timer(1000, this); 
	timer.start();
    }

    
    public void actionPerformed(ActionEvent e) {
	sec += 1; 
	if(sec == 60) { 
	    min ++;
	    sec = 0;
	}

	button.setText(min + ":" + sec);
    }

    public static void main(String [] args) {
        JFrame frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new StopWatch();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
}

