/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.UndoManager;
import view.TextEditor;

/**
 *
 * @author songm
 */
public class EditOperator
{

    private final TextEditor mte;
    private final UndoManager undoManager;
    private final FindController findDialog;
    private final ReplaceController replaceDialog;
    private final FontController fontDialog;

    public EditOperator(TextEditor mte)
    {
        this.mte = mte;
        undoManager = new UndoManager();
        findDialog = new FindController(mte);
        replaceDialog = new ReplaceController(mte);
        fontDialog = new FontController(mte);
        selectAll();
        cut();
        copy();
        paste();
        undo();
        redo();
        find();
        replace();
        font();
        implementUndo();
        removeCtrlH();
    }

    private void removeCtrlH()
    {
        JTextArea txtArea = mte.getjTextArea1();
        txtArea.getInputMap().put(KeyStroke.getKeyStroke("ctrl H"), "none");
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

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        if (undoManager.canUndo())
        {
            undoManager.undo();
        }
    }

    private void redoBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        if (undoManager.canRedo())
        {
            undoManager.redo();
        }
    }

    private void findBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        findDialog.display();
    }

    private void replaceBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        replaceDialog.display();
        System.out.println("something ");
    }

    private void fontBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        fontDialog.display();
    }

    private void implementUndo()
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.getDocument().addUndoableEditListener((UndoableEditEvent e) ->
        {
            undoManager.addEdit(e.getEdit());
        });
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

    private void undo()
    {
        JMenuItem undoBtn = mte.getUndoBtn();
        undoBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            undoBtnActionPerformed(evt);
        });
    }

    private void redo()
    {
        JMenuItem redoBtn = mte.getRedoBtn();
        redoBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            redoBtnActionPerformed(evt);
        });
    }

    private void find()
    {
        JMenuItem findBtn = mte.getFindBtn();
        findBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            findBtnActionPerformed(evt);
        });
    }

    private void replace()
    {
        JMenuItem replaceBtn = mte.getReplaceBtn();
        replaceBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            replaceBtnActionPerformed(evt);
        });
    }

    private void font()
    {
        JMenuItem fontBtn = mte.getFontBtn();
        fontBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            fontBtnActionPerformed(evt);
        });
    }
// </editor-fold>
}
