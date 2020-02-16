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
 * @Author 晨边#CB
 * @Date:created in  2020/2/2 14:33
 * @Version V1.0
 **/

public class NioServer {

    private static Map<String ,SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //配置成非阻塞的
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        //绑定端口号
        serverSocket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        //将sevrerSocketChannel注册到selector上面,关注事件注册
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            try{
                //返回所关注的事件的数量
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {

                    final SocketChannel client;

                    try{

                        if (selectionKey.isAcceptable()){
                            ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                            client = server.accept();
                            client.configureBlocking(false);

                            //关注事件读取
                            client.register(selector,SelectionKey.OP_READ);

                            String key = "【"+ UUID.randomUUID().toString()+"】";

                            //客户端注册完毕
                            clientMap.put(key,client);
                        }else if(selectionKey.isReadable()){
                            client = (SocketChannel)selectionKey.channel();

                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);
                            if(count>0){
                                readBuffer.flip();

                                Charset charset = Charset.forName("utf-8");
                                String receiveMessage = String.valueOf(charset.decode(readBuffer).array());

                                //输出客户端发送的消息
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
