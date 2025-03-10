import java.util.Date;

public class User {
    private int CNP;
    private String Name;
    private Date Birthday;
    private int height;

    public User(int CNP, String name, Date birthday, int height) {
        this.CNP = CNP;
        Name = name;
        Birthday = birthday;
        this.height = height;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCNP() {
        return CNP;
    }

    public String getName() {
        return Name;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "User{" +
                "CNP=" + CNP +
                ", Name='" + Name + '\'' +
                ", Birthday=" + Birthday +
                ", height=" + height +
                '}';
    }
}
