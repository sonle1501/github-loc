package dev.sonle.githubloc.output;

public class ConsoleOutput {
    public static String getAsciiTitle() {
        String art = "  __                                         \r\n" + //
                " /__  o  _|_  |_        |_   __  |    _    _ \r\n" + //
                " \\_|  |   |_  | |  |_|  |_)      |_  (_)  (_ \r\n" + //
                "                                             \r\n" + //
                "                                             \r\n" + //
                " ._   ._   _    o   _    _  _|_              \r\n" + //
                " |_)  |   (_)   |  (/_  (_   |_              \r\n" + //
                " |             _|                            ";

        String author = "by Sonle1501";
        return art + "\n\n" + author;
    }

    public static String getSeperator() {
        String art = "=============================================\r\n";
        return art;
    }

    public static void waitForExit() {
        try {
            System.out.println(getSeperator());
            System.out.println("The program is finished. Press Enter to exit...");
            System.in.read();
        } catch (java.io.IOException e) {
        }
    }

    public static void main(String[] args) {
        System.out.println(ConsoleOutput.getAsciiTitle());
    }
}
