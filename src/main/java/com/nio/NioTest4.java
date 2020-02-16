package com.nio;

import io.netty.buffer.ByteBuf;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/30 11:14
 * @Version V1.0
 **/

public class NioTest4 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputchannel = fileInputStream.getChannel();
        FileChannel outputchannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true){
            buffer.clear();//�������һ��ע�͵�����ʲô����ʲô�����
            //����ڶ��β�ִ��clear��ôposition��limitd��һ���ģ�position�����ܴ���limit ����readһֱ����0��
            //û�ж�ȡ���ݷ���0 �����˷���-1

            int read = inputchannel.read(buffer);
            System.out.println("read:"+read);

            if(-1 == read){
                break;
            }

            buffer.flip();

            outputchannel.write(buffer);
        }

        inputchannel.close();
        outputchannel.close();

    }
}
