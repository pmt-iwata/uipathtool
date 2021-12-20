package jp.co.pmtech.iwata;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class App {

    public static final void main(String[] args) {

        UiPathTool main = new UiPathTool();
        CmdLineParser parser = new CmdLineParser(main);

        try {
            parser.parseArgument(args);
        }
        catch (CmdLineException e) {
            System.out.println("usage:");
            parser.printSingleLineUsage(System.out);
            System.out.println();
            parser.printUsage(System.out);
            return;
        }

        main.execute();
    }
}