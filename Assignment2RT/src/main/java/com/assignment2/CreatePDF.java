package com.assignment2;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.out;

public class CreatePDF {

    public void writeFile() {

        try {
            out.println("\nWriting the data to chessResult.pdf ");
            out.println(" ");
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("chessResult.pdf"));
            document.open();


            Paragraph header = new Paragraph();
            for (String text : Common.textHeader) {
                header.add(text);
                header.add("\n");
            }

            document.add(header);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            table.setWidths(new float[]{5, 45, 7, 6, 5, 19});
            table.setWidthPercentage(100);
            table.getDefaultCell().setUseAscender(true);

            for (Student student : Common.studentList) {
                table.addCell(student.getNumber());
                table.addCell(student.getName());
                table.addCell(student.getFideID());
                table.addCell(student.getFed());
                table.addCell(student.getRating());
                table.addCell(student.getCity());
            }
            document.add(table);
            document.add(Chunk.NEWLINE);


            Paragraph footer = new Paragraph();
            for (String text : Common.textFooter) {
                footer.add(text);
                footer.add("\n");
            }
            document.add(footer);
            document.add(Chunk.NEWLINE);
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            out.println("Error in setting Table");
        }
        out.println("chessResult.pdf is written successfully on disk.");
    }
}
