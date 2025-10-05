import java.util.UUID;
public abstract class Node {
    protected String id;
    protected String name;
    protected Directory parent;
    protected Metadata metadata;
    protected User owner;

    public Node(String name, Directory parent, User owner) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.parent = parent;
        this.owner = owner;
        this.metadata = new Metadata();
    }
    public abstract void print(String prefix);
    public String getName() {return name;}
    public Metadata getMetadata() {return metadata;}
    public Directory getParent() {return parent;}
    public User getOwner() {return owner;}
    public String getId() {return id;}
    public String getPath() {
        if (parent == null) {
            return "/" + name;
        }
        return parent.getPath() + "/" + name;
    }
}
