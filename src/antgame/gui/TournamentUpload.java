package antgame.gui;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import mainPackage.TournamentFile;

/**
 *
 * @author jay-to-the-dee <jay-to-the-dee@users.noreply.github.com>
 */
public class TournamentUpload extends javax.swing.JFrame
{
    private DefaultListModel<TournamentFile> brainList;

    /**
     * Creates new form TournamentUpload
     */
    public TournamentUpload()
    {
        brainList = new DefaultListModel();
        initComponents();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        acceptButton = new javax.swing.JButton();
        addFileButton = new javax.swing.JButton();
        deleteFileButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tournament Upload");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jList1.setModel(brainList);
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 211;
        gridBagConstraints.ipady = 207;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        acceptButton.setMnemonic('R');
        acceptButton.setText("Accept & run!");
        acceptButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                acceptButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(acceptButton, gridBagConstraints);

        addFileButton.setMnemonic('a');
        addFileButton.setText("Add file");
        addFileButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addFileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(addFileButton, gridBagConstraints);

        deleteFileButton.setMnemonic('d');
        deleteFileButton.setText("Delete file");
        deleteFileButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteFileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(deleteFileButton, gridBagConstraints);

        cancelButton.setMnemonic('C');
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(cancelButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_acceptButtonActionPerformed
    {//GEN-HEADEREND:event_acceptButtonActionPerformed
        dispose();
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void deleteFileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteFileButtonActionPerformed
    {//GEN-HEADEREND:event_deleteFileButtonActionPerformed
        int index = jList1.getSelectedIndex();
        DefaultListModel model = (DefaultListModel) jList1.getModel();

        if (index != -1)
        {
            model.remove(index);
        }
    }//GEN-LAST:event_deleteFileButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addFileButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addFileButtonActionPerformed
    {//GEN-HEADEREND:event_addFileButtonActionPerformed
        final JFileChooser fc = new JFileChooser(new File("./data/brains"));

        if (fc.showOpenDialog(TournamentUpload.this) != JFileChooser.APPROVE_OPTION)
        {
            return;
        }
        
        File selectedFile = fc.getSelectedFile();
        
        TournamentFile tournamentFile = new TournamentFile(selectedFile);
        
        DefaultListModel model = (DefaultListModel) jList1.getModel();
        
        model.addElement(tournamentFile);
    }//GEN-LAST:event_addFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton addFileButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteFileButton;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
