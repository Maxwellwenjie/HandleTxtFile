import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SrtFileHandle {
    public static void main(String[] args) throws IOException {
        File txt = new File("D:\\IDEAProject");

        System.out.println(readFile("D:\\字幕\\Sherlock.2010.S01.Blu-ray.1080P.x264.AC3.Mysilu\\Sherlock.2010.S01E01.Blu-ray.1080P.x264.AC3.eng.srt.txt"));
        writeFile(readFile("D:\\字幕\\Sherlock.2010.S01.Blu-ray.1080P.x264.AC3.Mysilu\\Sherlock.2010.S01E01.Blu-ray.1080P.x264.AC3.eng.srt.txt"),"sherlock_S01E01.txt");
    }

    private static String readFile(String file) throws IOException {
        //FileReader默认UTF-8编码
        BufferedReader reader = new BufferedReader(new FileReader (file));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();

        //换行符，此种写法屏蔽了 Windows和Linux的区别 ，更保险一些
        String         ls = System.getProperty("line.separator");
        System.out.println(ls);

        //字幕格式从第三行开始，前两行是时间，序列
        reader.readLine();
        reader.readLine();
        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
                //读掉3行非字幕格式
                String a = reader.readLine();
                String b =reader.readLine();
                String c = reader.readLine();

            }
    
            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    // static String readFile(String path, Charset encoding) throws IOException{
    //     byte[] encoded = Files.readAllBytes(Paths.get(path));
    //     return new String(encoded, encoding);
    // }

    private static void writeFile(String fileContent,String fileName) throws IOException {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(fileContent);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
