public class Main {
    public static void main(String[] args) {
        FileSystem fs = FileSystem.getInstance();
        // Create a user
        User admin = fs.addUser("Admin", "admin@example.com");

        // Get root directory
        Directory root = fs.getRoot();

        // Create sub-directory "Documents"
        Directory documents = new Directory("Documents", root, admin);
        root.addChild(documents);

        // Create a file "notes.txt" inside "Documents"
        File file1 = new File("notes.txt", documents, admin);
        file1.write("This is a sample note.");
        documents.addChild(file1);

        // Create another sub-directory "Images"
        Directory images = new Directory("Images", root, admin);
        root.addChild(images);

        // Create a file "photo.png" inside "Images"
        File file2 = new File("photo.png", images, admin);
        file2.write("Image data placeholder.");
        images.addChild(file2);

        // Print the entire file system structure
        root.print("");
    }
}
