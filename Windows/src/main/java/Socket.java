import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Socket extends WebSocketClient {

    public Socket(URI uri) {
        super(uri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        Core.showMessageBox("Homecenter已启动", "Homecenter");
    }

    @Override
    public void onMessage(String s) {
        try {
            Runner.run(s);
        } catch (IOException | ParseException | AWTException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {

    }

}