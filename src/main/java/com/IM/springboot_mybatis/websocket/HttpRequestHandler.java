package com.IM.springboot_mybatis.websocket;

import com.IM.springboot_mybatis.utils.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
import org.springframework.stereotype.Component;

@Component
@Sharable
public class HttpRequestHandler extends SimpleChannelInboundHandler<Object> {

    /**
     * 处理HTTP请求，WebSocket请求向下传递。
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if (o instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) o);
        } else if (o instanceof WebSocketFrame) {
            channelHandlerContext.fireChannelRead(((WebSocketFrame) o).retain());
        }
    }

    /**
     * 描述：处理Http请求，HTTP升级到Websocket
     * @param channelHandlerContext
     * @param req
     */
    private void handleHttpRequest(ChannelHandlerContext channelHandlerContext, FullHttpRequest req) {
        if (!req.decoderResult().isSuccess()) {
            sendHttpResponse(channelHandlerContext, req,
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }

        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                "ws:/" + channelHandlerContext.channel() + "/websocket", null, false);
        WebSocketServerHandshaker handShaker = wsFactory.newHandshaker(req);
        Constant.webSocketHandshakerMap.put(channelHandlerContext.channel().id().asLongText(), handShaker);

        if (handShaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
        } else {
            handShaker.handshake(channelHandlerContext.channel(), req);
        }
    }

    private void sendHttpResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest req, DefaultFullHttpResponse res) {
        if (res.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        boolean keepAlive = HttpUtil.isKeepAlive(req);
        ChannelFuture future = channelHandlerContext.channel().writeAndFlush(res);
        if (!keepAlive) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable cause) throws Exception {
        cause.printStackTrace();
        channelHandlerContext.close();
    }
}
