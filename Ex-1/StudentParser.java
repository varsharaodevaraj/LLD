import java.util.*;

public class StudentParser {
    // here we are parsing the raw input that we get
    public Map<String, String> parseToMap(String raw) {
        Map<String,String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }
        return kv;
    }
}
