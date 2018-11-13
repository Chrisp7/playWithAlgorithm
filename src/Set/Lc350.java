package Set;
import java.util.*;

/**
 * Created by CP on 12/11/2018.
 */
public class Lc350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>(nums1.length);
        for(int item:nums1){
            if(map.get(item)!=null)
                map.put(item,map.get(item)+1);
            else
                map.put(item,1);
        }
        for(int item2:nums2){
            if(map.get(item2)!=null){
                if(map.get(item2)>0){
                    list.add(item2);
                    map.put(item2,map.get(item2)-1);
                }
            }

        }
        int[] res=new int[list.size()];
        int j=0;
        for(Integer i:list)
            res[j++]=i;
        return res;
    }
}
