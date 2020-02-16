package com.zerocopy;

import io.grpc.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/4 17:34
 * @Version V1.0
 **/

public class NewServer {

    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        //�����ӱ��رպ����̹رո��������󶨵Ķ˿ں�
        serverSocket.setReuseAddress(true);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);


            int readCount = 0;
            while (-1!=readCount){
                try{
                    readCount = socketChannel.read(byteBuffer);
                }catch (Exception e){
                    e.printStackTrace();
                }
                byteBuffer.rewind();
            }


        }


    }

}
