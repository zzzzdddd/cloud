import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class test {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = newCachedThreadPool();

        // 创建serverSocker
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器socket已经启动");

        while(true){
            Socket accept = serverSocket.accept();
            System.out.println("链接到一个客户端socket");

            executorService.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

    private static void handler(Socket socket){

        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();

            while (true){

                inputStream.read(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}