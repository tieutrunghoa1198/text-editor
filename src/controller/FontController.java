/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.*;

/**
 *
 * @author songm
 */
public class FontController
{

    FontDialog fontDialog;
    TextEditor mte;

    public FontController(TextEditor mte)
    {
        this.mte = mte;
        fontDialog = new FontDialog(mte, true);
        fontDialog.setLocationRelativeTo(mte);
        fontDialog.setTitle("Font");
        setLookAndFeel();
        changeFont();
        oke();
        cancel();
        setUpFontDialog();
        setUpCurrentFont();
        changeStyle();
        changeSize();
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
            java.util.logging.Logger.getLogger(Font.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Font.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Font.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Font.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

    public void display()
    {
        fontDialog.setVisible(true);
    }

    //initialize font dialog
    private void setUpFontDialog()
    {
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontDialog.getListFont().setListData(fonts);
        String styles[] =
        {
            "Regular", "Bold", "Italic", "Bold Italic"
        };
        fontDialog.getListStyle().setListData(styles);
        String sizes[] =
        {
            "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "36", "40", "72"
        };
        fontDialog.getListSize().setListData(sizes);

    }

    //display the current font, style, size infomation
    private void setUpCurrentFont()
    {
        Font font = mte.getjTextArea1().getFont();
        String currentFont = font.getFamily();
        int currentStyle = font.getStyle();
        int currentSize = font.getSize();

        fontDialog.getListFont().setSelectedValue(currentFont, true);
        fontDialog.getListStyle().setSelectedIndex(currentStyle);
        fontDialog.getListSize().setSelectedValue(Integer.toString(currentSize), true);

        fontDialog.getFontField().setText(currentFont);
        fontDialog.getStyleField().setText(fontDialog.getListStyle().getSelectedValue());
        fontDialog.getSizeField().setText(Integer.toString(currentSize));
    }

    //return the choosen font
    private void changeFont()
    {
        fontDialog.getListFont().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                String font = fontDialog.getListFont().getSelectedValue();
                int style = fontDialog.getTextPreview().getFont().getStyle();
                int size = fontDialog.getTextPreview().getFont().getSize();
                JTextField fontField = fontDialog.getFontField();

                fontField.setText(font);
                fontDialog.getTextPreview().setFont(new Font(font, style, size));

            }
        });
    }

    //return the choosen style
    private void changeStyle()
    {
        fontDialog.getListStyle().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                String font = fontDialog.getTextPreview().getFont().getFamily();
                int style = fontDialog.getListStyle().getSelectedIndex();
                int size = fontDialog.getTextPreview().getFont().getSize();
                JTextField styleField = fontDialog.getStyleField();

                switch (style)
                {
                    case 0:
                        styleField.setText("Regular");
                        break;
                    case 1:
                        styleField.setText("Bold");
                        break;
                    case 2:
                        styleField.setText("Italic");
                        break;
                    case 3:
                        styleField.setText("Italic Bold");
                        break;
                }
                fontDialog.getTextPreview().setFont(new Font(font, style, size));
            }
        });
    }

    //return the choosen size
    private void changeSize()
    {
        fontDialog.getListSize().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                String font = fontDialog.getTextPreview().getFont().getFamily();
                int style = fontDialog.getTextPreview().getFont().getStyle();
                String selectedSize = fontDialog.getListSize().getSelectedValue();
                int size = Integer.parseInt(selectedSize);
                JTextField sizeField = fontDialog.getSizeField();

                sizeField.setText(selectedSize);
                fontDialog.getTextPreview().setFont(new Font(font, style, size));
            }
        });
    }

    private void changeFontFormat()
    {
        String font = fontDialog.getListFont().getSelectedValue();
        int style = fontDialog.getListStyle().getSelectedIndex();
        String selectedSize = fontDialog.getListSize().getSelectedValue();
        int size = Integer.parseInt(selectedSize);

        JTextField fontField = fontDialog.getFontField();
        JTextField styleField = fontDialog.getStyleField();
        JTextField sizeField = fontDialog.getSizeField();

        if (fontField.getText().isEmpty() || styleField.getText().isEmpty() || sizeField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please choose valid font, style, size format.", "My Text Editor", JOptionPane.DEFAULT_OPTION);
            return;
        }

        mte.getjTextArea1().setFont(new Font(font, style, size));
    }

    private void okeBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        changeFontFormat();
        fontDialog.dispose();
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt)
    {
        fontDialog.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated code"> 
    private void oke()
    {
        JButton okeBtn = fontDialog.getOkeBtn();
        okeBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            okeBtnActionPerformed(evt);
        });
    }

    private void cancel()
    {
        JButton cancelBtn = fontDialog.getCancelBtn();
        cancelBtn.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            cancelBtnActionPerformed(evt);
        });
    }
    //</editor-fold>
}
