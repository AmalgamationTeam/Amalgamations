package menus.components;

import campaign.CampaignLevel;

import java.awt.Rectangle;

import util.CampaignLevels;

/**
 * A CampaignDialog allows the player to play all of the CampaignLevels in
 * the res/clvl/ directory in alphabetical order.
 * 
 * @author CalebRush
 */
public class CampaignDialog extends acomponent.ADialog {
    // The list of CampaignLevel names.
    private final String[]  levelNames;
    // The current level index.
    private int             currentIndex;
    // The current level.
    private CampaignLevel   currentLevel;
    // The bounds of all the AmalgamationPanels.
    private Rectangle       minion1Bounds;
    private Rectangle       minion2Bounds;
    private Rectangle       minion3Bounds;
    private Rectangle       minion4Bounds;
    private Rectangle       minion5Bounds;
    private Rectangle       minion6Bounds;
    private Rectangle       guard1Bounds;
    private Rectangle       guard2Bounds;
    private Rectangle       guard3Bounds;
    private Rectangle       bossBounds;

    // Called when the dialog is first displayed. Animates beginning values
    // as appropriate.
    private void animateIn() {
        // Load the bounds of all the panels.
        minion1Bounds = Minion1Panel.getBounds();
        minion2Bounds = Minion2Panel.getBounds();
        minion3Bounds = Minion3Panel.getBounds();
        minion4Bounds = Minion4Panel.getBounds();
        minion5Bounds = Minion5Panel.getBounds();
        minion6Bounds = Minion6Panel.getBounds();
        guard1Bounds = Guard1Panel.getBounds();
        guard2Bounds = Guard2Panel.getBounds();
        guard3Bounds = Guard3Panel.getBounds();
        bossBounds = BossPanel.getBounds();
        // Hide the panels so that they can be animated in.
        Minion1Panel.setLocation(-200, 0);
        Minion2Panel.setLocation(-200, 0);
        Minion3Panel.setLocation(-200, 0);
        Minion4Panel.setLocation(-200, 0);
        Minion5Panel.setLocation(-200, 0);
        Minion6Panel.setLocation(-200, 0);
        guard1Bounds.setLocation(-200, 0);
        guard2Bounds.setLocation(-200, 0);
        guard3Bounds.setLocation(-200, 0);
        bossBounds.setLocation(-200, 0);
        NameLabel.setLocation(NameLabel.getX(), NameLabel.getY() - 500);
        // Animate the NameLabel in.
        NameLabel.slideY(500, 1000).then(this::animateLevelIn);
    }
    
    // Animates the current level in.
    private void animateLevelIn() {
        // Animate the boss in.
        BossPanel.enter(bossBounds).then(() -> {
            // Animate the guards in.
            Guard1Panel.setLocation(
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard1Panel.getWidth()) / 2,
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard1Panel.getWidth()) / 2
            );
            Guard2Panel.setLocation(
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard2Panel.getWidth()) / 2,
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard2Panel.getWidth()) / 2
            );
            Guard3Panel.setLocation(
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard3Panel.getWidth()) / 2,
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard3Panel.getWidth()) / 2
            );
            repaint();
            Guard1Panel.translate((int)guard1Bounds.getX(), 
                    (int)guard1Bounds.getY(), 1000);
            Guard2Panel.translate((int)guard2Bounds.getX(), 
                    (int)guard2Bounds.getY(), 500);
            Guard3Panel.translate((int)guard3Bounds.getX(), 
                    (int)guard3Bounds.getY(), 500);
        });
    }
    
    @Override
    public void showDialog() {
        // Calculate the distance from the current Y position to the bottom of
        // the screen.
        int distance = (int)java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - getY();
        setLocation(getX(), getY() + distance);
        translate(getX(), getY() - distance, 250).then(this::animateLevelIn);
        setVisible(true);
    }
    
    // <editor-fold desc="GUI Code" defaultstate="collapsed">
    /**
     * Creates new form CampaignDialog
     */
    public CampaignDialog(java.awt.Frame parent) throws IllegalStateException {
        super(parent, true);
        initComponents();
        setSize(740, 620);
        pack();
        setLocationRelativeTo(parent);
        levelNames = CampaignLevels.getCampaignLevelNames();
        if (levelNames == null || levelNames.length == 0)
            throw new IllegalStateException("There are no Campaign levels!");
        currentIndex = 0;
        try {
            currentLevel = CampaignLevels.loadCampaignLevel(
                    levelNames[currentIndex]);
        } catch (Exception e) {
            throw new IllegalStateException("There are no Campaign levels!");
        }
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                animateIn();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new acomponent.ALabel();
        NextButton = new acomponent.AButton();
        PreviousButton = new acomponent.AButton();
        BossPanel = new menus.components.AmalgamationPanel();
        Guard1Panel = new menus.components.AmalgamationPanel();
        Guard3Panel = new menus.components.AmalgamationPanel();
        Guard2Panel = new menus.components.AmalgamationPanel();
        Minion2Panel = new menus.components.AmalgamationPanel();
        Minion4Panel = new menus.components.AmalgamationPanel();
        Minion1Panel = new menus.components.AmalgamationPanel();
        Minion3Panel = new menus.components.AmalgamationPanel();
        Minion5Panel = new menus.components.AmalgamationPanel();
        Minion6Panel = new menus.components.AmalgamationPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        NameLabel.setBackground(new java.awt.Color(255, 255, 255));
        NameLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        NameLabel.setHorizontalAlignment(0);
        NameLabel.setText("Level Name");

        javax.swing.GroupLayout NameLabelLayout = new javax.swing.GroupLayout(NameLabel);
        NameLabel.setLayout(NameLabelLayout);
        NameLabelLayout.setHorizontalGroup(
            NameLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        NameLabelLayout.setVerticalGroup(
            NameLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        NextButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        NextButton.setText("Next");

        javax.swing.GroupLayout NextButtonLayout = new javax.swing.GroupLayout(NextButton);
        NextButton.setLayout(NextButtonLayout);
        NextButtonLayout.setHorizontalGroup(
            NextButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        NextButtonLayout.setVerticalGroup(
            NextButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        PreviousButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        PreviousButton.setText("Previous");

        javax.swing.GroupLayout PreviousButtonLayout = new javax.swing.GroupLayout(PreviousButton);
        PreviousButton.setLayout(PreviousButtonLayout);
        PreviousButtonLayout.setHorizontalGroup(
            PreviousButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        PreviousButtonLayout.setVerticalGroup(
            PreviousButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BossPanelLayout = new javax.swing.GroupLayout(BossPanel);
        BossPanel.setLayout(BossPanelLayout);
        BossPanelLayout.setHorizontalGroup(
            BossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );
        BossPanelLayout.setVerticalGroup(
            BossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 127, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Guard1PanelLayout = new javax.swing.GroupLayout(Guard1Panel);
        Guard1Panel.setLayout(Guard1PanelLayout);
        Guard1PanelLayout.setHorizontalGroup(
            Guard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        Guard1PanelLayout.setVerticalGroup(
            Guard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Guard3PanelLayout = new javax.swing.GroupLayout(Guard3Panel);
        Guard3Panel.setLayout(Guard3PanelLayout);
        Guard3PanelLayout.setHorizontalGroup(
            Guard3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        Guard3PanelLayout.setVerticalGroup(
            Guard3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Guard2PanelLayout = new javax.swing.GroupLayout(Guard2Panel);
        Guard2Panel.setLayout(Guard2PanelLayout);
        Guard2PanelLayout.setHorizontalGroup(
            Guard2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );
        Guard2PanelLayout.setVerticalGroup(
            Guard2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Minion2PanelLayout = new javax.swing.GroupLayout(Minion2Panel);
        Minion2Panel.setLayout(Minion2PanelLayout);
        Minion2PanelLayout.setHorizontalGroup(
            Minion2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        Minion2PanelLayout.setVerticalGroup(
            Minion2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Minion4PanelLayout = new javax.swing.GroupLayout(Minion4Panel);
        Minion4Panel.setLayout(Minion4PanelLayout);
        Minion4PanelLayout.setHorizontalGroup(
            Minion4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        Minion4PanelLayout.setVerticalGroup(
            Minion4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        Minion1Panel.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout Minion1PanelLayout = new javax.swing.GroupLayout(Minion1Panel);
        Minion1Panel.setLayout(Minion1PanelLayout);
        Minion1PanelLayout.setHorizontalGroup(
            Minion1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        Minion1PanelLayout.setVerticalGroup(
            Minion1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Minion3PanelLayout = new javax.swing.GroupLayout(Minion3Panel);
        Minion3Panel.setLayout(Minion3PanelLayout);
        Minion3PanelLayout.setHorizontalGroup(
            Minion3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        Minion3PanelLayout.setVerticalGroup(
            Minion3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Minion5PanelLayout = new javax.swing.GroupLayout(Minion5Panel);
        Minion5Panel.setLayout(Minion5PanelLayout);
        Minion5PanelLayout.setHorizontalGroup(
            Minion5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        Minion5PanelLayout.setVerticalGroup(
            Minion5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Minion6PanelLayout = new javax.swing.GroupLayout(Minion6Panel);
        Minion6Panel.setLayout(Minion6PanelLayout);
        Minion6PanelLayout.setHorizontalGroup(
            Minion6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        Minion6PanelLayout.setVerticalGroup(
            Minion6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Minion1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(Guard2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(Minion6Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(Minion3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Minion4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(Guard1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(BossPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(Guard3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(Minion2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Minion5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BossPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Guard1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Guard3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Minion1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Guard2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Minion6Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Minion2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Minion5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Minion3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Minion4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NextButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CampaignDialog dialog = new CampaignDialog(new javax.swing.JFrame());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.showDialog();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menus.components.AmalgamationPanel BossPanel;
    private menus.components.AmalgamationPanel Guard1Panel;
    private menus.components.AmalgamationPanel Guard2Panel;
    private menus.components.AmalgamationPanel Guard3Panel;
    private menus.components.AmalgamationPanel Minion1Panel;
    private menus.components.AmalgamationPanel Minion2Panel;
    private menus.components.AmalgamationPanel Minion3Panel;
    private menus.components.AmalgamationPanel Minion4Panel;
    private menus.components.AmalgamationPanel Minion5Panel;
    private menus.components.AmalgamationPanel Minion6Panel;
    private acomponent.ALabel NameLabel;
    private acomponent.AButton NextButton;
    private acomponent.AButton PreviousButton;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
