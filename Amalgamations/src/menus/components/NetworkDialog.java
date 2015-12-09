package menus.components;

import acomponent.ADialog;

import amalgamation.Amalgamation;

import java.io.IOException;

import network.*;
import util.Amalgamations;

/**
 * A NetworkDialog prompts the user to connect to another user over a shared
 * network.
 * 
 * The NetworkDialog will take care of setting up a network connection and
 * starting a Battle. All that needs to be supplied is the Amalgamation.
 * 
 * @author Caleb Rush
 */
public class NetworkDialog extends ADialog {
    private Amalgamation amalgamation;
    
    private NetworkDialog(Amalgamation amalgamation) {
        super(null, true);
        this.amalgamation = amalgamation;
        
        // Add the text to the dialog.
        addText(
            "Would you like to <i>Host</i> a battle or <i>Join</i> a battle?\n\n"
            + "You should <i>Host</i> a battle if you are waiting on the other player.\n\n"
            + "You should <i>Join</i> a battle if the other player is waiting on you."
        );
        
        // Add a button to select Host.
        addButton("Host",
                e -> {
                    host();
                },
                new java.awt.Color(76, 175, 80) // Green
        );
        
        // Add a button to select Join.
        addButton("Join",
                e -> {
                    join();
                },
                new java.awt.Color(33, 150, 243) // Blue
        );
        
        // Add a cancel button.
        addButton("Cancel",
                e -> {
                    hideDialog();
                }
        );
        
        pack();
        setLocationRelativeTo(null);
    }
    
    // Sets up a NetworkAdapter and waits for another player to connect.
    private void host() {
        // Show a new HostDialog.
        HostDialog dialog = new HostDialog();
        hideDialog();
                // NetworkDialog.this.hideDialog();
                // If the controller successfully connected, retrieve the
                // other Amalgamation.
                Amalgamation opponent = dialog.controller.retrieveAmalgamation();
                if (opponent != null)
                    // Create a Battle with the NetworkController as the opposing
                    // controller.
                    menus.components.BattleDialog.startBattle(dialog.controller, 
                            amalgamation, opponent);
    }
    
    // Prompts the user for the host name and port number and attempts to
    // connect to a server socket.
    private void join() {
        JoinDialog dialog = new JoinDialog();
        if (dialog.dialog != null)
            dialog.dialog.setVisible(true);
        hideDialog();
    }
    
    /**
     * Creates a new NetworkDialog that will walk the user through the steps
     * of connecting to another player across a shared network.
     * 
     * @param amalgamation the Amalgamation the user will battle with when they
     *                     connect to the other player
     * @return the created NetworkDialog.
     */
    public static NetworkDialog createNetworkDialog(Amalgamation amalgamation) {
        return new NetworkDialog(amalgamation);
    }
    
    public static void main(String[] args) {
        createNetworkDialog(Amalgamations.load("Horsey")).showDialog();
    }
    
    public class JoinDialog extends acomponent.ADialog {
        private menus.components.BattleDialog dialog;
        
        /**
         * Creates new form JoinDialog
         */
        public JoinDialog() {
            super(null, true);
            initComponents();
            setLocationRelativeTo(null);
            showDialog();
        }

        // <editor-fold desc="JoinForm GUI Code" defaultstate="collapsed">
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {
            jLabel1 = new javax.swing.JLabel();
            HostLabel = new acomponent.ALabel();
            HostField = new javax.swing.JTextField();
            PortLabel = new acomponent.ALabel();
            PortField = new javax.swing.JTextField();
            CancelButton = new acomponent.AButton();
            CancelButton1 = new acomponent.AButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            
            HostField.setBorder(null);
            HostField.setForeground(new java.awt.Color(76,175,80));
            HostField.setCaretColor(new java.awt.Color(76,175,80));
            HostField.setFont(new java.awt.Font("Berlin Sans FB Demi", java.awt.Font.BOLD, 18));
            
            PortField.setBorder(null);
            PortField.setForeground(new java.awt.Color(76,175,80));
            PortField.setCaretColor(new java.awt.Color(76,175,80));
            PortField.setFont(new java.awt.Font("Berlin Sans FB Demi", java.awt.Font.BOLD, 18));

            jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
            jLabel1.setText("If the other player chose \"Host\", ask them for the following information:");

            HostLabel.setText("Host:");
            HostLabel.setBackground(java.awt.Color.WHITE);

            javax.swing.GroupLayout HostLabelLayout = new javax.swing.GroupLayout(HostLabel);
            HostLabel.setLayout(HostLabelLayout);
            HostLabelLayout.setHorizontalGroup(
                HostLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 60, Short.MAX_VALUE)
            );
            HostLabelLayout.setVerticalGroup(
                HostLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            PortLabel.setText("Port:");
            PortLabel.setBackground(java.awt.Color.WHITE);

            javax.swing.GroupLayout PortLabelLayout = new javax.swing.GroupLayout(PortLabel);
            PortLabel.setLayout(PortLabelLayout);
            PortLabelLayout.setHorizontalGroup(
                PortLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 60, Short.MAX_VALUE)
            );
            PortLabelLayout.setVerticalGroup(
                PortLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            CancelButton.setBackground(new java.awt.Color(255, 255, 255));
            CancelButton.setBorder(null);
            CancelButton.setForeground(new java.awt.Color(0, 0, 0));
            CancelButton.setActionListener(e -> {
                hideDialog();
            });
            CancelButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
            CancelButton.setHighlightColor(new java.awt.Color(0, 0, 0));
            CancelButton.setText("Cancel");

            javax.swing.GroupLayout CancelButtonLayout = new javax.swing.GroupLayout(CancelButton);
            CancelButton.setLayout(CancelButtonLayout);
            CancelButtonLayout.setHorizontalGroup(
                CancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 85, Short.MAX_VALUE)
            );
            CancelButtonLayout.setVerticalGroup(
                CancelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            CancelButton1.setBackground(new java.awt.Color(255, 255, 255));
            CancelButton1.setBorder(null);
            CancelButton1.setForeground(new java.awt.Color(33, 150, 243));
            CancelButton1.setActionListener(e -> {
                // Create a new NetworkAdapter
                try (NetworkAdapter adapter = new NetworkAdapter(
                    HostField.getText(),
                    Integer.parseInt(PortField.getText()))){
                    hideDialog();
                    NetworkDialog.this.hideDialog();
                    // Connect a new BattleDialog to the NetworkAdapter.
                    dialog = new menus.components.BattleDialog();
                    // Place the dialog underneath the screen until it's ready to reveal
                    // itself.
                    dialog.setLocationRelativeTo(null);
                    dialog.setLocation(dialog.getX(), 
                    (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize()
                            .getHeight());
                    adapter.connectController(dialog, amalgamation);
                    // Make the dialog visible.
                    dialog.setVisible(true);
                } catch (java.io.IOException ex) {
                    createMessageDialog(null, "Could not connect to Host!\n"
                        + "Please ensurs the information was correct. If the\n"
                        + "numbers are correct, ensure your network connection\n"
                        + "is secure and that your firewall is not blocking the\nprogram.")
                    .showDialog();
                    hideDialog();
                } catch (NumberFormatException ex) {}
            });
            CancelButton1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
            CancelButton1.setHighlightColor(new java.awt.Color(33, 150, 243));
            CancelButton1.setText("Connect");

            javax.swing.GroupLayout CancelButton1Layout = new javax.swing.GroupLayout(CancelButton1);
            CancelButton1.setLayout(CancelButton1Layout);
            CancelButton1Layout.setHorizontalGroup(
                CancelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 85, Short.MAX_VALUE)
            );
            CancelButton1Layout.setVerticalGroup(
                CancelButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 27, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(HostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(HostField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(PortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PortField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HostField)
                            .addComponent(PortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(PortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>                        
        // Variables declaration - do not modify                     
        private acomponent.AButton CancelButton;
        private acomponent.AButton CancelButton1;
        private javax.swing.JTextField HostField;
        private acomponent.ALabel HostLabel;
        private javax.swing.JTextField PortField;
        private acomponent.ALabel PortLabel;
        private javax.swing.JLabel jLabel1;
        // End of variables declaration                   
        // </editor-fold>
    }
    
    // A dialog that displays the necessary socket information and attempts to
    // allow another socket to connect and start a battle.
    private class HostDialog extends ADialog {
        private NetworkController controller;
        
        public HostDialog() {
            super(null, true);
            
            // Attempt to create a NetworkController to be connected to by a
            // NetworkAdapter.
            try {
                controller = new NetworkController();
                
                // Add directions.
                addText(
                    "Waiting for a player to join the battle.\n\n"
                    + "When the other player is ready, tell them to choose \"Join\""
                    + " and give them the following information:\n\n"
                    + "Host:     " + controller.getHost() + "\n"
                    + "Port:     " + controller.getPort() + "\n"
                );
                
                // Add a cancel button.
                addButton("Cancel", e -> {
                    hideDialog();
                    try {
                        controller.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                
                // Show the dialog.
                pack();
                setLocationRelativeTo(null);
                showDialog();
                then(new Thread(this::connect)::start);
            } catch (IOException e) {
                hideDialog();
            }
        }
        
        public void connect() {
            try {
                // Wait for a connection for the controller.
                controller.connect();
                hideDialog();
            }
            catch (IOException e) {
                hideDialog();
            }
        }
    }
}
