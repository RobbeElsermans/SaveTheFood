package com.example.savethefood.SaveData;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileStream {

    private File file;

    public FileStream(String location,Context context)
    {
        File filePath = context.getFilesDir();
        file = new File(filePath, location);
    }
    public void writeRecipeToFile(String data) throws IOException {

        String savedData = readFromFile();
        if (!savedData.isEmpty())
        {
            int lenghtString = savedData.length();
            String newSavedData = savedData.substring(0, lenghtString -1);
            data = newSavedData + ","  + data + "]";
        }
        else
        {
            data =  "[" + data + "]";
        }

        //data = "";
        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(data.getBytes());
        } catch (IOException e) {
        }
    }

    public void writeNewRecipesToFile(String data){
        try (FileOutputStream stream = new FileOutputStream(file)) {
            if (!data.isEmpty())
                data = "[" + data + "]";
            stream.write(data.getBytes());
        } catch (IOException e) {
        }
    }

    public String readFromFile() throws IOException {
        int length = (int) file.length();

        byte[] bytes = new byte[length];

        try (FileInputStream in = new FileInputStream(file)) {
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(bytes);
    }
}
