package org.tcpchat.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 65433;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to the chat server");
            out.println(userName);

            final boolean[] running = {true};

            Thread readThread = getThread(running, in);

            String userInput;
            while (true) {
                userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    out.println(userName + ": exit");
                    System.out.println("Disconnecting...");
                    running[0] = false;
                    break;
                }

                out.println(userName + ": " + userInput);
            }

            socket.close();
            readThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    private static Thread getThread(boolean[] running, BufferedReader in) {
        Thread readThread = new Thread(() -> {
            try {
                String fromServer;
                while (running[0] && (fromServer = in.readLine()) != null) {
                    System.out.println(fromServer);
                }
            } catch (IOException e) {
                if (running[0]) {
                    System.out.println("Connection to the server was interrupted");
                }
            }
        });

        readThread.start();
        return readThread;
    }
}