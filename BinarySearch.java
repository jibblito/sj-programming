public class BinarySearch {

    public static void main(String[] args) {

        int[] test = {0, 5, 22, 33, 55, 77, 100, 101, 123, 180, 203};
        int a = indexOf(test,5);
        System.out.print("" + a);

    }

    public static int indexOf(int[] array, int search) {

        int low = 0;
        int high = array.length - 1;
        boolean finished = false;
        int index = 0;

        while(!finished) {

            int mid = (low + high) / 2;

            if(search == array[mid]) {
                index = mid;
                finished = true;
            } else if (search < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            System.out.println(mid);
        }
        return index;
    }
}
