package prj5;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

/**
 * The class for testing the song and the person
 * classes
 * 
 * @author Group24
 *         Haisheng Xu (haisheng),
 *         Zhengyu Liu (samueliu14),
 *         Xiao Guo (kevinguo2003)
 * @version 11.18.2019
 *
 */
public class Project5Test {

    /**
     * The method for testing the whole song class
     * 
     * @throws FileNotFoundException
     */
    @Test
    public void testSong() throws FileNotFoundException {
        Song song = new Song("title", "artists", "1999", "pop");
        // Song song2 = new Song("title", "artists", "1999", "pop");
        Person person = new Person("Other", "Southest", "music");
        song.addHeardTotals(person);
        song.addToLikes(person);
        song.getDate();
        song.getGenre();
        song.getHeards();
        song.getHeardsByHobbies();
        song.getHeardsByMajors();
        song.getHeardsByRegions();
        song.getLikes();
        song.getLikesByHobbies();
        song.getLikesByMajors();
        song.getLikesByRegions();
        assertEquals(song.getTitle(), "title");

        song.toString();

        assertEquals(song.getTitle(), "title");
        Input.main(new String[] { "Book1.csv", "SongList2018Intro.csv" });

    }


    /**
     * test for the whole Person class
     */
    public void testPerson() {
        Person person = new Person("Other", "Southest", "music");
        person.getHobby();
        person.getMajor();
        person.getRecord();
        Object objNull = null;
        assertFalse(person.equals(objNull));
        assertTrue(person.equals(person));
        Person person2 = new Person("Other", "Southest", "music");
        assertTrue(person.equals(person2));
        assertFalse(person.equals(new Person("Other", "Southest", "musi")));
        assertEquals(person.getRegion(), "Southest");
    }

}
