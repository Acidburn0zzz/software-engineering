package antgame.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mainPackage.TournamentFile;

/**
 *
 * @author jay-to-the-dee <jay-to-the-dee@users.noreply.github.com>
 */
public class TournamentStatsFloat extends javax.swing.JPanel
{
    private ArrayList<TournamentFile> tournamentFiles;
    private MainScreen mainScreen;
    private boolean battleFirstRound = true;
    private boolean tournamentCompleted = false;

    enum Result
    {
        WIN,
        LOSE,
        DRAW
    }

    private TournamentFile blackBrain;
    private TournamentFile redBrain;

    /**
     * Creates new form TournamentStatusFloat
     */
    public TournamentStatsFloat()
    {
        initComponents();
    }

    public void setMainScreen(MainScreen mainScreen)
    {
        this.mainScreen = mainScreen;
    }

    public void setTournamentFiles(ArrayList tournamentFiles)
    {
        this.tournamentFiles = tournamentFiles;
    }

    public void updateTable()
    {
        //Clear table
        DefaultTableModel model = (DefaultTableModel) statsTable.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--)
        {
            model.removeRow(i);
        }

        try
        {
            for (TournamentFile tournamentFile : tournamentFiles)
            {
                model.addRow(new Object[]
                {
                    tournamentFile.toString(), tournamentFile.getWins(), tournamentFile.getDraws(), tournamentFile.getLoses()
                });
            }
        }
        catch (NullPointerException e)
        {
            // tournamentFile is just empty - ignore
        }
    }

    private void battleTwoBrainFiles()
    {
        if (battleFirstRound)
        {
            mainScreen.resetMenuItem.doClick();
            mainScreen.loadRandomWorldMenuItem.doClick();
            mainScreen.setBlackBrainFile(blackBrain.getBrainFile());
            mainScreen.setRedBrainFile(redBrain.getBrainFile());
            mainScreen.startMenuItem.doClick();
        }
        else
        {
            TournamentFile swapBrains = blackBrain;
            blackBrain = redBrain;
            redBrain = swapBrains;

            mainScreen.resetMenuItem.doClick();
            mainScreen.setBlackBrainFile(blackBrain.getBrainFile());
            mainScreen.setRedBrainFile(redBrain.getBrainFile());
            mainScreen.startMenuItem.doClick();
        }
    }

    /**
     * Returns from MainScreen the game result
     *
     * @param blackResult black result
     * @param redResult red result
     */
    public void returnGameResults(Result blackResult, Result redResult)
    {
        updateResults(blackResult, redResult);

        if (battleFirstRound)
        {
            battleFirstRound = false;
            battleTwoBrainFiles();
        }
        else
        {
            battleFirstRound = true;

            //Set battled status
            redBrain.addBrainBattled(blackBrain);
            blackBrain.addBrainBattled(redBrain);

            //Carry on with the logic
            doTournamentLogic();
        }
    }

    private void doTournamentLogic()
    {
        if (tournamentFiles.size() < 2)
        {
            JOptionPane.showMessageDialog(mainScreen, "Need two or more brain files uploaded to do tournament.");
            endTournamentButton.doClick();
        }

        tournamentCompleted = true;
        for (TournamentFile tournamentFile : tournamentFiles)
        {

            if ((tournamentFile.getBrainsBattled().size() != tournamentFiles.size()) && tournamentCompleted)
            {
                for (TournamentFile tournamentFileToBattle : tournamentFiles)
                {
                    if (!tournamentFile.getBrainsBattled().contains(tournamentFileToBattle))
                    {
                        redBrain = tournamentFile;
                        blackBrain = tournamentFileToBattle;
                        tournamentCompleted = false;
                        break;
                    }
                }
            }
            else
            {
                //All other brains battled for this brain - move on
                continue;
            }
        }

        if (!tournamentCompleted)
        {
            battleFirstRound = true;
            battleTwoBrainFiles();
        }
        else
        {
            JOptionPane.showMessageDialog(mainScreen, "Tournament complete!");
        }
    }

    private void updateResults(Result blackResult, Result redResult)
    {
        switch (blackResult)
        {
            case WIN:
                blackBrain.increaseWins();
                break;
            case DRAW:
                blackBrain.increaseDraws();
                break;
            case LOSE:
                blackBrain.increaseLoses();
                break;
        }
        switch (redResult)
        {
            case WIN:
                redBrain.increaseWins();
                break;
            case DRAW:
                redBrain.increaseDraws();
                break;
            case LOSE:
                redBrain.increaseLoses();
                break;
        }
        updateTable();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        statsTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        startTournamentButton = new javax.swing.JButton();
        endTournamentButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout(5, 5));

        statsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Brain", "W", "D", "L"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(statsTable);
        if (statsTable.getColumnModel().getColumnCount() > 0)
        {
            statsTable.getColumnModel().getColumn(0).setMinWidth(50);
            statsTable.getColumnModel().getColumn(0).setPreferredWidth(125);
            statsTable.getColumnModel().getColumn(1).setResizable(false);
            statsTable.getColumnModel().getColumn(1).setPreferredWidth(15);
            statsTable.getColumnModel().getColumn(2).setResizable(false);
            statsTable.getColumnModel().getColumn(2).setPreferredWidth(15);
            statsTable.getColumnModel().getColumn(3).setResizable(false);
            statsTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        startTournamentButton.setText("Start");
        startTournamentButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startTournamentButtonActionPerformed(evt);
            }
        });
        jPanel2.add(startTournamentButton);

        endTournamentButton.setText("End");
        endTournamentButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                endTournamentButtonActionPerformed(evt);
            }
        });
        jPanel2.add(endTournamentButton);

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void startTournamentButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startTournamentButtonActionPerformed
    {//GEN-HEADEREND:event_startTournamentButtonActionPerformed
        startTournamentButton.setEnabled(false);

        mainScreen.setInTournamentMode(true);
        mainScreen.setMaxSpeed();

        doTournamentLogic();
    }//GEN-LAST:event_startTournamentButtonActionPerformed

    private void endTournamentButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_endTournamentButtonActionPerformed
    {//GEN-HEADEREND:event_endTournamentButtonActionPerformed
        mainScreen.tournamentStatsToolbar.setVisible(false);
        mainScreen.setInTournamentMode(false);
        startTournamentButton.setEnabled(true);
        tournamentFiles = null;
        updateTable();
    }//GEN-LAST:event_endTournamentButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endTournamentButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startTournamentButton;
    private javax.swing.JTable statsTable;
    // End of variables declaration//GEN-END:variables
}
