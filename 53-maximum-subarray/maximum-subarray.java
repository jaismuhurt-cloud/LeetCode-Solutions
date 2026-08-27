class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currentSum=0;
        for(int i=0;i< nums.length;i++)
        {
            if (nums[i] > currentSum +nums[i])
            {
                currentSum = nums[i];
            }
            else{
                currentSum = currentSum + nums[i];
            }   
            if (currentSum > maxSum){
                    maxSum= currentSum;
                }
            }
        return maxSum;
    }
}