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


    /**
     * The toString method for Song class
     * 
     * @return String the info of the Song
     */
    @Override
    public String toString() {
        return "Song Title: " + title + "\n" + "Song Artist: " + artists + "\n"
            + "Song Genre: " + genre + "\n" + "Song Year: " + date + "\n"
            + "Heard" + "\n" + "reading" + hobbiesHeards[0] * 100 / Math.max(1,
                hobbiesHeardsTotal[0]) + " " + "art" + hobbiesHeards[1] * 100
                    / Math.max(1, hobbiesHeardsTotal[1]) + " " + "sports"
            + hobbiesHeards[2] * 100 / Math.max(1, hobbiesHeardsTotal[2]) + " "
            + "music" + hobbiesHeards[3] * 100 / Math.max(1,
                hobbiesHeardsTotal[3]) + " " + "\n" + "Likes" + "\n" + ""
            + "reading" + hobbiesLikes[0] * 100 / Math.max(1,
                hobbiesLikesTotal[0]) + " " + "art" + hobbiesLikes[1] * 100
                    / Math.max(1, hobbiesLikesTotal[1]) + " " + "sports"
            + hobbiesLikes[2] * 100 / Math.max(1, hobbiesLikesTotal[2]) + " "
            + "music" + hobbiesLikes[3] * 100 / Math.max(1,
                hobbiesLikesTotal[3]) + "\n" + "\n";
    }


    /**
     * do calc
     * 
     * @param pp
     *            the person
     */
    public void addToHeards(Person pp) {
        if (pp.getHobby().equals("reading")) {
            hobbiesHeards[0]++;
        }
        else if (pp.getHobby().equals("art")) {
            hobbiesHeards[1]++;
        }
        else if (pp.getHobby().equals("sports")) {
            hobbiesHeards[2]++;
        }
        else if (pp.getHobby().equals("music")) {
            hobbiesHeards[3]++;
        }

        if (pp.getMajor().equals("Computer Science")) {
            majorsHeards[0]++;
        }
        else if (pp.getMajor().equals("Other Engineering")) {
            majorsHeards[1]++;
        }
        else if (pp.getMajor().equals("Math or CMDA")) {
            majorsHeards[2]++;
        }
        else if (pp.getMajor().equals("Other")) {
            majorsHeards[3]++;
        }

        if (pp.getRegion().equals("Northeast")) {
            regionsHeards[0]++;
        }
        else if (pp.getRegion().equals("Southeast")) {
            regionsHeards[1]++;
        }
        else if (pp.getRegion().contains(
            "United States (other than Southeast or Northwest)")) {
            regionsHeards[2]++;
        }
        else if (pp.getRegion().contains("Outside of United States")) {
            regionsHeards[3]++;
        }

    }


    /**
     * do calc
     * 
     * @param pp
     *            the person
     */
    public void addToLikes(Person pp) {
        if (pp.getHobby().equals("reading")) {
            hobbiesLikes[0]++;
        }
        else if (pp.getHobby().equals("art")) {
            hobbiesLikes[1]++;
        }
        else if (pp.getHobby().equals("sports")) {
            hobbiesLikes[2]++;
        }
        else if (pp.getHobby().equals("music")) {
            hobbiesLikes[3]++;
        }

        if (pp.getMajor().equals("Computer Science")) {
            majorsLikes[0]++;
        }
        else if (pp.getMajor().equals("Other Engineering")) {
            majorsLikes[1]++;
        }
        else if (pp.getMajor().equals("Math or CMDA")) {
            majorsLikes[2]++;
        }
        else if (pp.getMajor().equals("Other")) {
            majorsLikes[3]++;
        }

        if (pp.getRegion().equals("Northeast")) {
            regionsLikes[0]++;
        }
        else if (pp.getRegion().equals("Southeast")) {
            regionsLikes[1]++;
        }
        else if (pp.getRegion().contains(
            "United States (other than Southeast or Northwest)")) {
            regionsLikes[2]++;
        }
        else if (pp.getRegion().contains("Outside of United States")) {
            regionsLikes[3]++;
        }

    }


    /**
     * do calc
     * 
     * @param pp
     *            the person
     */
    public void addHeardTotals(Person pp) {
        if (pp.getHobby().equals("reading")) {
            hobbiesHeardsTotal[0]++;
        }
        else if (pp.getHobby().equals("art")) {
            hobbiesHeardsTotal[1]++;
        }
        else if (pp.getHobby().equals("sports")) {
            hobbiesHeardsTotal[2]++;
        }
        else if (pp.getHobby().equals("music")) {
            hobbiesHeardsTotal[3]++;
        }

        if (pp.getMajor().equals("Computer Science")) {
            majorsHeardsTotal[0]++;
        }
        else if (pp.getMajor().equals("Other Engineering")) {
            majorsHeardsTotal[1]++;
        }
        else if (pp.getMajor().equals("Math or CMDA")) {
            majorsHeardsTotal[2]++;
        }
        else if (pp.getMajor().equals("Other")) {
            majorsHeardsTotal[3]++;
        }

        if (pp.getRegion().equals("Northeast")) {
            regionsHeardsTotal[0]++;
        }
        else if (pp.getRegion().equals("Southeast")) {
            regionsHeardsTotal[1]++;
        }
        else if (pp.getRegion().contains(
            "United States (other than Southeast or Northwest)")) {
            regionsHeardsTotal[2]++;
        }
        else if (pp.getRegion().contains("Outside of United States")) {
            regionsHeardsTotal[3]++;
        }

    }


    /**
     * do calc
     * 
     * @param pp
     *            the person
     */
    public void addLikeTotals(Person pp) {
        if (pp.getHobby().equals("reading")) {
            hobbiesLikesTotal[0]++;
        }
        else if (pp.getHobby().equals("art")) {
            hobbiesLikesTotal[1]++;
        }
        else if (pp.getHobby().equals("sports")) {
            hobbiesLikesTotal[2]++;
        }
        else if (pp.getHobby().equals("music")) {
            hobbiesLikesTotal[3]++;
        }

        if (pp.getMajor().equals("Computer Science")) {
            majorsLikesTotal[0]++;
        }
        else if (pp.getMajor().equals("Other Engineering")) {
            majorsLikesTotal[1]++;
        }
        else if (pp.getMajor().equals("Math or CMDA")) {
            majorsLikesTotal[2]++;
        }
        else if (pp.getMajor().equals("Other")) {
            majorsLikesTotal[3]++;
        }

        if (pp.getRegion().equals("Northeast")) {
            regionsLikesTotal[0]++;
        }
        else if (pp.getRegion().equals("Southeast")) {
            regionsLikesTotal[1]++;
        }
        else if (pp.getRegion().contains(
            "United States (other than Southeast or Northwest)")) {
            regionsLikesTotal[2]++;
        }
        else if (pp.getRegion().contains("Outside of United States")) {
            regionsLikesTotal[3]++;
        }

    }

}
