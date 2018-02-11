package vector;

import java.util.Arrays;

/**
* @author Tanechka Khotynyuk
* @version 0.1
*/

/**
* Implementation of 3-dimensional vector
*/
public class Vector
{        
    private final double[]arr; 

    
    public Vector()
    {
        arr = new double[3];
    }

    /**
     * @param arr
     * @throws vector.ArrayException
     */
    public Vector(double[] arr) throws ArrayException
    {
        if (arr.length > 3) {
            throw new ArrayException("The dimension of array is greater than 3.");
        }
        this.arr = new double[3];
        System.arraycopy(arr, 0, this.arr, 0, 3);
    }

    /**
    * @param A
    */
    private Vector(Vector A) { 
        arr = A.getArray();
    }

       
   /**
    * @return new vector with random coordinates.
    */
    public static Vector random()
    {
        Vector res = new Vector( );
        for (int i = 0; i < 3 ; i++)
            res.arr[i] =((int)(10* Math.random()));
        return res;
    }
 
    /**
     * @param i
     * @param j 
     */
    public void swap(int i, int j)
    {
        double t = arr[i-1];
        arr[i-1] = arr[j-1];
        arr[j-1] = t;
    }
 
    /**
    * @param v2
    * @return initial vector plus given vector
    */
    public Vector plus(Vector v2)
    {
        Vector v1 = this;
        Vector res = new Vector();
        for (int i = 0; i < 3; i++)
           res.arr[i] = v1.arr[i] + v2.arr[i];
        return res;
    }

    /**
    * @param v2
    * @return initial vector minus given vector
    */
    public Vector minus(Vector v2)
    {
        Vector v1 = this;
        Vector res = new Vector();
        for (int i = 0; i < 3; i++)
            res.arr[i] = v1.arr[i] - v2.arr[i];
        return res;
    }
     
    /**
     * @param c 
     * @return product of initial vector by given vector
     */
    public Vector times(int c)
    {
        Vector v1 = this;
        Vector res = new Vector();
        for (int i = 0; i < 3; i++)
             res.arr[i] = v1.arr[i] * c;
        return res;
    }
    
    /**
    * @param v2
    * @return skalene product of initial vector and given vector
    */
    public int skaltimes(Vector v2)
    {
        Vector v1 = this;
        int res=0;
        for (int i = 0; i < 3; i++)
             res += (v1.arr[i] * v2.arr[i]);
        return res;
    }
    
   /**
     * @param v2
     * @return vector product of initial vector and given vector
     */
     public Vector vecttimes( Vector v2 )
    {
        Vector v1 = this;
        Vector res = new Vector();
        res.arr[0] = (v1.arr[1] * v2.arr[2]-v1.arr[2] * v2.arr[1]);
        res.arr[1] = (v1.arr[2] * v2.arr[0]-v1.arr[0] * v2.arr[2]);
        res.arr[2] = (v1.arr[0] * v2.arr[1]-v1.arr[1] * v2.arr[0]);
        return res;
    }
    
    /**
     * @return length of the initial vector
     */
    public double module( )
    {
        return Math.sqrt(skaltimes(this));
    }
    
    
    public String output()
    {
        String result = new String();
        for (int i = 0; i < 3; i++)
            result = result + Double.toString(arr[i])+ ' ';
        return result;
    }
    
    public double[] getArray() {
        return arr;
    } 
    
    /**
     * @param other
     * @return true - if equals, else - false
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Vector other_vec = (Vector)other;
        double[] other_arr = other_vec.getArray();
        for (int i = 0; i < 3; i++) {
            if (other_arr[i] != arr[i]) 
                return false;
        }
        return true;
    }

    /**
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Arrays.hashCode(this.arr);
        return hash;
    }
     
}