package project1;

import util.Constants.Format;
import converter.impl.JasonConverter;
import project1.cmd.BinaryFormatCmdProcessor;
import project1.cmd.Executable;
import project1.cmd.StringFormatCmdProcessor;

public class FormatFactory {

    private final Executable jsonExecutable = new StringFormatCmdProcessor(new JasonConverter());
    private final Executable binaryExecutable = new BinaryFormatCmdProcessor();

    public Executable getInstance(String format) {
        Executable instance;
        switch (format.toLowerCase()) {
            case Format.YML:
            case Format.CSV:
            case Format.XML:
            case Format.JSON:
                instance = jsonExecutable;
                break;
            default:
                instance = binaryExecutable;
        }
        return instance;
    }
}
