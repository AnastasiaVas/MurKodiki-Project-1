package converter.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import converter.IConverter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import project1.model.Person;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JasonConverter implements IConverter {
    Gson json = new Gson();

    @Override
    public String getStrFromPersons(List<Person> persons) {
        String resultStr = json.toJson(persons);
        return resultStr;
    }

 //  public void delete(FileReader file, long id) throws IOException, ParseException {
 //      JSONParser jsonParser = new JSONParser();
 //      JSONArray jsonArray = (JSONArray) jsonParser.parse(file);
 //      Iterator i = jsonArray.iterator();
 //      while (i.hasNext()){
 //          JSONObject innerObj = (JSONObject) i.next();
 //          if (innerObj.get("id").equals(id)){
 //              jsonArray.remove(innerObj);
 //              System.out.println(jsonArray);
 //              System.out.println(file);
 //          }
 //      }
 //  }

    public List<Person> getPersonsFromString(String strPersons){
        Gson gson = new Gson();
        List<Person> list =  new ArrayList<Person>();
        Type collectionType = new TypeToken<List<Person>>(){}.getType();
        List<Person> persons = gson.fromJson(strPersons, collectionType);
        return persons;
    }

    @Override
    public  String removePersonsFromList(long id, String strPersons) throws IOException {
        return null;
    }

}
