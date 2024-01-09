package week13.github.lab.task3;

public class TextEditor {
    private TextFormatter textFormatter;

    public void setTextFormatter(TextFormatter textFormatter)
    {
        this.textFormatter=textFormatter;
    }
    public String formatText(String text)
    {
        return textFormatter.formatText(text);
    }
}
