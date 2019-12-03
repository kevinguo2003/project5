/**
 * 
 */
package prj5;

/**
 * Song class
 * 
 * @author Group24
 *         Haisheng Xu (haisheng),
 *         Zhengyu Liu (samueliu14),
 *         Xiao Guo (kevinguo2003)
 * @version 11.17.2019
 *
 */
public class Song {
    private String artists;
    private String title;
    private String genre;
    private String date;

    private int[] hobbiesHeardsTotal;
    private int[] hobbiesLikesTotal;
    private int[] majorsHeardsTotal;
    private int[] majorsLikesTotal;
    private int[] regionsHeardsTotal;
    private int[] regionsLikesTotal;

    /**
     * two fields that store the statics
     */
    LinkedList<Person> heards;
    /**
     * two fields that store the statics
     */
    LinkedList<Person> likes;

    private int[] hobbiesHeards;
    private int[] regionsHeards;
    private int[] majorsHeards;
    private int[] hobbiesLikes;
    private int[] regionsLikes;
    private int[] majorsLikes;


    /**
     * The constructor of the Song
     * 
     * @param songTitle
     *            The title of the song
     * @param name
     *            The name of the artists
     * @param year
     *            The release date of the song
     * @param type
     *            The genre of the song
     */
    public Song(String songTitle, String name, String year, String type) {
        title = songTitle;
        artists = name;
        date = year;
        genre = type;

        hobbiesHeardsTotal = new int[4];
        hobbiesLikesTotal = new int[4];
        majorsHeardsTotal = new int[4];
        majorsLikesTotal = new int[4];
        regionsHeardsTotal = new int[4];
        regionsLikesTotal = new int[4];

        likes = new LinkedList<Person>();
        heards = new LinkedList<Person>();

        hobbiesHeards = new int[4];
        regionsHeards = new int[4];
        majorsHeards = new int[4];

        hobbiesLikes = new int[4];
        regionsLikes = new int[4];
        majorsLikes = new int[4];

        for (int i = 0; i < 4; i++) {
            hobbiesHeards[i] = 0;
            regionsHeards[i] = 0;
            majorsHeards[i] = 0;
            hobbiesLikes[i] = 0;
            regionsLikes[i] = 0;
            majorsLikes[i] = 0;
            hobbiesLikesTotal[i] = 0;
            hobbiesHeardsTotal[i] = 0;
            majorsHeardsTotal[i] = 0;
            majorsLikesTotal[i] = 0;
            regionsHeardsTotal[i] = 0;
            regionsLikesTotal[i] = 0;
        }
    }


    /**
     * The get method for getting the artists
     * 
     * @return the artist names in String
     * 
     *         public String getArtists() {
     *         return artists;
     *         }
     */

    /**
     * The get method for getting the title of the Song
     * 
     * @return the title of the Song
     */
    public String getTitle() {
        return title;
    }


    /**
     * The get method for getting the genre of the Song
     * 
     * @return the genre of the Song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * The get method for getting the releasing
     * date of the Song
     * 
     * @return the releasing date of the Song
     */
    public String getDate() {
        return date;
    }


    /**
     * The get method for getting the artists
     * 
     * @return the artists of the Song
     */
    public String getArtists() {
        return artists;
    }


    /**
     * getter
     * 
     * @return person's list
     */
    public LinkedList<Person> getHeards() {
        return heards;
    }


    /**
     * getter
     * 
     * @return person;s list
     */
    public LinkedList<Person> getLikes() {
        return likes;
    }


    /**
     * getter
     * 
     * @return hobbies count
     */
    public int[] getHeardsByHobbies() {
        return hobbiesHeards;
    }


    /**
     * getter
     * 
     * @return majors count
     */
    public int[] getHeardsByMajors() {
        return majorsHeards;
    }


    /**
     * getter
     * 
     * @return regions count
     */
    public int[] getHeardsByRegions() {
        return regionsHeards;
    }


    /**
     * getter
     * 
     * @return hobbies count
     */
    public int[] getLikesByHobbies() {
        return hobbiesLikes;
    }


    /**
     * getter
     * 
     * @return majors count
     */
    public int[] getLikesByMajors() {
        return majorsLikes;
    }


    /**
     * getter
     * 
     * @return regions count
     */
    public int[] getLikesByRegions() {
        return regionsLikes;
    }


    /**
     * The getter method for get total number of hears in hobbies
     * 
     * @return total hears by hobbies
     */
    public int[] getHobbyHeardsTotal() {
        return hobbiesHeardsTotal;
    }


    /**
     * The getter method for get total number of hears in hobbies
     * 
     * @return total likes by hobbies
     */
    public int[] getHobbyLikesTotal() {
        return hobbiesLikesTotal;
    }


    /**
     * getter for total majors likes
     * 
     * @return the count for total major likes
     */
    public int[] getMajorsLikesTotal() {
        return majorsLikesTotal;
    }


    /**
     * getter for total regions likes
     * 
     * @return the count for total region likes
     */
    public int[] getRegionsLikesTotal() {
        return regionsLikesTotal;
    }


    /**
     * getter for total majors hears
     * 
     * @return the count for total major hears
     */
    public int[] getMajorsHeardsTotal() {
        return majorsHeardsTotal;
    }


    /**
     * getter for total regions hears
     * 
     * @return the count for total region hears
     */
    public int[] getRegionsHeardsTotal() {
        return regionsHeardsTotal;
    }




}
