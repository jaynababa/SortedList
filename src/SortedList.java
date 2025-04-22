import java.util.ArrayList;

public class SortedList {
    ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    private int InsertIndex(String value) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = value.compareTo(list.get(mid));
            if (cmp == 0) return mid;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public void add(String value) {
        int index = InsertIndex(value);
        list.add(index, value);
    }

    public int binarySearch(String value) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = value.compareTo(list.get(mid));
            if (cmp == 0) return mid;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -low - 1;
    }

    public ArrayList<String> getList() {
        return list;
    }
}

