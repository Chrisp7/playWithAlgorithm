package Array;

/**
 * Created by CP on 11/11/2018.
 */
public class Lc88 {
    public int[] copy(int[] nums,int m){
        int[] res=new int[m];
        for(int i=0;i<m;i++)
            res[i]=nums[i];
        return res;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp=copy(nums1,m);
        int n1=0;
        int n2=0;
        for(int i=0;i<m+n;i++){
            if(n1>m-1)
                nums1[i]=nums2[n2++];
            else if(n2>n-1)
                nums1[i]=temp[n1++];
            else{
                if(temp[n1]>=nums2[n2])
                    nums1[i]=nums2[n2++];
                else
                    nums1[i]=temp[n1++];
            }
        }
    }
}
