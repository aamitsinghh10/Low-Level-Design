import java.util.Date;
public class File extends Node {
    private String content;
    public File(String name, Directory parent, User owner) {
        super(name, parent, owner);
        this.content = "";
    }
    public String read() {
        return content;
    }
    public void write(String content) {
        this.content = content;
        this.metadata.setSize(content.length());
        this.metadata.setUpdatedAt(new Date());
    }
    @Override
    public void print(String prefix) {
        System.out.println(prefix + "File: " + name + " (Size: " + metadata.getSize() + ")");
    }
}
