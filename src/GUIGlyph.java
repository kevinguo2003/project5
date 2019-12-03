package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * a front end class
 * 
 * @author Group24
 *         Haisheng Xu (haisheng),
 *         Zhengyu Liu (samueliu14),
 *         Xiao Guo (kevinguo2003)
 * @version 11.17.2019
 *
 */
public class GUIGlyph {

    private Window window;
    private Button artistButton;
    private Button titleButton;
    private Button yearButton;
    private Button genreButton;
    private Button hobbyButton;
    private Button majorButton;
    private Button regionButton;
    private Button next;
    private Button previous;
    private Button quit;

    private int numOfPage;
    private LinkedList<Song> songs;
    private int page;
    

    
    
    private String property;

    /**
     * default cons
     * 
     * @param songList
     *            a list of songs
     * @param personsList
     *            a list of survey results
     */
    public GUIGlyph(LinkedList<Song> songList, LinkedList<Person> personsList) {
        window = new Window("Project 5 haisheng kevinguo2003 samueliu14");
        window.setSize(800, 400);
        setUpButtons();
        
        property = null;
        songs = songList;
        page = 0;
        ini(); 
        numOfPage = songs.size() / 9;
        if (songs.size() % 9 > 0) {
            numOfPage++;
        }
        
    }
    
    public void ini()
    {
        next.disable();
        previous.disable();
        display();
        
        
        if (numOfPage > 1)
        {
            next.enable();
        }
        if (page > 0)
        {
            previous.enable();
        }
        
        
    }
    
    
    /**
     * sort the songlist according to the keyword
     * 
     * @param keyword
     *            the keyword identifying which kind of sort
     *            should be used
     * @param songList
     *            the list that's going to be sorted
     */
    public void sort(String keyword, LinkedList<Song> songList) {
        if (keyword == "genre") {
            genreSort(songList);
        }
        else if (keyword == "title") {
            titleSort(songList);
        }
        else if (keyword == "year") {
            yearSort(songList);
        }
        else if (keyword == "name") {
            nameSort(songList);
        }
    }


    /**
     * sort by genre
     * 
     * @param <T>
     *            basically songs
     * @param songList
     *            the list to be sorted
     */
    private static <T extends Comparable<T>> void genreSort(
        LinkedList<Song> songList) {
        for (int i = 1; i < songList.size(); i++) {
            for (int j = i; (j > 0) && (songList.get(j).getGenre().compareTo(
                songList.get(j - 1).getGenre()) < 0); j--) {
                swap(songList, j - 1, j);
            }
        }

    }


    /**
     * sort by genre
     * 
     * @param <T>
     *            basically songs
     * @param songList
     *            the list to be sorted
     */
    private static <T extends Comparable<T>> void yearSort(
        LinkedList<Song> songList) {
        for (int i = 1; i < songList.size(); i++) {
            for (int j = i; (j > 0) && (songList.get(j).getDate().compareTo(
                songList.get(j - 1).getDate()) < 0); j--) {
                swap(songList, j - 1, j);
            }
        }

    }


    /**
     * sort by title
     * 
     * @param <T>
     *            Basically songs
     * @param songList
     *            the list to be sorted
     */
    private static <T extends Comparable<T>> void titleSort(
        LinkedList<Song> songList) {
        for (int i = 1; i < songList.size(); i++) {
            for (int j = i; (j > 0) && (songList.get(j).getTitle().compareTo(
                songList.get(j - 1).getTitle()) < 0); j--) {
                swap(songList, j - 1, j);
            }
        }

    }


    /**
     * sort by title
     * 
     * @param <T>
     *            Basically songs
     * @param songList
     *            the list to be sorted
     */
    private static <T extends Comparable<T>> void nameSort(
        LinkedList<Song> songList) {
        for (int i = 1; i < songList.size(); i++) {
            for (int j = i; (j > 0) && (songList.get(j).getArtists().compareTo(
                songList.get(j - 1).getArtists()) < 0); j--) {
                swap(songList, j - 1, j);
            }
        }

    }


    /**
     * swap two objects
     * 
     * @param songList
     *            the list that swap action happened
     * @param begin
     *            the begin index
     * @param end
     *            the end index
     */
    private static void swap(LinkedList<Song> songList, int begin, int end) {
        Song currSong = songList.get(begin); // 0
        Song currSong2 = songList.get(end); // 1 0,1 null,1 1,1 1 ,0
        songList.remove(begin);
        songList.add(begin, currSong2);
        songList.remove(end);
        songList.add(end, currSong);

    }


    private void display()
    {
        if (property == null)
        {
            //do nothing
        }
        if (property == "Hobby") {
            //Legend
            
            TextShape legendTitle = new TextShape(653, 125,
                "Hobby Legend");
            TextShape legendTitle1 = new TextShape(653, 140,
                "Read", Color.MAGENTA);
            TextShape legendTitle2 = new TextShape(653, 155,
                "Art", Color.BLUE);
            TextShape legendTitle3 = new TextShape(653, 170,
                "Sports", Color.ORANGE);
            TextShape legendTitle4 = new TextShape(653, 185,
                "Music", Color.GREEN);
            legendTitle.setBackgroundColor(Color.WHITE);
            legendTitle1.setBackgroundColor(Color.WHITE);
            legendTitle2.setBackgroundColor(Color.WHITE);
            legendTitle3.setBackgroundColor(Color.WHITE);
            legendTitle4.setBackgroundColor(Color.WHITE);
            
            window.addShape(legendTitle);
            window.addShape(legendTitle1);
            window.addShape(legendTitle2);
            window.addShape(legendTitle3);
            window.addShape(legendTitle4);
            
            TextShape legendTitle5 = new TextShape(672, 205,
                "Song Title");
            TextShape legendTitle6 = new TextShape(648, 230,
                "Heards");
            Shape legendTitle8 = new Shape(702, 230, 3, 28, Color.BLACK);
            TextShape legendTitle7 = new TextShape(712, 230,
                "Likes");
            legendTitle5.setBackgroundColor(Color.WHITE);
            legendTitle6.setBackgroundColor(Color.WHITE);
            legendTitle7.setBackgroundColor(Color.WHITE);
            
            window.addShape(legendTitle5);
            window.addShape(legendTitle6);
            window.addShape(legendTitle7);
            window.addShape(legendTitle8);
            
            Shape square = new Shape(640, 120, 1, 150, Color.BLACK);
            Shape square2 = new Shape(640, 120, 125, 1, Color.BLACK);
            Shape square3 = new Shape(640, 270, 125, 1, Color.BLACK);
            Shape square4 = new Shape(765, 120, 1, 150, Color.BLACK);
            window.addShape(square);
            window.addShape(square2);
            window.addShape(square3);
            window.addShape(square4);
            
            
            //Glyph
            for (int i = 0; i < songs.size() - page * 9 && i < 9; i++)
                
                
            {
                Song song = songs.get(page * 9 + i);
                //
                int percentHeardsRead = 80 * (song.getHeardsByHobbies()[0] * 100 / Math.max(1 , song.getHobbyHeardsTotal()[0])) / 100;
                int percentHeardsArt = 80 * (song.getHeardsByHobbies()[1] * 100 / Math.max(1 , song.getHobbyHeardsTotal()[1])) / 100;
                int percentHeardsSports = 80 * (song.getHeardsByHobbies()[2] * 100 / Math.max(1 , song.getHobbyHeardsTotal()[2])) / 100;
                int percentHeardsMusic = 80 * (song.getHeardsByHobbies()[3] * 100 / Math.max(1 , song.getHobbyHeardsTotal()[3])) / 100;
                //displacement by likes
                int percentLikesRead = 80 * (song.getLikesByHobbies()[0] * 100 / Math.max(1 , song.getHobbyLikesTotal()[0])) / 100;
                int percentLikesArt = 80 * (song.getLikesByHobbies()[1] * 100 / Math.max(1 , song.getHobbyLikesTotal()[1])) / 100;
                int percentLikesSports = 80 * (song.getLikesByHobbies()[2] * 100 / Math.max(1 , song.getHobbyLikesTotal()[2])) / 100;
                int percentLikesMusic = 80 * (song.getLikesByHobbies()[3] * 100 / Math.max(1 , song.getHobbyLikesTotal()[3])) / 100;
                
                if (i < 3) {
                    Shape shape = new Shape(90 + 230 * i, 35,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    System.out.println(song.getHeardsByHobbies()[0]);
                    System.out.println(song.getHobbyHeardsTotal()[0]);
                    System.out.println(song.getHeardsByHobbies()[0] * 100/ Math.max(1 , song.getHobbyHeardsTotal()[0]) );
                    //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 230 * i, 2, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 230 * i, 16, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    
                    //displacement by heards
                    
                    
                    //glyph
                    Shape songShape1 = new Shape((10 + 230 * i) + (80 - percentHeardsRead), 35, percentHeardsRead, 13,
                        
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * i + (80 - percentHeardsArt), 48, percentHeardsArt, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * i + (80 - percentHeardsSports), 61, percentHeardsSports, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * i + (80 - percentHeardsMusic), 74, percentHeardsMusic, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * i , 35, percentLikesRead, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * i , 48, percentLikesArt, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * i , 61, percentLikesSports, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * i , 74, percentLikesMusic, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                    window.addShape(text1);
                    window.addShape(text2);
                }
                else if (i < 6)
                {
                  //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 220 * (i - 3), 95, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 220 * (i - 3), 109, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    window.addShape(text1);
                    window.addShape(text2);
                    
                    Shape shape = new Shape(90 + 230 * (i - 3), 130,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    
                                    
                    Shape songShape1 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsRead), 130, percentHeardsRead, 13,
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsArt), 143, percentHeardsArt, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsSports), 156, percentHeardsSports, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsMusic), 169, percentHeardsMusic, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * (i - 3), 130, percentLikesRead, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * (i - 3), 143, percentLikesArt, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * (i - 3), 156, percentLikesSports, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * (i - 3), 169, percentLikesMusic, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                }
                else if (i < 9)
                {
                    
                  //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 220 * (i - 6), 192, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 220 * (i - 6), 206, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    window.addShape(text1);
                    window.addShape(text2);
                    
                    Shape shape = new Shape(90 + 230 * (i - 6), 225,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    Shape songShape1 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsRead), 225, percentHeardsRead, 13,
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsArt), 238, percentHeardsArt, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsSports), 251, percentHeardsSports, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsMusic), 264, percentHeardsMusic, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * (i - 6), 225, percentLikesRead, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * (i - 6), 238, percentLikesArt, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * (i - 6), 251, percentLikesSports, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * (i - 6), 264, percentLikesMusic, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                }
            }
        }
        
        if (property == "Major") {
            //Legend
            TextShape legendTitle = new TextShape(653, 125,
                "Major Legend");
            TextShape legendTitle1 = new TextShape(653, 140,
                "Comp Sci", Color.MAGENTA);
            TextShape legendTitle2 = new TextShape(653, 155,
                "Other Eng", Color.BLUE);
            TextShape legendTitle3 = new TextShape(653, 170,
                "Math/CMDA", Color.ORANGE);
            TextShape legendTitle4 = new TextShape(653, 185,
                "Other", Color.GREEN);
            legendTitle.setBackgroundColor(Color.WHITE);
            legendTitle1.setBackgroundColor(Color.WHITE);
            legendTitle2.setBackgroundColor(Color.WHITE);
            legendTitle3.setBackgroundColor(Color.WHITE);
            legendTitle4.setBackgroundColor(Color.WHITE);
            
            window.addShape(legendTitle);
            window.addShape(legendTitle1);
            window.addShape(legendTitle2);
            window.addShape(legendTitle3);
            window.addShape(legendTitle4);
            
            TextShape legendTitle5 = new TextShape(672, 205,
                "Song Title");
            TextShape legendTitle6 = new TextShape(648, 230,
                "Heards");
            Shape legendTitle8 = new Shape(702, 230, 3, 28, Color.BLACK);
            TextShape legendTitle7 = new TextShape(712, 230,
                "Likes");
            legendTitle5.setBackgroundColor(Color.WHITE);
            legendTitle6.setBackgroundColor(Color.WHITE);
            legendTitle7.setBackgroundColor(Color.WHITE);
            
            window.addShape(legendTitle5);
            window.addShape(legendTitle6);
            window.addShape(legendTitle7);
            window.addShape(legendTitle8);
            
            Shape square = new Shape(640, 120, 1, 150, Color.BLACK);
            Shape square2 = new Shape(640, 120, 125, 1, Color.BLACK);
            Shape square3 = new Shape(640, 270, 125, 1, Color.BLACK);
            Shape square4 = new Shape(765, 120, 1, 150, Color.BLACK);
            window.addShape(square);
            window.addShape(square2);
            window.addShape(square3);
            window.addShape(square4);
            
          //Glyph
            for (int i = 0; i < songs.size() - page * 9 && i < 9; i++)
                
                
            {
                Song song = songs.get(page * 9 + i);
                
                
                //displacement by hears
                int percentHeardsCS = 80 * (song.getHeardsByMajors()[0] * 100 / Math.max(1 , song.getMajorsHeardsTotal()[0])) / 100;
                
                int percentHeardsEng = 80 * (song.getHeardsByMajors()[1] * 100 / Math.max(1 , song.getMajorsHeardsTotal()[1])) / 100;
                int percentHeardsMath = 80 * (song.getHeardsByMajors()[2] * 100 / Math.max(1 , song.getMajorsHeardsTotal()[2])) / 100;
                int percentHeardsOther = 80 * (song.getHeardsByMajors()[3] * 100 / Math.max(1 , song.getMajorsHeardsTotal()[3])) / 100;
                //displacement by likes
                
                int percentLikesCS = 80 * (song.getLikesByMajors()[0]  * 100 / Math.max(1 , song.getMajorsLikesTotal()[0])) / 100;
                int percentLikesEng = 80 * (song.getLikesByMajors()[1] * 100 / Math.max(1 , song.getMajorsLikesTotal()[1])) / 100;
                int percentLikesMath = 80 * (song.getLikesByMajors()[2] * 100 / Math.max(1 , song.getMajorsLikesTotal()[2])) / 100;
                int percentLikesOther = 80 * (song.getLikesByMajors()[3] * 100 / Math.max(1 , song.getMajorsLikesTotal()[3])) / 100;
                
                if (i < 3) {
                    Shape shape = new Shape(90 + 230 * i, 35,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 230 * i, 2, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 230 * i, 16, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    
                
                    
                    
                    //glyph
                    Shape songShape1 = new Shape((10 + 230 * i) + (80 - percentHeardsCS), 35, percentHeardsCS, 13,
                        
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * i + (80 - percentHeardsEng), 48, percentHeardsEng, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * i + (80 - percentHeardsMath), 61, percentHeardsMath, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * i + (80 - percentHeardsOther), 74, percentHeardsOther, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * i , 35, percentLikesCS, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * i , 48, percentLikesEng, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * i , 61, percentLikesMath, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * i , 74, percentLikesOther, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                    window.addShape(text1);
                    window.addShape(text2);
                }
                else if (i < 6)
                {
                  //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 220 * (i - 3), 95, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 220 * (i - 3), 109, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    window.addShape(text1);
                    window.addShape(text2);
                    
                    Shape shape = new Shape(90 + 230 * (i - 3), 130,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    
                                    
                    Shape songShape1 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsCS), 130, percentHeardsCS, 13,
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsEng), 143, percentHeardsEng, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsMath), 156, percentHeardsMath, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsOther), 169, percentHeardsOther, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * (i - 3), 130, percentLikesCS, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * (i - 3), 143, percentLikesEng, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * (i - 3), 156, percentLikesMath, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * (i - 3), 169, percentLikesOther, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                }
                else if (i < 9)
                {
                    
                  //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 220 * (i - 6), 192, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 220 * (i - 6), 206, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    window.addShape(text1);
                    window.addShape(text2);
                    
                    Shape shape = new Shape(90 + 230 * (i - 6), 225,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    Shape songShape1 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsCS), 225, percentHeardsCS, 13,
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsEng), 238, percentHeardsEng, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsMath), 251, percentHeardsMath, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsOther), 264, percentHeardsOther, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * (i - 6), 225, percentLikesCS, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * (i - 6), 238, percentLikesEng, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * (i - 6), 251, percentLikesMath, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * (i - 6), 264, percentLikesOther, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                }
            }

        }
        
        if (property == "Region") {
          //Legend
            TextShape legendTitle = new TextShape(653, 125,
                "Region Legend");
            TextShape legendTitle1 = new TextShape(653, 140,
                "Northeast", Color.MAGENTA);
            TextShape legendTitle2 = new TextShape(653, 155,
                "Southeast", Color.BLUE);
            TextShape legendTitle3 = new TextShape(653, 170,
                "United States", Color.ORANGE);
            TextShape legendTitle4 = new TextShape(653, 185,
                "Outside of U.S.", Color.GREEN);
            legendTitle.setBackgroundColor(Color.WHITE);
            legendTitle1.setBackgroundColor(Color.WHITE);
            legendTitle2.setBackgroundColor(Color.WHITE);
            legendTitle3.setBackgroundColor(Color.WHITE);
            legendTitle4.setBackgroundColor(Color.WHITE);
            
            window.addShape(legendTitle);
            window.addShape(legendTitle1);
            window.addShape(legendTitle2);
            window.addShape(legendTitle3);
            window.addShape(legendTitle4);
            
            TextShape legendTitle5 = new TextShape(672, 205,
                "Song Title");
            TextShape legendTitle6 = new TextShape(648, 230,
                "Heards");
            Shape legendTitle8 = new Shape(702, 230, 3, 28, Color.BLACK);
            TextShape legendTitle7 = new TextShape(712, 230,
                "Likes");
            legendTitle5.setBackgroundColor(Color.WHITE);
            legendTitle6.setBackgroundColor(Color.WHITE);
            legendTitle7.setBackgroundColor(Color.WHITE);
            
            window.addShape(legendTitle5);
            window.addShape(legendTitle6);
            window.addShape(legendTitle7);
            window.addShape(legendTitle8);
            
            Shape square = new Shape(640, 120, 1, 150, Color.BLACK);
            Shape square2 = new Shape(640, 120, 125, 1, Color.BLACK);
            Shape square3 = new Shape(640, 270, 125, 1, Color.BLACK);
            Shape square4 = new Shape(765, 120, 1, 150, Color.BLACK);
            window.addShape(square);
            window.addShape(square2);
            window.addShape(square3);
            window.addShape(square4);
        
        //Glyph
            for (int i = 0; i < songs.size() - page * 9 && i < 9; i++)
                
                
            {
                Song song = songs.get(page * 9 + i);
                
                
                //displacement by hears
                int percentHeardsNE = 80 * (song.getHeardsByRegions()[0] * 100 / Math.max(1 , song.getRegionsHeardsTotal()[0])) / 100;
                
                int percentHeardsSE = 80 * (song.getHeardsByRegions()[1] * 100 / Math.max(1 , song.getRegionsHeardsTotal()[1])) / 100;
                int percentHeardsUS = 80 * (song.getHeardsByRegions()[2] * 100 / Math.max(1 , song.getRegionsHeardsTotal()[2])) / 100;
                int percentHeardsOut = 80 * (song.getHeardsByRegions()[3] * 100 / Math.max(1 , song.getRegionsHeardsTotal()[3])) / 100;
                //displacement by likes
                
                int percentLikesNE = 80 * (song.getLikesByRegions()[0] * 100 / Math.max(1 , song.getRegionsLikesTotal()[0])) / 100;
                int percentLikesSE = 80 * (song.getLikesByRegions()[1] * 100 / Math.max(1 , song.getRegionsLikesTotal()[1])) / 100;
                int percentLikesUS = 80 * (song.getLikesByRegions()[2] * 100 / Math.max(1 , song.getRegionsLikesTotal()[2])) / 100;
                int percentLikesOut = 80 * (song.getLikesByRegions()[3] * 100 / Math.max(1 , song.getRegionsLikesTotal()[3])) / 100;
                
                if (i < 3) {
                    Shape shape = new Shape(90 + 230 * i, 35,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 230 * i, 2, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 230 * i, 16, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    
                
                    
                    
                    //glyph
                    Shape songShape1 = new Shape((10 + 230 * i) + (80 - percentHeardsNE), 35, percentHeardsNE, 13,
                        
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * i + (80 - percentHeardsSE), 48, percentHeardsSE, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * i + (80 - percentHeardsUS), 61, percentHeardsUS, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * i + (80 - percentHeardsOut), 74, percentHeardsOut, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * i , 35, percentLikesNE, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * i , 48, percentLikesSE, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * i , 61, percentLikesUS, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * i , 74, percentLikesOut, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                    window.addShape(text1);
                    window.addShape(text2);
                }
                else if (i < 6)
                {
                  //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 220 * (i - 3), 95, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 220 * (i - 3), 109, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    window.addShape(text1);
                    window.addShape(text2);
                    
                    Shape shape = new Shape(90 + 230 * (i - 3), 130,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    
                                    
                    Shape songShape1 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsNE), 130, percentHeardsNE, 13,
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsSE), 143, percentHeardsSE, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsUS), 156, percentHeardsUS, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * (i - 3) + (80 - percentHeardsOut), 169, percentHeardsOut, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * (i - 3), 130, percentLikesNE, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * (i - 3), 143, percentLikesSE, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * (i - 3), 156, percentLikesUS, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * (i - 3), 169, percentLikesOut, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                }
                else if (i < 9)
                {
                    
                  //Title info
                    String info1 = song.getTitle();
                    TextShape text1 = new TextShape(35 + 220 * (i - 6), 192, info1);
                    text1.setBackgroundColor(Color.WHITE);
                    String info2 = "by " + song.getArtists();
                    TextShape text2 = new TextShape(35 + 220 * (i - 6), 206, info2);
                    text2.setBackgroundColor(Color.WHITE);
                    window.addShape(text1);
                    window.addShape(text2);
                    
                    Shape shape = new Shape(90 + 230 * (i - 6), 225,
                        5, 52, Color.BLACK);
                    window.addShape(shape);
                    
                    Shape songShape1 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsNE), 225, percentHeardsNE, 13,
                        Color.MAGENTA);
                    Shape songShape2 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsSE), 238, percentHeardsSE, 13,
                        Color.BLUE);
                    Shape songShape3 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsUS), 251, percentHeardsUS, 13,
                        Color.ORANGE);
                    Shape songShape4 = new Shape(10 + 230 * (i - 6) + (80 - percentHeardsOut), 264, percentHeardsOut, 13,
                        Color.GREEN);
                    Shape songShape5 = new Shape(90 + 230 * (i - 6), 225, percentLikesNE, 13,
                        Color.MAGENTA);
                    Shape songShape6 = new Shape(90 + 230 * (i - 6), 238, percentLikesSE, 13,
                        Color.BLUE);
                    Shape songShape7 = new Shape(90 + 230 * (i - 6), 251, percentLikesUS, 13,
                        Color.ORANGE);
                    Shape songShape8 = new Shape(90 + 230 * (i - 6), 264, percentLikesOut, 13,
                        Color.GREEN);
                    window.addShape(songShape1);
                    window.addShape(songShape2);
                    window.addShape(songShape3);
                    window.addShape(songShape4);
                    window.addShape(songShape5);
                    window.addShape(songShape6);
                    window.addShape(songShape7);
                    window.addShape(songShape8);
                }
            }
        
        
        }
        
        
        
    }
    
    
    /**
     * show all the buttons in the window.
     */
    private void setUpButtons() {
        previous = new Button("Previous");
        window.addButton(previous, WindowSide.NORTH);
        previous.onClick(this, "clickedPrevious");

        artistButton = new Button("Sort by Artist Name");
        window.addButton(artistButton, WindowSide.NORTH);
        artistButton.onClick(this, "clickedArtist");

        titleButton = new Button("Sort by Title");
        window.addButton(titleButton, WindowSide.NORTH);
        titleButton.onClick(this, "clickedTitle");

        yearButton = new Button("Sort by Release Year");
        window.addButton(yearButton, WindowSide.NORTH);
        yearButton.onClick(this, "clickedYear");

        genreButton = new Button("Sort by Genre");
        window.addButton(genreButton, WindowSide.NORTH);
        genreButton.onClick(this, "clickedGenre");

        next = new Button("Next");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

        hobbyButton = new Button("Represent Hobby");
        window.addButton(hobbyButton, WindowSide.SOUTH);
        hobbyButton.onClick(this, "clickedHobby");

        majorButton = new Button("Represent Major");
        window.addButton(majorButton, WindowSide.SOUTH);
        majorButton.onClick(this, "clickedMajor");

        regionButton = new Button("Represent Region");
        window.addButton(regionButton, WindowSide.SOUTH);
        regionButton.onClick(this, "clickedRegion");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");
    }
    
    


    /**
     * quit the window
     * 
     * @param quit
     *            the quit button
     * 
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }
    
    
    
    
    /**
     * the method defines the function of the next Button
     * @param next Button
     */
    public void clickedNext(Button next) {
        if (page < numOfPage) {
            page++;
            previous.enable();
            window.removeAllShapes();
            ini();
        }
        
        if (page == numOfPage - 1) {
            next.disable();
        }
        

    }
    
    /**
     * The method defines the function of previous Button
     * @param previous Button
     */
    public void clickedPrevious(Button previous) {
        if (page > 0) {
            page--;
            next.enable();
        }
        if (page == 0) {
            previous.disable();
        }
        window.removeAllShapes();
        ini();

    }
    
    public void clickedTitle(Button button)
    {
        window.removeAllShapes();
        sort("title", songs); 
        ini(); 
    }
    
    public void clickedArtist(Button button)
    {
        window.removeAllShapes();
        sort("name", songs); 
        ini(); 
        
        
                
    }
    public void clickedGenre(Button button)
    {
        window.removeAllShapes();
        sort("genre", songs); 
        ini(); 
                
    }
    public void clickedYear(Button button)
    {
        window.removeAllShapes();
        sort("year", songs); 
        ini(); 
                
    }
    public void clickedHobby(Button button)
    {
        window.removeAllShapes();
        property = "Hobby";
        
        
        
        next.disable();
        previous.disable();
        display();
        
        numOfPage = songs.size() / 9;
        if (songs.size() % 9 > 0) {
            numOfPage++;
        }
        if (numOfPage > 1)
        {
            next.enable();
        }
                
    }
    public void clickedMajor(Button button)
    {
        window.removeAllShapes();
        property = "Major";
        
        
        
        
        next.disable();
        previous.disable();
        display();
        
        numOfPage = songs.size() / 9;
        if (songs.size() % 9 > 0) {
            numOfPage++;
        }
        if (numOfPage > 1)
        {
            next.enable();
        }
    }
    public void clickedRegion(Button button)
    {
        window.removeAllShapes();
        property = "Region";
        
       
        next.disable();
        previous.disable();
        display();
        
        numOfPage = songs.size() / 9;
        if (songs.size() % 9 > 0) {
            numOfPage++;
        }
        if (numOfPage > 1)
        {
            next.enable();
        }
    }
    
}
