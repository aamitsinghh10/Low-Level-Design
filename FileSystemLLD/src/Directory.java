import java.util.*;
public class Directory extends Node {
    private List<Node> children;
    public Directory(String name, Directory parent, User owner) {
        super(name, parent, owner);
        this.children = new ArrayList<>();
    }
    public void addChild(Node node) {
        children.add(node);
        node.parent = this;
    }
    public void removeChild(Node node) {
        children.remove(node);
    }
    public List<Node> getChildren() {
        return children;
    }
    @Override
    public void print(String prefix) {
        System.out.println(prefix + "Directory: " + name);
        for (Node child : children) {
            child.print(prefix + "  ");
        }
    }
}