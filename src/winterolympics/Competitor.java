
package winterolympics;

import java.io.Serializable;

/**
 *
 * @author KristofferKeene
 */
public class Competitor implements Comparable<Competitor>, Serializable{

    private String name;
    private String timeScore;
    private String country;
    

    public Competitor(String name, String timeScore, String country) {
        this.name = name;
        this.timeScore = timeScore;
        this.country = country;
    } // end Competitors constructor


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeScore() {
        return timeScore;
    }

    public void setTimeScore(String timeScore) {
        this.timeScore = timeScore;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public double getTime() {
        
        try{
        int colon = this.getTimeScore().indexOf(":");
        int decimal = this.getTimeScore().indexOf(".");
        double min = Double.parseDouble(this.getTimeScore().substring(0, colon)) * 60;
        double sec = (Double.parseDouble(this.getTimeScore().substring(colon + 1, decimal)));
        double milsec = (Double.parseDouble(this.getTimeScore().substring(decimal + 1))) / 100;
        Double time = min + sec + milsec;
        
//            System.out.println("min: " + min);
//            System.out.println("sec: " + sec);
//            System.out.println("milsec: " + milsec);
//            System.out.println("Time: " + time);
        
        return time;
        }
        
        catch (StringIndexOutOfBoundsException siobe) {
            int colon = this.getTimeScore().indexOf(".");
            int decimal = this.getTimeScore().lastIndexOf(".");
            double min = Double.parseDouble(this.getTimeScore().substring(0, colon)) * 60;
            double sec = (Double.parseDouble(this.getTimeScore().substring(colon + 1, decimal)));
            double milsec = (Double.parseDouble(this.getTimeScore().substring(decimal + 1))) / 100;
            Double time = min + sec + milsec;
            return time;   
        }


    } // end getTime
    
    @Override
    public int compareTo(Competitor comp) {

        try{
//            System.out.println("\nCompetitor name: " +((Competitor) comp).getName());
//            System.out.println("Competitor time: " +((Competitor) comp).getTime() );
            
        return (this.getTime()) < ((Competitor) comp).getTime() ? -1
                : (this.getTime()) == ((Competitor) comp).getTime() ? 0 : 1;
        } 
        catch (StringIndexOutOfBoundsException siob) {
//            System.out.println("okay");
        return (Double.parseDouble(this.getTimeScore()) < Double.parseDouble(((Competitor) comp).getTimeScore()) ? -1
                : (Double.parseDouble(this.getTimeScore()) == Double.parseDouble(((Competitor) comp).getTimeScore()) ? 0 : 1));           
        }
        catch (Exception e) {
//            System.out.println(e);
//            System.out.println(e.getClass());
        return (Double.parseDouble(this.getTimeScore()) < Double.parseDouble(((Competitor) comp).getTimeScore()) ? -1
                : (Double.parseDouble(this.getTimeScore()) == Double.parseDouble(((Competitor) comp).getTimeScore()) ? 0 : 1));
        }

        

        
    } // end compareTo

    
    
}
