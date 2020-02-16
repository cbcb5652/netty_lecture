package com.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/30 9:50
 * @Version V1.0
 **/

public class NioTest3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");

        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer  = ByteBuffer.allocate(512);

        byte[] messages = "hello world welcome".getBytes();

        for (int i =0;i<messages.length;i++){
            byteBuffer.put(messages[i]);
        }

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileOutputStream.close();


    }

}
