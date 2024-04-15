package JavaEE.chapter07;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("小明",20,"uoda12");
        //只能访问到name，其他两个属性只能通过get方法进行获取，体现了面向对象的封装性
        System.out.println(account.name);
    }
}
