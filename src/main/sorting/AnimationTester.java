package main.sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Hieu Le
 * @version 11/26/15
 */
public class AnimationTester {
    private static final int VALUES_LENGTH = 30;
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayComponent panel = new ArrayComponent();
        frame.add(panel, BorderLayout.CENTER);

        JButton stepButton = new JButton("Step");
        final JButton runButton = new JButton("Run");

        JPanel buttons = new JPanel();
        buttons.add(stepButton);
        buttons.add(runButton);

        frame.add(buttons, BorderLayout.NORTH);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        Double[] values = new Double[VALUES_LENGTH];
        for (int i = 0; i < values.length; i++)
            values[i] = Math.random() * panel.getHeight();

        final BlockingQueue<String> queue
                = new LinkedBlockingQueue<String>();
        queue.add("Step");

        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                queue.add("Step");
                runButton.setEnabled(true);
            }
        });

        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                runButton.setEnabled(false);
                queue.add("Run");
            }
        });

        final Runnable sorter = new Sorter(values, panel, queue, new MergesortAlgorithm<>());

        Thread sorterThread = new Thread(sorter);
        sorterThread.start();
    }
}
