import java.util.List;

public class Sort {
    public static void quickSort(List<String> arr) {
        if (arr == null || arr.isEmpty()) {
            return;
        }
        quickSort(arr, 0, arr.size() - 1);
    }

    private static void quickSort(List<String> list, int start, int end) {
        if (start < end) {
            int pi = partition(list, start, end);
            quickSort(list, start, pi - 1);
            quickSort(list, pi + 1, end);

        }
    }

    public static int partition(List<String> list, int start, int end) {
        String pivot = list.get(end);
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, end);

        return i + 1;
    }

    public static void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void insertionSort(List<Team> list) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Team team = list.get(i);
            Double key = team.getOverallScore();
            int j = i - 1;
    

            while (j >= 0 && list.get(j).getOverallScore().compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;

            }
    
            list.set(j + 1, team);
            
        }
        
    }
    

}
