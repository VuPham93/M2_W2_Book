import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite<E> {

    public void writeProgrammingBook(String pathFile, ArrayList<E> books) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (E book : books) {
            objectOutputStream.writeObject(book);
        }
        objectOutputStream.close();
    }

    public  void readProgrammingBook(String pathFile) throws IOException, ClassNotFoundException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream(pathFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        E book;
        try {
            while ((book = (E) objectInputStream.readObject()) != null) {
                System.out.println(book.toString());
                Thread.sleep(500);
            }
        } catch (EOFException e) {
            System.out.println("Finish reading");
        }

    }
}
