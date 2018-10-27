package com.assignment2;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import static java.lang.System.out;

public class ExcelReader {

    public void readFile() {

        String number, name, fideID, fed, rating, city;

        try {
            out.println("Reading data from " + Common.PATH);
            out.println(" ");
            FileInputStream inputStream = new FileInputStream(Common.PATH);

            //Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet firstSheet = workbook.getSheetAt(0);

            for (Row rowIterator : firstSheet) {
                DataFormatter formatter = new DataFormatter(Locale.US);


                if (rowIterator.getRowNum() <= 3) {

                    Common.textHeader.add(rowIterator.getCell(0).toString());

                } else if (rowIterator.getRowNum() >= 4 && rowIterator.getRowNum() <= 154) {
                    number = formatter.formatCellValue(rowIterator.getCell(0));
                    name = rowIterator.getCell(2).toString();
                    fideID = rowIterator.getCell(3).toString();
                    fed = rowIterator.getCell(4).toString();
                    rating = formatter.formatCellValue(rowIterator.getCell(5));
                    city = rowIterator.getCell(6).toString();

                    Common.studentList.add(new Student(number, name, fideID, fed, rating, city));

                } else if (rowIterator.getRowNum() >= 155) {

                    Common.textFooter.add(rowIterator.getCell(0).toString());
                } else {
                    System.out.print("Success");
                }

            }

            for (String text : Common.textHeader) {
                System.out.println(text);
            }

            for (Student student : Common.studentList) {
                System.out.printf("%-5s %-70s %-15s %-15s %-7s %-35s %n", student.getNumber(), student.getName(), student.getFideID(),
                        student.getFed(), student.getRating(), student.getCity());

            }
            out.println(" ");

            for (String text : Common.textFooter) {
                System.out.println(text);

            }
            out.println("\nSuccessfully read the data!");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
