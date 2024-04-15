package JavaEE.chapter07.HomeWork.HomeWork13;

public class Test {
    public static void main(String[] args) {
        Person person[] = new Person[4];
        person[0] = new Student("小明",'男',17,"202301");
        person[1] = new Student("小刘",'女',15,"202302");
        person[2] = new Teacher("王老师",'男',35,10);
        person[3] = new Teacher("罗老师",'男',40,15);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i -1; j++) {
                if(person[j].getAge() < person[j+1].getAge()){
                    Person temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
        Test test = new Test();
        for(int i = 0; i < 4; i++){
            System.out.println(person[i]);
            test.outPlay(person[i]);
        }
    }

    public void outPlay(Person person){
        System.out.println(person.play());
    }
}
