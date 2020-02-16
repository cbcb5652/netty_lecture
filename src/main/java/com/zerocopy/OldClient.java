package com.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/4 17:27
 * @Version V1.0
 **/

public class OldClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8899);

        String fileName = "/User/chenbin/Desktop/...";

        InputStream inputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((readCount = inputStream.read(buffer))>=0){

            total += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("�������ֽ���:"+total+",��ʱ:"+(System.currentTimeMillis()-startTime));

        dataOutputStream.close();
        inputStream.close();
        socket.close();



    }
}
