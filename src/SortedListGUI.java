import javax.swing.*;
import java.awt.*;

public class SortedListGUI {

    SortedList sortedList = new SortedList();
    JTextArea textArea = new JTextArea(10, 30);

    public SortedListGUI() {
        JFrame frame = new JFrame("Sorted List Manager");
        JTextField inputField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        textArea.setEditable(false);

        addButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                sortedList.add(text);
                inputField.setText("");
                updateTextArea("Added: " + text);
            }
        });

        searchButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (!text.isEmpty()) {
                int index = sortedList.binarySearch(text);
                if (index >= 0) {
                    updateTextArea("Found '" + text + "' at index: " + index);
                } else {
                    int insertPoint = -index - 1;
                    updateTextArea("'" + text + "' not found. It would be at index: " + insertPoint);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Input:"));
        panel.add(inputField);
        panel.add(addButton);
        panel.add(searchButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateTextArea(String operation) {
        StringBuilder builder = new StringBuilder(operation + "\nCurrent List:\n");
        for (String item : sortedList.getList()) {
            builder.append(item).append("\n");
        }
        textArea.setText(builder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortedListGUI::new);
    }
}
