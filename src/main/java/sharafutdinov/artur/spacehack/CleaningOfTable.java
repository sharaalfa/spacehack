package sharafutdinov.artur.spacehack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;

/**
 * Created by first on 29.04.17.
 */
public class CleaningOfTable  {

    /**
     * Логгирование
     */

    private static final Logger logger  = Logger.getLogger(CleaningOfTable.class);
    static {
        PropertyConfigurator.configure(
                "/home/first/Yandex.Disk/Java_study/spacehack/src/main/resources/log4j.xml");
    }
    public static void main(String[] args) throws IOException {
        /*Field field1 = new Field();
        StringBuilder stringBuilder = new StringBuilder();

        File file = null;

        BufferedWriter bufferedWriter = null;

        file = new File("/home/first/spacehack/1.csv");

        try{
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            stringBuilder.append(field1
                    .nameField("/home/first/Downloads/subuser.xml",
                            "/", "/",1));
            bufferedWriter.write(stringBuilder + "");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //new DataFromCSV().included(
        //        "/home/first/Yandex.Disk/Java_study/spacehack/src/main/python/google1.csv",
         //       "/home/first/Yandex.Disk/Java_study/spacehack/src/main/python/google.csv");
        //System.out.println(new ReadXMLProSubusers().getUser("ne.xml", "sex", "f"));
        //System.out.println(new CreateGroupUsersForValue().getEqualsUser("ne.xml", "sex", "f"));
        new ReadXMLProSubusers().saveToDB("artur", "12345",
                "gender", "genders",
               "sex", "subusers3.xml", 5, 38, -3);




    }

}
