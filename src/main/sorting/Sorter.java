package main.sorting;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;

/**
 * @author Hieu Le
 * @version 11/26/15
 */
public class Sorter implements Runnable {
    private Double[] values;
    private ArrayComponent panel;
    private BlockingQueue<String> queue;
    private SortingAlgorithm<Double> algorithm;

    private static final int DELAY = 100;

    public Sorter(Double[] values, ArrayComponent panel,
                  BlockingQueue<String> queue, SortingAlgorithm<Double> algorithm) {
        this.values = values;
        this.panel = panel;
        this.queue = queue;
        this.algorithm = algorithm;
    }

    public void run() {
        Comparator<Double> comp = new Comparator<Double>() {
            public int compare(Double d1, Double d2) {
                try {
                    String command = queue.take();
                    if (command.equals("Run")) {
                        Thread.sleep(DELAY);
                        if (!"Step".equals(queue.peek()))
                            queue.add("Run");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                panel.setValues(values, d1, d2);
                return d1.compareTo(d2);
            }
        };
        algorithm.sort(values, comp);
        panel.setValues(values, null, null);
    }
}
