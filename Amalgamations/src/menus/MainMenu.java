package menus;

/**
 * The main menu of the game.
 * 
 * @author Caleb Rush, barely Adam Meanor
 */
public class MainMenu extends javax.swing.JPanel {
    // The currently selected Amalgamation's panel.
    private menus.components.AmalgamationPanel amalgamation;
    private menus.components.StatPanel statPanel;
    private menus.components.LevelPanel levelPanel;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
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

        LogoPanel = new acomponent.AComponent();
        CreateButton = new acomponent.AButton();
        LoadButton = new acomponent.AButton();
        CampaignButton = new acomponent.AButton();
        NetworkButton = new acomponent.AButton();
        AmalPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        LogoPanel.setBackground(new java.awt.Color(255, 255, 255));
        LogoPanel.setImage("res/img/logo.png");
        LogoPanel.setStretchImage(true);

        javax.swing.GroupLayout LogoPanelLayout = new javax.swing.GroupLayout(LogoPanel);
        LogoPanel.setLayout(LogoPanelLayout);
        LogoPanelLayout.setHorizontalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        LogoPanelLayout.setVerticalGroup(
            LogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        CreateButton.setBackground(new java.awt.Color(244, 67, 54));
        CreateButton.setActionListener(e -> {
            // Create a new Amalgamation.
            menus.components.AmalgamationCreatorDialog.create(null);
        });
        CreateButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        CreateButton.setText("Create");

        javax.swing.GroupLayout CreateButtonLayout = new javax.swing.GroupLayout(CreateButton);
        CreateButton.setLayout(CreateButtonLayout);
        CreateButtonLayout.setHorizontalGroup(
            CreateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
        );
        CreateButtonLayout.setVerticalGroup(
            CreateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        LoadButton.setBackground(new java.awt.Color(76, 175, 80));
        LoadButton.setActionListener(e -> {
            // Have the user choose an Amalgamation
            amalgamation.Amalgamation amal =
            menus.components.AmalgamationDialog.showDialog(null);
            if (amal != null) {
                swapAmalgamation(amal);
            }
        }
    );
    LoadButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
    LoadButton.setText("Load");

    javax.swing.GroupLayout LoadButtonLayout = new javax.swing.GroupLayout(LoadButton);
    LoadButton.setLayout(LoadButtonLayout);
    LoadButtonLayout.setHorizontalGroup(
        LoadButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 173, Short.MAX_VALUE)
    );
    LoadButtonLayout.setVerticalGroup(
        LoadButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    CampaignButton.setBackground(new java.awt.Color(33, 150, 243));
    CampaignButton.setActionListener(e -> {
        if (amalgamation == null)
        acomponent.ADialog.createMessageDialog(null,
            "You must load an Amalgamation first!"
        ).showDialog(
            (int)LoadButton.getLocationOnScreen().getX() + LoadButton.getWidth() / 2,
            (int)LoadButton.getLocationOnScreen().getY() + LoadButton.getHeight() / 2
        );
        else
        // Start the campaign with the selected amalgamation.
        menus.components.CampaignDialog.startCampaign(null,
            amalgamation.getAmalgamation());
    });
    CampaignButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
    CampaignButton.setText("Campaign");

    javax.swing.GroupLayout CampaignButtonLayout = new javax.swing.GroupLayout(CampaignButton);
    CampaignButton.setLayout(CampaignButtonLayout);
    CampaignButtonLayout.setHorizontalGroup(
        CampaignButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 173, Short.MAX_VALUE)
    );
    CampaignButtonLayout.setVerticalGroup(
        CampaignButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    NetworkButton.setBackground(new java.awt.Color(66, 66, 66));
    NetworkButton.setActionListener(e -> {
        if (amalgamation == null)
        acomponent.ADialog.createMessageDialog(null,
            "You must load an Amalgamation first!"
        ).showDialog(
            (int)LoadButton.getLocationOnScreen().getX() + LoadButton.getWidth() / 2,
            (int)LoadButton.getLocationOnScreen().getY() + LoadButton.getHeight() / 2
        );
        else
        // Show a new NetworkDialog.
        menus.components.NetworkDialog.createNetworkDialog(
            amalgamation.getAmalgamation())
        .showDialog(
            (int)NetworkButton.getLocationOnScreen().getX() + NetworkButton.getWidth() / 2,
            (int)NetworkButton.getLocationOnScreen().getY() + NetworkButton.getHeight() / 2
        );
    });
    NetworkButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
    NetworkButton.setText("Network");

    javax.swing.GroupLayout NetworkButtonLayout = new javax.swing.GroupLayout(NetworkButton);
    NetworkButton.setLayout(NetworkButtonLayout);
    NetworkButtonLayout.setHorizontalGroup(
        NetworkButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 173, Short.MAX_VALUE)
    );
    NetworkButtonLayout.setVerticalGroup(
        NetworkButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    AmalPanel.setOpaque(false);

    javax.swing.GroupLayout AmalPanelLayout = new javax.swing.GroupLayout(AmalPanel);
    AmalPanel.setLayout(AmalPanelLayout);
    AmalPanelLayout.setHorizontalGroup(
        AmalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 235, Short.MAX_VALUE)
    );
    AmalPanelLayout.setVerticalGroup(
        AmalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 242, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(CreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(CampaignButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(NetworkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(AmalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(LogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(AmalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(CreateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CampaignButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NetworkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AmalPanel;
    private acomponent.AButton CampaignButton;
    private acomponent.AButton CreateButton;
    private acomponent.AButton LoadButton;
    private acomponent.AComponent LogoPanel;
    private acomponent.AButton NetworkButton;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

    // Deletes the currently selected Amalgamation.
    public void delete(int x, int y) {
        // Make sure the user is really sure of their decision.
        if (!acomponent.ADialog.createConfirmDialog(
                null,
                "Are you sure you would like to release " 
                        + amalgamation.getAmalgamation().getName() + "?"
            ).confirmed(x, y))
            return;
        
        if (!acomponent.ADialog.createConfirmDialog(
                null,
                "Are you <i>really</i> sure you would like to release " 
                        + amalgamation.getAmalgamation().getName() + "?"
                + "\n\nYou will <i>never</i> get it back!"
            ).confirmed(x, y))
            return;
        
        if (!acomponent.ADialog.createConfirmDialog(
                null,
                "Hold on a moment. Like, this is some really heavy stuff here.\n\n"
                + "You're talking about releasing " + amalgamation.getAmalgamation().getName() 
                + " into the cold harsh world!\nIt doesn't have any skills or special talents "
                + "that can help it get a job and make a living!\nFor all you know it may not"
                + " even be able to survive out there!\n\nKnowing this, do you <i>still</i> want "
                + "to release " + amalgamation.getAmalgamation().getName() + "?",
                "Yes, I get it", "No"
            ).confirmed(x, y))
            return;
        
        if (!acomponent.ADialog.createConfirmDialog(
                null,
                "Okay, think about it. You created " + amalgamation.getAmalgamation().getName()
                + ", so in a way, you're like its parent.\nThis thing probably won't last long"
                + ", probably get immediately mauled by a pack of wolves.\nBy releasing it"
                + ", you're basically performing an abortion.\n\n" + "Are you sure you "
                + "can live with yourself?",
                "Yes, I am a sociopath who doesn't care about the well being of others",
                "No, I have a heart"
            ).confirmed(x, y))
            return;
        
        // Delete the Amalgamation.
        util.Amalgamations.delete(amalgamation.getAmalgamation().getName());
        
        // Remove the amalgamation.
        levelPanel.translateX(getWidth(), 500);
        statPanel.translateX(getWidth(), 500);
        amalgamation.slideX(-400, 500).then(() -> {
            remove(amalgamation);
            remove(levelPanel);
            remove(statPanel);
                
            acomponent.ADialog.createMessageDialog(null, 
                amalgamation.getAmalgamation().getName() + " is gone forever."
                + " Hope you're happy.", "I am. Mwahaha").showDialog();
            amalgamation = null;
        });
    }
    
    // Animates the components into the panel.
    public void enter() {
        // Disable the buttons so they cannot interrupt the animation.
        CreateButton.setEnabled(false);
        LoadButton.setEnabled(false);
        CampaignButton.setEnabled(false);
        NetworkButton.setEnabled(false);
        
        // Relocate the components to animate them back in.
        CreateButton.translate(CreateButton.getX() - 200, CreateButton.getY(), 0);
        LoadButton.translate(LoadButton.getX() - 400, LoadButton.getY(), 0);
        CampaignButton.translate(CampaignButton.getX() + 400, CampaignButton.getY(), 0);
        NetworkButton.translate(NetworkButton.getX() + 200, NetworkButton.getY(), 0);
        
        LogoPanel.enter(LogoPanel.getX(), LogoPanel.getY(), LogoPanel.getWidth(), 
                LogoPanel.getHeight()).then(() -> {;
            CreateButton.slideX(200, 350);
            LoadButton.slideX(400, 350);
            CampaignButton.slideX(-400, 350);
            NetworkButton.slideX(-200, 350).then(() -> {
                        // Re-enable the buttons.
                        CreateButton.setEnabled(true);
                        LoadButton.setEnabled(true);
                        CampaignButton.setEnabled(true);
                        NetworkButton.setEnabled(true);
                });
        });
    }
    
    // Swaps out the currently selected amalgamation with the new one.
    private void swapAmalgamation(amalgamation.Amalgamation amal) {
        // Check if there is already an amalgaamtion in place.
        if (amalgamation != null) {
            // Remove the amalgamation.
            levelPanel.translateX(getWidth(), 300);
            statPanel.translateX(getWidth(), 300);
            amalgamation.slideX(-400, 300).then(() -> {
                remove(amalgamation);
                remove(levelPanel);
                remove(statPanel);
                amalgamation = null;
                
                // Call the method again now that the amalgamation has been
                // removed.
                swapAmalgamation(amal);
            });
            
            return;
        }
        
        // Create a new panel for the amalagamation.
        amalgamation = new menus.components.AmalgamationPanel(amal);
        amalgamation.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                delete(e.getXOnScreen(), e.getYOnScreen());
            }
        });
        // Add the new panels.
        add(amalgamation);
        amalgamation.setBounds(LoadButton.getX() + LoadButton.getWidth() / 2,
                LoadButton.getY() + LoadButton.getHeight() / 2,
                0, 0);
        amalgamation.translate(AmalPanel.getX(), AmalPanel.getY(), 400);
        amalgamation.transform(AmalPanel.getWidth(), AmalPanel.getHeight(),
                400).then(() -> {
                    statPanel = new menus.components.StatPanel(amal);
                    add(statPanel);
                    statPanel.setBounds(amalgamation.getBounds());
                    statPanel.setSize(statPanel.getWidth()/2, 
                            statPanel.getHeight());
                    statPanel.validate();
                    statPanel.slideX(amalgamation.getWidth() + 10, 250);
                    levelPanel = new menus.components.LevelPanel(amal);
                    add(levelPanel);
                    levelPanel.setBounds(amalgamation.getBounds());
                    levelPanel.setSize(levelPanel.getWidth(), 
                            levelPanel.getHeight()/3);
                    levelPanel.validate();
                    levelPanel.slideX(amalgamation.getWidth() + 
                            statPanel.getWidth() + 20, 250);
                    levelPanel.transform(levelPanel.getWidth() + 150 , 
                            levelPanel.getHeight() , 250);
                });
    }
    
    public static void main(String[] args) {
        javax.swing.JFrame window = new javax.swing.JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        MainMenu menu = new MainMenu();
        window.add(menu);
        
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        menu.enter();
    }
}
