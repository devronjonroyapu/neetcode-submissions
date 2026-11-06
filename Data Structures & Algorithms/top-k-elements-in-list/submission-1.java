class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>freq = new HashMap<>();
        for(int num : nums){
            freq.merge(num,1,Integer::sum);
        }
        //Brute Force
        // List<int[]>pairs= new ArrayList<>();
        // for(Map.Entry<Integer,Integer>e: freq.entrySet()){
        //     pairs.add(new int[]{e.getValue(),e.getKey()});
        // }
        // pairs.sort((a,b)->b[0]-a[0]);
        // int result[] = new int[k];
        // for(int i = 0;i<k;i++){
        //     result[i]=pairs.get(i)[1];
        // }
        // return result;

        //Using Min Heap on freqency
        PriorityQueue<int[]>heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer>e:freq.entrySet()){
            heap.offer(new int[] {e.getValue(),e.getKey()});
            if(heap.size()>k){
                heap.poll();
            }
        }
        int result[] = new int[k];
        for(int i = 0;i<k;i++){
            result[i]=heap.poll()[1];
        }
        return result;
    }
}
