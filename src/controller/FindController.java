/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.*;

/**
 *
 * @author songm
 */
public class FindController
{

    private FindDialog findDialog;
    private TextEditor mte;

    public FindController(TextEditor mte)
    {
        this.mte = mte;
        findDialog = new FindDialog(mte, true);
        findDialog.setLocationRelativeTo(mte);
        findDialog.setTitle("Find");
        setLookAndFeel();
    }
    // <editor-fold defaultstate="collapsed" desc="Look and feel"> 
    private void setLookAndFeel()
    {
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
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FindDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FindDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FindDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FindDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    public void display()
    {
        findDialog.setVisible(true);
    }

}
