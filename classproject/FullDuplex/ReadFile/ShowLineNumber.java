package FullDuplex.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: classprogram
 * @Description:ReadFile
 * @author: WMJ
 * @date: 2019/12/16 20:00 pm
 */
public class ShowLineNumber {
    public static void main(String[] args)throws IOException {

            BufferedReader br = new BufferedReader(new FileReader("d:\\Stream.txt"));
            String str = null;
            int lineNumber = 0;
            while ((str = br.readLine())!=null){
                lineNumber++;
                System.out.println(lineNumber + "" + str);
            }
            br.close();

    }
}
