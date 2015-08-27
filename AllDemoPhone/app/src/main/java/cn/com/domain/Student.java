package cn.com.domain;

/**
 * 学生类
 * Created by admin on 2015/8/11.
 */
public class Student {
    private String _id;
    //学生姓名
    private String stu_name;
    //学生年龄
    private String stu_age;
    //学生性别
    private String stu_sex;

    public Student() {
    }

    public Student(String stu_name, String stu_age, String stu_sex) {
        this.stu_name = stu_name;
        this.stu_age = stu_age;
        this.stu_sex = stu_sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id='" + _id + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_age='" + stu_age + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }
}
