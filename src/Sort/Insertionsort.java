package Sort;

/**
 *
 * @author elie
 */
public class Insertionsort extends AbstractSort{
     /**
     * Method which sorts an arbitrary array of objects
     */
    public static void sort(Comparable[] array){
        int len = array.length;
        // iterate through to each item and float back until in correct place
        for(int i = 1; i < len; i++){
            int j = i;
            while(j > 0 && less(array[j], array[j-1])){
                exch(array, j, j-1);
                j--;
            }
        }
    }
}
