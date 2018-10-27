package com.assignment2;

/**
 * Read Excel file to Java then convert to PDF
 * created by ArifAkashah
 */
public class App {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.start();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {

                CreatePDF printPDF = new CreatePDF();
                ExcelReader printExcel = new ExcelReader();
                OpenPDF openPDF = new OpenPDF();

                printExcel.readFile();
                sleep(Common.SLEEP_THREAD);
                printPDF.writeFile();
                sleep(Common.SLEEP_THREAD);
                openPDF.openFile();
                sleep(Common.SLEEP_THREAD);

            } catch (Exception e) {
                System.out.println("Error in Thread!");

            }
        }
    }


}
