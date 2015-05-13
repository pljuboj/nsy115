package sevlet;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import model.Partie;
import service.TicTacToeDecoder;
import service.TicTacToeEncoder;

@ServerEndpoint(value="/tictactoe", encoders = {TicTacToeEncoder.class}, decoders = {TicTacToeDecoder.class})

public class TicTacToe {

	private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(Partie partie, Session session) throws IOException, EncodeException {
		for (Session peer : peers) {
			if (!peer.equals(session)) {
				peer.getBasicRemote().sendObject(partie);				
			}
		}
	}

	@OnOpen
	public void onOpen (Session peer) {
		peers.add(peer);
	}

	@OnClose
	public void onClose (Session peer) {
		peers.remove(peer);
	}
}

