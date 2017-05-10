import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ST001 on 2017/5/10.
 */
public class Copy {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/a.txt");
        File outputFile= new File("src/res.txt");

        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile,true);
        int c;
        while((c=in.read())!=-1) {
            out.write(c);
            System.out.print((char)Integer.parseInt(String.valueOf(c)));
        }
        out.write("\r\n");
        in.close();
        out.close();
    }
}
