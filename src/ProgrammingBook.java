import java.io.*;
import java.util.ArrayList;

public class ProgrammingBook extends Book implements Serializable{
    private String language;
    private String framework;


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public ProgrammingBook() {
    }

    public ProgrammingBook(String bookCode, String name, double price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    @Override
    public String toString() {
        return "Programing Book: " + getName() + " | Author: " +getAuthor() + " | Language : " + getLanguage() + " | Framework : " + getFramework() + " | Price: " + getPrice();
    }

    public static void writeProgrammingBook(String pathFile, ArrayList<ProgrammingBook> programmingBooks) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (ProgrammingBook programmingBook : programmingBooks) {
            objectOutputStream.writeObject(programmingBook);
        }
        objectOutputStream.close();
    }

    public static void readProgrammingBook(String pathFile) throws IOException, ClassNotFoundException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream(pathFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ProgrammingBook myProgrammingBook;
        try {
            while ((myProgrammingBook = (ProgrammingBook) objectInputStream.readObject()) != null) {
                System.out.println(myProgrammingBook.toString());
                Thread.sleep(500);
            }
        } catch (EOFException e) {
            System.out.println("Finish reading");
        }

    }
}
