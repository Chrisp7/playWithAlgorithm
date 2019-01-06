package Queue;

import java.util.*;

public class Lc126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res=new ArrayList<>();
        HashSet<String> unvisited=new HashSet<>(wordList);
        HashSet<String> visited=new HashSet<>();
        HashMap<String,List<String>> map=new HashMap<>();

        int curNum=1;
        int nextNum=0;
        boolean found=false;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        // BFS, generate a tree
        while(!q.isEmpty()){
            String word=q.poll();
            curNum--;

            for(int i=0;i<word.length();i++){
                char[] wordUnit=word.toCharArray();
                for(char ch='a';ch<'z';ch++){
                    wordUnit[i]=ch;
                    String temp=new String(wordUnit);
                    if(unvisited.contains(temp)){
                        if(temp.equals(endWord)) found=true;
                        if(visited.add(temp)){
                            nextNum++;
                            q.offer(temp);
                        }
                        if(map.containsKey(temp)){
                            map.get(temp).add(word);
                        }else{
                            List<String> list=new ArrayList<>();
                            list.add(word);
                            map.put(temp,list);
                        }
                    }
                }
            }
            if(curNum==0){
                if(found==true) break;
                else{
                    curNum=nextNum;
                    nextNum=0;
                    unvisited.removeAll(visited);
                    visited.clear();
                }
            }
        }

        // DFS
        dfs(res,new ArrayList<>(),map,endWord,beginWord);
        return res;

    }

    private void dfs(List<List<String>> res,List<String> list, HashMap<String,List<String>> map, String endWord, String beginWord){
        if(endWord.equals(beginWord)){
            list.add(0,beginWord);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0,endWord);
        if(map.get(endWord)!=null){
            for(String s:map.get(endWord)){
                dfs(res,list,map,s,beginWord);
            }
        }
        list.remove(0);
    }
}
