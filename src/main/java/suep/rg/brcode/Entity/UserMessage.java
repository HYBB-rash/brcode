package suep.rg.brcode.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user_message")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserMessage {

    @Id
    @Column(name = "id")
    Integer id;

    String icon;
    String mail;
    String instruction;
    Integer love;
    Integer watch;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"icon\":\"")
                .append(icon).append('\"');
        sb.append(",\"mail\":\"")
                .append(mail).append('\"');
        sb.append(",\"instruction\":\"")
                .append(instruction).append('\"');
        sb.append(",\"love\":")
                .append(love);
        sb.append(",\"watch\":")
                .append(watch);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Integer getWatch() {
        return watch;
    }

    public void setWatch(Integer watch) {
        this.watch = watch;
    }
}
