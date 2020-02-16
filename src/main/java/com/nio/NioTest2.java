package com.nio;

import io.netty.buffer.ByteBuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/30 9:44
 * @Version V1.0
 **/

public class NioTest2 {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        //���ļ��е���Ϣд�뵽bytebuffer��
        fileChannel.read(byteBuffer);

        //������ת
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            System.out.println("Character:"+(char)b);
        }
        fileInputStream.close();
    }

}
