package week13.github.lab.task3;

import week13.github.lab.task3.TextFormatter;

public class UpperCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toUpperCase();

    }
}
