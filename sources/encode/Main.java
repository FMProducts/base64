package fmproducts.base64.encode;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static String textPath = getPath()+"/base.txt";
    private static String imagePath = getPath()+"/image.jpg";


    public static void main(String[] args) throws URISyntaxException {
        try {
            File file = new File(imagePath);
            String result = encode(file);
            write(result);
            System.out.print("okey");

        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }


    }

    private static String encode(File file) throws FileNotFoundException, IOException {
        FileInputStream stream = new FileInputStream(file);
        byte[] b = new byte[(int)file.length()];
        stream.read(b);
        return com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(b);
    }
    private static void write(String str) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(textPath, "UTF-8");
        writer.print(str);
        writer.close();
    }
    private static String getPath(){
        String str = null;
        try {
            str = new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI()).getParent();
            return str;
        } catch (URISyntaxException e) {
            System.out.print(e.getMessage());
            return null;
        }
    }
}
