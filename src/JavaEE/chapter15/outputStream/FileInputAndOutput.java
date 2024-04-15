package JavaEE.chapter15.outputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class FileInputAndOutput {
    public static void main(String[] args) {

    }
    @Test
    //从一个文件中读取图片，输出到另外一个文件中
    public void SrcToAnother() throws IOException {
        String src = "d:\\bp.jpg";
        String dest = "d:\\bp1.jpg";
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        byte buf[] = new byte[1024];
        int readLen = 0;
        while((readLen = fis.read(buf)) != -1){
//            fos.write(buf,0,readLen);
              fos.write(buf);
        }
        fis.close();
        fos.close();
    }
}



