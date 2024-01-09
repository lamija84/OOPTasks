package week13.github.lab.task3;

public class Main {
    public static void main(String[] args)
    {
        TextEditor textEditor=new TextEditor();
        textEditor.setTextFormatter(new UpperCaseFormatter());
        System.out.println(textEditor.formatText("Hey, how are you?"));

        textEditor.setTextFormatter(new LowerCaseFormatter());
        System.out.println(textEditor.formatText("Hey, how are you?"));

        textEditor.setTextFormatter(new CamelCaseFormatter());
        System.out.println(textEditor.formatText("Hey, how are you?"));
    }
}
class Strategy {
}
