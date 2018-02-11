
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private String opp_name, name;

    Client() {
        Scanner scan = new Scanner(System.in);
        try {
            // Подключаемся в серверу и получаем потоки(in и out) для передачи сообщений
            socket = new Socket("localhost", 80);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
                
            System.out.print("Print your name: ");
            name = scan.nextLine();
            System.out.println("Print \"exit\" to close conversation.");
            
            out.println(name);
            opp_name = in.readLine();
            
            Resender resender = new Resender();
            resender.start();
            
            String str = null;
            while (true) {
                str = scan.nextLine();
                if (str.equals("exit")) { 
                    break;
                }
                out.println(str);
            }
            resender.setStop();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    
    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     /**
     * Работает пока не будет вызван метод setStop().
     */
    private class Resender extends Thread {
        private boolean stoped;

        public void setStop() {
                stoped = true;
        }

        /**
        * Считывает все сообщения от сервера.
        * Останавливается вызовом метода setStop()
        */
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
