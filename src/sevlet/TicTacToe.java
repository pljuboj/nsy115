package sevlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.Partie;
import service.TicTacToeDecoder;
import service.TicTacToeEncoder;

@ServerEndpoint(value="/tictactoe/{idpartie}", encoders = {TicTacToeEncoder.class}, decoders = {TicTacToeDecoder.class})

public class TicTacToe {

	//private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
	private static HashMap<Integer, Session> firstPlayer = new HashMap<Integer, Session>();
	private static HashMap<Integer, Session> secondPlayer = new HashMap<Integer, Session>();


	@OnMessage
	public void onMessage(Partie partie, Session session, @PathParam("idpartie") Integer idpartie) throws IOException, EncodeException {
		/*for (Session peer : peers) {
			if (!peer.equals(session)) {
				peer.getBasicRemote().sendObject(partie);				
			}
		}*/
		
		Session firstSession = firstPlayer.get(idpartie);
		Session secondSession = secondPlayer.get(idpartie);
		ArrayList<Session> sessions = new ArrayList<Session>();
		sessions.add(firstSession);
		sessions.add(secondSession);
		for (Session peer : sessions) {
			if (!peer.equals(session)) {
				peer.getBasicRemote().sendObject(partie);				
			}
		}

	}

	@OnOpen
	public void onOpen (@PathParam("idpartie") Integer idpartie, Session peer) {
		//peers.add(peer);
		if (firstPlayer.get(idpartie) == null) {
			firstPlayer.put(idpartie, peer);
		}else {
			if (secondPlayer.get(idpartie) == null) {
				secondPlayer.put(idpartie, peer);
			}
		}		
	}

	@OnClose
	public void onClose (/*Session peer*/ @PathParam("idpartie") Integer idpartie) {
		//peers.remove(peer);
		firstPlayer.remove(idpartie);
		secondPlayer.remove(idpartie);
	}
}

