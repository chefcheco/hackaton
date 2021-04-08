package service;

import model.Carer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Service {

    private List<Carer> carerList;
    private Carer carer = new Carer();

    public List<Carer> list() {

        JSONObject jsonObject;
        JSONParser parser = new JSONParser();

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader("/home/checo/HACKATON/FOXTROT/duck-tales/src/main/webapp/carerDB.json"));
            carer.setName((String) jsonObject.get("name"));
            carer.setAge((long) jsonObject.get("age"));
            carer.setEmail((String) jsonObject.get("email"));
            carer.setPhone((String) jsonObject.get("phone"));
            carer.setAboutMe((String) jsonObject.get("aboutMe"));
            carer.setRating((long) jsonObject.get("rating"));
            carer.setServiceCounter((long) jsonObject.get("serviceCounter"));

            System.out.println(carer.toString());


        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carerList;

    }
}
