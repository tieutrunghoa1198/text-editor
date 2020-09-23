/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author songm
 */
public class NewClass
{
    public static void main(String[] args)
    {
        String pwd = System.getProperty("user.dir");
        System.out.println(pwd);
//        String s = new String(Files.readAllBytes(path));
        String[] tach = pwd.split("\\\\");
        System.out.println(tach[tach.length - 1]);
    }
}
