package com.nio;

import io.netty.buffer.ByteBuf;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author 晨边#CB
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
            buffer.clear();//如果把这一行注释掉会有什么错误。什么情况？
            //如果第二次不执行clear那么position和limitd是一样的，position不可能大于limit 所以read一直都是0，
            //没有读取数据返回0 超过了返回-1

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
