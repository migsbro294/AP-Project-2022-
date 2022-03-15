package client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.Server;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Client {
    private static final Logger logger = LogManager.getLogger(Client.class);
    private  ObjectOutputStream outputStream;
    private  ObjectInputStream inputStream;
    private  Socket connectionSocket;
    private  BufferedReader bufferedReader;

    public Client(){
        logger.info("Instantiate socket, ObjectOutputStream and ObjectInputStream ");
        try{
            connectionSocket = new Socket("127.0.0.1",8888);
            outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            inputStream = new ObjectInputStream(connectionSocket.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            logger.error("IOException: Error instantiating socket, ObjectOutputStream and ObjectInputStream: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        logger.info("Closing Connection ");
        try{
            outputStream.close();
            inputStream.close();
            connectionSocket.close();
        }catch (IOException e){
            logger.error("IOException: Error closing connection: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public <O> void sendOneRequest(O parameter) {
        logger.info("Sending one request to server");
        try {
            outputStream.writeObject(parameter);
        }catch (IOException e) {
            logger.error("IOException: Error sending one request to server: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendOption(Options option) {
        logger.info("Sending option to server");
        try {
            outputStream.writeObject(option);
        }catch (IOException e) {
            logger.error("IOException: Error sending option to server: "+e.getMessage());
            e.printStackTrace();
        }
    }


    public <O> void sendMultipleRequest(List<O> parameters) {
        logger.info("Sending multiple request to server");
        try {
            for(O object : parameters) {
                outputStream.writeObject(object);
            }
        }catch (IOException e) {
            logger.error("IOException: Error sending multiple request to serve: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public  <O> Object getResponse() {
        // get response form server
        logger.info("Getting response from server");
        Object response = null;
        try {
            response =  inputStream.readObject();
        }catch (EOFException e){
            logger.warn("EOFException: Warning "+e.getMessage());
        }catch (IOException | ClassNotFoundException e) {
            logger.error("IOException: Error getting response from server: "+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
