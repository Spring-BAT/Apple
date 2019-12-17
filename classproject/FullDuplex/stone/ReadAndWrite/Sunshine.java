package FullDuplex.stone.ReadAndWrite;

import java.io.*;

public class Sunshine {
    public static void ReadTxtFile(String filePath){
        try{
        String encoding = "GBK";
        File file = new File(filePath);
        if(file.isFile()&&file.exists()){
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine())!=null){
                System.out.println(lineTxt);
            }
            read.close();
        }
    }catch (IOException e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
}
    public static void WriteTxtFile(String filepath){
        File file = new File(filepath);
        BufferedWriter writer = null;
        try {
            if (file.isFile() && !file.exists()) {
                System.out.println("找不到指定文件");
                file.createNewFile();

            } else {
                //writer = new BufferedWriter(new FileWriter(file, true));
                writer = new BufferedWriter(new FileWriter(file));
                writer.write("hello");
                writer.write("\n");
                writer.write("hello");

            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(writer!=null){
                try{
                    writer.flush();
                    writer.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
    public static void main(String args[]){
        final String filepath = "d:\\Stream.txt";
        WriteTxtFile(filepath);
        System.out.println("---------------------");
        ReadTxtFile(filepath);
    }
}
