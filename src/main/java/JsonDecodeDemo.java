import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.soap.SOAPPart;
import java.io.IOException;
import java.net.URL;

class JsonDecodeDemo {

    public static void main(String[] args){

        JSONParser parser = new JSONParser();

        try{
            URL url = Resources.getResource("detail.json");
            String text = Resources.toString(url, Charsets.UTF_8);
            Object obj = parser.parse(text);
            JSONArray array = (JSONArray)obj;

            for(int counter=0;counter<array.size();++counter)
                System.out.println(array.get(counter));

        }catch(ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}