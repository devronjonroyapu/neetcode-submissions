class Solution {
    @SuppressWarnings("unchecked")
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>freq = new HashMap<>();
        for(int num : nums){
            freq.merge(num,1,Integer :: sum);
        }

        //Using Min Heap on freqency
        // PriorityQueue<int[]>heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // for(Map.Entry<Integer,Integer>e:freq.entrySet()){
        //     heap.offer(new int[] {e.getValue(),e.getKey()});
        //     if(heap.size()>k){
        //         heap.poll();
        //     }
        // }
        // int result[] = new int[k];
        // for(int i = 0;i<k;i++){
        //     result[i]=heap.poll()[1];
        // }
        // return result;


        //Optimal Bucket Sort
        List<Integer>[] buckets = new List[nums.length+1];
        for(Map.Entry<Integer,Integer>e : freq.entrySet()){
            int f = e.getValue();
            if(buckets[f]==null){
                buckets[f]=new ArrayList<>();
            }
            buckets[f].add(e.getKey());
        }
        int result[] = new int[k];
        int  idx =0;
        for(int f= buckets.length-1;f>=1 && idx <k;f--){
            if(buckets[f]==null) continue;
            for(int num: buckets[f]){
                result[idx++]= num;
                if(idx ==k)break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
}
