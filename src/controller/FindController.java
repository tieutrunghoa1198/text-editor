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
public class FindController
{

    private FindDialog findDialog;
    private TextEditor mte;
    private int currentWordPos = 0;
    private boolean directionUp;

    public FindController(TextEditor mte)
    {
        this.mte = mte;
        findDialog = new FindDialog(mte, true);
        findDialog.setLocationRelativeTo(mte);
        findDialog.setTitle("Find");
        setLookAndFeel();
        find();
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
        findDialog.setVisible(true);
    }

    private List<Integer> listOfWordFound()
    {
        JTextArea textArea = mte.getjTextArea1();
        String content = textArea.getText();
        String searchTerm = findDialog.getjTextField1().getText();
        List<Integer> foundIndex = new ArrayList<>();
        //the index is found here is the starting index of word found
        for (int i = -1; (i = content.indexOf(searchTerm, i + 1)) != -1; i++)
        {
            foundIndex.add(i);
        }
        return foundIndex;
    }

    private void findNextBtnActionPerformed(java.awt.event.ActionEvent evt)
    {

        if (findDialog.getUpBtn().isSelected())
        {
            if (directionUp == false)
            {
                currentWordPos -= 2;
                directionUp = true;
            }
            findUp();
        } else
        {
            if (directionUp == true)
            {
                currentWordPos += 2;
                directionUp = false;
            }
            findDown();
        }
    }

    private void findDown()
    {
        JTextArea textArea = mte.getjTextArea1();
        String searchTerm = findDialog.getjTextField1().getText();
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
            textArea.select(start, start + searchTerm.length());
        } else
        {
            int start = wordFound.get(currentWordPos);
            textArea.select(start, start + searchTerm.length());
        }
        currentWordPos++;
    }

    private void findUp()
    {
        JTextArea textArea = mte.getjTextArea1();
        String searchTerm = findDialog.getjTextField1().getText();
        List<Integer> wordFound = listOfWordFound();
        String content = textArea.getText();

        if (content.contains(searchTerm) == false)
        {
            JOptionPane.showConfirmDialog(null, "Cannot find \"" + searchTerm + "\"", "My Text Editor", JOptionPane.DEFAULT_OPTION);
            return;
        }

        if (currentWordPos < 0)
        {
            currentWordPos = wordFound.size() - 1;
            int start = wordFound.get(currentWordPos);
            textArea.select(start, start + searchTerm.length());
        } else
        {
            int start = wordFound.get(currentWordPos);
            textArea.select(start, start + searchTerm.length());
        }
        currentWordPos--;
    }

//    // find all occurrences forward
//for (int i = -1; (i = text.indexOf(word, i + 1)) != -1; i++) {
//    System.out.println(i);
//} // prints "4", "13", "22"
//
//// find all occurrences backward
//for (int i = text.length(); (i = text.lastIndexOf(word, i - 1)) != -1; i++) {
//    System.out.println(i);
//} // prints "22", "13", "4"
    /*
        auto generated code
     */
    private void find()
    {
        JButton findNextBtn = findDialog.getFindNextBtn();
        findNextBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            findNextBtnActionPerformed(evt);
        });
    }

    private void cancel()
    {
        JButton cancelBtn = findDialog.getCancelBtn();
        cancelBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            findDialog.dispose();
        });
    }

}
