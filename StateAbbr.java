import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateAbbr {

    
    private final String Name;
    @SuppressWarnings("unused")
	private final String Abbr;
    private final String Largestcity;
    private final String Capital;

    private static final Map<String, StateAbbr> states = new HashMap<>();

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
            {"New Hampshire","NH",  "Manchester", "Concord"},
            {"New Jersey","NJ",  "Newark", "Trenton"},
            {"New Mexico","NM",  "Albuquerque", "Santa Fe"},
            {"New York","NY",  "New York City", "Albany"},
            {"North Carolina","NC",  "Charlotte", "Raleigh"},
            {"North Dakota","ND",  "Fargo", "Bismarck"},
            {"Ohio", "OH", "Columbus", "Columbus"},
            {"Oklahoma","OK", "Oklahoma City","Oklahoma City"},            
            {"Oregon","OR",  "Portland", "Salem"},
            {"Pennsylvania","PA",  "Philadelphia", "Harrisburg"},
            {"Rhode Island","RI",  "Providence", "Providence"},           
            {"South Carolina","SC",  "Charleston", "Columbia"},
            {"South Dakota","SD", "Sioux Falls", "Pasque Flower"},
            {"Tennessee","TN", "Nashville", "Nashville"},
            {"Texas","TX", "Houston", "Austin"},
            {"Utah","UT", "Salt Lake City", "Salt Lake City"},
            {"Vermont","VT", "Burlington", "Montpelier"},
            {"Virginia","VA","Virginia Beach"," Richmond"},
            {"Washington","WA", "Seattle", "Olympia"},
            {"West Virginia","WV", "Charleston", "Charleston"},
            {"Wisconsin","WI", "Milwaukee", "Madison"},
            {"Wyoming","WY", "Cheyenne", "Cheyenne"},
            
            {"American Samoa","AS"," "," Pago Pago"},
            {"Guam","GU", " ", "Hagåtña"},
            {"Northern Mariana Islands","MP", " ", "Saipan"},
            {"Puerto Rico","PR", " ", "San Juan"},
            {"U.S. Virgin Islands","VI", " ", "Charlotte Amalie"}
        };

        for (String[] info : stateInformation) {
            states.put(info[1].toLowerCase(), new StateAbbr(info[0], info[1], info[2],info[3]));
        }
    }

    public StateAbbr(String Name,String Abbr, String Largestcity, String Capital) {
        this.Name = Name;
        this.Abbr = Abbr;
        this.Largestcity = Largestcity;
        this.Capital = Capital;
    }

    public static StateAbbr findState(String stateAbbr) {
        return states.get(stateAbbr.toLowerCase());
    }

    public static void main(String[] args) {

        @SuppressWarnings("resource")
                                Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a State Abbreviation or None to exit:");
            String stateAbbr = userInput.next();

            if (stateAbbr.equalsIgnoreCase("None")) {
                break;
            } else {
                StateAbbr stateInfo = findState(stateAbbr);
                if (stateInfo != null) {
                              System.out.println("State Name: " + stateInfo.Name);
                    System.out.println("Largest City: " + stateInfo.Largestcity);
                    System.out.println("Capital: " + stateInfo.Capital);
                } else {
                    System.out.println("Invalid State Abbreviation Entered");
                }
            }
        }
    }
}