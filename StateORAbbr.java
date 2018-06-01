

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public enum StateORAbbr {

       Alabama("Alabama", "AL","Birmingham", "Montgomery"),Alaska("Alaska","AK", "Anchorage", "Juneau"),ARIZONA("Arizona","AZ",  "Phoenix", "Phoenix"),
       Arkansas("Arkansas","AR", "Little Rock", "Little Rock"),California("California","CA",  "Los Angeles", "Sacramento"),
       Connecticut("Connecticut","CT",  "Bridgeport", "Hartford"),
    Delaware("Delaware","DE",  "Wilmington", "Dover"),
    Florida("Florida","FL",  "Jacksonville", "Tallahassee"),
    Georgia("Georgia","GA",  "Atlanta", "Atlanta"),
    Hawaii("Hawaii","HI",  "Honolulu", "Honolulu"),
    Idaho("Idaho","ID",  "Boise", "Boise"),
    Illinois("Illinois","IL",  "Chicago", "Springfield"),
    Indiana("Indiana","IN",  "Indianapolis", "Indianapolis"),
    Iowa("Iowa","IA",  "Des Moines", "Des Moines"),
    Kansas("Kansas","KS",  "Wichita", "Topeka"),
    Kentucky("Kentucky","KY",  "Louisville", "Frankfort"),           
    Louisiana("Louisiana","LA",  "New Orleans", "Baton Rouge"),
    Maine("Maine","ME",  "Portland", "Augusta"),
    Maryland("Maryland","MD",  "Baltimore", "Annapolis"),
    Massachusetts("Massachusetts","MA",  "Boston", "Boston"),
    Michigan("Michigan","MI",  "Detroit", "Lansing"),
    Minnesota("Minnesota","MN",  "Minneapolis", "St. Paul"),
    Mississippi("Mississippi","MS",  "Jackson", "Jackson"),
    Missouri("Missouri","MO",  "Kansas City", "Jefferson City"),
    Montana("Montana","MT",  "Billings", "Helena"),
    Nebraska("Nebraska","NE",  "Omaha", "Lincoln"),
    Nevada("Nevada","NV",  "Las Vegas", "Carson City"),
    New_Hampshire("New Hampshire","NH",  "Manchester", "Concord"),
    New_Jersey("New Jersey","NJ",  "Newark", "Trenton"),
    New_Mexico("New Mexico","NM",  "Albuquerque", "Santa Fe"),
    New_York("New York","NY",  "New York City", "Albany"),
    North_Carolina("North Carolina","NC",  "Charlotte", "Raleigh"),
    North_Dakota("North Dakota","ND",  "Fargo", "Bismarck"),
    Ohio("Ohio", "OH", "Columbus", "Columbus"),
    Oklahoma("Oklahoma","OK", "Oklahoma City","Oklahoma City"),            
    Oregon("Oregon","OR",  "Portland", "Salem"),
    Pennsylvania("Pennsylvania","PA",  "Philadelphia", "Harrisburg"),
    Rhode_Island("Rhode Island","RI",  "Providence", "Providence"),           
    South_Carolina("South Carolina","SC",  "Charleston", "Columbia"),
    South_Dakota("South Dakota","SD", "Sioux Falls", "Pasque Flower"),
    Tennessee("Tennessee","TN", "Nashville", "Nashville"),
    Texas("Texas","TX", "Houston", "Austin"),
    Utah("Utah","UT", "Salt Lake City", "Salt Lake City"),
    Vermont("Vermont","VT", "Burlington", "Montpelier"),
    Virginia("Virginia","VA","Virginia Beach"," Richmond"),
    Washington("Washington","WA", "Seattle", "Olympia"),
    West_Virginia("West Virginia","WV", "Charleston", "Charleston"),
    Wisconsin("Wisconsin","WI", "Milwaukee", "Madison"),
    Wyoming("Wyoming","WY", "Cheyenne", "Cheyenne"),    
    American_Samoa("American Samoa","AS"," "," Pago Pago"),
    Guam("Guam","GU", " ", "Hagåtña"),
    Northern_Mariana_Islands("Northern Mariana Islands","MP", " ", "Saipan"),
    Puerto_Rico("Puerto Rico","PR", " ", "San Juan"),
    UNKNOWN("Unknown","Unknown","Unknown","Unknown"),
    US_Virgin_Islands("U.S. Virgin Islands","VI", " ", "Charlotte Amalie");
       
       
       

       /**
       * The state's name.
       */
       private String name;

       /**
       * The state's abbreviation.
       */
       private String abbreviation;
       private String largestCity;
       private String capital;
       /**
       * The set of states addressed by abbreviations.
       */
       private static final Map<String, StateORAbbr> STATES_BY_ABBR = new HashMap<String, StateORAbbr>();

       /* static initializer */
       static {
              for (StateORAbbr state : values()) {
                     STATES_BY_ABBR.put(state.getAbbreviation().toLowerCase(), state);
              }
       }
       private static final Map<String, StateORAbbr> STATES_BY_NAME = new HashMap<String, StateORAbbr>();

       /* static initializer */
       static {
              for (StateORAbbr state : values()) {
                     STATES_BY_NAME.put(state.getName().toLowerCase(), state);
              }
       }

       /**
       * Constructs a new state.
       *
       * @param name
       *            the state's name.
       * @param abbreviation
       *            the state's abbreviation.
       */
       StateORAbbr(String name, String abbreviation, String largestCity, String capital) {
              this.setName(name);
              this.setAbbreviation(abbreviation);
              this.setLargestCity(largestCity);
              this.setCapital(capital);

       }

       /**
       * Gets the enum constant with the specified abbreviation.
       *
       * @param abbr
       *            the state's abbreviation.
       * @return the enum constant with the specified abbreviation.
       * @throws SunlightException
       *             if the abbreviation is invalid.
       */
       public static StateORAbbr valueOfAbbreviation(final String abbr) {
              final StateORAbbr state = STATES_BY_ABBR.get(abbr);
              if (state != null) {
                     return state;
              } else {
                     return UNKNOWN;
              }
       }

       /**
       * Gets the enum constant with the specified state.
       *
       * @param abbr
       *            the state's name.
       * @return the enum constant with the specified name.
       * @throws SunlightException
       *             if the name is invalid.
       */
       public static StateORAbbr valueOfStateName(final String name) {
              final StateORAbbr state = STATES_BY_NAME.get(name);
              if (state != null) {
                     return state;
              } else {
                     return UNKNOWN;
              }
       }

       public static StateORAbbr valueOfName(final String name) {
              final String enumName = name.toLowerCase().replaceAll(" ", "_");

              try {
                     return valueOf(enumName);
              } catch (final IllegalArgumentException e) {
                     return StateORAbbr.UNKNOWN;
              }
       }

       @Override
       public String toString() {
              return getName().toLowerCase();
       }

       public static void main(String s[]) {
              @SuppressWarnings("resource")
              Scanner userInput = new Scanner(System.in);

              while (true) {
                     System.out.println("Enter a State Name or State Abbreviation or None to exit:");
                     String stateName = userInput.nextLine().toLowerCase();

                     if (stateName.equalsIgnoreCase("None")) {
                           break;
                     } else {

                           StateORAbbr stateInfo = valueOfStateName(stateName);
                           if (stateName.length() > 2) {

                                  // System.out.println("State: " + stateInfo.getName());
                                  System.out.println("Abbreviation: " + stateInfo.getAbbreviation());
                                  System.out.println("Largest City: " + stateInfo.getLargestCity());
                                  System.out.println("Capital: " + stateInfo.getCapital());
                           } else {

                                  if (stateName.length() == 2) {
                                         StateORAbbr stateInfowithabr = valueOfAbbreviation(stateName);
                                         // System.out.println("in state "+stateInfowithabr);
                                         System.out.println("State: " + stateInfowithabr.getName());
                                         System.out.println("Abbreviation: " + stateInfowithabr.getAbbreviation());
                                         System.out.println("Largest City: " + stateInfowithabr.getLargestCity());
                                         System.out.println("Capital: " + stateInfowithabr.getCapital());
                                  }
                           }

                     }
              }

       }

       private String getName() {
              return name;
       }

       private void setName(String name) {
              this.name = name;
       }

       private String getAbbreviation() {
              return abbreviation;
       }

       private void setAbbreviation(String abbreviation) {
              this.abbreviation = abbreviation;
       }

       private String getLargestCity() {
              return largestCity;
       }

       private void setLargestCity(String largestCity) {
              this.largestCity = largestCity;
       }

       private String getCapital() {
              return capital;
       }

       private void setCapital(String capital) {
              this.capital = capital;
       }
}

