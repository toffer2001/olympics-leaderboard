/****************************************
 * WinterOlympics.java
 * Kristoffer Keene
 * 
 * This shows the rankings in the Winter Olympics
 ****************************************/
package winterolympics;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author KristofferKeene
 */
public class WinterOlympics {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Event> events = new ArrayList<>();
    public static String[] eventsArray = new String[7];
    public static FileWriter filewriter;
    public static BufferedWriter bufferedwriter;
    public static String filename = "C:\\Users\\KristofferKeene\\Dropbox\\Personal\\DATC\\2220 - Java II\\Final Project\\WinterOlympics\\WinterOlympics.txt";
    
    public static void main(String[] args) {

        writeDataToFile();

        new LeaderBoard();

    } // end main

    public static void addToArray() {

        for (int i = 0; i < events.size(); i++) {
            eventsArray[i] = events.get(i).getEventName();
//            System.out.println("array: " + events.get(i).getEventName());
        } // end for
        

    } // end addToArray
    
    public static void writeDataToFile() {
                Event menSnowboardHalfpipe = new Event(
                "Mens Snowboarding Halfpipe",
                "The half-pipe is a semi-circular ditch dug into the mountain or purpose-built ramp made up of snow, with walls between 8 and 23 feet (7.0 m). Competitors perform tricks while going from one side to the other and while in the air above the sides of the pipe.",
                false
        ); // https://www.bbc.com/sport/winter-olympics/results/sports/snowboarding/snowboard-mens-halfpipe

        Event menSingleSkating = new Event(
                "Mens Single Figure Skating",
                "There are two segments in all international competitions, the short program and the free skating program. Singles skating has required elements that skaters must perform during a competition and that make up a well-balanced skating program.",
                false
        ); // http://www.isuresults.com/results/season1718/owg2018/CAT001RS.HTM

        Event menSkiLargeHill = new Event(
                "Mens Large Hill Ski Jump",
                "Ski jumping has been included in the program of every Winter Olympic Games. From 1924 through to 1956, the competition involved jumping from one hill whose length varied from each edition of the games to the next.",
                false
        ); // https://www.olympic.org/pyeongchang-2018/ski-jumping/mens-large-hill-individual

        Event womenSkiAlpine = new Event(
                "Womens Alpine Ski",
                "Alpine skiing, or downhill skiing, is the pastime of sliding down snow-covered slopes on skis with fixed-heel bindings, unlike other types of skiing (cross-country, Telemark, or ski jumping), which use skis with free-heel bindings.",
                true
        ); // https://www.olympic.org/pyeongchang-2018/alpine-skiing/ladies-downhill

        Event womenSkeleton = new Event(
                "Womens Skeleton",
                "Skeleton is where the competitor rides head-first and prone (lying face down) on a flat sled. It is normally run on an ice track that allows the sled to gain speed by gravity.",
                true
        ); // https://www.olympic.org/pyeongchang-2018/skeleton/women

        Event womenSpeedSkating500M = new Event(
                "Womens Speed Skating 500m",
                "Speed skating has been featured as a sport in the Winter Olympics since the first winter games in 1924. Women's events were added to the Olympic program for the first time in 1960.",
                true
        ); // https://www.olympic.org/pyeongchang-2018/speed-skating/ladies-500m
        
        
        menSnowboardHalfpipe.addCompetitor(new Competitor ("Scotty James", "92.00", "AUS"));
        menSnowboardHalfpipe.addCompetitor(new Competitor("Patrick Burgener", "89.75", "SWI"));
        menSnowboardHalfpipe.addCompetitor(new Competitor ("Shaun White", "97.75", "USA"));
        menSnowboardHalfpipe.addCompetitor(new Competitor("Ben Furguson", "90.75", "USA"));
        menSnowboardHalfpipe.addCompetitor(new Competitor ("Ayumu Hirano", "95.25", "JPN"));    
        

        menSingleSkating.addCompetitor(new Competitor("Boyang Jin", "297.77", "CHN"));
        menSingleSkating.addCompetitor(new Competitor("Javier Fernandez", "305.24", "ESP"));
        menSingleSkating.addCompetitor(new Competitor("Shoma Uno", "306.90", "JPN"));
        menSingleSkating.addCompetitor(new Competitor("Yuzuru Hanyu", "317.85", "JPN"));
        menSingleSkating.addCompetitor(new Competitor("Boyang Jin", "297.35", "USA"));

        menSkiLargeHill.addCompetitor(new Competitor("Kamil Stoch", "285.7", "POL"));
        menSkiLargeHill.addCompetitor(new Competitor("Daniel Andre Tande", "273.1", "NOR"));
        menSkiLargeHill.addCompetitor(new Competitor("Johann Andre Forfang", "271.6", "NOR"));
        menSkiLargeHill.addCompetitor(new Competitor("Robert Johansson", "275.3", "NOR"));
        menSkiLargeHill.addCompetitor(new Competitor("Andreas Wellinger", "282.3", "GER"));
        
        womenSkiAlpine.addCompetitor(new Competitor("Alice McKennis", "1:40.24", "USA")); // 6024
        womenSkiAlpine.addCompetitor(new Competitor("Tina Weirather", "1:39.85", "LIE")); // 6025
        womenSkiAlpine.addCompetitor(new Competitor("Lindsey Vonn", "1:39.69", "USA"));
        womenSkiAlpine.addCompetitor(new Competitor("Ragnhild Mowinckel", "1:39.31", "NOR"));
        womenSkiAlpine.addCompetitor(new Competitor("Sofia Goggia", "1:39.22", "ITA"));
        

        
        womenSkeleton.addCompetitor(new Competitor("Laura Deas", "3:27.90", "GBR"));
        womenSkeleton.addCompetitor(new Competitor("Jacqueline Loelling", "3:27.73", "GER"));
        womenSkeleton.addCompetitor(new Competitor("Elizabeth Yarnold", "3:27.28", "GBR"));
        womenSkeleton.addCompetitor(new Competitor("Tina Hermann", "3:27.98", "GER"));
        womenSkeleton.addCompetitor(new Competitor("Janine Flock", "3:27.92", "AUT"));
        
        womenSpeedSkating500M.addCompetitor(new Competitor("Vanessa Bittner", "37.51", "AUT"));
        womenSpeedSkating500M.addCompetitor(new Competitor("Karolina Erbanova", "37.34", "CZE"));
        womenSpeedSkating500M.addCompetitor(new Competitor("Nao Kodaira", "36.94", "JPN"));
        womenSpeedSkating500M.addCompetitor(new Competitor("Brittany Bowe", "37.530", "USA"));
        womenSpeedSkating500M.addCompetitor(new Competitor("Sang Hwa Lee", "37.33", "KOR"));


        
        try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filename))) {
            
            events.add(menSnowboardHalfpipe);
            events.add(menSingleSkating);
            events.add(menSkiLargeHill);
            events.add(womenSkiAlpine);
            events.add(womenSkeleton);
            events.add(womenSpeedSkating500M);
            fileOut.writeObject(events);

            fileOut.reset();

            addToArray();           
            

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

        
        //read file
        try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename))) {
            while (true) {
                events = (ArrayList) fileIn.readObject();
            }
        } catch (EOFException e) {
            // eof excpetion terminates infinite while loop
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        


//        for (int i = 0; i < events.size(); i++) {
//            System.out.println(events.get(i).getEventName());
//            for (int j = 0; j < events.get(i).getCompetitors().size(); j++) {
//                System.out.println(events.get(i).getCompetitors().get(j).getName());
//            }
//        }
    }
    

} // end WinterOlympics class
