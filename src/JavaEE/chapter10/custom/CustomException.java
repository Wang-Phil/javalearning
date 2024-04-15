package JavaEE.chapter10.custom;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class CustomException {
    public static void main(String[] args) throws Exception{
        int age = 180;
        if(!(age >= 18 && age <= 120)){
            //这里可以根据构造器，设置信息
            throw new AgeException("年龄需要在18和120之间");
        }
        System.out.println("年龄范围正确");
    }
}

//自定义一个异常
//一般情况下，都是自定义为运行时异常，RuntimeException，这样可以使用默认的处理机制
class AgeException extends RuntimeException{
    public AgeException(String message) {//构造器
        super(message);
    }
}
