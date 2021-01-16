package suep.rg.brcode.Entity.rev;

public class Reply {

    private Integer userId;
    private Integer paperId;
    private String content;
    private Integer commentId;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userId\":")
                .append(userId);
        sb.append(",\"paperId\":")
                .append(paperId);
        sb.append(",\"content\":\"")
                .append(content).append('\"');
        sb.append(",\"commentId\":")
                .append(commentId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
