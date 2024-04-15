package JavaEE.chapter10.trycatch;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TryCatchDetail01 {
    public static void main(String[] args) {
        //多个异常，可以多个catch，但是要求子类写在前面，父类写在后面
        try {
            Person person = new Person();
            System.out.println(person.getName());   //空指针异常
            int n1 = 10;
            int n2 = 0;
            int res = n1/n2;                    //算术异常
        } catch (NullPointerException e){
            System.out.println("空指针异常"+e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("算术异常"+e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}

class Person{
    private String name;

    public Person() {
    }
    public String getName() {
        return name;
    }
}
