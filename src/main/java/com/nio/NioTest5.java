package com.nio;


import java.nio.ByteBuffer;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/31 9:16
 * @Version V1.0
 **/

/**
 * ByteBuffer���ͻ���put��get����
 */

public class NioTest5 {

    public static void main(String[] args) {
        ByteBuffer buffer =  ByteBuffer.allocate(64);

        buffer.putInt(15);
        buffer.putLong(500000000L);
        buffer.putDouble(14.123456);
        buffer.putChar('��');
        buffer.putShort((short)2);
        buffer.putChar('��');

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        System.out.println(buffer.getChar());

    }

}
