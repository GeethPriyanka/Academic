import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.Timer; //for timer

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Multi extends JPanel { // no action listener
    JButton button; 

    public Multi() {
        super(new BorderLayout());
        button = new JButton("Click me");
        button.setPreferredSize(new Dimension(200, 80));
        add(button, BorderLayout.CENTER);
        button.addActionListener(new MyEvent(1));
        button.addActionListener(new MyEvent(2));
    }

    public static void main(String [] args) {
        JFrame frame = new JFrame("Multi listeners");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Multi();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
}

class MyEvent implements ActionListener { 
    int eventId; 
    public MyEvent(int eventId) { 
	this.eventId = eventId; 
    }
    
    public void actionPerformed(ActionEvent e) { 
	System.out.println(eventId + ": Got an event");
    }
}


