class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet(wordList);

       if(!wordSet.contains(endWord))
            return 0;
        
        int level=1;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty())
        {

            int len = q.size();

            for(int i=0; i < len; i++)
            {
                String current = q.poll();
                if(current.equals(endWord))
                    return level;
                
                char[] ch = current.toCharArray(); 

                for(int j=0; j < ch.length; j++)
                {
                    char origional = ch[j];
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        ch[j] = c;

                        String temp = new String(ch);

                        if(wordSet.contains(temp))
                        {
                            q.add(temp);
                            wordSet.remove(temp);
                        }
                    }
                    ch[j] = origional;

                }
            }
            
            level++;
        }

        return 0;


    }
}
