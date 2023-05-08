package domain;

public class Magazine extends PrintedMatter{
    private String type;
    private String editor;
    private int first_issue = 1;

    public Magazine(String[] line) {
        super(line[1], line[2], line[3], line[4], line[5]);
        type = line[6];
        editor = line[7];
        first_issue = Integer.parseInt(line[8]);;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFirst_issue() {
        return first_issue;
    }

    public void setFirst_issue(int first_issue) {
        this.first_issue = first_issue;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Журнал. ");
        builder.append(super.toString());
        builder.append(" type: ");
        builder.append(type);
        builder.append(" | editor: ");
        builder.append(editor);
        builder.append(" | first_issue: ");
        builder.append(first_issue);
        return builder.toString();
    }
}
