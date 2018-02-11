
package vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tanechka Khotynyuk
 */
public class VectorTest {
    
    public VectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of plus method, of class Vector.
     */
    @Test
    public void testPlus() {
        try {
            double arr[] = {1, 2, 3};
            Vector v2 = new Vector(arr);
            Vector v1 = new Vector(arr);
            double res_arr[] = {2, 4, 6};
            Vector expResult = new Vector(res_arr);
            Vector result = v1.plus(v2);
            assertEquals(expResult.equals(result), true);
        } catch (ArrayException ex) {
            System.out.println(ex.getMessage());
            assertFalse(null, true);
        }
    }

    /**
     * Test of minus method, of class Vector.
     */
    @Test
    public void testMinus() {
        try {
            double arr[] = {1, 2, 3};
            Vector v2 = new Vector(arr);
            Vector v1 = new Vector(arr);
            double res_arr[] = {0, 0, 0};
            Vector expResult = new Vector(res_arr);
            
            Vector result = v1.minus(v2);
            assertEquals(expResult.equals(result), true);
        } catch (ArrayException ex) {
            System.out.println(ex.getMessage());
            assertFalse(null, true);
        }
    }

    /**
     * Test of times method, of class Vector.
     */
    @Test
    public void testTimes() {
        try {
            double arr[] = {1, 2, 3};
            int c = 3;
            Vector v1 = new Vector(arr);
            double res_arr[] = {3, 6, 9};
            Vector expResult = new Vector(res_arr);
            Vector result = v1.times(c);
            assertEquals(expResult.equals(result), true);
        } catch (ArrayException ex) {
           System.out.println(ex.getMessage());
            assertFalse(null, true);
        }
    }

    /**
     * Test of skaltimes method, of class Vector.
     */
    @Test
    public void testSkaltimes() {
        try {
            double arr[] = {1, 2, 3};
            Vector v2 = new Vector(arr);
            Vector v1 = new Vector(arr);
            int expResult = 14;
            int result = v1.skaltimes(v2);
            assertEquals(expResult, result);
        } catch (ArrayException ex) {
            System.out.println(ex.getMessage());
            assertFalse(null, true);
        }
    }

    /**
     * Test of vecttimes method, of class Vector.
     */
    @Test
    public void testVecttimes() {
        try {
            double arr[] = {0, 0, 0};
            Vector v2 = new Vector(arr);
            Vector v1 = new Vector(arr);
            Vector expResult = new Vector(arr);
            Vector result = v1.vecttimes(v2);
            assertEquals(expResult.equals(result), true);
        } catch (ArrayException ex) {
            System.out.println(ex.getMessage());
            assertFalse(null, true);
        }
    }

    /**
     * Test of module method, of class Vector.
     */
    @Test
    public void testModule() {
        try {
            double arr[] = {2, 2, 1};
            Vector v = new Vector(arr);
            double expResult = 3.0;
            double result = v.module();
            assertEquals(expResult, result, 0.0);
        } catch (ArrayException ex) {
            System.out.println(ex.getMessage());
            assertFalse(null, true);
        }
    }
    
}
