package tool;

/**
 *
 * @author Caleb Rush
 */
public class CampaignLevelEditor extends javax.swing.JFrame {
    
    // Shows the user a dialog to choose an Arm to add to the list of Arms.
    private void addArm() {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(this, true);
        // Add a cancel button to the dialog.
        dialog.addButton("Cancel", e -> dialog.hideDialog());
        // Add a PartListPanel to the dialog.
        menus.components.PartListPanel partList = 
                new menus.components.PartListPanel(util.Parts.TYPE_ARM);
        dialog.add(partList);
        // Have the part set when the user clicks it.
        partList.setPartChangeListener(part -> {
            // Check if the list already has the part.
            for (int i = 0; i < ArmsList.getModel().getSize(); i++)
                if (part.getName().equals(((amalgamation.parts.Arm)
                        ArmsList.getModel().getElementAt(i)).getName())) {
                    dialog.hideDialog();
                    return;
                }
            
            // Add the part to the list.
            ((javax.swing.DefaultListModel)ArmsList.getModel())
                        .addElement(part);
            dialog.hideDialog();
        });
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }
    
    // Shows the user a dialog to choose an Arm to add to the list of Bodies.
    private void addBody() {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(this, true);
        // Add a cancel button to the dialog.
        dialog.addButton("Cancel", e -> dialog.hideDialog());
        // Add a PartListPanel to the dialog.
        menus.components.PartListPanel partList = 
                new menus.components.PartListPanel(util.Parts.TYPE_BODY);
        dialog.add(partList);
        // Have the part set when the user clicks it.
        partList.setPartChangeListener(part -> {
            // Check if the list already has the part.
            for (int i = 0; i < BodyList.getModel().getSize(); i++)
                if (part.getName().equals(((amalgamation.parts.Body)
                        BodyList.getModel().getElementAt(i)).getName())) {
                    dialog.hideDialog();
                    return;
                }
            
            // Add the part to the list.
            ((javax.swing.DefaultListModel)BodyList.getModel())
                        .addElement(part);
            dialog.hideDialog();
        });
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }
    
    // Shows the user a dialog to choose an Arm to add to the list of Arms.
    private void addHead() {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(this, true);
        // Add a cancel button to the dialog.
        dialog.addButton("Cancel", e -> dialog.hideDialog());
        // Add a PartListPanel to the dialog.
        menus.components.PartListPanel partList = 
                new menus.components.PartListPanel(util.Parts.TYPE_HEAD);
        dialog.add(partList);
        // Have the part set when the user clicks it.
        partList.setPartChangeListener(part -> {
            // Check if the list already has the part.
            for (int i = 0; i < HeadsList.getModel().getSize(); i++)
                if (part.getName().equals(((amalgamation.parts.Head)
                        HeadsList.getModel().getElementAt(i)).getName())) {
                    dialog.hideDialog();
                    return;
                }
            
            // Add the part to the list.
            ((javax.swing.DefaultListModel)HeadsList.getModel())
                        .addElement(part);
            dialog.hideDialog();
        });
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }
    
    // Shows the user a dialog to choose an Arm to add to the list of Legs.
    private void addLeg() {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(this, true);
        // Add a cancel button to the dialog.
        dialog.addButton("Cancel", e -> dialog.hideDialog());
        // Add a PartListPanel to the dialog.
        menus.components.PartListPanel partList = 
                new menus.components.PartListPanel(util.Parts.TYPE_LEG);
        dialog.add(partList);
        // Have the part set when the user clicks it.
        partList.setPartChangeListener(part -> {
            // Check if the list already has the part.
            for (int i = 0; i < LegsList.getModel().getSize(); i++)
                if (part.getName().equals(((amalgamation.parts.Leg)
                        LegsList.getModel().getElementAt(i)).getName())) {
                    dialog.hideDialog();
                    return;
                }
            
            // Add the part to the list.
            ((javax.swing.DefaultListModel)LegsList.getModel())
                        .addElement(part);
            dialog.hideDialog();
        });
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }

    // Checks the fields for valid input.
    private boolean checkValidity() {
        if ("".equals(NameField.getText())) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "The level must have a name.",
                    "No name",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        try {
            int level = Integer.parseInt(MinionsLevelField.getText());
            if (level < 1 || level > 100) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "The minions' level must be between 1 and 100.",
                    "Invalid Minions Level",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "The minions' level must be a valid integer.",
                "Invalid Minions Level",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        try {
            int level = Integer.parseInt(GuardsLevelField.getText());
            if (level < 1 || level > 100) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "The gaurds' level must be between 1 and 100.",
                    "Invalid Guards Level",
                    javax.swing.JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "The guards' level must be a valid integer.",
                "Invalid Guards Level",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (BossPanel.getAmalgamation() == null) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "You must choose a boss for the level.",
                "No Boss Chosen",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (ArmsList.getModel().getSize() == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "You must have at least one Arm.",
                "No Arms",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (BodyList.getModel().getSize() == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "You must have at least one Body.",
                "No Bodies",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (HeadsList.getModel().getSize() == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "You must have at least one Head.",
                "No Heads",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        if (LegsList.getModel().getSize() == 0) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "You must have at least one Leg.",
                "No Legs",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        
        return true;
    }
    
    // Brings up a dialog for the user to select an Amalgamation to act as the
    // boss for the level.
    private void chooseBoss() {
        amalgamation.Amalgamation amalgamation = 
                menus.components.AmalgamationDialog.showDialog(this);
        if (amalgamation != null) {
            BossPanel.setAmalgamation(amalgamation);
            BossStat.setAmalgamation(amalgamation);
            AbilPanel1.setAbility(amalgamation.getAbilities()[0]);
            AbilPanel2.setAbility(amalgamation.getAbilities()[1]);
            AbilPanel3.setAbility(amalgamation.getAbilities()[2]);
            AbilPanel4.setAbility(amalgamation.getAbilities()[3]);
            repaint();
        }
    }
    
    // Deletes the currently selected level.
    private void deleteLevel() {
        // Ensure an item is selected.
        if (LevelList.getSelectedIndex() == -1)
            return;
        
        // Confirm that the user wishes to delete the level.
        if (javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you "
                + "would like to delete " + LevelList.getSelectedValue() + "?")
                == javax.swing.JOptionPane.YES_OPTION) {
            // Delete the level and remove it from the list.
            util.CampaignLevels.delete(LevelList.getSelectedValue().toString());
            ((javax.swing.DefaultListModel)LevelList.getModel())
                    .removeElementAt(LevelList.getSelectedIndex());
            setComponentsEnabled(false);
        }
    }
    
    // Loads the currently selected level.
    private void loadLevel() {
        // Check if a level is selected.
        if (LevelList.getSelectedIndex() == -1)
            return;
        
        // Attempt to load the level.
        campaign.CampaignLevel level;
        try {
            level = util.CampaignLevels.loadCampaignLevel(
                    LevelList.getSelectedValue().toString());
        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Could not load the selected Level!\n\n"
                        + "The Level's file is either corrupted or the Level is\n"
                        + "incompatible with the newest version of the class.",
                "No Legs",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        // Load the level's values into the fields.
        setComponentsEnabled(true);
        NameField.setText(level.getName());
        MinionsLevelField.setText("" + level.getMinionsLevel());
        GuardsLevelField.setText("" + level.getGuardsLevel());
        BossPanel.setAmalgamation(level.getBoss());
        BossStat.setAmalgamation(level.getBoss());
        AbilPanel1.setAbility(level.getBoss().getAbilities()[0]);
        AbilPanel2.setAbility(level.getBoss().getAbilities()[1]);
        AbilPanel3.setAbility(level.getBoss().getAbilities()[2]);
        AbilPanel4.setAbility(level.getBoss().getAbilities()[3]);
        for (amalgamation.parts.Arm arm : level.getArms())
            ((javax.swing.DefaultListModel)ArmsList.getModel()).addElement(arm);
        for (amalgamation.parts.Body body : level.getBodies())
            ((javax.swing.DefaultListModel)BodyList.getModel()).addElement(body);
        for (amalgamation.parts.Head head : level.getHeads())
            ((javax.swing.DefaultListModel)HeadsList.getModel()).addElement(head);
        for (amalgamation.parts.Leg leg : level.getLegs())
            ((javax.swing.DefaultListModel)LegsList.getModel()).addElement(leg);
    }
    
    // Clears the components and makes them enabled.
    private void newLevel() {
        setComponentsEnabled(true);
    }
    
    // Attempts to create and save the Campaign level using the information in 
    // the fields.
    private void save() {
        // Check if the fields are valid.
        if (!checkValidity())
            return;
        
        // Try to save the new CampaignLevel object.
        try {
            util.CampaignLevels.saveCampaignLevel(
                    new campaign.CampaignLevel(
                            NameField.getText(), 
                            Integer.parseInt(MinionsLevelField.getText()), 
                            5, 
                            Integer.parseInt(GuardsLevelField.getText()), 
                            5, 
                            BossPanel.getAmalgamation(), 
                            /**
                             * I deeply apologize for the absurdity of the
                             * following lines.
                             * 
                             * Basically, the Lists' models are being converted
                             * to DefaultListModels so that the elements method
                             * can be called which returns an Enumeration of all
                             * the elements in the list. Then, the list method
                             * from the Collections class is called to convert
                             * the Enumeration to a List. Finally, the List
                             * is converted to an array using the toArray method
                             * in List.
                             */
                            java.util.Collections.list(((javax.swing.DefaultListModel<amalgamation.parts.Arm>)ArmsList.getModel()).elements()).toArray(new amalgamation.parts.Arm[0]), 
                            java.util.Collections.list(((javax.swing.DefaultListModel<amalgamation.parts.Body>)BodyList.getModel()).elements()).toArray(new amalgamation.parts.Body[0]),
                            java.util.Collections.list(((javax.swing.DefaultListModel<amalgamation.parts.Head>)HeadsList.getModel()).elements()).toArray(new amalgamation.parts.Head[0]), 
                            java.util.Collections.list(((javax.swing.DefaultListModel<amalgamation.parts.Leg>)LegsList.getModel()).elements()).toArray(new amalgamation.parts.Leg[0])
                    )
            );
            ((javax.swing.DefaultListModel)LevelList.getModel())
                    .addElement(NameField.getText());
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Level was successfully saved!",
                "Save Successful",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(
                this,
                "Failed to save the Campaign Level!\n\n"
                        + "Please ensure the res/clvl/ directory exists!",
                "Save Failed",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    // Sets all of the components enabled status and clears them.
    private void setComponentsEnabled(boolean enabled) {
        NameField.setText("");
        NameField.setEnabled(enabled);
        MinionsLevelField.setText("");
        MinionsLevelField.setEnabled(enabled);
        GuardsLevelField.setText("");
        GuardsLevelField.setEnabled(enabled);
        SaveButton.setEnabled(enabled);
        BossPanel.setAmalgamation(null);
        BossStat.removeAmalgamation();
        AbilPanel1.setAbility(null);
        AbilPanel2.setAbility(null);
        AbilPanel3.setAbility(null);
        AbilPanel4.setAbility(null);
        ChooseBossButton.setEnabled(enabled);
        AddArmButton.setEnabled(enabled);
        AddBodyButton.setEnabled(enabled);
        AddHeadButton.setEnabled(enabled);
        AddLegButton.setEnabled(enabled);
        ArmsList.setModel(new javax.swing.DefaultListModel<>());
        BodyList.setModel(new javax.swing.DefaultListModel<>());
        HeadsList.setModel(new javax.swing.DefaultListModel<>());
        LegsList.setModel(new javax.swing.DefaultListModel<>());
        repaint();
    }
    
    // <editor-fold desc="GUI Code" defaultstate="collapsed" >
    /**
     * Creates new form CampaignLevelEditor
     */
    public CampaignLevelEditor() {
        initComponents();
        setLocationRelativeTo(null);
        setComponentsEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        LevelList = new javax.swing.JList();
        NewLevelButton = new javax.swing.JButton();
        EditorPanel = new javax.swing.JPanel();
        jpanel = new javax.swing.JPanel();
        NameField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        MinionsLevelField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        GuardsLevelField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ArmsList = new javax.swing.JList();
        AddArmButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        BodyList = new javax.swing.JList();
        AddBodyButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        AddHeadButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        HeadsList = new javax.swing.JList();
        jPanel7 = new javax.swing.JPanel();
        AddLegButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        LegsList = new javax.swing.JList();
        SaveButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        BossPanel = new menus.components.AmalgamationPanel();
        ChooseBossButton = new javax.swing.JButton();
        AbilPanel3 = new menus.components.AbilityPanel();
        AbilPanel4 = new menus.components.AbilityPanel();
        AbilPanel1 = new menus.components.AbilityPanel();
        AbilPanel2 = new menus.components.AbilityPanel();
        BossStat = new menus.components.StatPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LevelList.setModel(new javax.swing.DefaultListModel<String>());
        LevelList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        for (String s : util.CampaignLevels.getCampaignLevelNames())
        ((javax.swing.DefaultListModel)LevelList.getModel()).addElement(s);
        LevelList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LevelListKeyPressed(evt);
            }
        });
        LevelList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LevelListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LevelList);

        NewLevelButton.setText("New Level");
        NewLevelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewLevelButtonActionPerformed(evt);
            }
        });

        EditorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Name"));

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Minion LV"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MinionsLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MinionsLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Guard LV"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GuardsLevelField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(GuardsLevelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Arms"));

        ArmsList.setModel(new javax.swing.DefaultListModel<amalgamation.parts.Arm>());
        ArmsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ArmsList.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list,
                Object object,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
                super.getListCellRendererComponent(list, object, index, isSelected, cellHasFocus);
                setText(((amalgamation.parts.Arm)object).getName());
                return this;
            }
        });
        ArmsList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ArmsListKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(ArmsList);

        AddArmButton.setText("Add");
        AddArmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddArmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddArmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddArmButton)
                .addGap(0, 0, 0))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bodies"));

        BodyList.setModel(new javax.swing.DefaultListModel<amalgamation.parts.Body>());
        BodyList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        BodyList.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list,
                Object object,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
                super.getListCellRendererComponent(list, object, index, isSelected, cellHasFocus);
                setText(((amalgamation.parts.Body)object).getName());
                return this;
            }});
            BodyList.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    BodyListKeyPressed(evt);
                }
            });
            jScrollPane3.setViewportView(BodyList);

            AddBodyButton.setText("Add");
            AddBodyButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddBodyButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AddBodyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(AddBodyButton)
                    .addGap(0, 0, 0))
            );

            jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Heads"));

            AddHeadButton.setText("Add");
            AddHeadButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddHeadButtonActionPerformed(evt);
                }
            });

            HeadsList.setModel(new javax.swing.DefaultListModel<amalgamation.parts.Head>());
            HeadsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            HeadsList.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
                @Override
                public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list,
                    Object object,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, object, index, isSelected, cellHasFocus);
                    setText(((amalgamation.parts.Head)object).getName());
                    return this;
                }});
                HeadsList.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        HeadsListKeyPressed(evt);
                    }
                });
                jScrollPane5.setViewportView(HeadsList);

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                    jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddHeadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                jPanel6Layout.setVerticalGroup(
                    jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddHeadButton))
                );

                jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Legs"));

                AddLegButton.setText("Add");
                AddLegButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        AddLegButtonActionPerformed(evt);
                    }
                });

                LegsList.setModel(new javax.swing.DefaultListModel<amalgamation.parts.Leg>());
                LegsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                LegsList.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
                    @Override
                    public java.awt.Component getListCellRendererComponent(
                        javax.swing.JList<?> list,
                        Object object,
                        int index,
                        boolean isSelected,
                        boolean cellHasFocus) {
                        super.getListCellRendererComponent(list, object, index, isSelected, cellHasFocus);
                        setText(((amalgamation.parts.Leg)object).getName());
                        return this;
                    }});
                    LegsList.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                            LegsListKeyPressed(evt);
                        }
                    });
                    jScrollPane6.setViewportView(LegsList);

                    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                    jPanel7.setLayout(jPanel7Layout);
                    jPanel7Layout.setHorizontalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AddLegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    );
                    jPanel7Layout.setVerticalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(AddLegButton))
                    );

                    SaveButton.setText("Save");
                    SaveButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            SaveButtonActionPerformed(evt);
                        }
                    });

                    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Boss"));

                    javax.swing.GroupLayout BossPanelLayout = new javax.swing.GroupLayout(BossPanel);
                    BossPanel.setLayout(BossPanelLayout);
                    BossPanelLayout.setHorizontalGroup(
                        BossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 320, Short.MAX_VALUE)
                    );
                    BossPanelLayout.setVerticalGroup(
                        BossPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                    );

                    ChooseBossButton.setText("Choose Boss");
                    ChooseBossButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            ChooseBossButtonActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                    jPanel8.setLayout(jPanel8Layout);
                    jPanel8Layout.setHorizontalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(AbilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AbilPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ChooseBossButton, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addComponent(BossPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(BossStat, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addComponent(AbilPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(AbilPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
                    );
                    jPanel8Layout.setVerticalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BossPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BossStat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(AbilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AbilPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AbilPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ChooseBossButton))
                                .addComponent(AbilPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                    );

                    javax.swing.GroupLayout EditorPanelLayout = new javax.swing.GroupLayout(EditorPanel);
                    EditorPanel.setLayout(EditorPanelLayout);
                    EditorPanelLayout.setHorizontalGroup(
                        EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EditorPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(EditorPanelLayout.createSequentialGroup()
                                    .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(EditorPanelLayout.createSequentialGroup()
                                    .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );
                    EditorPanelLayout.setVerticalGroup(
                        EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EditorPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EditorPanelLayout.createSequentialGroup()
                                    .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(EditorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SaveButton)
                                    .addGap(0, 1, Short.MAX_VALUE))
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                    );

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addComponent(NewLevelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EditorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                    );
                    layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EditorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(NewLevelButton)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    pack();
                }// </editor-fold>//GEN-END:initComponents

    private void NewLevelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewLevelButtonActionPerformed
        newLevel();
    }//GEN-LAST:event_NewLevelButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        save();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ChooseBossButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseBossButtonActionPerformed
        chooseBoss();
    }//GEN-LAST:event_ChooseBossButtonActionPerformed

    private void AddArmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddArmButtonActionPerformed
        addArm();
    }//GEN-LAST:event_AddArmButtonActionPerformed

    private void AddBodyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBodyButtonActionPerformed
        addBody();
    }//GEN-LAST:event_AddBodyButtonActionPerformed

    private void AddHeadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddHeadButtonActionPerformed
        addHead();
    }//GEN-LAST:event_AddHeadButtonActionPerformed

    private void AddLegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLegButtonActionPerformed
        addLeg();
    }//GEN-LAST:event_AddLegButtonActionPerformed

    private void LevelListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LevelListKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
            deleteLevel();
    }//GEN-LAST:event_LevelListKeyPressed

    private void ArmsListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ArmsListKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && ArmsList.getSelectedIndex() != -1)
            ((javax.swing.DefaultListModel)ArmsList.getModel()).removeElementAt(ArmsList.getSelectedIndex());
    }//GEN-LAST:event_ArmsListKeyPressed

    private void BodyListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BodyListKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && BodyList.getSelectedIndex() != -1)
            ((javax.swing.DefaultListModel)BodyList.getModel()).removeElementAt(BodyList.getSelectedIndex());
    }//GEN-LAST:event_BodyListKeyPressed

    private void HeadsListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HeadsListKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && HeadsList.getSelectedIndex() != -1)
            ((javax.swing.DefaultListModel)HeadsList.getModel()).removeElementAt(HeadsList.getSelectedIndex());
    }//GEN-LAST:event_HeadsListKeyPressed

    private void LegsListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LegsListKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE && LegsList.getSelectedIndex() != -1)
            ((javax.swing.DefaultListModel)LegsList.getModel()).removeElementAt(LegsList.getSelectedIndex());
    }//GEN-LAST:event_LegsListKeyPressed

    private void LevelListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LevelListValueChanged
        loadLevel();
    }//GEN-LAST:event_LevelListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CampaignLevelEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menus.components.AbilityPanel AbilPanel1;
    private menus.components.AbilityPanel AbilPanel2;
    private menus.components.AbilityPanel AbilPanel3;
    private menus.components.AbilityPanel AbilPanel4;
    private javax.swing.JButton AddArmButton;
    private javax.swing.JButton AddBodyButton;
    private javax.swing.JButton AddHeadButton;
    private javax.swing.JButton AddLegButton;
    private javax.swing.JList ArmsList;
    private javax.swing.JList BodyList;
    private menus.components.AmalgamationPanel BossPanel;
    private menus.components.StatPanel BossStat;
    private javax.swing.JButton ChooseBossButton;
    private javax.swing.JPanel EditorPanel;
    private javax.swing.JTextField GuardsLevelField;
    private javax.swing.JList HeadsList;
    private javax.swing.JList LegsList;
    private javax.swing.JList LevelList;
    private javax.swing.JTextField MinionsLevelField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton NewLevelButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel jpanel;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
