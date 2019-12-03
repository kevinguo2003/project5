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
        window = new Window("Project 5");
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
