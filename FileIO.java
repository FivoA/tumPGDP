import java.io.*;

public class FileIO {

    // example for reading and writing a file with penguins

    public void save(Penguin p, String filename) {
        // TODO
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(p.name() + "\n");
            bw.write(p.age() + "\n");
            bw.write(p.weight() + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Penguin load(String filename) {
        // TOD
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            //Penguin p = new Penguin(line,br.readLine(),br.readLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
