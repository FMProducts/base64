package fmproducts.base64.decode;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    private static String imagePath = getPath()+"/image.jpg";
    private static String textPath = getPath()+"/base.txt";

    public static void main(String[] args) throws IOException {
        String code = read();
        byte[] b = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.decode(code);

        File file = new File(imagePath);
        writeByte(b , file);

    }


    private static void writeByte(byte[] bytes , File file) throws IOException {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
    }

    private static String read() throws IOException {
        FileReader fr= new FileReader(textPath);
        Scanner scan = new Scanner(fr);

        StringBuilder builder = new StringBuilder();
        int i = 1;

        while (scan.hasNextLine()) {
            builder = builder.append(scan.nextLine());
        }
        fr.close();
        return builder.toString();
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
