package com.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Random;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/2 16:15
 * @Version V1.0
 **/

public class NioTest13 {
    public static void main(String[] args) throws IOException {

        String inputFile = "NioTest13_In.txt";
        String outputFile = "NioTest13_Out.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile,"r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile,"rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputFilechannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer inputData = inputFileChannel.map(FileChannel.MapMode.READ_ONLY,0,inputLength);

        System.out.println("=============��ӡϵͳ�����е��ַ���======================");

        Charset.availableCharsets().forEach((k,v)->{
            System.out.println(k+","+v);
        });


        System.out.println("====================================");

        Charset charset = Charset.forName("utf-8");
        //decoder���ֽ�����ת��Ϊ�ַ���
        CharsetDecoder decoder = charset.newDecoder();
        //encoder���ַ���ת��Ϊ�ֽ�����
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(inputData);

        ByteBuffer outputData = encoder.encode(charBuffer);

        outputFilechannel.write(outputData);

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();

    }
}
