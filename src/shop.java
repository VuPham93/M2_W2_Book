import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class shop {
    public static void main(String[] args) {
        ArrayList<ProgrammingBook> programmingBooks = new ArrayList<>();
        programmingBooks.add(new ProgrammingBook("BK1", "Think Java", 200.000, "Allen B.Downey & Chris Mayfield", "Java", "GridWorld"));
        programmingBooks.add(new ProgrammingBook("BK2", "Think in Java (4th Edition)", 100.000, "Bruce Eckel", "Java", "JSF"));
        programmingBooks.add(new ProgrammingBook("BK3", "Effective Java", 300.000, "Joshua Bloch", "Java", "Struts"));
        programmingBooks.add(new ProgrammingBook("BK4", "Giáo trình Kỹ thuật lập trình C căn bản & nâng cao ", 230.000, "Phạm Văn Ất", "C", "Hibernate"));
        programmingBooks.add(new ProgrammingBook("BK5", "C# Yellow Book", 570.000, "Rob Miles", "C#", "GWT"));

        ArrayList<FictionBook> fictionBooks = new ArrayList<>();
        fictionBooks.add(new FictionBook("FB1", "Harry Porter" , 650.000, "J.K. Rowling", "Fantasy" ));
        fictionBooks.add(new FictionBook("FB2", "Frankenstein" , 450.000, "Mary Shelley", "Horror" ));
        fictionBooks.add(new FictionBook("FB3", "Charlotte's Web" , 250.000, "E.B. White", "For Kid" ));
        fictionBooks.add(new FictionBook("FB4", "The Book Thief" , 400.000, "Robert Crayola", "War" ));
        fictionBooks.add(new FictionBook("FB5", "Dracula" , 300.000, "Bram Stoker", "Horror" ));

        try {
            ProgrammingBook.writeProgrammingBook("ProgramingBook.txt", programmingBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FictionBook.writeFictionBook("FictionBook.txt", fictionBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ProgrammingBook.readProgrammingBook("ProgramingBook.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            FictionBook.readFictionBook("FictionBook.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        double totalPrice = 0;
//        int pbCount = 0;
//
//        for (ProgrammingBook pb : programmingBooks) {
//            totalPrice += pb.getPrice();
//            if (pb.getLanguage().equals("Java"))
//                pbCount++;
//        }
//        for (FictionBook fb : fictionBooks) {
//            totalPrice += fb.getPrice();
//
//        }
//        System.out.println("Total price of ten books is " + totalPrice + " VND");
//        System.out.println("There are " + pbCount + " books about Java");
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("What book you want to find?");
//        String findingBook = sc.nextLine();
//
//
//        for (ProgrammingBook pb : programmingBooks) {
//            if (pb.getName().equals(findingBook))
//                System.out.println("Price of finding book is : " + pb.getPrice() + " VND");
//        }
//        for (FictionBook fb : fictionBooks) {
//            if (fb.getName().equals(findingBook))
//                System.out.println("Price of finding book is : " + fb.getPrice() + " VND");
//        }
    }
}
