import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        createPaths();
        createFiles();
        log();
    }
    static void createPaths(){
        List<String> paths = new ArrayList<>();
        paths.add("D://Games");
        paths.add("D://Games//src");
        paths.add("D://Games//res");
        paths.add("D://Games//savegames");
        paths.add("D://Games//temp");
        paths.add("D://Games//src//main");
        paths.add("D://Games//src//test");
        paths.add("D://Games//res//drawables");
        paths.add("D://Games//res//vectors");
        paths.add("D://Games//res//icons");
        for(String path : paths) {
            new File(path).mkdir();
        }
    }
    static void createFiles() throws IOException {
        List<String> files = new ArrayList<>();
        files.add("D://Games//src//main//Main.java");
        files.add("D://Games//src//main//utils.java");
        files.add("D://Games//temp//temp.txt");
        for(String file : files){
            new File(file).createNewFile();
        }
    }
    static void log() {
        StringBuilder builder = new StringBuilder();
        try (Stream<Path> paths = Files.walk(Paths.get("D://Games//"))) {
            paths
                    .filter(Files::isDirectory)
                    .forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Stream<Path> paths = Files.walk(Paths.get("D://Games//"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try
        {
            FileWriter nFile = new FileWriter("D://Games//temp//temp.txt");
            nFile.write(builder +"\n");
            nFile.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

