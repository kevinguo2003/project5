package prj5;

/**
 * the test case for person class
 * 
 * @author Group24
 *         Haisheng Xu (haisheng),
 *         Zhengyu Liu (samueliu14),
 *         Xiao Guo (kevinguo2003)
 * @version 11.17.2019
 *
 */
public class PersonTest extends student.TestCase {

    private Person pp1;
    private Person pp2;


    /**
     * set up the test class by initialize two general person
     */
    public void setUp() {
        pp1 = new Person("RD", "CS", "NY");
        pp2 = new Person("RD", "ISE", "NY");
    }


    /**
     * test if toString() returns the right string
     */
    public void testToString() {
        assertEquals("NY RD CS", pp1.toString());
    }


    /**
     * test the getter for record
     */
    public void testGetRecord() {
        assertNull(pp1.getRecord());
    }


    /**
     * test equals in different situation
     */
    public void testEquals() {
        Object objNull = null;
        Person pp3 = new Person("HK", "CS", "NY");
        Person pp4 = new Person("RD", "CS", "SH");
        Person pp5 = new Person("RD", "CS", "NY");
        assertFalse(pp1.equals(pp2));
        assertFalse(pp1.equals(objNull));
        assertTrue(pp1.equals(pp1));
        assertFalse(pp1.equals(pp3));
        assertFalse(pp1.equals(pp4));
        assertTrue(pp1.equals(pp5));
        int notSameClass = 5;
        assertFalse(pp1.equals(notSameClass));

    }

}
