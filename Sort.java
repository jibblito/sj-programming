public class Sort {

    public static void main(String[] args) {

        int[] boop = {7,6,5,4,3,2,1};
        int[] boop2 = blankSort(boop);
        for(int i : boop2) System.out.println(i);

    }

    static int[] blankSort(int[] ar) {

        for(int i = 0; i < ar.length; i++) {

            int j = i; int index = ar[i];

            while (j < ar.length - 2 && ar[j] > ar[j + 1]) {

                ar[j] = ar[j + 1];
                ar[j + 1] = index;
                j++;

            }

        //    if(ar[j] < ar[j+1]) index = ar[j + 1];

        }

       return ar;

    }

}
