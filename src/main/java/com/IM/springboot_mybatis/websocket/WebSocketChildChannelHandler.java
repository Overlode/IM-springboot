package com.IM.springboot_mybatis.websocket;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class WebSocketChildChannelHandler extends ChannelInitializer<SocketChannel>{

	@Resource(name = "webSocketServerHandler")
	private ChannelHandler webSocketServerHandler;

	private String[] addContext(){
		return new String[]{"http-codec","aggregator","http-chunked","http-handler","websocket-handler"};
	}


	@Resource(name = "httpRequestHandler")
	private ChannelHandler httpRequestHandler;

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(addContext()[0], new HttpServerCodec());
		ch.pipeline().addLast(addContext()[1], new HttpObjectAggregator(65536));
		ch.pipeline().addLast(addContext()[2], new ChunkedWriteHandler());
		ch.pipeline().addLast(addContext()[3], httpRequestHandler);
		ch.pipeline().addLast(addContext()[4],webSocketServerHandler);
	}


}
