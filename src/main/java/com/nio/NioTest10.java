package com.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Author 晨边#CB
 * @Date:created in  2020/1/31 10:19
 * @Version V1.0
 **/

public class NioTest10 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10.txt","rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        //true的共享锁  false是排他锁
        FileLock fileLock = fileChannel.lock(3,6,true);

        System.out.println("valid:"+fileLock.isValid());
        System.out.println("lock type:"+fileLock.isShared());

        fileLock.release();

        randomAccessFile.close();
    }

}
