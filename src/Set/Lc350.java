package Set;
import java.util.*;

/**
 * Created by CP on 12/11/2018.
 */
public class Lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>(nums1.length);
        for(int i:nums1){
            if(map.get(i)!=null) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for(int j:nums2){
            if(map.get(j)!=null){
                list.add(j);
                map.put(j,map.get(j)-1);
                if(map.get(j)==0) map.remove(j);
            }
        }
        int[] arr=new int[list.size()];
        int k=0;
        for(Integer i:list){
            arr[k++]=i;
        }
        return arr;
    }
}
