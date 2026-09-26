class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        if(set.size()!= nums.length){
            return true;
        }
        return false;
    }
}