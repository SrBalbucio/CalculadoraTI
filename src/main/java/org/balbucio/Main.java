package org.balbucio;

import com.formdev.flatlaf.intellijthemes.*;
import org.balbucio.frame.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        try {
            UIManager.setLookAndFeel( new FlatDarkPurpleIJTheme() );
            new MainFrame();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}