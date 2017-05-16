package IO;

import java.io.*;

/**
 * Created by ST001 on 2017/5/10.
 */
public class CopyBytes {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/a.txt");
        File outputFile = new File("src/res.txt");
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);

        int c;
        while((c=in.read())!=-1)
            out.write(c);
        in.close();
        out.close();
    }
}
