package com.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @Author ����#CB
 * @Date:created in  2020/2/2 14:33
 * @Version V1.0
 **/

public class NioServer {

    private static Map<String ,SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //���óɷ�������
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        //�󶨶˿ں�
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        //��sevrerSocketChannelע�ᵽselector����,��ע�¼�ע��
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            try{
                //��������ע���¼�������
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {

                    final SocketChannel client;

                    try{

                        if (selectionKey.isAcceptable()){
                            ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                            client = server.accept();
                            client.configureBlocking(false);

                            //��ע�¼���ȡ
                            client.register(selector,SelectionKey.OP_READ);

                            String key = "��"+ UUID.randomUUID().toString()+"��";

                            //�ͻ���ע�����
                            clientMap.put(key,client);
                        }else if(selectionKey.isReadable()){
                            client = (SocketChannel)selectionKey.channel();

                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);
                            if(count>0){
                                readBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receiveMessage = String.valueOf(charset.decode(readBuffer).array());

                                //����ͻ��˷��͵���Ϣ
                                System.out.println(client+":"+receiveMessage);

                                String senderkey = null;

                                for (Map.Entry<String,SocketChannel> entry:clientMap.entrySet()){
                                    if (client == entry.getValue()){
                                        senderkey= entry.getKey();
                                        break;
                                    }
                                }

                                for (Map.Entry<String,SocketChannel> entry:clientMap.entrySet()){
                                    SocketChannel value = entry.getValue();

                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

                                    writeBuffer.put((senderkey+":"+receiveMessage).getBytes());

                                    writeBuffer.flip();

                                    value.write(writeBuffer);
                                }

                            }

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });

                selectionKeys.clear();


            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }
}
