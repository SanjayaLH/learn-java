package com.learn.networkprog;

import java.net.*;
import java.util.*;

public class CustomDNSResolver {
    public static void main(String[] args) {
        String dnsServer = "8.8.8.8"; // Google's public DNS
        String domain = "www.google.com";

        try {
            Process process = Runtime.getRuntime().exec("nslookup " + domain + " " + dnsServer);

            Scanner scanner = new Scanner(process.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

