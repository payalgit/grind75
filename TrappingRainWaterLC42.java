class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int maxleft = 0;
        int maxright = n-1;

        int trap = 0;
        int left =1; int right = n-2;

        while(left <= right)
        {
            if(height[maxleft] <= height[maxright])
            {
                if(height[maxleft] > height[left])
                {
                    trap += (height[maxleft]-height[left]);
                }
                else{
                    maxleft = left;
                 }
                 left++;
            }
            else{
                if(height[maxright] > height[right])
                {
                    trap += (height[maxright] - height[right]);
                }
                else
                    maxright = right;

                right--;
            }
        }
        return trap;
    }
}
