import java.io.*;
import java.util.ArrayList;

public class FictionBook extends Book implements Serializable{
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FictionBook() {
    }

    public FictionBook(String bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }

    @Override
    public String toString() {
        return "Fiction Book: " + getName() + " | Author: " +getAuthor() + " | Category : " + getCategory() + " | Price: " + getPrice();
    }

    public static void writeFictionBook(String pathFile, ArrayList<FictionBook> fictionBooks) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (FictionBook fictionBook : fictionBooks) {
            objectOutputStream.writeObject(fictionBook);
        }
        objectOutputStream.close();
    }

    public static void readFictionBook(String pathFile) throws IOException, ClassNotFoundException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream(pathFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        FictionBook myFicBook;

        try {
            while ((myFicBook = (FictionBook) objectInputStream.readObject()) != null) {
                System.out.println(myFicBook.toString());
                Thread.sleep(500);
            }
        } catch (EOFException e) {
            System.out.println("Finish reading");
        }
    }
}
