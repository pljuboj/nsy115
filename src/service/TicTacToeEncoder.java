package service;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import model.Partie;

public class TicTacToeEncoder implements Encoder.Text<Partie> {

	@Override
	public void destroy() {
        System.out.println("destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
        System.out.println("init");
	}

	@Override
	public String encode(Partie partie) throws EncodeException {
        return partie.getJson().toString();
	}

}
