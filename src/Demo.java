import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

public class Demo {

    public static void main(String[] args) {
        /*JFrame chatFrame = new JFrame();
        int result = 0;
        File file = null;
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
        }*/

       // String a = "D:\字幕\rick&morty 蓝光\102.m2ts.sushi.ass";
        //String arr[] = path.split("\");
        

        //这是另外一种方法得到桌面路径：
        //File desktop = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"XX");

        //filechooser.setCurrentDirectory(desktop);

        //我的文档 路径：  fsv.getDefaultDirectory());
    }
    
}
