package suep.rg.brcode.Entity.send;

public class VueReply {

    private String username;
    private String content;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
