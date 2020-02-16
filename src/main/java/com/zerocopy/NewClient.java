package com.zerocopy;

import io.netty.handler.codec.spdy.SpdySynStreamFrame;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/2/4 17:46
 * @Version V1.0
 **/

public class NewClient {
    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);

        String fileName = "/User/chenbin/Desktop/...";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();

        //将整个文件的信息传递到socketChannel当中
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送总字节数:"+transferCount+",耗时:"+(System.currentTimeMillis()-startTime));

        fileChannel.close();
    }


}
