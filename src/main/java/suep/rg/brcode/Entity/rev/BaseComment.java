package suep.rg.brcode.Entity.rev;

public class BaseComment {

    private Integer userId;
    private String content;
    private Integer paperId;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":")
                .append(userId);
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"paperId\":")
                .append(paperId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }
}
