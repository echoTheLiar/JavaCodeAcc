package designpattern.proxy;

/**
 * 代理客户端
 * 
 * @author liu yuning
 *
 */
public class ProxyClient {
    public static void main(String[] args) {
	Proxy proxy = new Proxy();
	proxy.request();
    }
}
