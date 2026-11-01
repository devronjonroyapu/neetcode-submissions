class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<high){
            int mid = low + (high - low + 1)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return nums[low];
    }
}
