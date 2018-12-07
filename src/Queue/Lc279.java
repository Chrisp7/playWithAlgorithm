package Queue;
import java.util.*;

public class Lc279 {
    class Node{
        int num;
        int step;
        public Node(int num,int step){
            this.num=num;
            this.step=step;
        }
    }
    public int numSquares(int n) {
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(n,0));
        boolean[] visited=new boolean[n+1];
        int res=n;
        while(!queue.isEmpty()){
            Node cur=queue.remove();
            if(cur.num==0) {
                res=cur.step;
                break;
            }

            for(int i=1;cur.num-i*i>=0;i++){
                if(!visited[cur.num-i*i]){
                    queue.add(new Node(cur.num-i*i,cur.step+1));
                    visited[cur.num-i*i]=true;
                }
            }
        }
        return res;
    }
}
