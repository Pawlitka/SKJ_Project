public class NodeServers {
    public final String address;
    public final int port;

    public NodeServers(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public String toString() {
        return address + " : " + port;
    }
}

