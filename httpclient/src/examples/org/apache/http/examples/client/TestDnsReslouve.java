package org.apache.http.examples.client;

import org.apache.http.impl.conn.SystemDefaultDnsResolver;

import java.net.InetAddress;

/**
 * @Descriprion:
 * @Author:wuxiaoguang@58.com
 * @Date：created in 2019/10/22
 */
public class TestDnsReslouve {
    public static void main(String[] args) throws Exception{
        SystemDefaultDnsResolver resolver = new SystemDefaultDnsResolver();
        InetAddress[] addresses= resolver.resolve("consumeloan_wf_gateway.58dns.org");
        for (InetAddress inetAddress : addresses) {
            System.err.println(inetAddress);
        }
        System.err.println(addresses);
    }
}
