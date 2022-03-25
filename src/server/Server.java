package server;

import jdbc.controllers.ComplaintController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final Logger logger = LogManager.getLogger(Server.class);

    public static void main(String[] args) throws Exception {
        //created attributes
        ServerSocket serverSocket;
        Socket socket;
        logger.info("Starting Server");
        try{
            serverSocket = new ServerSocket(8888);//The Server is listening on port 8888

            System.out.println("The Micro-Star Cable Vision [SERVER] is running......");
            while(true){//infinite loop for clients requests
                socket = serverSocket.accept();//listen for and accept the client request
                System.out.println("[SERVER] Connected to client" );
                System.out.println("[SERVER] performing client request");
                Handler handler = new Handler(socket);//instance of handler class and passing socket object
                handler.start();//Starting the thread
            }
        } catch (IOException e) {
            logger.error("IOException: Error running server: "+e.getMessage());
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
