package service;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import model.Partie;

public class TicTacToeDecoder implements Decoder.Text<Partie> {

	@Override
	public void destroy() {
		System.out.println("destroy");		
	}

	@Override
	public void init(EndpointConfig arg0) {
        System.out.println("init");		
	}

	@Override
	public Partie decode(String string) throws DecodeException {
		JsonObject jsonObject = Json.createReader(new StringReader(string)).readObject();
        return  new Partie(jsonObject);
	}

	@Override
	public boolean willDecode(String string) {
		try {
            Json.createReader(new StringReader(string)).readObject();
            return true;
        } catch (JsonException ex) {
            ex.printStackTrace();
            return false;
        }
	}

}
