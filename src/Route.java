public class Route {
    public RouteType type;
    public NodeServers address;

    public Route(RouteType type, NodeServers address) {
        this.type = type;
        this.address = address;
    }
}
