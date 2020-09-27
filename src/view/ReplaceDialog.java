/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author songm
 */
public class ReplaceDialog extends javax.swing.JDialog
{

    /**
     * Creates new form Replace
     */
    public ReplaceDialog(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }

    public JButton getCancelBtn()
    {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn)
    {
        this.cancelBtn = cancelBtn;
    }

    public JButton getFindNextBtn()
    {
        return findNextBtn;
    }

    public void setFindNextBtn(JButton findNextBtn)
    {
        this.findNextBtn = findNextBtn;
    }

    public JTextField getFindWhat()
    {
        return findWhat;
    }

    public void setFindWhat(JTextField findWhat)
    {
        this.findWhat = findWhat;
    }

    public JButton getReplaceAllBtn()
    {
        return replaceAllBtn;
    }

    public void setReplaceAllBtn(JButton replaceAllBtn)
    {
        this.replaceAllBtn = replaceAllBtn;
    }

    public JButton getReplaceBtn()
    {
        return replaceBtn;
    }

    public void setReplaceBtn(JButton replaceBtn)
    {
        this.replaceBtn = replaceBtn;
    }

    public JTextField getReplaceWith()
    {
        return replaceWith;
    }

    public void setReplaceWith(JTextField replaceWith)
    {
        this.replaceWith = replaceWith;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        findWhat = new javax.swing.JTextField();
        replaceWith = new javax.swing.JTextField();
        findNextBtn = new javax.swing.JButton();
        replaceBtn = new javax.swing.JButton();
        replaceAllBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Find what:");

        jLabel2.setText("Replace with:");

        findNextBtn.setText("Find Next");
        findNextBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                findNextBtnActionPerformed(evt);
            }
        });

        replaceBtn.setText("Replace");
        replaceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                replaceBtnActionPerformed(evt);
            }
        });

        replaceAllBtn.setText("Replace All");
        replaceAllBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                replaceAllBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(findWhat)
                    .addComponent(replaceWith, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(replaceAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(replaceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findNextBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(findWhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findNextBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replaceWith, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(replaceBtn))
                .addGap(18, 18, 18)
                .addComponent(replaceAllBtn)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findNextBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_findNextBtnActionPerformed
    {//GEN-HEADEREND:event_findNextBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findNextBtnActionPerformed

    private void replaceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_replaceBtnActionPerformed
    {//GEN-HEADEREND:event_replaceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replaceBtnActionPerformed

    private void replaceAllBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_replaceAllBtnActionPerformed
    {//GEN-HEADEREND:event_replaceAllBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replaceAllBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelBtnActionPerformed
    {//GEN-HEADEREND:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton findNextBtn;
    private javax.swing.JTextField findWhat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton replaceAllBtn;
    private javax.swing.JButton replaceBtn;
    private javax.swing.JTextField replaceWith;
    // End of variables declaration//GEN-END:variables
}
