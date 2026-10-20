import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> dq = new ArrayDeque<>();

        for (int aster : asteroids) {

           boolean flag = false;
        while(!dq.isEmpty() && dq.peekLast() > 0 && aster < 0)
        {

            if(dq.peekLast() < -aster)
            {
                dq.pollLast();
            }
            else if(dq.peekLast() == -aster)
            {
                flag = true;
                dq.pollLast();
                break;
            }
            else{
                flag = true;
                break;
            }
        }


           if(!flag)
           dq.offerLast(aster);


        }

        int[] result = new int[dq.size()];
        int i = 0;

        for (int a : dq) {
            result[i++] = a;
        }

        return result;
    }
}
