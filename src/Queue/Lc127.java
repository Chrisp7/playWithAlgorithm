package Queue;
import java.util.*;

public class Lc127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet set=new HashSet<>(wordList);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }

        Queue<String> queue=new LinkedList<>();
        int level=1;
        int curNum=1;
        int nextNum=0;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            String word=queue.remove();
            curNum--;
            for(int i=0;i<word.length();i++){
                char[] wordUnit=word.toCharArray();
                for(char j='a';j<'z';j++){
                    wordUnit[i]=j;
                    String temp=new String(wordUnit);
                    if(set.contains(temp)){
                        if(temp.equals(endWord)) return level+1;
                        else{
                            nextNum++;
                            queue.add(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
            if(curNum==0){
                curNum=nextNum;
                nextNum=0;
                level++;
            }
        }
        return 0;
    }
}
