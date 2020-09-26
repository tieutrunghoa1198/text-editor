/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.*;
import view.TextEditor;

/**
 *
 * @author songm
 */
public class EditOperator
{

    TextEditor mte;

    public EditOperator(TextEditor mte)
    {
        this.mte = mte;
        selectAll();
        cut();
        copy();
        paste();
    }

    /*
        action performed functions
     */
    private void selectAllBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.selectAll();
    }

    private void cutBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.cut();
    }

    private void copyBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.copy();
    }

    private void pasteBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.paste();
    }

    /*
        auto generated code
        those code below should not be changed
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">     
    private void selectAll()
    {
        JMenuItem selectAllBtn = mte.getSelectAllBtn();
        selectAllBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            selectAllBtnActionPerformed(evt);
        });
    }

    private void cut()
    {
        JMenuItem cutBtn = mte.getCutBtn();
        cutBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            cutBtnActionPerformed(evt);
        });
    }

    private void copy()
    {
        JMenuItem copyBtn = mte.getCopyBtn();
        copyBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            copyBtnActionPerformed(evt);
        });
    }

    private void paste()
    {
        JMenuItem pasteBtn = mte.getPasteBtn();
        pasteBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            pasteBtnActionPerformed(evt);
        });
    }
// </editor-fold>
}
