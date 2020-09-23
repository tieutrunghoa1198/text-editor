/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author songm
 */
public class TextEditor extends javax.swing.JFrame
{

    public TextEditor()
    {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFileBtn = new javax.swing.JMenuItem();
        openFileBtn = new javax.swing.JMenuItem();
        saveFileBtn = new javax.swing.JMenuItem();
        saveAsBtn = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 15)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");

        newFileBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFileBtn.setText("New");
        newFileBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newFileBtnActionPerformed(evt);
            }
        });
        jMenu1.add(newFileBtn);

        openFileBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFileBtn.setText("Open");
        openFileBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openFileBtnActionPerformed(evt);
            }
        });
        jMenu1.add(openFileBtn);

        saveFileBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFileBtn.setText("Save");
        saveFileBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveFileBtnActionPerformed(evt);
            }
        });
        jMenu1.add(saveFileBtn);

        saveAsBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsBtn.setText("Save as");
        saveAsBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveAsBtnActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsBtn);
        jMenu1.add(jSeparator1);

        jMenuItem6.setText("Exit");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void newFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newFileBtnActionPerformed

    private void saveFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveFileBtnActionPerformed

    private void openFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openFileBtnActionPerformed

    private void saveAsBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAsBtnActionPerformed
    {//GEN-HEADEREND:event_saveAsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveAsBtnActionPerformed

    public JTextArea getjTextArea1()
    {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1)
    {
        this.jTextArea1 = jTextArea1;
    }

    public JMenuItem getNewFileBtn()
    {
        return newFileBtn;
    }

    public void setNewFileBtn(JMenuItem newFile)
    {
        this.newFileBtn = newFile;
    }

    public JMenuItem getOpenFileBtn()
    {
        return openFileBtn;
    }

    public void setOpenFileBtn(JMenuItem openFile)
    {
        this.openFileBtn = openFile;
    }

    public JMenuItem getSaveAsBtn()
    {
        return saveAsBtn;
    }

    public void setSaveAsBtn(JMenuItem saveAs)
    {
        this.saveAsBtn = saveAs;
    }

    public JMenuItem getSaveFileBtn()
    {
        return saveFileBtn;
    }

    public void setSaveFileBtn(JMenuItem saveFile)
    {
        this.saveFileBtn = saveFile;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new TextEditor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem newFileBtn;
    private javax.swing.JMenuItem openFileBtn;
    private javax.swing.JMenuItem saveAsBtn;
    private javax.swing.JMenuItem saveFileBtn;
    // End of variables declaration//GEN-END:variables
}