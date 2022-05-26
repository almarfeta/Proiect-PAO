package services;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class IOsingleton {
    private static final IOsingleton Instance = new IOsingleton();

    private IOsingleton() {}

    public static IOsingleton getInstance() {
        return Instance;
    }

    public ArrayList<String> read(String fisier) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(fisier));
            String linie = input.readLine();
            while (linie != null) {
                result.add(linie);
                linie = input.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void write(String action) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("D:\\IntelliJ\\Projects\\ProiectPAO_DB\\src\\main\\java\\audit.csv", true));
            String mesaj = action + "," + timestamp.toString() + "\n";
            output.write(mesaj);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
