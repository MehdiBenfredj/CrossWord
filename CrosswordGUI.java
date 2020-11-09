/**
 * Classe pour visualiser le tableau "Crossword"
 * ATTENTION: NE PAS MODIFIER CETTE CLASSE
**/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class CrosswordGUI
{
	public enum Directions{HORIZONTAL, VERTICAL};

    public static void display(char array[][])
    {
        final CrosswordPanel panel = new CrosswordPanel(array);
        displayPanel(panel);
    }

    public static void display(char array[][], int y1, int x1, int y2, int x2)
    {
        final CrosswordPanel panel = new CrosswordPanel(array);
        if(y1==y2 && x1<=x2)
        	panel.highlight(y1,x1,1+x2-x1, Directions.HORIZONTAL);
        if(x1==x2 && y1<=y2)
        	panel.highlight(y1,x1,1+y2-y1, Directions.VERTICAL);
        displayPanel(panel);
    }

    private static void displayPanel(CrosswordPanel panel)
        {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            f.getContentPane().setLayout(new BorderLayout());
    
            JPanel container = new JPanel(new FlowLayout());
            container.add(panel);
            f.getContentPane().add(container, BorderLayout.CENTER);
        
            f.setSize(800, 800);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
}

class CrosswordPanel extends JPanel
{
    private JTextField textFields[][];

    public CrosswordPanel(char array[][])
    {
        int height = array.length;
        int width = array[0].length;
        setLayout(new GridLayout(height, width));
        textFields = new JTextField[height][width];

        for (int y=0; y<height; y++)
        {
            for (int x=0; x<width; x++)
            {
                char c = array[y][x];
                if (c != 0)
                {
                    textFields[y][x] = new JTextField(String.valueOf(c));
                    textFields[y][x].setFont(textFields[y][x].getFont().deriveFont(20.0f));
                    add(textFields[y][x]);
                }
                else
                {
                    add(new JLabel());
                }
            }
        }
        repaint();
    }

	public void highlight(int startY, int startX, int length, CrosswordGUI.Directions dir) {
		int endY = startY+1;
        int endX = startX+1;
        if (dir == CrosswordGUI.Directions.HORIZONTAL) endX += (length-1);
        else endY += (length-1); 

        for (int y=startY; y < endY; y++)
            for (int x=startX; x < endX; x++)
            {
            	textFields[y][x].setBackground(Color.yellow);
            }
        repaint();
	}

}
