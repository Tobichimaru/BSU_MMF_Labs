
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private String opp_name, name;
    
    public Server() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Print your name: ");
            name = scan.nextLine();
            System.out.println("Waiting for client...");
            
            server = new ServerSocket(80);
            socket = server.accept();
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.println("Print \"exit\" to close conversation.");
            
            opp_name = in.readLine();
            out.println(name);
            
            Connection con = new Connection();
            con.start();
            
            String str = null;
            while (true) {
                str = scan.nextLine();
                if (str.equals("exit")) { 
                    break;
                }
                out.println(str);
            }
            con.setStop();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }
    
     private void closeAll() {
        try {
            server.close();
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Потоки не были закрыты!");
        }
    }
    
    private class Connection extends Thread {
        private boolean stoped;
        
        public void setStop() {
            stoped = true;
        }
         
        @Override
        public void run() {
            try {
                String str;
                while (!stoped) {
                    str = in.readLine();
                    if (str.equals("exit")) { 
                        stoped = true;
                        break;
                    }
                    System.out.println(opp_name + ": " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
