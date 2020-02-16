package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/1/31 9:45
 * @Version V1.0
 **/

public class NioTest8 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");

        FileChannel inputchannel = fileInputStream.getChannel();
        FileChannel outputchannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(512);

        while (true){
            buffer.clear();
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
