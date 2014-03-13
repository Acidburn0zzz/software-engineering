package antgame.gui;

import java.awt.Cursor;
import java.awt.Point;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.*;
import org.jdesktop.beansbinding.Converter;

/**
 * Ant Game Main GUI Screen.
 * The game play and simulation control all happens here!
 *
 * @author Jonathan Dilks <jay-to-the-dee@users.noreply.github.com>
 */
public class MainScreen extends javax.swing.JFrame
{
    final private static int UPDATES_PER_SECOND = 10;
    final private static int TOTAL_ROUNDS = 300000;

    private GameExecutionThread simulateGameRun;
    private boolean dragStart = true;
    private int startX;
    private int startY;

    /**
     * Creates new form MainScreen
     */
    public MainScreen()
    {
        setLayout(new MultiBorderLayout());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        gameSpeedToolbar = new javax.swing.JToolBar();
        roundPerSecondSetter = new javax.swing.JSlider();
        roundPerSecondDisplay = new javax.swing.JTextField();
        simulationOverallProgess = new javax.swing.JProgressBar();
        worldPanelScrollPane = new javax.swing.JScrollPane();
        worldPanel = new antgame.gui.WorldPanel();
        zoomToolbar = new javax.swing.JToolBar();
        zoomSlider = new javax.swing.JSlider();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadWorldMenuItem = new javax.swing.JMenuItem();
        editWorldMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        loadBlackAntBrainMenuItem = new javax.swing.JMenuItem();
        loadRedAntBrainMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        simulationMenu = new javax.swing.JMenu();
        startMenuItem = new javax.swing.JMenuItem();
        pauseMenuItem = new javax.swing.JMenuItem();
        resetMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Up The Ante!");
        setMaximumSize(new java.awt.Dimension(5120, 3200));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("mainFrame"); // NOI18N

        gameSpeedToolbar.setName("Game Speed Toolbar"); // NOI18N

        roundPerSecondSetter.setMaximum(60);
        roundPerSecondSetter.setToolTipText("Game rounds/second");
        roundPerSecondSetter.setValue(42);
        roundPerSecondSetter.setName("roundPerSecondSetter"); // NOI18N
        gameSpeedToolbar.add(roundPerSecondSetter);

        roundPerSecondDisplay.setEditable(false);
        roundPerSecondDisplay.setColumns(8);
        roundPerSecondDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        roundPerSecondDisplay.setToolTipText(roundPerSecondSetter.getToolTipText());
        roundPerSecondDisplay.setFocusable(false);
        roundPerSecondDisplay.setName("roundPerSecondDisplay"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, roundPerSecondSetter, org.jdesktop.beansbinding.ELProperty.create("${value}"), roundPerSecondDisplay, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(new RoundPerSecondSetterLogConverterString());
        bindingGroup.addBinding(binding);

        gameSpeedToolbar.add(roundPerSecondDisplay);

        simulationOverallProgess.setMaximum(TOTAL_ROUNDS);
        simulationOverallProgess.setToolTipText("Current simulation progress");
        simulationOverallProgess.setName("simulationOverallProgess"); // NOI18N
        simulationOverallProgess.setString(simulationOverallProgessStringUpdate());
        simulationOverallProgess.setStringPainted(true);
        simulationOverallProgess.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                simulationOverallProgessStateChanged(evt);
            }
        });
        gameSpeedToolbar.add(simulationOverallProgess);

        getContentPane().add(gameSpeedToolbar, java.awt.BorderLayout.SOUTH);

        worldPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        worldPanel.setRowsAndColumns(new java.awt.Dimension(150, 150));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, zoomSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), worldPanel, org.jdesktop.beansbinding.BeanProperty.create("hexagonSize"));
        bindingGroup.addBinding(binding);

        worldPanel.addMouseWheelListener(new java.awt.event.MouseWheelListener()
        {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt)
            {
                worldPanelMouseWheelMoved(evt);
            }
        });
        worldPanel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                worldPanelMouseReleased(evt);
            }
        });
        worldPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                worldPanelMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout worldPanelLayout = new javax.swing.GroupLayout(worldPanel);
        worldPanel.setLayout(worldPanelLayout);
        worldPanelLayout.setHorizontalGroup(
            worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3011, Short.MAX_VALUE)
        );
        worldPanelLayout.setVerticalGroup(
            worldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2142, Short.MAX_VALUE)
        );

        worldPanelScrollPane.setViewportView(worldPanel);

        getContentPane().add(worldPanelScrollPane, java.awt.BorderLayout.CENTER);

        zoomToolbar.setRollover(true);
        zoomToolbar.setName("Zoom Toolbar"); // NOI18N

        zoomSlider.setMaximum(60);
        zoomSlider.setMinimum(5);
        zoomSlider.setToolTipText("Zoom Slider");
        zoomSlider.setValue(20);
        zoomToolbar.add(zoomSlider);

        getContentPane().add(zoomToolbar, java.awt.BorderLayout.SOUTH);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        loadWorldMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        loadWorldMenuItem.setMnemonic('l');
        loadWorldMenuItem.setText("Load World");
        loadWorldMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadWorldMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadWorldMenuItem);

        editWorldMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        editWorldMenuItem.setMnemonic('e');
        editWorldMenuItem.setText("Edit World");
        editWorldMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editWorldMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(editWorldMenuItem);
        fileMenu.add(jSeparator1);

        loadBlackAntBrainMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        loadBlackAntBrainMenuItem.setMnemonic('b');
        loadBlackAntBrainMenuItem.setText("Load Black Ant Brain");
        loadBlackAntBrainMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadBlackAntBrainMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadBlackAntBrainMenuItem);

        loadRedAntBrainMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        loadRedAntBrainMenuItem.setMnemonic('r');
        loadRedAntBrainMenuItem.setText("Load Red Ant Brain");
        loadRedAntBrainMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadRedAntBrainMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadRedAntBrainMenuItem);
        fileMenu.add(jSeparator2);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitApplication(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        simulationMenu.setMnemonic('s');
        simulationMenu.setText("Simulation");

        startMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        startMenuItem.setMnemonic('s');
        startMenuItem.setText("Start / Resume");
        startMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startMenuItemActionPerformed(evt);
            }
        });
        simulationMenu.add(startMenuItem);

        pauseMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        pauseMenuItem.setMnemonic('p');
        pauseMenuItem.setText("Pause");
        pauseMenuItem.setEnabled(false);
        pauseMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pauseMenuItemActionPerformed(evt);
            }
        });
        simulationMenu.add(pauseMenuItem);

        resetMenuItem.setMnemonic('r');
        resetMenuItem.setText("Reset");
        resetMenuItem.setEnabled(false);
        resetMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                resetMenuItemActionPerformed(evt);
            }
        });
        simulationMenu.add(resetMenuItem);

        mainMenuBar.add(simulationMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");
        helpMenu.setToolTipText("");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        mainMenuBar.add(helpMenu);

        setJMenuBar(mainMenuBar);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simulationOverallProgessStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_simulationOverallProgessStateChanged
    {//GEN-HEADEREND:event_simulationOverallProgessStateChanged
        simulationOverallProgess.setString(simulationOverallProgessStringUpdate());
    }//GEN-LAST:event_simulationOverallProgessStateChanged

    private void startMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startMenuItemActionPerformed
    {//GEN-HEADEREND:event_startMenuItemActionPerformed
        startMenuItem.setEnabled(false);
        pauseMenuItem.setEnabled(true);
        resetMenuItem.setEnabled(false);

        if (simulateGameRun != null)
        {
            //Resume
            simulateGameRun.setIsPaused(false);
        }
        else
        {
            //Start
            (simulateGameRun = new GameExecutionThread()).execute();
        }
    }//GEN-LAST:event_startMenuItemActionPerformed

    private void pauseMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_pauseMenuItemActionPerformed
    {//GEN-HEADEREND:event_pauseMenuItemActionPerformed
        startMenuItem.setEnabled(true);
        pauseMenuItem.setEnabled(false);
        resetMenuItem.setEnabled(true);

        simulateGameRun.setIsPaused(true);
    }//GEN-LAST:event_pauseMenuItemActionPerformed

    private void loadWorldMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadWorldMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadWorldMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadWorldMenuItemActionPerformed

    private void loadBlackAntBrainMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadBlackAntBrainMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadBlackAntBrainMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadBlackAntBrainMenuItemActionPerformed

    private void editWorldMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editWorldMenuItemActionPerformed
    {//GEN-HEADEREND:event_editWorldMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editWorldMenuItemActionPerformed

    private void loadRedAntBrainMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadRedAntBrainMenuItemActionPerformed
    {//GEN-HEADEREND:event_loadRedAntBrainMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadRedAntBrainMenuItemActionPerformed

    private void exitApplication(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitApplication
    {//GEN-HEADEREND:event_exitApplication
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitApplication

    private void resetMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_resetMenuItemActionPerformed
    {//GEN-HEADEREND:event_resetMenuItemActionPerformed
        startMenuItem.setEnabled(true);
        pauseMenuItem.setEnabled(false);
        resetMenuItem.setEnabled(false);

        simulateGameRun.cancel(true);
        simulateGameRun = null;
        simulationOverallProgess.setValue(0);
    }//GEN-LAST:event_resetMenuItemActionPerformed

    private void worldPanelMouseWheelMoved(java.awt.event.MouseWheelEvent evt)//GEN-FIRST:event_worldPanelMouseWheelMoved
    {//GEN-HEADEREND:event_worldPanelMouseWheelMoved
        int notches = evt.getWheelRotation();

        zoomSlider.setValue(zoomSlider.getValue() - notches);
    }//GEN-LAST:event_worldPanelMouseWheelMoved

    private void worldPanelMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_worldPanelMouseReleased
    {//GEN-HEADEREND:event_worldPanelMouseReleased
        dragStart = true;
        this.setCursor(null);
    }//GEN-LAST:event_worldPanelMouseReleased

    private void worldPanelMouseDragged(java.awt.event.MouseEvent evt)//GEN-FIRST:event_worldPanelMouseDragged
    {//GEN-HEADEREND:event_worldPanelMouseDragged
        if (dragStart == true)
        {
            dragStart = false;
            this.setCursor(Cursor.getPredefinedCursor((Cursor.MOVE_CURSOR)));

            startX = evt.getX();
            startY = evt.getY();
        }

        int X = startX - evt.getX();
        int Y = startY - evt.getY();

        Point currentPoint = worldPanelScrollPane.getViewport().getViewPosition();

        int newX = (int) (currentPoint.getX() + X);
        int newY = (int) (currentPoint.getY() + Y);

        if (newX > worldPanel.getPreferredSize().getWidth() - worldPanelScrollPane.getViewport().getWidth())
        {
            newX = (int) worldPanel.getPreferredSize().getWidth() - worldPanelScrollPane.getViewport().getWidth();
        }
        if (newY > worldPanel.getPreferredSize().getHeight() - worldPanelScrollPane.getViewport().getHeight())
        {
            newY = (int) worldPanel.getPreferredSize().getHeight() - worldPanelScrollPane.getViewport().getHeight();
        }
        if (newX < 0)
        {
            newX = 0;
        }
        if (newY < 0)
        {
            newY = 0;
        }

        Point newPoint = new Point(newX, newY);

        worldPanelScrollPane.getViewport().setViewPosition(newPoint);
    }//GEN-LAST:event_worldPanelMouseDragged

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_aboutMenuItemActionPerformed
    {//GEN-HEADEREND:event_aboutMenuItemActionPerformed
        AboutDialog dialog = new AboutDialog(this, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private String simulationOverallProgessStringUpdate()
    {
        NumberFormat nf = NumberFormat.getInstance();

        //value / maximum
        return nf.format(simulationOverallProgess.getValue())
                + " / "
                + nf.format(simulationOverallProgess.getMaximum());

    }

    public class RoundPerSecondSetterLogConverter extends Converter<Integer, Integer>
    {
        private final int[] conversionTable =
        {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 25, 30, 35, 40, 45, 50, 60, 70, 80, 90, 100, 120, 140, 160, 180, 200, 250, 300, 350, 400, 450, 500, 600, 700, 800, 900, 1000, 1200, 1400, 1600, 1800, 2000, 2500, 3000, 4000, 5000, 6000, 7500, 10000, 15000, 20000, 25000, 35000, 50000, 100000
        };

        @Override
        public Integer convertForward(Integer value)
        {
            return conversionTable[value];
        }

        @Override
        public Integer convertReverse(Integer value)
        {
            for (int i = 1; i < conversionTable.length; i++)
            {
                if (conversionTable[i] == value)
                {
                    return i;
                }
            }
            return 0;
        }
    }

    public class RoundPerSecondSetterLogConverterString extends Converter<Integer, String>
    {
        RoundPerSecondSetterLogConverter converter;
        NumberFormat nf;

        public RoundPerSecondSetterLogConverterString()
        {
            converter = new RoundPerSecondSetterLogConverter();
            nf = NumberFormat.getInstance();
        }

        @Override
        public String convertForward(Integer value)
        {
            return nf.format(converter.convertForward(value)) + " r/s";
        }

        @Override
        public Integer convertReverse(String value)
        {
            return converter.convertReverse(Integer.parseInt(value.replaceAll("[\\D]", "")));
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Default System look and feel, else try Nimbus */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        try
        {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            try
            {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                {
                    if ("Nimbus".equals(info.getName()))
                    {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        //break;
                    }
                }
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
            {
            }
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainScreen().setVisible(true);
            }
        });

    }

    private class GameExecutionThread extends SwingWorker<Void, Void>
    {
        volatile boolean isPaused = false;
        private float completedRuns = 0;

        public void setIsPaused(boolean isPaused)
        {
            this.isPaused = isPaused;
        }

        @Override
        protected Void doInBackground() throws Exception
        {
            while (!isCancelled() && completedRuns < TOTAL_ROUNDS)
            {
                while (!isCancelled() && isPaused)
                {
                    //Wait for thread to become unpaused
                }
                float presentRoundsPerSecond = new RoundPerSecondSetterLogConverter().convertForward(roundPerSecondSetter.getValue());
                completedRuns += presentRoundsPerSecond / UPDATES_PER_SECOND;

                if (completedRuns > TOTAL_ROUNDS)
                {
                    //Fix for #7
                    completedRuns = TOTAL_ROUNDS;
                }

                /* TODO ItsTheRai : Do your stuff here!
                 Call your Brain Exectutor method!
                 Note that completedRuns is a float not an int! Deal with it! :L
                 */
                // TODO jay-to-the-dee : re-draw method stuff here
                worldPanel.repaint();

                Thread.sleep(1000 / UPDATES_PER_SECOND);
                publish();
            }
            return null;
        }

        @Override
        protected void process(List<Void> runs)
        {
            simulationOverallProgess.setValue((int) completedRuns);
        }

        @Override
        protected void done()
        {
            if (!isCancelled())
            {
                startMenuItem.setEnabled(false);
                pauseMenuItem.setEnabled(false);
                resetMenuItem.setEnabled(true);

                JOptionPane.showMessageDialog(null, "Game complete! " + completedRuns + " rounds completed!");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem editWorldMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JToolBar gameSpeedToolbar;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem loadBlackAntBrainMenuItem;
    private javax.swing.JMenuItem loadRedAntBrainMenuItem;
    private javax.swing.JMenuItem loadWorldMenuItem;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem pauseMenuItem;
    private javax.swing.JMenuItem resetMenuItem;
    private javax.swing.JTextField roundPerSecondDisplay;
    private javax.swing.JSlider roundPerSecondSetter;
    private javax.swing.JMenu simulationMenu;
    private javax.swing.JProgressBar simulationOverallProgess;
    private javax.swing.JMenuItem startMenuItem;
    private antgame.gui.WorldPanel worldPanel;
    private javax.swing.JScrollPane worldPanelScrollPane;
    private javax.swing.JSlider zoomSlider;
    private javax.swing.JToolBar zoomToolbar;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
