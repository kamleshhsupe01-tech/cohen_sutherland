import java.awt.*;
import javax.swing.*;

public class cohen_sutherland extends JPanel {
    static final int xMin = 100, yMin = 100, xMax = 300, yMax = 300;

    static final int INSIDE = 0;
    static final int LEFT = 1;
    static final int RIGHT = 2;
    static final int BOTTOM = 4;
    static final int TOP = 8;

    int x1 = 50, y1 = 250, x2 = 350, y2 = 150;

    public cohen_sutherland() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    int computeCode(int x, int y) {
        int code = INSIDE;

        if (x < xMin) code |= LEFT;
        else if (x > xMax) code |= RIGHT;
        if (y < yMin) code |= BOTTOM;
        else if (y > yMax) code |= TOP;

        return code;
    }

    boolean cohenSutherlandClipLine() {
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);
        boolean accept = false;

        while (true) {
            if ((code1 | code2) == 0) {
                accept = true;
                break;
            } else if ((code1 & code2) != 0) {
                break;
            } else {
                int codeOut = (code1 != 0) ? code1 : code2;
                int x = 0, y = 0;

                if ((codeOut & TOP) != 0) {
                    x = x1 + (x2 - x1) * (yMax - y1) / (y2 - y1);
                    y = yMax;
                } else if ((codeOut & BOTTOM) != 0) {
                    x = x1 + (x2 - x1) * (yMin - y1) / (y2 - y1);
                    y = yMin;
                } else if ((codeOut & RIGHT) != 0) {
                    y = y1 + (y2 - y1) * (xMax - x1) / (x2 - x1);
                    x = xMax;
                } else if ((codeOut & LEFT) != 0) {
                    y = y1 + (y2 - y1) * (xMin - x1) / (x2 - x1);
                    x = xMin;
                }

                if (codeOut == code1) {
                    x1 = x;
                    y1 = y;
                    code1 = computeCode(x1, y1);
                } else {
                    x2 = x;
                    y2 = y;
                    code2 = computeCode(x2, y2);
                }
            }
        }
        return accept;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.drawRect(xMin, yMin, xMax - xMin, yMax - yMin);

        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(50, 250, 350, 150);

        if (cohenSutherlandClipLine()) {
            g.setColor(Color.RED);
            g.drawLine(x1, y1, x2, y2);
        } else {
            g.setColor(Color.BLACK);
            g.drawString("Line is outside the clipping window.", 50, 50);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cohen-Sutherland Line Clipping");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new cohen_sutherland());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
