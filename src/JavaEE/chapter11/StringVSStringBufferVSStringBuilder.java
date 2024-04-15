package JavaEE.chapter11;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StringVSStringBufferVSStringBuilder {
    public static void main(String[] args) {
        long startTime = 0L;
        long endTime = 0L;

        //StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("执行时间："+(endTime-startTime));

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            stringBuilder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("执行时间："+(endTime-startTime));

        //String
        String s = new String();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("执行时间："+(endTime-startTime));
    }
}
