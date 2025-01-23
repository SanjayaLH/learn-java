package com.learn.networkprog;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class DNSDebugging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a domain to debug: ");
        String domain = scanner.nextLine();

        try {
            InetAddress address = InetAddress.getByName(domain);
            System.out.println("Resolved IP: " + address.getHostAddress());

            System.out.println("\nDebugging DNS:");
            System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
            System.out.println("Is reachable? " + address.isReachable(3000));
        } catch (UnknownHostException e) {
            System.err.println("Failed to resolve domain: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Network issue: " + e.getMessage());
        }
    }
}
