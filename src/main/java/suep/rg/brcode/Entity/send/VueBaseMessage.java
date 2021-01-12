package suep.rg.brcode.Entity.send;

public class VueBaseMessage {

    private Integer id;
    private Integer watch;
    private Integer love;
    private String mail;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"watch\":")
                .append(watch);
        sb.append(",\"love\":")
                .append(love);
        sb.append(",\"mail\":\"")
                .append(mail).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
