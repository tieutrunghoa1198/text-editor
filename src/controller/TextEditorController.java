/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.FileOperator;
import view.TextEditor;

/**
 *
 * @author songm
 */
public class TextEditorController
{

    TextEditor mte;
    
    public TextEditorController()
    {
        mte = new TextEditor();
        FileOperator fileCtrl = new FileOperator(mte);
        EditOperator edit = new EditOperator(mte);
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

        java.awt.EventQueue.invokeLater(() ->
        {
            mte.setVisible(true);
        });
    }

}
