package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * a main input class
 * 
 * @author Group24
 *         Haisheng Xu (haisheng),
 *         Zhengyu Liu (samueliu14),
 *         Xiao Guo (kevinguo2003)
 * @version 11.17.2019
 *
 */
public class Input {

    private LinkedList<Song> songList;


    /**
     * main constructor that handles most of the outputs
     * 
     * @param surveyFile
     *            the file name for survey
     * @param musicFile
     *            the file name for song list
     * @throws FileNotFoundException
     */
    public Input(String surveyFile, String musicFile)
        throws FileNotFoundException {
        songList = readSongFile(musicFile);
        LinkedList<Person> peopleList = readPersonFile(surveyFile);
        
        new GUIGlyph(songList, peopleList);

    }
    
    
    
    


    /**
     * read the song file
     * 
     * @param fileName
     *            the given file name
     * @return a list of songs
     * @throws FileNotFoundException
     *             when the file is not found
     */
    private LinkedList<Song> readSongFile(String fileName)
        throws FileNotFoundException {
        LinkedList<Song> songs = new LinkedList<Song>();
        File fileNew = new File(fileName);
        @SuppressWarnings("resource")
        Scanner file = new Scanner(fileNew);
        file.nextLine();
        while (file.hasNextLine()) {
            String songInfo = file.nextLine();
            String[] info = songInfo.split(",");
            Song song = new Song(info[0], info[1], info[2], info[3]);
            songs.add(song);
        }

        return songs;
    }


    /**
     * read person;s file, handle the data addition
     * 
     * @param personData
     *            the filename for survey
     * @return the list of persons
     * @throws FileNotFoundException
     *             when the file can not be found
     */
    private LinkedList<Person> readPersonFile(String personData)
        throws FileNotFoundException {

        LinkedList<Person> people = new LinkedList<Person>();

        Scanner file = new Scanner(new File(personData));
        file.nextLine();

        while (file.hasNextLine()) {
            String personInfo = file.nextLine();
            String[] str = personInfo.split(",");
            Song currSong;
            if (str.length > 5) {
                if (str[2] != null || str[3] != null || str[4] != null) {
                    Person pp = new Person(str[2], str[3], str[4]);
                    people.add(pp);
                    Iterator<Song> iter = songList.iterator();
                    currSong = iter.next();
                    for (int i = 5; i < str.length; i++) {
                        currSong = iter.next();
                        if (i < str.length && str[i].equals("Yes")) {
                            currSong.addToHeards(pp);
                            currSong.addHeardTotals(pp);
                        }
                        else if ((i < str.length) && (str[i].equals("No")
                            || str[i].equals(""))) {
                            currSong.addHeardTotals(pp);//add to total counts
                        }
                        i++;
                        if (i < str.length && str[i].equals("Yes")) {
                            currSong.addToLikes(pp);
                            currSong.addLikeTotals(pp);

                        }
                        else if ((i < str.length) && (str[i].equals("No")
                            || str[i].equals(""))) {
                            currSong.addLikeTotals(pp);//total counts used for calculate percentage

                        }

                    }
                }
            }
        }

        file.close();
        return people;
    }


    /**
     * the main method which passes the parameter to constructor
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 2) {
            new Input(args[0], args[1]);//takes two filename
        }
        else {
            //hard coded for final submission
            new Input("MusicSurveyData2019F.csv", "SongList2019F.csv");

        }
    }

}
