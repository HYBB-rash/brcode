package suep.rg.brcode.Entity.rev;

public class IPV4 {

    private String ip;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"ip\":\"")
                .append(ip).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
