package jingdong;

import leetcode.everyday.StrJingDong;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class sql {
    public static void main(StrJingDong[] args) {
        // 两张表,t1,t2,
        // t1 学生学号id，姓名name，班级class
        // t2 成绩表 学号id，姓名name， 科目subject, 成绩score
        // question1: 各科成绩总成绩大于300的同学，分数的同学
//        select id,name from t2 group by id,name having sum(score) >= 300
//        select class from t1 join t2 on t1.id = t2.id where subject = "数学" group by class  order by avg(score) desc limit 1
    }
}
