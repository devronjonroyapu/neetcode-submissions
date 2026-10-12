class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int ans = n;
        for( int i = 0;i<n;i++){
            System.out.print(ans);
            ans ^= i;
            System.out.print(ans);
            ans ^= nums[i];
            System.out.print(ans);
        }
        return ans;
    }
}
