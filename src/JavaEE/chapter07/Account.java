package JavaEE.chapter07;

public class Account {
    public String name;
    private int restMoney;
    private  String code;

    public Account(String name) {
        setName(name);
    }

    public Account(String name, int restMoney, String code) {
        this.name = name;
        this.restMoney = restMoney;
        this.code = code;
    }
    //获取姓名
    public String GetName(){
        return this.name;
    }
    //设置姓名
    public void setName(String name){
        if(name.length() >=2 && name.length() <= 4) this.name = name;
        else{
            System.out.println("输入的姓名长度不合法，默认为无名氏");
            this.name = "无名氏";
        }
    }

    public void setCode(String code) {
        if(code.length() == 6) this.code = code;
        else{
            System.out.println("输入的密码长度不合理，默认为123456");
            this.code = "123456";
        }
    }
    public void setRestMoney(int restMoney) {
            if(restMoney > 20)   this.restMoney = restMoney;
            else{
                System.out.println("输入的余额不合理，默认为30");
                this.restMoney = 30;
            }
        }
}
