package com.compressoranddecompressor.Model;

import java.io.*;

import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void compressOperation(File file) throws IOException {

        // Getting The Parent Directory Absolute Path.
        String parentFileDirectory= file.getParent();


        FileInputStream fileInputStream = new FileInputStream(file);

        // Pushing The Output In The Same Directory of selected File
        FileOutputStream fileOutputStream = new FileOutputStream(parentFileDirectory+"/CompressedFile.gz");

        // To Compress Used GZIPOutputStream.
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);

        byte[] buffer = new byte[2048];



        int len ;

        // Read the bits in the file entirely

        while((len = fileInputStream.read(buffer))!=-1){
            gzipOutputStream.write(buffer,0,len);
        }

        gzipOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
}
