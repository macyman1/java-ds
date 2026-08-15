import java.net.*;

public class hi {
    public static void main(String[] args) throws Exception {

        String url = "www.netflix.com";

        InetAddress ia = InetAddress.getByName(url);

        System.out.println("Host Name : " + ia.getHostName());
        System.out.println("IP Address: " + ia.getHostAddress());
    }
}