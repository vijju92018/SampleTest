import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateUSA {

    @SuppressWarnings("unused")
    private final String Name;
    private final String Abbr;
    private final String Largestcity;
    private final String Capital;

    private static final Map<String, StateUSA> states = new HashMap<>();

    static {
        String[][] stateInformation = new String[][] {
            {"Alabama","AL", "Birmingham", "Montgomery"},
            {"Alaska","AK", "Anchorage", "Juneau"},
            {"Arizona","AZ",  "Phoenix", "Phoenix"},
            {"Arkansas","AR", "Little Rock", "Little Rock"},
            {"California","CA",  "Los Angeles", "Sacramento"},
            {"Colorado","CO",  "Denver", "Denver"},
            {"Connecticut","CT",  "Bridgeport", "Hartford"},
            {"Delaware","DE",  "Wilmington", "Dover"},
            {"Florida","FL",  "Jacksonville", "Tallahassee"},
            {"Georgia","GA",  "Atlanta", "Atlanta"},
            {"Hawaii","HI",  "Honolulu", "Honolulu"},
            {"Idaho","ID",  "Boise", "Boise"},
            {"Illinois","IL",  "Chicago", "Springfield"},
            {"Indiana","IN",  "Indianapolis", "Indianapolis"},
            {"Iowa","IA",  "Des Moines", "Des Moines"},
            {"Kansas","KS",  "Wichita", "Topeka"},
            {"Kentucky","KY",  "Louisville", "Frankfort"},           
            {"Louisiana","LA",  "New Orleans", "Baton Rouge"},
            {"Maine","ME",  "Portland", "Augusta"},
            {"Maryland","MD",  "Baltimore", "Annapolis"},
            {"Massachusetts","MA",  "Boston", "Boston"},
            {"Michigan","MI",  "Detroit", "Lansing"},
            {"Minnesota","MN",  "Minneapolis", "St. Paul"},
            {"Mississippi","MS",  "Jackson", "Jackson"},
            {"Missouri","MO",  "Kansas City", "Jefferson City"},
            {"Montana","MT",  "Billings", "Helena"},
            {"Nebraska","NE",  "Omaha", "Lincoln"},
            {"Nevada","NV",  "Las Vegas", "Carson City"},
            {"NewHampshire","NH",  "Manchester", "Concord"},
            {"NewJersey","NJ",  "Newark", "Trenton"},
            {"NewMexico","NM",  "Albuquerque", "Santa Fe"},
            {"NewYork","NY",  "New York City", "Albany"},
            {"NorthCarolina","NC",  "Charlotte", "Raleigh"},
            {"NorthDakota","ND",  "Fargo", "Bismarck"},
            {"Ohio", "OH", "Columbus", "Columbus"},
            {"Oklahoma","OK", "Oklahoma City","Oklahoma City"},            
            {"Oregon","OR",  "Portland", "Salem"},
            {"Pennsylvania","PA",  "Philadelphia", "Harrisburg"},
            {"RhodeIsland","RI",  "Providence", "Providence"},           
            {"SouthCarolina","SC",  "Charleston", "Columbia"},
            {"SouthDakota","SD", "Sioux Falls", "Pasque Flower"},
            {"Tennessee","TN", "Nashville", "Nashville"},
            {"Texas","TX", "Houston", "Austin"},
            {"Utah","UT", "Salt Lake City", "Salt Lake City"},
            {"Vermont","VT", "Burlington", "Montpelier"},
            {"Virginia","VA","Virginia Beach"," Richmond"},
            {"Washington","WA", "Seattle", "Olympia"},
            {"WestVirginia","WV", "Charleston", "Charleston"},
            {"Wisconsin","WI", "Milwaukee", "Madison"},
            {"Wyoming","WY", "Cheyenne", "Cheyenne"},
            
            {"AmericanSamoa","AS"," "," Pago Pago"},
            {"Guam","GU", " ", "Hagåtña"},
            {"NorthernMarianaIslands","MP", " ", "Saipan"},
            {"PuertoRico","PR", " ", "San Juan"},
            {"U.S.VirginIslands","VI", " ", "Charlotte Amalie"}
        };

        for (String[] info : stateInformation) {
            states.put(info[0].toLowerCase(), new StateUSA(info[0], info[1], info[2],info[3]));
        }
    }

    public StateUSA(String Name,String Abbr, String Largestcity, String Capital) {
        this.Name = Name;
        this.Abbr = Abbr;
        this.Largestcity = Largestcity;
        this.Capital = Capital;
    }

    public static StateUSA findState(String stateName) {
        return states.get(stateName.toLowerCase());
    }

    public static void main(String[] args) {

        @SuppressWarnings("resource")
       Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a State Name or None to exit:");
            String stateName = userInput.next();

            if (stateName.equalsIgnoreCase("None")) {
                break;
            } else {
                StateUSA stateInfo = findState(stateName);
                if (stateInfo != null) {
                              System.out.println("Abbreviation: " + stateInfo.Abbr);
                    System.out.println("Largest City: " + stateInfo.Largestcity);
                    System.out.println("Capital: " + stateInfo.Capital);
                } else {
                    System.out.println("Invalid State Name Entered");
                }
            }
        }
    }
}