package prj5;

/**
 * person class that uses 4 parameters to initialize
 * the information of the person
 * 
 * @author Group24
 *         Haisheng Xu (haisheng),
 *         Zhengyu Liu (samueliu14),
 *         Xiao Guo (kevinguo2003)
 * @version 11.17.2019
 *
 */
public class Person {
    private String region;
    private String major;
    private String hobby;
    private String record;


    /**
     * default constructor that takes 3 parameters to initialize
     * the fields of the person
     * 
     * @param major
     *            input the major
     * @param hobby
     *            input the hobby
     * @param region
     *            input the region
     */
    public Person(String major, String region, String hobby) {
        this.region = region;
        this.major = major;
        this.hobby = hobby;

    }


    /**
     * a getter for hobby
     * 
     * @return the hobby of the person
     */
    public String getHobby() {
        return hobby;
    }


    /**
     * a getter for major
     * 
     * @return the major of the person
     */
    public String getMajor() {
        return major;
    }


    /**
     * a getter for region
     * 
     * @return the region of the person
     */
    public String getRegion() {
        return region;
    }


    /**
     * a getter for record
     * 
     * @return the record of the person
     */
    public String getRecord() {
        return record;
    }


    /**
     * return a string version of basic information of the
     * person
     * @return the string version
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(hobby + " " + major + " " + region);
        return sb.toString();
    }


    /**
     * equals only when all the fileds are the same
     * 
     * @return whether two person are all the same
     * @param obj
     *            the comparing object
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass().equals(obj.getClass())) {
            Person otherPP = (Person)obj;
            if (this.hobby.equals(otherPP.getHobby())) {
                if (this.major == otherPP.getMajor()) {
                    return this.region == otherPP.getRegion();
                }
            }

        }

        return false;
    }

}
