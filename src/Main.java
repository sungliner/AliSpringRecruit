import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int k=scanner.nextInt();
        List List=new ArrayList<Integer>();
        for (int i=0;i<n;i++){
            List.add(scanner.nextInt());
        }
        System.out.println( checkNum(n,m,k,List));
    }
    public static int checkNum(int n, int m, int k, List<Integer> List){

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                List.set(j,List.get(j)+k);
            }
            Collections.sort(List, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            int max=List.get(0);
            List.set(0,max/2);
        }
        int v=0;
        for (Integer integer : List) {
            v+=integer;

        }
        return v;
    }
}
