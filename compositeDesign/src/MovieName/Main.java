package MovieName;

public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("movie");

        movieDirectory.add(new File("border.mp4"));
        Directory comedy = new Directory("comedy");
        comedy.add(new File("HulChul.mp4"));

        comedy.add(new File("bhagam bhag.mp4"));
        movieDirectory.add(comedy);

        movieDirectory.ls();
    }
}