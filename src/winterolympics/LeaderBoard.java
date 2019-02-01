package winterolympics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.border.*;
import static winterolympics.WinterOlympics.*;

/**
 *
 * @author KristofferKeene
 */
public class LeaderBoard extends JFrame{
    
    private static final int WIDTH = 1300;
    private static final int HEIGHT = 800;
    private JComboBox eventsBox;
    private JTextField competitor1, competitor2, competitor3, competitor4, competitor5;
    private JTextField time1, time2, time3, time4, time5;
    private JTextField country1, country2, country3, country4, country5;
    private JTextField[] competitorVariables = {competitor1, competitor2, competitor3, competitor4, competitor5};
    private JLabel rank1, rank2, rank3, rank4, rank5;
    private JLabel[] ranks = {rank1, rank2, rank3, rank4, rank5};
    private String[] ranksText = {"GOLD", "SILVER", "BRONZE", "4", "5"};
    private JTextField[] timeVariables = {time1, time2, time3, time4, time5};
    private JTextField[] countryVariables = {country1, country2, country3, country4, country5};
    private boolean ifTimed = true;
    private JTextArea eventsInfoBox;
    private JLabel timeScore, timeScoreLabel;
    private JTextField newEvent, newEventInfo;
    private String[] timeVsScore = {"", "Timed", "Score"};
    private JComboBox timeScoreBox;
    private JTextField newCompetitor, newCompetitorTime, newCompetitorCountry;
    private JButton submitNewEvent, submitNewCompetitor;
    private JLabel enterEvent;
    private JLabel eventAddedConfirmation, competitorAddedConfirmation;
    private JLabel enterNewCompetitor;
    private Event eventAdded;
    private JPanel row1, row2, row3, row4, row5, row6, row7, row8;
    private JPanel westPanelTop;
    private Listener listener;


    public LeaderBoard() {
        setTitle("Winter Olympics");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    } // end LeaderBoard constructor
    
    public void createContents() {
        JPanel windowPanel = new JPanel(new BorderLayout(0,10));
        windowPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        
        // northPanel to hold title
        JPanel northPanel = new JPanel(new FlowLayout());
        
        // westPanel to hold event info
        JPanel westPanel = new JPanel();
        GridLayout gridLayoutWest = (new GridLayout(2,1));
        gridLayoutWest.setVgap(40);
        westPanel.setLayout(gridLayoutWest);
        
        // eastPanel to hold competitor info
        JPanel eastPanel = new JPanel();
        GridLayout gridLayoutEast = new GridLayout(6, 4);
        gridLayoutEast.setVgap(5);
        gridLayoutEast.setHgap(5);
        eastPanel.setLayout(gridLayoutEast);
        
        // southPanel to hold new event info
        JPanel southPanel = new JPanel(new GridLayout(8,1));
        southPanel.setBorder(new EmptyBorder(10,10,10,10));
        Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder newEventSection = BorderFactory.createTitledBorder(loweredetched, "Customize and Add More Info");
        newEventSection.setTitleFont(new Font("Courier", Font.BOLD,20));
        newEventSection.setTitleJustification(TitledBorder.CENTER);
        southPanel.setBorder(newEventSection);
        
        // northPanel
        JLabel title = new JLabel("PyeongChang 2018 Winter Olympics");
        title.setFont(new Font("Courier", Font.BOLD,40));
        northPanel.add(title);
        
        //westPanel
        westPanelTop = new JPanel(new GridLayout(2,1));
        JPanel westPanelBottom = new JPanel(new GridLayout());
        JLabel eventLabel = new JLabel("Select an event:");
        eventLabel.setFont(new Font("Courier", Font.PLAIN,22));
        //eventsBox = new JComboBox(eventsList);
        eventsBox = new JComboBox(eventsArray);
        
//        for (int i = 0; i < events.size(); i++) {
//            eventsBox.addItem(events.get(i).getEventName());
//        }

        eventsBox.setFont(new Font("Courier", Font.PLAIN, 18));
        eventsInfoBox = new JTextArea();
        eventsInfoBox.setEditable(false);
        eventsInfoBox.setLineWrap(true);
        eventsInfoBox.setWrapStyleWord(true);
        eventsInfoBox.setFont(new Font("Dialog", Font.ITALIC, 14));
        listener = new Listener();
        eventsBox.addActionListener(listener);
        eventsBox.setSelectedIndex(eventsArray.length-1);
        
        westPanelTop.add(eventLabel);
        westPanelTop.add(eventsBox);
        westPanelBottom.add(eventsInfoBox);
        
        westPanel.add(westPanelTop);
        westPanel.add(westPanelBottom);
        
        //eastPanel
        Font boardTitle = new Font("Courier", Font.BOLD,20);
        JLabel ranking, competitorName, country;
        eastPanel.add(ranking = new JLabel("Ranking", SwingConstants.CENTER));
        eastPanel.add(competitorName = new JLabel("Competitor Name", SwingConstants.CENTER));
        eastPanel.add(timeScore = new JLabel("Time/Score", SwingConstants.CENTER));
        eastPanel.add(country = new JLabel("Country", SwingConstants.CENTER));
        ranking.setFont(boardTitle);
        competitorName.setFont(boardTitle);
        timeScore.setFont(boardTitle);
        country.setFont(boardTitle);
        
        // create leader board
        for (int i = 0; i<5; i++) {
            //eastPanel.add(new JLabel(Integer.toString(i+1), SwingConstants.CENTER));
            eastPanel.add(ranks[i] = new JLabel((ranksText[i]), SwingConstants.CENTER));
            ranks[i].setFont(new Font("SansSerif", Font.BOLD, 16));
            eastPanel.add(competitorVariables[i] = new JTextField(20));
            competitorVariables[i].setEditable(false);
            competitorVariables[i].setBorder(createEmptyBorder());
            competitorVariables[i].setHorizontalAlignment(JTextField.CENTER);
            competitorVariables[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            eastPanel.add(timeVariables[i] = new JTextField(10));
            timeVariables[i].setEditable(false);
            timeVariables[i].setBorder(createEmptyBorder());
            timeVariables[i].setHorizontalAlignment(JTextField.CENTER);
            timeVariables[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            eastPanel.add(countryVariables[i] = new JTextField(5));
            countryVariables[i].setEditable(false);
            countryVariables[i].setBorder(createEmptyBorder());
            countryVariables[i].setHorizontalAlignment(JTextField.CENTER);
            countryVariables[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
        } // end for
        
        // no longer display 5 competitors, just top 3 winners
        for (int i = 3; i < 5; i++) {
            ranks[i].setVisible(false);
            competitorVariables[i].setVisible(false);
            timeVariables[i].setVisible(false);
            countryVariables[i].setVisible(false);
        }
        
        //color 3 ranked labels
        ranks[0].setForeground(new Color(203, 182, 119)); // gold
        ranks[1].setForeground(new Color(192, 192, 192)); // silver
        ranks[2].setForeground(new Color(205, 127, 50)); // bronze

        
        //southPanel
        //row1
        row1 = new JPanel(new FlowLayout());
        row1.add(enterEvent = new JLabel("Enter new Event:"));
        southPanel.add(row1);
        
        //row2
        row2 = new JPanel(new GridLayout(1,3));
        row2.add(new JLabel("Event Name"));
        row2.add(new JLabel("Event Info"));
        row2.add(new JLabel("Timed or Score?"));
        southPanel.add(row2);
        
        //row3
        row3 = new JPanel(new GridLayout(1,3));
        row3.add(newEvent = new JTextField(10));
        row3.add(newEventInfo = new JTextField(20));
        row3.add(timeScoreBox = new JComboBox(timeVsScore));
        southPanel.add(row3);
        
        //row4
        row4 = new JPanel(new FlowLayout());
        row4.add(submitNewEvent = new JButton("Click to Submit New Event"));
        row4.add(eventAddedConfirmation = new JLabel());
        southPanel.add(row4);
        
        submitNewEvent.addActionListener(listener);
        
        //row5
        row5 = new JPanel(new FlowLayout());
        row5.add(enterNewCompetitor = new JLabel("Enter new Competitor:"));
        row5.add(competitorAddedConfirmation = new JLabel());
        southPanel.add(row5);
        row5.setVisible(false);
        
                //row6
        row6 = new JPanel(new GridLayout(1,3));
        row6.add(new JLabel("Competitor Name"));
        row6.add(timeScoreLabel = new JLabel("Time/Score"));
        row6.add(new JLabel("Country"));
        southPanel.add(row6);
        row6.setVisible(false);
        
        //row7
        row7 = new JPanel(new GridLayout(1,3));
        row7.add(newCompetitor = new JTextField(10));
        row7.add(newCompetitorTime = new JTextField(5));
        row7.add(newCompetitorCountry = new JTextField(5));
        southPanel.add(row7);
        row7.setVisible(false);
        
        //row8
        row8 = new JPanel(new FlowLayout());
        row8.add(submitNewCompetitor = new JButton("Click to Submit New Competitor"));
        southPanel.add(row8);
        row8.setVisible(false);
        submitNewCompetitor.addActionListener(listener);

        
        windowPanel.add(northPanel, BorderLayout.NORTH);
        windowPanel.add(westPanel, BorderLayout.WEST);
        windowPanel.add(eastPanel, BorderLayout.EAST);
        windowPanel.add(southPanel, BorderLayout.SOUTH);
        add(windowPanel);
        
        
        
    } // end createContents
    
    
        private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() != submitNewEvent) {
                // JComboBox / dropdown list of events menu
                try {
                    for (int i = 0; i < eventsBox.getItemCount(); i++) {
//                        System.out.println("eventbox item count " + eventsBox.getItemCount());
//                        System.out.println("event box selected item" + eventsBox.getSelectedItem());
//                        System.out.println("get event name: " + events.get(i).getEventName());
                        
                        if (((String) eventsBox.getSelectedItem()).equals(events.get(i).getEventName())) {
                            
                            //eventsInfoBox.setText(events.get(i).getEventInfo());
                            getData2(events.get(i));
                            //System.out.println("get here: " + events.get(i));
                            if (events.get(i).isIfTimed()) {
                                timeScore.setText("Time");
                            } else {
                                timeScore.setText("Score");
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException iobe) {
                    //System.out.println("Index Out Of Bounds");
                } catch (NullPointerException npe) {
                    //System.out.println("here null pointer exception");
                }
            }

            // add new event
            if (e.getSource() == submitNewEvent) {

                if ((String) timeScoreBox.getSelectedItem()== "Timed") {
                    eventAdded = new Event(newEvent.getText(), newEventInfo.getText(), true);
                    timeScoreLabel.setText("Time   mm : ss . ms   (For Example 3:27.73)");
                } else {
                    eventAdded = new Event(newEvent.getText(), newEventInfo.getText(), false);
                    timeScoreLabel.setText("Score");
                }
                System.out.println("Timed: " + eventAdded.isIfTimed());


                
                
                
                updateFile(events);

                
                
                enterEvent.setVisible(false);
                submitNewEvent.setVisible(false);
                timeScoreBox.disable();
                newEvent.setEditable(false);
                newEventInfo.setEditable(false);
                eventAddedConfirmation.setText("Added new event: " + newEvent.getText());
                

                // turn on add competitor input
                row5.setVisible(true);
                row6.setVisible(true);
                row7.setVisible(true);
                row8.setVisible(true);
                
                getData2(eventAdded);
                addToArray();

                westPanelTop.remove(eventsBox);
                eventsBox = new JComboBox(eventsArray);
                eventsBox.setFont(new Font("Courier", Font.PLAIN, 18));
                westPanelTop.add(eventsBox);
                eventsBox.setSelectedIndex(eventsArray.length-1);
                eventsBox.addActionListener(listener);
                clearBoard();
                eventsInfoBox.setText(newEventInfo.getText());
                   
            }

            // add new competitor
            if (e.getSource() == submitNewCompetitor) {
                enterNewCompetitor.setVisible(false);
                competitorAddedConfirmation.setText("Competitor " + (eventAdded.getCompetitors().size() + 1) + " Added");
                eventAdded.addCompetitor(new Competitor(newCompetitor.getText(), newCompetitorTime.getText(), newCompetitorCountry.getText()));
                newCompetitor.setText(null);
                newCompetitorTime.setText(null);
                newCompetitorCountry.setText(null);

                // after sorting print
                
                updateFile(events);


                clearBoard();
                getData2(eventAdded);

            } // end if

        } // end actionPerformed
    } // end Listener class

        //        for (int i = 0; i < events.size(); i++) {
//            System.out.println(events.get(i).getEventName());
//            for (int j = 0; j < events.get(i).getCompetitors().size(); j++) {
//                System.out.println(events.get(i).getCompetitors().get(j).getName());
//            }
//        }
    
    public void getData2(Event event) {

        int listSize = event.getCompetitors().size();
        clearBoard();
        
        if (event.isIfTimed()) {
            try {
                Collections.sort(event.getCompetitors());

            } catch (UnsupportedOperationException uoe) {
                System.out.println("not yet");
            } catch (NumberFormatException nfe) {
                System.out.println("missing value");
            }
        } else {
            try {
                Collections.sort(event.getCompetitors());      // sorts list, but then reverses for highest score
                Collections.reverse(event.getCompetitors());
            } catch (UnsupportedOperationException uoe) {
                System.out.println("not yet");
            } catch (NumberFormatException nfe) {
                System.out.println("missing value");
            }
        }
        
        
try{
        for (int i = 0; i < listSize; i++) {
            competitorVariables[i].setText(event.getCompetitors().get(i).getName());
            timeVariables[i].setText(event.getCompetitors().get(i).getTimeScore());
            countryVariables[i].setText(event.getCompetitors().get(i).getCountry());
            //System.out.println("competitor name: " + event.getCompetitors().get(i).getName() + " time: " + event.getCompetitors().get(i).getTimeScore());
            

        } // end for             
        eventsInfoBox.setText(event.getEventInfo());
} catch (ArrayIndexOutOfBoundsException aiobe) {
                    System.out.println("More than 5 competitors added");
                }
    } // end getData2
    
        public void clearBoard() {

        int listSize = 5;

        for (int i = 0; i < listSize; i++) {
            competitorVariables[i].setText("");
            timeVariables[i].setText("");
            countryVariables[i].setText("");

        } // end for      
        eventsInfoBox.setText("");
    } // end clearBoard
    
        private void updateFile(ArrayList arraylist) {
                            try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(filename))) {

                    arraylist.add(eventAdded);
                    fileOut.writeObject(arraylist);

                    fileOut.reset();

                    addToArray();

                } catch (Exception ex) {
                    System.out.println(ex.getClass());
                    System.out.println(ex.getMessage());
                }

                //read file
                try (ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(filename))) {
                    while (true) {
                        arraylist = (ArrayList) fileIn.readObject();
                    }
                } catch (EOFException eof) {
                    // eof excpetion terminates infinite while loop
                } catch (Exception eof) {
                    System.out.println(eof.getClass());
                    System.out.println(eof.getMessage());
                }
        }
    
} // end LeaderBoard class
