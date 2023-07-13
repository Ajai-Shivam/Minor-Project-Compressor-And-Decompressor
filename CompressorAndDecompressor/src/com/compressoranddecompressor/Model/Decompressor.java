package com.compressoranddecompressor.Model;

import java.io.*;
import java.util.zip.GZIPInputStream;


public class Decompressor {
    public static void decompressionOperation(File file) throws IOException {

        // Getting The Parent Directory Absolute Path.
        String parentFileDirectory= file.getParent();

        // Reading the Compressed File.
        FileInputStream fileInputStream = new FileInputStream(file);

        // Using GZIPInputStream going to decompress it
        GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(parentFileDirectory+   "/DecompressedFile");

        byte[] buffer = new byte[1024];

        int len ;

        while ((len = gzipInputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,len);
        }


        gzipInputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
