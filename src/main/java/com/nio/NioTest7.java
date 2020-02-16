package com.nio;

import java.nio.ByteBuffer;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/31 9:32
 * @Version V1.0
 **/

/**
 * ֻ��buffer ���ǿ�����ʱ��һ����ͨ��buffer����asReadOnlyBuffer��������һ��ֻ��buffer
 * �����ܽ�һ��ֻ��bufferת��Ϊ��дBuffer
 */
public class NioTest7 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0;i<buffer.capacity();i++){
            buffer.put((byte)i);
        }
        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());

        readonlyBuffer.position(0);

        //readonlyBuffer����putʱֱ���׳��쳣
//        readonlyBuffer.put((byte)2);
    }
}
