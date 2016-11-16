package json.Components;

/**
 * Created by lin on 2016/11/15.
 */
public class Gift {
    int id,type,gx;
    float pc;
    String name,desc,mimg,himg,intro;


    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", type=" + type +
                ", gx=" + gx +
                ", pc=" + pc +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", mimg='" + mimg + '\'' +
                ", himg='" + himg + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGx() {
        return gx;
    }

    public void setGx(int gx) {
        this.gx = gx;
    }

    public float getPc() {
        return pc;
    }

    public void setPc(float pc) {
        this.pc = pc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public String getHimg() {
        return himg;
    }

    public void setHimg(String himg) {
        this.himg = himg;
    }
}
