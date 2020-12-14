import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JasonConverter {

        /**
         * Generating a JSON Object
         *
         * @param args
         */
        public static void main(String[] args) {
            JSONObject myObject = new JSONObject();
            // Basic strings
            myObject.put("name", "Carlos");
            myObject.put("last_name", "Carlos");
            System.out.print(myObject);
            // Primitive values
            myObject.put("age", new Integer(21));
            myObject.put("bank_account_balance", new Double(20.2));
            myObject.put("is_developer", new Boolean(true));

            // Key with array
            double[] myList = {1.9, 2.9, 3.4, 3.5};
            myObject.put("number_list", myList);

            // Object inside object
            JSONObject subdata = new JSONObject();
            myObject.put("extra_data", subdata);

            // Generate JSON String
        }
}
