package com.learn.networkprog;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DNSResolverExercise1 {
    private static boolean isValidDomain(String domain) {
        String domainRegex = "^www\\.[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$";
        return domain.matches(domainRegex);
    }
    public static void main(String[] args) {

            System.out.println("Enter the domain name: ");
            Scanner in = new Scanner(System.in);

            String domain = in.nextLine();
            boolean isValid = isValidDomain(domain);
            try {
                if (isValid) {
                    InetAddress[] addresses = InetAddress.getAllByName(domain);

                    System.out.println("IP addresses for domain: " + domain);
                    for (InetAddress address : addresses) {
                        String ip = address.getHostAddress();
                        System.out.println(" - " + ip);

                        String reverseDNS = InetAddress.getByName(ip).getHostName();
                        System.out.println("   Reverse DNS for IP: " + ip + " -> " + reverseDNS);
                    }
                } else {
                    System.out.println("The input is not a valid domain");
                }
            } catch (UnknownHostException e) {
                System.err.println("DNS resolution failed: " + e.getMessage());
            } finally {
                in.close();
            }

    }
}
