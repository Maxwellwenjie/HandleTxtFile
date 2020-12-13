import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

public class AssFileHandle {
    public static void main(String[] args) throws IOException {
        JFrame chatFrame = new JFrame();
        int result = 0;
        //File file = null;
        String path = null;
        JFileChooser fileChooser = new JFileChooser();
        FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
        System.out.println(fsv.getHomeDirectory());                //得到桌面路径
        fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
        fileChooser.setDialogTitle("请选择要上传的文件...");
        fileChooser.setApproveButtonText("确定");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        result = fileChooser.showOpenDialog(chatFrame);
        if (JFileChooser.APPROVE_OPTION == result) {
                path=fileChooser.getSelectedFile().getPath();
                System.out.println("path: "+path);
        }

        String arr[] = path.split("\\\\");
        String name = arr[arr.length-1];
        //File txt = new File("D:\\IDEAProject");
        System.out.println(name);
        System.out.println(readFile(path));
        writeFile(readFile(path),name+".txt");
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
                String[] array = line.split("}");
                if (array.length>1) {
                    line = line.split("}")[1];
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                } 
                
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
