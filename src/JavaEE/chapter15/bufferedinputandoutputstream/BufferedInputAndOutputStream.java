package JavaEE.chapter15.bufferedinputandoutputstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class BufferedInputAndOutputStream {
    public static void main(String[] args) {

    }
    @Test
    public void BufferedInputAndOutput() throws IOException{
        String src1 = "d:\\bp.jpg";
        String src2 = "d:\\FileReadStream01.java";
        String dest1 = "d:\\bp1.jpg";
        String dest2 = "d:\\FileReadStream02.java";

        //创建对象,因为 FileInputStream是InputStream的子类，所以可以传FileInputStream
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest1));

        byte buf[] = new byte[1024];
        int readLen = 0;
        while((readLen = bis.read(buf)) != -1){
//            bos.write(buf, 0, readLen);
            bos.write(buf);
        }
        bis.close();
        bos.close();
    }
}
