package com.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/2/4 17:22
 * @Version V1.0
 **/

public class OldServer {

    public static void main(String[] args) throws  Exception{

        ServerSocket serverSocket = new ServerSocket(8899);

        while (true){
            //没有客户端链接的时候在这个地方等待链接。
            Socket socket = serverSocket.accept();

            DataInputStream  dataInputStream = new DataInputStream(socket.getInputStream());

            try{
                byte[] byteArray = new byte[4096];

                int readCount = dataInputStream.read(byteArray,0,byteArray.length);
                if(-1==readCount){
                    break;
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
