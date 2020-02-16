//package com.nio;
//
//import io.netty.buffer.ByteBuf;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.InetSocketAddress;
//import java.net.SocketException;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.SocketChannel;
//import java.time.LocalDateTime;
//import java.util.Set;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @Author 晨边#CB
// * @Date:created in  2020/2/2 15:28
// * @Version V1.0
// **/
//
//public class NioClient {
//
//    public static void main(String[] args) throws Exception {
//
//        try {
//            SocketChannel socketChannel = SocketChannel.open();
//            socketChannel.configureBlocking(false);
//
//            Selector selector = Selector.open();
//            socketChannel.register(selector, SelectionKey.OP_CONNECT);
//            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));
//
//            while (true) {
//                selector.select();
//
//                Set<SelectionKey> keySet = selector.selectedKeys();
//
//                for (SelectionKey selectionKey : keySet) {
//                    if (selectionKey.isConnectable()) {
//                        SocketChannel client = (SocketChannel) selectionKey.channel();
//
//                        if (client.isConnectionPending()) {
//                            client.finishConnect();
//
//                            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
//
//                            writeBuffer.put((LocalDateTime.now() + "链接成功").getBytes());
//                            writeBuffer.flip();
//                            client.write(writeBuffer);
//
//                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
//
//                            executorService.submit(() -> {
//                                while (true) {
//                                    try {
//
//                                        writeBuffer.clear();
//                                        InputStreamReader input = new InputStreamReader(System.in);
//
//                                        BufferedReader br = new BufferedReader(input);
//                                        String sendMessage = br.readLine();
//
//                                        writeBuffer.put(sendMessage.getBytes());
//                                        writeBuffer.flip();
//                                        client.write(writeBuffer);
//
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            });
//
//                        }
//                        //主持读取事件
//                        client.register(selector, SelectionKey.OP_READ);
//                    } else if (selectionKey.isReadable()) {
//                        SocketChannel client = (SocketChannel) selectionKey.channel();
//
//                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
//
//                        int count = client.read(readBuffer);
//
//                        if (count > 0) {
//                            String receivedMessage = new String(readBuffer.array(), 0, count);
//                            System.out.println(receivedMessage);
//                        }
//                    }
//                }
//                keySet.clear();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
