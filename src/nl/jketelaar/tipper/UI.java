package nl.jketelaar.tipper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author JKetelaar
 */
public class UI {

    private JFrame frame;
    private Core core;

    public UI(Core core) {
        this.core = core;
        this.initalise();
        this.frame.setVisible(true);
    }

    private void initalise() {
        this.frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel lblTips = new JLabel("Tips");
        frame.getContentPane().add(lblTips, BorderLayout.WEST);

        JButton btnStart = new JButton("Start");
        frame.getContentPane().add(btnStart, BorderLayout.SOUTH);

        ArrayList<String> options = new ArrayList<String>();
        for (Tips t : Tips.values()) {
            options.add(t.name().toLowerCase());
        }
        String[] optionsArray = new String[options.size()];
        optionsArray = options.toArray(optionsArray);

        JComboBox<? extends String> comboBox = new JComboBox<String>(optionsArray);
        frame.getContentPane().add(comboBox, BorderLayout.CENTER);

        comboBox.setSelectedIndex(4);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String option = (String) cb.getSelectedItem();
                for (Tips t : Tips.values()) {
                    if (t.name().toLowerCase().equals(option)) {
                        core.setTip(t);
                    }
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
