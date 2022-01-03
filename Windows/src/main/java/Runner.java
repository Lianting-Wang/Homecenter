import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

public final class Runner {
    public static void run(String code) throws IOException, ParseException, AWTException {
        Object ob = new JSONParser().parse(new FileReader("./info.json"));
        JSONObject info = (JSONObject) ob;

        if (info.containsKey(code)) {
            JSONObject value = (JSONObject) info.get(code);
            if ((long) value.get("method") == 1) {
                JSONArray content = (JSONArray) value.get("content");
                open((String) content.get(0), (String) content.get(1));
            } else if ((long) value.get("method") == 2) {
                JSONArray content = (JSONArray) value.get("content");
                close((String) content.get(0), (String) content.get(1));
            } else if ((long) value.get("method") == 3) {
                JSONArray content = (JSONArray) value.get("content");
                key(content);
            }
        }
    }

    private static void open(String name, String locate) {
        Core.shellExecute("open", name, locate);
    }

    private static void close(String type, String title) {
        Core.closeWindows(type, title);
    }

    private static void key(JSONArray array) throws AWTException {
        if (array.size()>2) {
            Core.shortcutKeys((int)(long) array.get(0), (int)(long) array.get(1), (int)(long) array.get(2));
        } else {
            Core.shortcutKeys((int)(long) array.get(0), (int)(long) array.get(1));
        }
    }

}