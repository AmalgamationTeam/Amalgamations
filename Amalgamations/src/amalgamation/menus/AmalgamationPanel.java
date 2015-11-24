package amalgamation.menus;

import amalgamation.Amalgamation;
import java.awt.Color;

/**
 * An AmalgamationPanel is a GUI element that can be used to display the image
 * of an Amalgamation.
 * 
 * @author Jordan LaRiccia, Caleb Rush
 */
public class AmalgamationPanel extends acomponent.AComponent {
    // The body to test.
    private final Amalgamation amal;
    // ImagePanel to draw the image.
    private Runnable clickAction;

    /**
     * Creates a new AmalgamationPanel that displays the image of the given
     * Amalgamation.
     * 
     * @param amal the Amalgamation to be displayed by the created panel
     */
    public AmalgamationPanel(Amalgamation amal) {
        initComponents();
        this.amal = amal;
        setBackground(Color.WHITE);
        // Set the highlight color to a pleasant shade of red.
        setHighlightColor(new java.awt.Color(244, 67, 54));
        // Initialize the mouse listener.
        initMouseListener();
        // Set the border.
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 2, 
                Color.LIGHT_GRAY));
    }
    
    /**
     * Retrieves the Amalgamation being displayed by this panel.
     * 
     * @return the Amalgamation being displayed by this panel
     */
    public Amalgamation getAmalgamation() {
        return amal;
    }
    
    // Initializes the mouse listener.
    private final void initMouseListener() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // Run the Runnable.
                if (clickAction != null)
                    clickAction.run();
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Change the cursor.
                setCursor(java.awt.Cursor.getPredefinedCursor(
                        java.awt.Cursor.HAND_CURSOR));
                // Highlight the panel.
                stopAnimations();
                highlight(getWidth() / 2, getHeight() / 2, 10);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // Change the cursor.
                setCursor(java.awt.Cursor.getDefaultCursor());
                // Dehighlight the panel.
                stopAnimations();
                dehighlight(getWidth() / 2, getHeight() / 2, 0);
            }
        });
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw the image scaled to the size of the panel.
        int width, height;
        if (getWidth() <= getHeight()) {
            width = getWidth();
            height = amal.getFullImage().getHeight() 
                    * width / amal.getFullImage().getWidth();
        }
        else {
            height = getHeight();
            width = amal.getFullImage().getWidth() 
                    * height / amal.getFullImage().getHeight();
        }
        g.drawImage(amal.getFullImage(), 
                getWidth() / 2 - width / 2, 
                getHeight() / 2 - height / 2,
                width,
                height,
                null);
    }
    
    /**
     * Sets the Runnable to be run when this panel is clicked.
     * 
     * @param clickAction the Runnable to be run when this panel is clicked
     */
    public void setClickAction(Runnable clickAction) {
        this.clickAction = clickAction;
    }

    // <editor-fold desc="GUI Variables" defaultstate="collapsed">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(null);
        setMinimumSize(null);
        setPreferredSize(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    public static void main(String[] args) {
        javax.swing.JFrame window = new javax.swing.JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        
        AmalgamationPanel panel = new AmalgamationPanel(amalgamation.Amalgamations.load("Davy Jones"));
        window.add(panel);
        
        window.setVisible(true);
    }
}



