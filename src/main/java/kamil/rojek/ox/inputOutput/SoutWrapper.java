package kamil.rojek.ox.inputOutput;

import java.io.PrintStream;

/**
 * @author Kamil Rojek
 */
public class SoutWrapper {

    public static void printMsg(String msg) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        System.out.println(msg);
    }

    public static void printMsg(String msg, boolean oneLine) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        if (oneLine) {
            System.out.print(msg);
        } else {
            System.out.println(msg);
        }
    }

    public static void printMsg(String msg, PrintStream stream) {
        if (msg == null) {
            throw new IllegalArgumentException("Invalid input argument");
        }

        System.setOut(stream);
        System.out.println(msg);
    }
}
