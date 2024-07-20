package MovieName;

public class File implements FileSystem {
    String fileName;

    public File(String name) {
        fileName = name;
    }

    @Override
    public void ls() {
        System.out.println("fileName: " + fileName);
    }
}
