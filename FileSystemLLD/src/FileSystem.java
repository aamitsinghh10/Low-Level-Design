import java.util.*;
class FileSystem {
    private static FileSystem instance;
    private Directory root;
    private Map<String, User> users;
    private FileSystem() {
        root = new Directory("root", null, null);
        users = new HashMap<>();
    }
    public static FileSystem getInstance() {
        if(instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }
    public Directory getRoot() {
        return root;
    }
    public User addUser(String name, String email) {
        User user = new User(UUID.randomUUID().toString(), name, email);
        users.put(user.getId(), user);
        return user;
    }
    public User getUser(String id) {
        return users.get(id);
    }
}

