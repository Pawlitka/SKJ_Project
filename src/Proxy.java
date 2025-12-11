import java.util.HashSet;


public class Proxy {
    public static final int MAX_PORT_NUMBER = 65535;
    private static int proxyPort = 0;
    private static final HashSet<NodeServers> servers = new HashSet<>();

    public static void main(String[] args) {
        if(!parseArgs(args)) {
            System.exit(1);
        }
    }

    private static boolean parseArgs(String[] args) {
        try {
            for (int i = 0; i < args.length; i++) {

                switch (args[i]) {

                    case "-port":
                        if (i + 1 >= args.length) return false;
                        proxyPort = Integer.parseInt(args[++i]);
                        if (proxyPort < 1 || proxyPort > MAX_PORT_NUMBER) {
                            System.err.println("Invalid port number: " + proxyPort);
                            return false;
                        }
                        break;

                    case "-server":
                        if (i + 2 >= args.length) return false;
                        String serverAddress = args[++i];
                        int serverPort = Integer.parseInt(args[++i]);
                        servers.add(new NodeServers(serverAddress,serverPort));
                        break;

                    default:
                        System.err.println("Unknown argument: " + args[i]);
                        return false;
                }
            }

            if (proxyPort == 0) {
                System.err.println("Missing -port");
                return false;
            }
            if (servers.isEmpty()) {
                System.err.println("At least one -server required");
                return false;
            }

            return true;

        } catch (Exception e) {
            System.err.println("Argument error: " + e.getMessage());
            return false;
        }
        
    }
}