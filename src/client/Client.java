package client;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Client {
    private  ObjectOutputStream outputStream;
    private  ObjectInputStream inputStream;
    private  Socket connectionSocket;
    private  BufferedReader bufferedReader;

    public Client(){
        try{
            connectionSocket = new Socket("127.0.0.1",8888);
            outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            inputStream = new ObjectInputStream(connectionSocket.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            outputStream.close();
            inputStream.close();
            connectionSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public <O> void sendOneRequest(O parameter) {
        try {
            outputStream.writeObject(parameter);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendOption(Options option) {
        try {
            outputStream.writeObject(option);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public <O> void sendMultipleRequest(List<O> parameters) {
        try {
            for(O object : parameters) {
                outputStream.writeObject(object);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  <O> Object getResponse() {
        // get response form server
        Object response = null;
        try {
            response =  inputStream.readObject();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return response;
    }
}
