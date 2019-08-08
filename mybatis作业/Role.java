package day.daymybatis;

public class Role {
    private Integer id;
    private String note;
    private String roleName;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
