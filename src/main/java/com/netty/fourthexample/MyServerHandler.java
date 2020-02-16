package com.netty.fourthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Author ����#CB
 * @Date:created in  2020/1/20 11:05
 * @Version V1.0
 **/

public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;

            String eventType = null;

            switch (event.state()){
                case READER_IDLE:
                    eventType = "������";
                case WRITER_IDLE:
                    eventType = "д����";
                case ALL_IDLE:
                    eventType = "��д����";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"��ʱ�¼�"+eventType);
            ctx.channel().close();
        }

    }
}
