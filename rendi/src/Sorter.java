import java.util.ArrayList;

public class Sorter {
    public void quicksort(ArrayList<Integer> list, int lo, int hi) {
        if(lo < hi) {
            int p = partition(list, lo, hi);
            quicksort(list, lo, p-1);
            quicksort(list, p+1, hi);
        }
    }

    //Gyors rendezés
    private int partition(ArrayList<Integer> list, int lo, int hi) {
        int pivot = list.get(hi);
        int i = lo -1;
        for (int j = lo; j < hi; j++) {
            if(list.get(j)<= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i+1, hi);
        return i + 1;
    }
    
    private void swap(ArrayList<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    // Buborék rendezés
    public void bubble(ArrayList<Integer> list) {
        int n = list.size();
        for(int i= n-1; i>0; i--)
			for(int j=0; j<i; j++)
				if(list.get(j) > list.get(j+1))
				{
					int tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
    }
}