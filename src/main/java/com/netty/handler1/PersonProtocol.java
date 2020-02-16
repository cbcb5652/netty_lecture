package com.netty.handler1;

/**
 * @Author ³¿±ß#CB
 * @Date:created in  2020/2/16 17:34
 * @Version V1.0
 **/

public class PersonProtocol {

    private int length;

    private byte[] content;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
