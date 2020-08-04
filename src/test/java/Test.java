import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

public class Test {
    private static long suiteStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running Test");
        suiteStartTime = System.nanoTime();
    }

    @org.junit.jupiter.api.Test
    public void Testcatalog(){
        Main.createPaths();
        File dir = new File("test");
        Assertions.assertTrue(dir.exists());
        Assertions.assertNotNull(dir);


    }
    @org.junit.jupiter.api.Test
    public void Testfile() throws IOException {
        Main.createFiles();
        File newFile = new File("test.txt");
        try
        {
            boolean created = newFile.createNewFile();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        Assertions.assertTrue(newFile.exists());
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("Test complete: " + (System.nanoTime() - suiteStartTime));
    }
}
