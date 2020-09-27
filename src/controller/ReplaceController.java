/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import view.*;

/**
 *
 * @author songm
 */
public class ReplaceController
{

    private ReplaceDialog replaceDialog;
    private TextEditor mte;
    private int currentWordPos = 0;

    public ReplaceController(TextEditor mte)
    {
        this.mte = mte;
        replaceDialog = new ReplaceDialog(mte, true);
        replaceDialog.setLocationRelativeTo(mte);
        replaceDialog.setTitle("Replace");
        setLookAndFeel();
        findNext();
        replace();
        replaceAll();
        cancel();
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ReplaceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    public void display()
    {
        replaceDialog.setVisible(true);
    }

    private List<Integer> listOfWordFound()
    {
        JTextArea textArea = mte.getjTextArea1();
        String content = textArea.getText();
        String searchTerm = replaceDialog.getFindWhat().getText();
        List<Integer> foundIndex = new ArrayList<>();
        //the index is found here is the starting index of word found
        for (int i = -1; (i = content.indexOf(searchTerm, i + 1)) != -1; i++)
        {
            foundIndex.add(i);
        }
        return foundIndex;
    }

    private void find()
    {
        JTextArea textArea = mte.getjTextArea1();
        String searchTerm = replaceDialog.getFindWhat().getText();
        List<Integer> wordFound = listOfWordFound();
        String content = textArea.getText();

        if (content.contains(searchTerm) == false)
        {
            JOptionPane.showConfirmDialog(null, "Cannot find \"" + searchTerm + "\"", "My Text Editor", JOptionPane.DEFAULT_OPTION);
            return;
        }

        if (currentWordPos > (wordFound.size() - 1))
        {
            currentWordPos = 0;
            int start = wordFound.get(currentWordPos);
            int end = start + searchTerm.length();
            textArea.select(start, end);
        } else
        {
            int start = wordFound.get(currentWordPos);
            int end = start + searchTerm.length();
            textArea.select(start, end);
        }
        currentWordPos++;
    }

    //action performed fundtions 
    private void findNextBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        find();
    }

    private void replaceBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        JTextArea textArea = mte.getjTextArea1();
        String searchTerm = replaceDialog.getFindWhat().getText();
        String content = textArea.getText();
        //if search term cannot be found in textarea then do nothing
        if (content.contains(searchTerm) == false)
        {
            JOptionPane.showConfirmDialog(null, "Cannot find \"" + searchTerm + "\"", "My Text Editor", JOptionPane.DEFAULT_OPTION);
            return;
        }

        int start = mte.getjTextArea1().getSelectionStart();
        int end = mte.getjTextArea1().getSelectionEnd();
        //if there is no word is selected in textare then do nothing
        if ((end - start) == 0)
        {
            return;
        }
        //replace selected word with the new one
        mte.getjTextArea1().replaceSelection(replaceDialog.getReplaceWith().getText());
        currentWordPos -= 1;
    }

    private void replaceAllBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        JTextArea textArea = mte.getjTextArea1();
        String searchTerm = replaceDialog.getFindWhat().getText();
        String content = textArea.getText();
        //if search term cannot be found in textarea then do nothing
        if (content.contains(searchTerm) == false)
        {
            JOptionPane.showConfirmDialog(null, "Cannot find \"" + searchTerm + "\"", "My Text Editor", JOptionPane.DEFAULT_OPTION);
            return;
        }

        String replaceWith = replaceDialog.getReplaceWith().getText();
        mte.getjTextArea1().setText(mte.getjTextArea1().getText().replaceAll(searchTerm, replaceWith));
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        replaceDialog.dispose();
    }

    /*
        auto generated code 
     */
    // <editor-fold defaultstate="collapsed" desc="Look and feel"> 
    private void findNext()
    {
        JButton findNextBtn = replaceDialog.getFindNextBtn();
        findNextBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            findNextBtnActionPerformed(evt);
        });
    }

    private void replace()
    {
        JButton replaceBtn = replaceDialog.getReplaceBtn();
        replaceBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            replaceBtnActionPerformed(evt);
        });
    }

    private void replaceAll()
    {
        JButton replaceAllBtn = replaceDialog.getReplaceAllBtn();
        replaceAllBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            replaceAllBtnActionPerformed(evt);
        });
    }

    private void cancel()
    {
        JButton cancelBtn = replaceDialog.getCancelBtn();
        cancelBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            cancelBtnActionPerformed(evt);
        });
    }
    //</editor-fold>
}
