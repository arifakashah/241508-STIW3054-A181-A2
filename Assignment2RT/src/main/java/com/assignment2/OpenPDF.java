package com.assignment2;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class OpenPDF {

    public void openFile() {
        try {
            out.print("\nOpening the file...");
            Desktop.getDesktop().open(new File("chessResult.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
