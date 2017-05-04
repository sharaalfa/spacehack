package sharafutdinov.artur.spacehack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by first on 29.04.17.
 */
public class DataFromCSV {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {return data;}

    public void included(String csvFile, String csvFile1) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        BufferedReader bufferedReader1  = new BufferedReader(new FileReader(csvFile1));
        String line = null;
        String line1 = null;
        Scanner scanner = null;
        Scanner scanner1 = null;
        int index =1;
        int count = 0;
        ArrayList<DataFromCSV> list = new ArrayList<DataFromCSV>();
        while((line = bufferedReader.readLine()) != null
                && (line1 = bufferedReader.readLine()) != null){

            DataFromCSV dataFromCSV = new DataFromCSV();
            DataFromCSV dataFromCSV1 = new DataFromCSV();
            scanner = new Scanner(line);
            scanner1 = new Scanner(line1);
            scanner.useDelimiter(",");
            scanner1.useDelimiter(",");
            while (scanner.hasNext()) {
                int index1 = 0;
                String data = scanner.next();
                while (scanner1.hasNext()) {
                    String data1 = scanner1.next();
                    if (index == 0)
                        dataFromCSV.setData(data1);
                    index1 = 0;
                    index++;
                    }
                    //System.out.println(data);


                    //System.out.println(data);
                    if (index1 == 0)
                        dataFromCSV1.setData(data);
                    index1++;

                }
                index = 0;

            }

            //if(dataFromCSV.toString() != null)
          ///  list.add(dataFromCSV);
            //list.add(dataFromCSV);

            count++;


        }

       // for (int i = 0; i < 1000; ++i) {
        //}

        /*for (int i = 0; i < 2680; ++i) {
            Field field = new Field();
            if (!field.equalsAppStore(list.get(i).toString().substring(0, 35))) {
                if (list.get(i).toString().substring(41) == ";") {
                    System.out.println(list.get(i).toString().substring(0, 35).concat(" " + list.get(i).toString().substring(40)));
                }
                else if (list.get(i).toString().substring(42) == ";") {
                    System.out.println(list.get(i).toString().substring(0, 35).concat(" " + list.get(i).toString().substring(40, 41)));
                }
                else System.out.println(list.get(i).toString().substring(0, 35).concat(" " + list.get(i).toString().substring(40, 42)));


            } else {

                if (list.get(i).toString().substring(18) == ";") {
                    System.out.println(list.get(i).toString().substring(0, 13).concat(" " + list.get(i).toString().substring(17)));
                }
                else if (list.get(i).toString().substring(19) == ";") {
                    System.out.println(list.get(i).toString().substring(0, 13).concat(" " + list.get(i).toString().substring(17, 18)));
                }
                else System.out.println(list.get(i).toString().substring(0, 13).concat(" " + list.get(i).toString().substring(17, 19)));

            }

        }*/
        /*for (int j = 100; j < 200; ++j){
            j = j*1000;
            String[] dataString  = new String[list.toString().length()];
            char[] dataChar = list.toString().toCharArray();
            for (int i = 0; i < list.toString().length(); ++i) {
                dataString[i] = Character.toString(dataChar[i]);
                if (dataString[i] == ";") {
                    System.out.println(list.toString().substring(i, i + 13));
                }
            }

        }*/

       /* String[] dataString  = new String[list.toString().length()];
        char[] dataChar = list.toString().toCharArray();

        for (int i = 0; i < list.toString().length(); ++i) {
            dataString[i] = Character.toString(dataChar[i]);
            if (dataString[i] == ",") {
                System.out.println(list.toString().substring(i, 35+i));
            }
        }*/


        //System.out.println();

       // bufferedReader.close();
    }
//}
