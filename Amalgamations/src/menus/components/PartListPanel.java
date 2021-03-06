package menus.components;

import amalgamation.parts.Part;
import util.Parts;

/**
 * A PartListPanel is a modified JPanel intended to display a vertically 
 * scrollable list of PartPanels.
 * 
 * @author Adam Meanor, Jordan LaRiccia, Caleb Rush
 */
public class PartListPanel extends javax.swing.JPanel {
    // The number of columns in the GridBagLayout.
    private static final int COLUMNS = 2;
    
    // The array of Parts displayed.
    private Part[] parts;
    // The PartChooseListener to set off whenever a Part is selected.
    private PartChooseListener listener;
    // The RotationChangeListener to set off whenever the rotation changes.
    private RotationChangeListener rotationListener;
    
    /**
     * Creates a PartListPanel without a rotation slider.
     */
    public PartListPanel(int type) {
        this(type, 0);
        
        remove(RotationPanel);
        RotationPanel.setVisible(false);
    }
    
    /**
     * Creates new form PartListPanel
     */
    public PartListPanel(int type, int initialRotation) {
        initComponents();
        
        // Retrieve the Part from the appropriate directory.
        switch (type) {
            case Parts.TYPE_ARM:
                try {
                    parts = Parts.getArms(Parts.ARMS_RES_DIR);
                } catch (java.io.IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "ERROR! The " + Parts.ARMS_RES_DIR + 
                                    " directory could not be "
                                    + "found! Please ensure it exists!",
                            "Directory not found",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                break;
            
            case Parts.TYPE_BODY:
                try {
                    parts = Parts.getBodies(Parts.BODIES_RES_DIR);
                } catch (java.io.IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "ERROR! The " + Parts.BODIES_RES_DIR + 
                                    " directory could not be "
                                    + "found! Please ensure it exists!",
                            "Directory not found",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                break;
            
            case Parts.TYPE_HEAD:
                try {
                    parts = Parts.getHeads(Parts.HEADS_RES_DIR);
                } catch (java.io.IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "ERROR! The " + Parts.HEADS_RES_DIR + 
                                    " directory could not be "
                                    + "found! Please ensure it exists!",
                            "Directory not found",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                break;
                
            case Parts.TYPE_LEG:
                try {
                    parts = Parts.getLegs(Parts.LEGS_RES_DIR);
                } catch (java.io.IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "ERROR! The " + Parts.LEGS_RES_DIR + 
                                    " directory could not be "
                                    + "found! Please ensure it exists!",
                            "Directory not found",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
        }
         
        // Create a PartPanel for each Part and add them to the panel.
        for(int i = 0; i < parts.length; i++) {
            // Create the new PartPanel.
            PartPanel panel = new PartPanel(parts[i]);
            panel.setPreferredSize(new java.awt.Dimension(
                    ListPanel.getWidth() / COLUMNS, 
                    150
            ));
            
            // Set the PartPanel's clickAction.
            final int index = i;
            panel.setClickAction(() -> {
                // Call the listener.
                if (listener != null)
                    listener.partChosen(parts[index]);
            });
            
            // Add the panel to the list.
            java.awt.GridBagConstraints constraints = 
                    new java.awt.GridBagConstraints();
            constraints.gridx = i % COLUMNS;
            constraints.gridy = i / COLUMNS;
            constraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1.0;
            //constraints.weighty = 1.0;
            ListPanel.add(panel, constraints);
        }
        
        // Set the slider's initial value.
        RotationSlider.setValue(initialRotation);
    }
    
    /**
     * Sets the PartChooseListener that will have its method called whenever
     * the selected Part is changed.
     * 
     * A PartChooseListener can easily be expressed with a lambda expression
     * like so:
     * 
     * <code>part -> { ... }</code>
     * 
     * @param listener the new PartChooseListener.
     */
    public void setPartChangeListener(PartChooseListener listener) {
        this.listener = listener;
    }
    
    /**
     * Adds the specified ChangeListener to the rotation slider.
     * 
     * This should be used to receive update events from the panel's rotation
     * slider.
     * 
     * @param rotationListener the listener to add to the rotation slider
     */
    public void setSliderListener(RotationChangeListener rotationListener) {
        this.rotationListener = rotationListener;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        ListPanel = new javax.swing.JPanel();
        RotationPanel = new javax.swing.JPanel();
        RotationSlider = new javax.swing.JSlider();

        setPreferredSize(new java.awt.Dimension(400, 450));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 150, 243), 2));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(null);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);

        ListPanel.setBackground(new java.awt.Color(255, 255, 255));
        ListPanel.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(ListPanel);

        RotationPanel.setBackground(new java.awt.Color(255, 255, 255));
        RotationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Rotation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Berlin Sans FB Demi", 1, 12), new java.awt.Color(30, 150, 243))); // NOI18N

        RotationSlider.setBackground(new java.awt.Color(255, 255, 255));
        RotationSlider.setForeground(new java.awt.Color(30, 150, 243));
        RotationSlider.setMaximum(360);
        RotationSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RotationSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RotationSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout RotationPanelLayout = new javax.swing.GroupLayout(RotationPanel);
        RotationPanel.setLayout(RotationPanelLayout);
        RotationPanelLayout.setHorizontalGroup(
            RotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RotationSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        RotationPanelLayout.setVerticalGroup(
            RotationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RotationPanelLayout.createSequentialGroup()
                .addComponent(RotationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RotationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(RotationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RotationSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RotationSliderStateChanged
        javax.swing.SwingUtilities.invokeLater(() -> {
            if (rotationListener != null)
                rotationListener.rotationChanged(RotationSlider.getValue());
        }); 
    }//GEN-LAST:event_RotationSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ListPanel;
    private javax.swing.JPanel RotationPanel;
    private javax.swing.JSlider RotationSlider;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
    
    /**
     * A PartChooseListener can be used to perform an action with the selected
     * Part whenever the selection is changed.
     */
    public static interface PartChooseListener {
        void partChosen(Part part);
    }
    
    /**
     * A RotationChangeListener can be used to perform an action when the
     * rotation slider is modified.
     */
    public static interface RotationChangeListener {
        void rotationChanged(int newRotation);
    }
}
