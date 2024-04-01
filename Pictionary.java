import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pictionary {
    private JFrame frame;
    private JPanel canvas;
    private JComboBox<String> colorComboBox;

    private Color currentColor = Color.BLACK;

    public Pictionary(int width, int height) {
        frame = new JFrame("Pixel Art Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new JPanel(new GridLayout(height, width));
        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(width * 50, height * 50));

        for (int i = 0; i < width * height; i++) {
            JPanel pixel = new JPanel();
            pixel.setBackground(Color.WHITE);
            pixel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            pixel.addMouseListener(new PixelMouseListener());
            pixel.addMouseListener(new ColorMouseMotionListener());
            canvas.add(pixel);
        }

        colorComboBox = new JComboBox<>(new String[]{"Black", "Red", "Green", "Blue","Yellow", "Magenta","White"});
        colorComboBox.addActionListener(e -> updateColor());

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Color:"));
        controlPanel.add(colorComboBox);

        frame.add(canvas, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateColor() {
        String selectedColor = (String) colorComboBox.getSelectedItem();
        switch (selectedColor) {
            case "Red":
                currentColor = Color.RED;
                break;
            case "Green":
                currentColor = Color.GREEN;
                break;
            case "Blue":
                currentColor = Color.BLUE;
                break;
            case "Yellow":
                currentColor = Color.YELLOW;
                break;
            case "Magenta":
                currentColor = Color.MAGENTA;
                break;
            case "White":
                currentColor = Color.WHITE;
                break;

            default:
                currentColor = Color.BLACK;
        }
    }

    private class PixelMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JPanel pixel = (JPanel) e.getSource();
            pixel.setBackground(currentColor);
        }
    }
    private class ColorMouseMotionListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            JPanel pixel =  (JPanel) e.getSource();
            pixel.setBackground(currentColor);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pictionary(20, 20)); // Specify the width and height of the canvas
    }
}

//https://chat.openai.com/share/cf13833b-5491-46bc-a1df-2ce80c747075
