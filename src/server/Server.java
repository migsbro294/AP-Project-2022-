package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket;
        Socket socket;
        try{
            serverSocket = new ServerSocket(8888);

            System.out.println("The Micro-Star Cable Vision [SERVER] is running......");
            while(true){
                socket = serverSocket.accept();
                System.out.println("[SERVER] Connected to client" );
                System.out.println("[SERVER] performing client request");
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
