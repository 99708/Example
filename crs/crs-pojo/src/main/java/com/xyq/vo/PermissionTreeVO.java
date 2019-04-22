package com.xyq.vo;

public class PermissionTreeVO {
    private int id;
    private int pId;
    private String name;
    private boolean checked;

    public PermissionTreeVO() {
    }

    @Override
    public String toString() {
        return "PermissionTreeVO{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public PermissionTreeVO(int id, int pId, String name, boolean checked) {

        this.id = id;
        this.pId = pId;
        this.name = name;
        this.checked = checked;
    }
}
