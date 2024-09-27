package co.edu.uptc.persistence;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Persistence {

    public void store(String storeJson) throws FileNotFoundException {
        PrintWriter print = new PrintWriter("data/processor.json");
        print.write(storeJson);
        print.close();
    }

    public JsonReader load() throws FileNotFoundException {
        return new JsonReader(new FileReader("data/processor.json"));
    }
}
