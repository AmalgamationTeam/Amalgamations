package menus.components;

import amalgamation.Amalgamation;

import campaign.CampaignLevel;
import java.awt.Color;

import java.awt.Rectangle;

import util.CampaignLevels;

/**
 * A CampaignDialog allows the player to play all of the CampaignLevels in
 * the res/clvl/ directory in alphabetical order.
 * 
 * @author CalebRush
 */
public class CampaignDialog extends acomponent.ADialog {
    // The Amalgamation the player will control in Battles.
    private final Amalgamation  playerAmalgamation;
    // The list of CampaignLevel names.
    private final String[]      levelNames;
    // The current level index.
    private int                 currentIndex;
    // The current level.
    private CampaignLevel       currentLevel;
    // The bounds of all the AmalgamationPanels.
    private Rectangle           minion1Bounds;
    private Rectangle           minion2Bounds;
    private Rectangle           minion3Bounds;
    private Rectangle           minion4Bounds;
    private Rectangle           minion5Bounds;
    private Rectangle           minion6Bounds;
    private Rectangle           guard1Bounds;
    private Rectangle           guard2Bounds;
    private Rectangle           guard3Bounds;
    private Rectangle           bossBounds;
    // The bounds of the buttons.
    private Rectangle           previousBounds;
    private Rectangle           exitBounds;
    private Rectangle           nextBounds;

    // Called when the dialog is first displayed. Animates beginning values
    // as appropriate.
    private void animateIn() {
        setComponentsEnabled(false);
        // Animate the NameLabel in.
        NameLabel.setText(currentLevel.getName());
        NameLabel.setLocation(getWidth(), NameLabel.getY());
        NameLabel.translateX(0, 500)
                // Then animate the first level in.
                .then(this::animateLevelIn);
    }
    
    // Sets up the buttons and animates them in.
    private void animateButtonsIn() {
        // Check if there is a previous level.
        if (currentIndex > 0)
            PreviousButton.enter(previousBounds);
        // Check if there is a next level and the player has unlocked it.
        if (currentIndex < levelNames.length - 1 && currentLevel.isBossDefeated())
            NextButton.enter(nextBounds);
        // Animate the exit button in.
        ExitButton.enter(exitBounds).then(() -> setComponentsEnabled(true));
    }
    
    // Animates the buttons out.
    private void animateButtonsOut() {
        setComponentsEnabled(false);
        
        PreviousButton.exit();
        NextButton.exit();
        ExitButton.exit();
    }
    
    // Animates the current level in.
    private void animateLevelIn() {
        // Set the panels.
        
        setAmalgamations();
        // Animate the boss in.
        BossPanel.enter(bossBounds).then(() -> {
            // Animate the guards in.
            Guard1Panel.setLocation(
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard1Panel.getWidth()) / 2,
                    BossPanel.getY() + (BossPanel.getHeight() 
                            - Guard1Panel.getWidth()) / 2
            );
            Guard2Panel.setLocation(
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard2Panel.getWidth()) / 2,
                    BossPanel.getY() + (BossPanel.getHeight() 
                            - Guard2Panel.getWidth()) / 2
            );
            Guard3Panel.setLocation(
                    BossPanel.getX() + (BossPanel.getWidth() 
                            - Guard3Panel.getWidth()) / 2,
                    BossPanel.getY() + (BossPanel.getHeight() 
                            - Guard3Panel.getWidth()) / 2
            );
            Guard1Panel.translate((int)guard1Bounds.getX(), 
                    (int)guard1Bounds.getY(), 250);
            Guard2Panel.translate((int)guard2Bounds.getX(), 
                    (int)guard2Bounds.getY(), 250);
            Guard3Panel.translate((int)guard3Bounds.getX(), 
                    (int)guard3Bounds.getY(), 250).then(() -> {
                        // Animate the minions in.
                        Minion1Panel.setLocation(
                            BossPanel.getX() + (BossPanel.getWidth() 
                                    - Minion1Panel.getWidth()) / 2,
                            BossPanel.getY() + (BossPanel.getHeight() 
                                    - Minion1Panel.getWidth()) / 2
                        );
                        Minion2Panel.setLocation(
                            BossPanel.getX() + (BossPanel.getWidth() 
                                    - Minion2Panel.getWidth()) / 2,
                            BossPanel.getY() + (BossPanel.getHeight() 
                                    - Minion2Panel.getWidth()) / 2
                        );
                        Minion3Panel.setLocation(
                            BossPanel.getX() + (BossPanel.getWidth() 
                                    - Minion3Panel.getWidth()) / 2,
                            BossPanel.getY() + (BossPanel.getHeight() 
                                    - Minion3Panel.getWidth()) / 2
                        );
                        Minion4Panel.setLocation(
                            BossPanel.getX() + (BossPanel.getWidth() 
                                    - Minion4Panel.getWidth()) / 2,
                            BossPanel.getY() + (BossPanel.getHeight() 
                                    - Minion4Panel.getWidth()) / 2
                        );
                        Minion5Panel.setLocation(
                            BossPanel.getX() + (BossPanel.getWidth() 
                                    - Minion5Panel.getWidth()) / 2,
                            BossPanel.getY() + (BossPanel.getHeight() 
                                    - Minion5Panel.getWidth()) / 2
                        );
                        Minion6Panel.setLocation(
                            BossPanel.getX() + (BossPanel.getWidth() 
                                    - Minion6Panel.getWidth()) / 2,
                            BossPanel.getY() + (BossPanel.getHeight() 
                                    - Minion6Panel.getWidth()) / 2
                        );
                        Minion1Panel.translate((int)minion1Bounds.getX(), 
                            (int)minion1Bounds.getY(), 250);
                        Minion2Panel.translate((int)minion2Bounds.getX(), 
                            (int)minion2Bounds.getY(), 250);
                        Minion3Panel.translate((int)minion3Bounds.getX(), 
                            (int)minion3Bounds.getY(), 250);
                        Minion4Panel.translate((int)minion4Bounds.getX(), 
                            (int)minion4Bounds.getY(), 250);
                        Minion5Panel.translate((int)minion5Bounds.getX(), 
                            (int)minion5Bounds.getY(), 250);
                        Minion6Panel.translate((int)minion6Bounds.getX(), 
                            (int)minion6Bounds.getY(), 250)
                                // Then animate the buttons in.
                                .then(this::animateButtonsIn);
                    });
        });     
    }
    
    private void animateLevelOut() {
        // Animate each panel off of the screen.
        BossPanel.translateY(-BossPanel.getHeight(), 250);
        Guard1Panel.translateX(-Guard1Panel.getWidth(), 250);
        Guard2Panel.exit().then(() -> Guard2Panel.setBounds(-200, 0, 
                (int)guard2Bounds.getWidth(), (int)guard2Bounds.getHeight()));
        Guard3Panel.translateX(getWidth(), 250);
        Minion1Panel.translateX(-Minion1Panel.getWidth(), 250);
        Minion2Panel.translateX(-Minion2Panel.getWidth(), 250);
        Minion3Panel.translateY(getHeight(), 250);
        Minion4Panel.translateY(getHeight(), 250);
        Minion5Panel.translateX(getWidth(), 250);
        Minion6Panel.translateX(getWidth(), 250).then(() -> {
            // Remove the Amalgamations fromt the panels.
            BossPanel.setAmalgamation(null);
            Guard1Panel.setAmalgamation(null);
            Guard2Panel.setAmalgamation(null);
            Guard3Panel.setAmalgamation(null);
            Minion1Panel.setAmalgamation(null);
            Minion2Panel.setAmalgamation(null);
            Minion3Panel.setAmalgamation(null);
            Minion4Panel.setAmalgamation(null);
            Minion5Panel.setAmalgamation(null);
            Minion6Panel.setAmalgamation(null);
        });
    }
    
    // Confirms that the user wants to battle the boss and initiates the
    // battle.
    private void battleBoss() {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(null, true);
        // Add a Confirm button.
        dialog.addButton("Bring It!", e -> {
                // Check if the minion was already defeated.
                boolean alreadyDefeated = currentLevel.isBossDefeated();
                // Close the dialog.
                dialog.hideDialog();
                // Initiate the battle.
                currentLevel.battleBoss(playerAmalgamation);
                // Check if the minion was defeated for the first time.
                if (!alreadyDefeated && currentLevel.isBossDefeated()){
                    // See if the next level can be unlocked.
                    setDefeated();
                    unlockNextLevel();
                }
            }, 
                new java.awt.Color(76,175,80));
        // Add a Cancel button.
        dialog.addButton("Uhh... Hold On a Minute", e -> dialog.hideDialog(), 
                new java.awt.Color(244,67,54));
        // Add the message to the dialog.
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, 
                javax.swing.BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        javax.swing.JLabel message = new javax.swing.JLabel(
                "<html>Would you like to take on " 
                        + currentLevel.getBoss().getName() 
                        + "?<br><br></html>");
        message.setFont(new java.awt.Font("Berlin Sans FB Demi", 
                java.awt.Font.BOLD, 18));
        panel.add(message);
        // Add a component displaying the Amalgamation.
        menus.components.AmalgamationPanel aPanel = 
                new menus.components.AmalgamationPanel(
                    currentLevel.getBoss());
        // Remove the panel's mouse listener.
        aPanel.removeMouseListener(aPanel.getMouseListeners()[0]);
        panel.add(aPanel);
        dialog.add(panel);
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }
    
    // Confirms that the user wants to battle the guard and initiates the
    // battle.
    private void battleGuard(int index) {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(null, true);
        // Add a Confirm button.
        dialog.addButton("Bring It!", e -> {
                // Check if the minion was already defeated.
                boolean alreadyDefeated = currentLevel.isGuardDefeated(index);
                // Close the dialog.
                dialog.hideDialog();
                // Initiate the battle.
                currentLevel.battleGuard(index, playerAmalgamation);
               
                // Check if the minion was defeated for the first time.
                if (!alreadyDefeated && currentLevel.isGuardDefeated(index)){
                    // See if the boss can be unlocked.
                    setDefeated();
                    unlockBoss();
                }
            }, 
                new java.awt.Color(76,175,80));
        // Add a Cancel button.
        dialog.addButton("Uhh... Hold On a Minute", e -> dialog.hideDialog(), 
                new java.awt.Color(244,67,54));
        // Add the message to the dialog.
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, 
                javax.swing.BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        javax.swing.JLabel message = new javax.swing.JLabel(
                "<html>Would you like to take on " 
                        + currentLevel.getGuards()[index].getName() 
                        + "?<br><br></html>");
        message.setFont(new java.awt.Font("Berlin Sans FB Demi", 
                java.awt.Font.BOLD, 18));
        panel.add(message);
        // Add a component displaying the Amalgamation.
        menus.components.AmalgamationPanel aPanel = 
                new menus.components.AmalgamationPanel(
                    currentLevel.getGuards()[index]);
        // Remove the panel's mouse listener.
        aPanel.removeMouseListener(aPanel.getMouseListeners()[0]);
        panel.add(aPanel);
        dialog.add(panel);
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }
    
    // Confirms that the user wants to battle the minion and initiates the
    // battle.
    private void battleMinion(int index) {
        // Create a new dialog.
        acomponent.ADialog dialog = new acomponent.ADialog(null, true);
        // Add a Confirm button.
        dialog.addButton("Bring It!", e -> {
                // Check if the minion was already defeated.
                boolean alreadyDefeated = currentLevel.isMinionDefeated(index);
                // Close the dialog.
                dialog.hideDialog();
                // Initiate the battle.
                currentLevel.battleMinion(index, playerAmalgamation);
                // Check if the minion was defeated for the first time.
               
                    
                
                if (!alreadyDefeated && currentLevel.isMinionDefeated(index)) {
                    // See if the guards can be unlocked.
                    setDefeated();
                    unlockGuards();
                }
            }, 
                new java.awt.Color(76,175,80));
        // Add a Cancel button.
        dialog.addButton("Uhh... Hold On a Minute", e -> dialog.hideDialog(), 
                new java.awt.Color(244,67,54));
        // Add the message to the dialog.
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, 
                javax.swing.BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        javax.swing.JLabel message = new javax.swing.JLabel(
                "<html>Would you like to take on " 
                        + currentLevel.getMinions()[index].getName() 
                        + "?<br><br></html>");
        message.setFont(new java.awt.Font("Berlin Sans FB Demi", 
                java.awt.Font.BOLD, 18));
        panel.add(message);
        // Add a component displaying the Amalgamation.
        menus.components.AmalgamationPanel aPanel = 
                new menus.components.AmalgamationPanel(
                    currentLevel.getMinions()[index]);
        // Remove the panel's mouse listener.
        aPanel.removeMouseListener(aPanel.getMouseListeners()[0]);
        panel.add(aPanel);
        dialog.add(panel);
        // Show the dialog.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.showDialog();
    }
    
    // Saves the current level and closes the dialog.
    private void exitCampaign() {
        // Save the current level.
        save();
        // Close the dialog.
        hideDialog();
    }
    
    // Moves the panels out of sight to be animated in later.
    private void hidePanels() {
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
        previousBounds = PreviousButton.getBounds();
        exitBounds = ExitButton.getBounds();
        nextBounds = NextButton.getBounds();
        // Move the panels out of sight.
        Minion1Panel.setLocation(-200, 0);
        Minion2Panel.setLocation(-200, 0);
        Minion3Panel.setLocation(-200, 0);
        Minion4Panel.setLocation(-200, 0);
        Minion5Panel.setLocation(-200, 0);
        Minion6Panel.setLocation(-200, 0);
        Guard1Panel.setLocation(-200, 0);
        Guard2Panel.setLocation(-200, 0);
        Guard3Panel.setLocation(-200, 0);
        BossPanel.setLocation(-200, 0);
        NameLabel.setLocation(getWidth(), NameLabel.getY());
        PreviousButton.setLocation(-200, 0);
        ExitButton.setLocation(-200, 0);
        NextButton.setLocation(-200, 0);
    }
    
    // Returns to the previous level.
    private void previousLevel()  {
        // Save the current level.
        save();
        
        // Animate the name out to the right.
        NameLabel.translateX(getWidth(), 150).then(() -> {
            try {
                // Set the new level.
                currentIndex--;
                currentLevel = CampaignLevels.loadCampaignLevel(
                    levelNames[currentIndex]);
            } catch (java.io.IOException e) {
                // Show an error message.
                createMessageDialog(null,
                        "Could not load the previous stage! Please ensure the\n"
                        + "res/clvl directory has not been tampered with."
                ).showDialog();
            }
            
            // Animate the new level in.
            NameLabel.setText(currentLevel.getName());
            NameLabel.setLocation(-NameLabel.getWidth(), NameLabel.getY());
            NameLabel.translateX(0, 150).then(this::animateLevelIn);
        });
        
        // Animate the level out.
        animateButtonsOut();
        animateLevelOut();
    }
    
    // Proceeeds to the next level.
    private void nextLevel()  {
        // Save the current level.
        save();
        
        // Animate the name out to the right.
        NameLabel.translateX(-NameLabel.getWidth(), 150).then(() -> {
            try {
                // Set the new level.
                currentIndex++;
                currentLevel = CampaignLevels.loadCampaignLevel(
                    levelNames[currentIndex]);
            } catch (java.io.IOException e) {
                // Show an error message.
                createMessageDialog(null,
                        "Could not load the previous stage! Please ensure the\n"
                        + "res/clvl directory has not been tampered with."
                ).showDialog();
            }
            
            // Animate the new level in.
            NameLabel.setText(currentLevel.getName());
            NameLabel.setLocation(getWidth(), NameLabel.getY());
            NameLabel.translateX(0, 150).then(this::animateLevelIn);
        });
        
        // Animate the level out.
        animateButtonsOut();
        animateLevelOut();
    }
    
    // Saves the current level.
    private void save() {
        try {
            CampaignLevels.saveCampaignLevel(currentLevel);
        } catch (java.io.IOException e) {
            // Display an error message.
            createMessageDialog(null, 
                    "Could not save the progress in the current level!\n\n"
                    + "Please make sure that the res/clvl/ directory has\n"
                    + "not been tampered with."
            ).showDialog();
        }
    }
    
    // Sets the minions, guards, and boss if they are unlocked.
    private void setAmalgamations() {
        /**
         * On top of setting the minions, their getFullImage methods are called
         * so that their images are generated before the animation is started.
         * If this isn't done, the animation will be choppy.
         */
        // Set the minions. 
        Minion1Panel.setAmalgamation(currentLevel.getMinions()[0]);
        currentLevel.getMinions()[0].getFullImage();
        Minion2Panel.setAmalgamation(currentLevel.getMinions()[1]);
        currentLevel.getMinions()[1].getFullImage();
        Minion3Panel.setAmalgamation(currentLevel.getMinions()[2]);
        currentLevel.getMinions()[2].getFullImage();
        Minion4Panel.setAmalgamation(currentLevel.getMinions()[3]);
        currentLevel.getMinions()[3].getFullImage();
        Minion5Panel.setAmalgamation(currentLevel.getMinions()[4]);
        currentLevel.getMinions()[4].getFullImage();
        Minion6Panel.setAmalgamation(currentLevel.getMinions()[5]);
        currentLevel.getMinions()[5].getFullImage();
        // Check if the guards are unlocked yet.
        if (currentLevel.isMinionsDefeated()) {
            Guard1Panel.setAmalgamation(currentLevel.getGuards()[0]);
            currentLevel.getGuards()[0].getFullImage();
            Guard2Panel.setAmalgamation(currentLevel.getGuards()[1]);
            currentLevel.getGuards()[1].getFullImage();
            Guard3Panel.setAmalgamation(currentLevel.getGuards()[2]);  
            currentLevel.getGuards()[2].getFullImage();
       }
        // Check if the boss is unlockled yet.
        if (currentLevel.isGuardsDefeated()) {
            BossPanel.setAmalgamation(currentLevel.getBoss());
            currentLevel.getBoss().getFullImage();
        }
        setDefeated();
    }
    
    // Sets the enabled status of all components.
    private void setComponentsEnabled(boolean enabled) {
        PreviousButton.setEnabled(enabled);
        ExitButton.setEnabled(enabled);
        NextButton.setEnabled(enabled);
        Minion1Panel.setEnabled(enabled);
        Minion2Panel.setEnabled(enabled);
        Minion3Panel.setEnabled(enabled);
        Minion4Panel.setEnabled(enabled);
        Minion5Panel.setEnabled(enabled);
        Minion6Panel.setEnabled(enabled);
        Guard1Panel.setEnabled(enabled);
        Guard2Panel.setEnabled(enabled);
        Guard3Panel.setEnabled(enabled);
        BossPanel.setEnabled(enabled);
    }
    
    public void setDefeated(){
                    if(currentLevel.isMinionDefeated(0))
                    {
                        Minion1Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isMinionDefeated(1))
                    {
                        Minion2Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isMinionDefeated(2))
                    {
                        Minion3Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isMinionDefeated(3))
                    {
                        Minion4Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isMinionDefeated(4))
                    {
                        Minion5Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isMinionDefeated(5))
                    {
                        Minion6Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isGuardDefeated(0))
                    {
                        Guard1Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isGuardDefeated(1))
                    {
                        Guard2Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isGuardDefeated(2))
                    {
                        Guard3Panel.setBackground(Color.red);
                    }
                    if(currentLevel.isBossDefeated())
                    {
                        BossPanel.setBackground(Color.red);
                    }
                   repaint();
        
    }
    
    
    
    @Override
    public void showDialog() {
        // Calculate the distance from the current Y position to the bottom of
        // the screen.
        int distance = (int)java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize().getHeight() - getY();
        setLocation(getX(), getY() + distance);
        translate(getX(), getY() - distance, 250).then(this::animateIn);
        setVisible(true);
    }
    
    /**
     * Displays a new CampaignDialog that allows the player to play through the
     * CampaignLevels stored in the res/clvl/ directory in order.
     * 
     * Progress in the Campaign is kept internally, so nothing needs to be done
     * by the caller other than calling this method.
     * 
     * Keep in mind that this method will not return until the player is
     * finished playing the Campaign and closes the dialog.
     * 
     * @param parent the Frame that will be the parent of the created dialog.
     *               This can be null.
     * @param player the Amalgamation the player will control when battling
     *               during Campaign mode.
     */
    public static void startCampaign(java.awt.Frame parent, Amalgamation player) {
        // Create a new CampaignDialog.
        CampaignDialog dialog  = new CampaignDialog(parent, player);
        // Display the dialog.
        dialog.showDialog();
    }
    
    // Unlocks the boss if necessary.
    private void unlockBoss() {
        // Check if all the guards were defeated.
        if (!currentLevel.isGuardsDefeated())
            return;
        
        // Animate the boss panel out.
        BossPanel.exit().then(() -> {
            
            // Set the boss in its panel and load its image.
            BossPanel.setAmalgamation(currentLevel.getBoss());
            currentLevel.getBoss().getFullImage();
            
            // Animate the boss in.
            BossPanel.enter(bossBounds).then(() -> {
                
                // Display a message.
                createMessageDialog(null, 
                        "You can now fight the boss of this stage!",
                        "Finally!"
                ).showDialog();
            });
        });
    }
    
    // Unlocks the guards if possible.
    private void unlockGuards() {
        // Check if all the minions were defeated.
        if (!currentLevel.isMinionsDefeated())
            return;
        
        // Animate the guard panels out.
        Guard1Panel.exit();
        Guard2Panel.exit();
        Guard3Panel.exit().then(() -> {
            
            // Set the guards in their panels and load their images.
            Guard1Panel.setAmalgamation(currentLevel.getGuards()[0]);
            currentLevel.getGuards()[0].getFullImage();
            Guard2Panel.setAmalgamation(currentLevel.getGuards()[1]);
            currentLevel.getGuards()[1].getFullImage();
            Guard3Panel.setAmalgamation(currentLevel.getGuards()[2]);
            currentLevel.getGuards()[2].getFullImage();
            
            // Animate the guard panels in.
            Guard1Panel.enter(guard1Bounds);
            Guard2Panel.enter(guard2Bounds);
            Guard3Panel.enter(guard3Bounds).then(() -> {
                
                // Display a message.
                createMessageDialog(null, 
                        "You can now fight the guards of this stage!", 
                        "Sweet!"
                ).showDialog();
            });
        });
    }
    
    // Unlocks the next level if possible.
    private void unlockNextLevel() {
        // Check if there is a next level.
        if (currentIndex == levelNames.length - 1) {
            // Display a dialog.
            createMessageDialog(null,
                    "Congratulations! You have completed the Campaign!\n\n"
                    + "We hope this experience has allowed you to grow\n"
                    + "as a person and appreciate the value of a life,\n"
                    + "no matter how gross, ugly, disgusting, horrifically\n"
                    + "displeasant, generally smelly, uncool, distasteful,\n"
                    + "sickening, or still-owes-you-money-ish it may be.\n\n"
                    + "We hope that you realize that Amalgamations are no\n"
                    + "different from all of us. We are also nothing but a\n"
                    + "crazy mismatch of different parts: some that are\n"
                    + "literal body parts, others that define how we act:\n"
                    + "our emotions, our personality traits. Perhaps you have\n"
                    + "laughed at some of the ridiculous looking creatures \n"
                    + "throughout your journey. I hope you feel like a jerk\n"
                    + "for that, because that's literally what you are. We\n"
                    + "hope that you see that now.\n\n"
                    + "Most of all, we hope this message has distracted you\n"
                    + "from the fact that completing this Campaign has earned\n"
                    + "you literally nothing other than a wasted hour and a\n"
                    + "lengthy dialog box. Seriously, are you still reading\n"
                    + "this? Why? Go outside! Enjoy the rest of your day! Stop\n"
                    + "playing this game! You're done now.",
                    "YEAH! I'M THE BEST AT EVERYTHING EVER!"
            ).showDialog();
            return;
        }
        
        // Display the next button.
        NextButton.enter(nextBounds).then(() -> {
            
            // Display a message.
            createMessageDialog(null,
                    "Congratulations on defeating " 
                            + currentLevel.getBoss().getName()
                            + "!\n\n"
                            + "You can now advance to the next stage!",
                    "Woohoo!"
            ).showDialog();
        });
    }
    
    // <editor-fold desc="GUI Code" defaultstate="collapsed">
    /**
     * Creates new form CampaignDialog
     */
    public CampaignDialog(java.awt.Frame parent, Amalgamation playerAmalgamation)
            throws IllegalStateException {
        super(parent, true);
        initComponents();
        pack();
        setLocationRelativeTo(parent);
        this.playerAmalgamation = playerAmalgamation;
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
                hidePanels();
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
        jLabel1 = new javax.swing.JLabel();
        Guard3Panel = new menus.components.AmalgamationPanel();
        Guard2Panel = new menus.components.AmalgamationPanel();
        Minion2Panel = new menus.components.AmalgamationPanel();
        Minion4Panel = new menus.components.AmalgamationPanel();
        Minion1Panel = new menus.components.AmalgamationPanel();
        Minion3Panel = new menus.components.AmalgamationPanel();
        Minion5Panel = new menus.components.AmalgamationPanel();
        Minion6Panel = new menus.components.AmalgamationPanel();
        ExitButton = new acomponent.AButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        NameLabel.setBackground(new java.awt.Color(255, 255, 255));
        NameLabel.setForeground(new java.awt.Color(244, 67, 54));
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

        NextButton.setBackground(new java.awt.Color(76, 175, 80));
        NextButton.setActionListener(e -> nextLevel());
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

        PreviousButton.setBackground(new java.awt.Color(33, 150, 243));
        PreviousButton.setActionListener(e -> previousLevel());
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

        BossPanel.setClickAction(this::battleBoss);

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

        Guard1Panel.setToolTipText("");
        Guard1Panel.setClickAction(() -> battleGuard(0));
        Guard1Panel.setHighlightColor(new java.awt.Color(76, 175, 80));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout Guard1PanelLayout = new javax.swing.GroupLayout(Guard1Panel);
        Guard1Panel.setLayout(Guard1PanelLayout);
        Guard1PanelLayout.setHorizontalGroup(
            Guard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Guard1PanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        Guard1PanelLayout.setVerticalGroup(
            Guard1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Guard1PanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        Guard3Panel.setClickAction(() -> battleGuard(2));
        Guard3Panel.setHighlightColor(new java.awt.Color(76, 175, 80));

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

        Guard2Panel.setClickAction(() -> battleGuard(1));
        Guard2Panel.setHighlightColor(new java.awt.Color(76, 175, 80));

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

        Minion2Panel.setClickAction(() -> battleMinion(1));
        Minion2Panel.setHighlightColor(new java.awt.Color(33, 150, 243));

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

        Minion4Panel.setClickAction(() -> battleMinion(3));
        Minion4Panel.setHighlightColor(new java.awt.Color(33, 150, 243));

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

        Minion1Panel.setClickAction(() -> battleMinion(0));
        Minion1Panel.setHighlightColor(new java.awt.Color(33, 150, 243));
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

        Minion3Panel.setClickAction(() -> battleMinion(2));
        Minion3Panel.setHighlightColor(new java.awt.Color(33, 150, 243));

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

        Minion5Panel.setClickAction(() -> battleMinion(4));
        Minion5Panel.setHighlightColor(new java.awt.Color(33, 150, 243));

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

        Minion6Panel.setClickAction(() -> battleMinion(5));
        Minion6Panel.setHighlightColor(new java.awt.Color(33, 150, 243));

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

        ExitButton.setBackground(new java.awt.Color(66, 66, 66));
        ExitButton.setActionListener(e -> exitCampaign());
        ExitButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        ExitButton.setText("Main Menu");

        javax.swing.GroupLayout ExitButtonLayout = new javax.swing.GroupLayout(ExitButton);
        ExitButton.setLayout(ExitButtonLayout);
        ExitButtonLayout.setHorizontalGroup(
            ExitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
        ExitButtonLayout.setVerticalGroup(
            ExitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(160, 160, 160)
                        .addComponent(Guard1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(BossPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(Guard3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Minion3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(Minion4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(163, 163, 163)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(Minion2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279)
                .addComponent(Minion5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
            .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Make sure this panel is drawn on top of others.
        getContentPane().setComponentZOrder(BossPanel, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        startCampaign(null, util.Amalgamations.load("Dippy the Strictly Platonic"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private menus.components.AmalgamationPanel BossPanel;
    private acomponent.AButton ExitButton;
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
