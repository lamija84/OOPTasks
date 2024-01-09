package week12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
public class lab12 {


    public class ChatServer {
        private List<ClientHandler> clients = new ArrayList<>();

        public void start(int port) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server is running on port " + port);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New connection accepted.");

                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    clients.add(clientHandler);

                    Thread thread = new Thread(clientHandler);
                    thread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void broadcastMessage(String message, ClientHandler sender) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(sender.getUsername() + ": " + message);
                }
            }
        }

        private class ClientHandler implements Runnable {
            private Socket socket;
            private BufferedReader reader;
            private PrintWriter writer;
            private String username;

            public ClientHandler(Socket socket) {
                this.socket = socket;
                try {
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    writer = new PrintWriter(socket.getOutputStream(), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public String getUsername() {
                return username;
            }

            public void sendMessage(String message) {
                writer.println(message);
            }

            @Override
            public void run() {
                try {
                    writer.println("Enter your username:");
                    username = reader.readLine();
                    broadcastMessage(username + " has joined the chat.", this);

                    String message;
                    while ((message = reader.readLine()) != null) {
                        broadcastMessage(message, this);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                        clients.remove(this);
                        broadcastMessage(username + " has left the chat.", this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
class ChatApplication {
    public static void main(String[] args) {
        lab12.ChatServer chatServer = new lab12.ChatServer();
        chatServer.start(12345);
    }
}


 class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server IP>");
            System.exit(1);
        }

        String username = args[0];
        String serverIP = args[1];
        int serverPort = 12345;

        try (Socket socket = new Socket(serverIP, serverPort);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            serverWriter.println(username);

            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = serverReader.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                serverWriter.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


