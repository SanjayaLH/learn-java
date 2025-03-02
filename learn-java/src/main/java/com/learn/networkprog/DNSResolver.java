package com.learn.networkprog;

import java.net.*;

public class DNSResolver {
    public static void main(String[] args) {
        try {
            String domain = "www.google.com";
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            System.out.println("IP addresses for domain: " + domain);
            for (InetAddress address : addresses) {
                System.out.println(" - " + address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("DNS resolution failed: " + e.getMessage());
        }
    }
}
