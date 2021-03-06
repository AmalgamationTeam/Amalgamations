package menus.components;

import amalgamation.parts.Part;

/**
 * A PartPanel is a modified JPanel intended to display a specific Part.
 * 
 * @author Adam Meanor, Jordan LaRiccia, Caleb Rush
 */
public class PartPanel extends acomponent.AComponent {
    // The color of the background under normal circumstances.
    public static java.awt.Color BG_NORMAL = java.awt.Color.WHITE;
    // The color of the background when the panel is highlighted.
    public static java.awt.Color BG_HIGHLIGHT 
            = new java.awt.Color(33, 150, 243);
    
    private amalgamation.parts.Part part;
    // The Runnable to be run when this panel is clicked.
    private Runnable clickAction;
    
    /**
     * Creates new form PartPanel
     */
    public PartPanel(Part part) {
        initComponents();
        this.part = part;
        NameLabel.setText(part.getName());
        setHighlightColor(BG_HIGHLIGHT);
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

        NameLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 2, new java.awt.Color(204, 204, 204)));
        setMaximumSize(new java.awt.Dimension(200, 200));
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(200, 200));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        NameLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(0, 204, 0));
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(NameLabel)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Change the cursor.
            setCursor(java.awt.Cursor.getPredefinedCursor(
                    java.awt.Cursor.HAND_CURSOR));
            stopAnimations();
            //highlight(evt.getX(), evt.getY(), 10);
            highlight(getWidth() / 2, getHeight() / 2, 10);
        });
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Change the cursor.
            setCursor(java.awt.Cursor.getDefaultCursor());
            stopAnimations();
            dehighlight(getWidth() / 2, getHeight() / 2, 0);
        });
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        javax.swing.SwingUtilities.invokeLater(() -> {
            if (clickAction != null)
                clickAction.run();
        });
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameLabel;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    /**
     * Sets the action to be performed when this Panel is clicked.
     * 
     * @param clickAction the Runnable to be run when the Panel is clicked.
     */
    public void setClickAction(Runnable clickAction) {
        this.clickAction = clickAction;
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw the image scaled to the size of the panel.
        int width, height;
        if (part.getImage().getWidth() >= part.getImage().getHeight()) {
            width = getWidth();
            height = part.getImage().getHeight() 
                    * width / part.getImage().getWidth();
        }
        else {
            height = getHeight();
            width = part.getImage().getWidth() 
                    * height / part.getImage().getHeight();
        }
        g.drawImage(part.getImage(), 
                getWidth() / 2 - width / 2, 
                getHeight() / 2 - height / 2,
                width,
                height,
                null);
    }
}
