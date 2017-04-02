import java.io.Console;

/**
 * * datou on 2017/4/2.
 */
public class console {
    public static void main(String[] args) {
        Console console = System.console();
        String password ;
        password = new String(console.readPassword());
        System.out.println("password="+password);
    }
}
