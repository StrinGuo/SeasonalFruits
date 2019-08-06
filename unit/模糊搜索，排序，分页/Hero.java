package unit18;

/**
 * 与hero表映射的实体类
 */
public class Hero {
    private int id;
    private String sno;
    private String sname;
    private String ssex;
    private int sage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public Hero() {
    }


    public Hero(int id, String sno, String sname, String ssex, int sage) {
        this.id = id;
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage='" + sage + '\'' +
                '}';
    }
}
