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

    private String fileLocation;
    private File filePath;
    private File file;

    public FileStream(String location,Context context)
    {
        this.fileLocation = location;
        filePath = context.getFilesDir();
        file = new File(filePath, fileLocation);
    }
    public void writeToFile(String data) throws IOException {

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
        FileOutputStream stream = new FileOutputStream(file);
        try {
            stream.write(data.getBytes());
        } catch (IOException e)
        {
        } finally {
            stream.close();
        }
    }

    public String readFromFile() throws IOException {
        int length = (int) file.length();

        byte[] bytes = new byte[length];

        FileInputStream in = new FileInputStream(file);
        try {
            in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

        return new String(bytes);
    }
/*
    public void writeToFile(String data, Context context) {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(fileLocation, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    public String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(fileLocation);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

 */
}
