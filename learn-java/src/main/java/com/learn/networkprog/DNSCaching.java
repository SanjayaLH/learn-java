package com.learn.networkprog;

import java.net.InetAddress;

public class DNSCaching {
    public static void main(String[] args) {
        try {
            // Get IP address and TTL value
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Resolved IP: " + address.getHostAddress());
            System.out.println("Default TTL: " + getDefaultDnsTtl());

            // Simulate DNS caching by resolving the same domain multiple times
            for (int i = 0; i < 5; i++) {
                InetAddress cachedAddress = InetAddress.getByName("www.google.com");
                System.out.println("Cached Resolution: " + cachedAddress.getHostAddress());
                Thread.sleep(2000); // Wait before next resolution
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long getDefaultDnsTtl() {
        return java.security.Security.getProperty("networkaddress.cache.ttl") != null
                ? Long.parseLong(java.security.Security.getProperty("networkaddress.cache.ttl"))
                : -1;
    }
}
