package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import java.io.*;
import view.TextEditor;
import javax.swing.*;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author songm
 */
public class FileOperator
{

    TextEditor mte;
    boolean isSaved, isNewFile, isModified;
    JFileChooser fileChooser;
    boolean cancelIsClicked;
    String appName = "My Text Editor";
    String untitledName = "Untitled";
    String defaultTitle = untitledName + " - " + appName;
    String filePath;

    public FileOperator(TextEditor mte)
    {
        isSaved = false;
        isNewFile = true;
        this.mte = mte;
        mte.setTitle(untitledName + " - " + appName);
        showConfirmClose();
        newFileBtn();
        openFileBtn();
        saveFileBtn();
        saveAsFileBtn();
        isContentChanged();
        System.out.println(isModified);
    }

    //////////////////////////////////
    private void newFile()
    {
        if (isSaved == false && hasContent() == true)
        {
            showConfirmNewFile();
        } else
        {
            createEmptyDocument();
        }
    }

    private void isContentChanged()
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                System.out.println(isModified);
                System.out.println("Input insert function");
                isSaved = false;
                if (isModified == false)
                {
                    mte.setTitle("*" + mte.getTitle());
                    isModified = true;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                System.out.println("Remove function");
                isSaved = false;
                if (isModified == false)
                {
                    mte.setTitle("*" + mte.getTitle());
                    isModified = true;
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                System.out.println("Changed function");
            }
        });
    }

    //START OF SHOW DIALOG CODE
    private void showSaveFileDialog()
    {
        JFileChooser jfc;
        //check if file is exist or not 
        jfc = new JFileChooser(new File("."))
        {
            @Override
            public void approveSelection()
            {
                File f = getSelectedFile();
                if (f.exists() && getDialogType() == SAVE_DIALOG)
                {
                    int returnValue = JOptionPane.showConfirmDialog(null, splitPath(f.toString()) + " already exist.\n Do you want to replace it?", "Save As File", JOptionPane.YES_NO_OPTION);
                    switch (returnValue)
                    {
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                    }
                } else
                {
                    super.approveSelection();
                }
            }
        };

        //file filter 
        jfc.addChoosableFileFilter(new javax.swing.filechooser.FileFilter()
        {
            @Override
            public boolean accept(File f)
            {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription()
            {
                return "Text Files (*.txt)";
            }
        });

        // innitialize save dialog 
        jfc.setDialogTitle("Save File");
        jfc.setSelectedFile(new File(untitledName + ".txt"));
        int option = jfc.showSaveDialog(null);
        String path = jfc.getSelectedFile().toString();
        String title = splitPath(path);
        filePath = path;

        switch (option)
        {
            case JFileChooser.APPROVE_OPTION:
                System.out.println("save success");
                writeContentToFile(jfc.getSelectedFile(), mte.getjTextArea1().getText());
                mte.setTitle(title + " - " + appName);
                break;
            case JFileChooser.CANCEL_OPTION:
                System.out.println("nothing saved");
                break;
        }

        //end of initialize save dialog 
    }

    private void showConfirmNewFile()
    {
        String frameTitle = mte.getTitle().split("-")[0];
        int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to save change to " + frameTitle, "My Text Editor (MTE)", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (confirmOption)
        {
            case JOptionPane.YES_OPTION:
                showSaveFileDialog();
                break;
            case JOptionPane.NO_OPTION:
                createEmptyDocument();
                break;
            case JOptionPane.CANCEL_OPTION:
                mte.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                break;
        }
    }

    private void showConfirmClose()
    {
        String frameTitle = mte.getTitle().split("-")[0];
        mte.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                if (isSaved == false && hasContent() == true)
                {
                    int confirmOption = JOptionPane.showConfirmDialog(null, "Do you want to save change to " + frameTitle, "My Text Editor (MTE)", JOptionPane.YES_NO_CANCEL_OPTION);
                    switch (confirmOption)
                    {
                        case JOptionPane.YES_OPTION:
                            showSaveFileDialog();
                            break;
                        case JOptionPane.NO_OPTION:
                            e.getWindow().dispose();
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            mte.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                            break;
                    }
                } else
                {
                    e.getWindow().dispose();
                }
            }

        });
    }
    // END OF DIALOG CODE

    private boolean hasContent()
    {
        return !mte.getjTextArea1().getText().equals("");
    }

    private void createEmptyDocument()
    {
        JTextArea textArea = mte.getjTextArea1();
        textArea.setText("");
    }

    private String splitPath(String pathString)
    {
        String[] seperator = pathString.split("\\\\");
        String title = seperator[seperator.length - 1].split("\\.")[0];
        return title;
    }

    private void writeContentToFile(File file, String content)
    {
        try
        {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            isSaved = true;
            isNewFile = false;
        } catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Can not save at saveFile(file, content)");
        }
    }

    /*
        action performed functions
     */
    private void newFileBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        newFile();
        isNewFile = true;
        isSaved = false;
        isModified = false;
        mte.setTitle(defaultTitle);
    }

    private void saveFileBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        if (isSaved == false && hasContent() == true && isNewFile == true)
        {
            //ask if user wants to save or not
            showSaveFileDialog();

        } else if (isSaved == false && hasContent() == true && isNewFile == false)
        {
            //save only content to current saved file and saveDialog is not displayed
            File file = new File(filePath);
            String content = mte.getjTextArea1().getText();
            writeContentToFile(file, content);
        }
        isModified = false;
        mte.setTitle(mte.getTitle().replace("*", ""));
    }

    private void openFileBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:
    }

    private void saveAsBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        showSaveFileDialog();
    }

    /*
        automatic generated code from TextEditor JFrame
        those code below should not be changed
     */
    private void saveFileBtn()
    {
        JMenuItem saveFileMte = mte.getSaveFileBtn();
        saveFileMte.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            saveFileBtnActionPerformed(evt);
        });
    }

    private void saveAsFileBtn()
    {
        JMenuItem saveAsBtn = mte.getSaveAsBtn();
        saveAsBtn.addActionListener(this::saveAsBtnActionPerformed);
    }

    private void openFileBtn()
    {
        JMenuItem openFileBtn = mte.getOpenFileBtn();
        openFileBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            openFileBtnActionPerformed(evt);
        });
    }

    private void newFileBtn()
    {
        JMenuItem newFileMte = mte.getNewFileBtn();
        newFileMte.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            newFileBtnActionPerformed(evt);
        });
    }

}
