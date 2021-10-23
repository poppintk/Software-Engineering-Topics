class Solution {
    
    private Random r = new Random();
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int n : nums){
            if(!countMap.containsKey(n)){
                countMap.put(n,1);
            }else{
                countMap.put(n,countMap.get(n) + 1);
            }
        }
        
        Map.Entry<Integer,Integer> [] arr = new Map.Entry[countMap.size()];
        int i = 0;
        for(Map.Entry entry: countMap.entrySet()){
            arr[i++] = entry;
        }
        
        //System.out.println(Arrays.toString(arr));
        quickSelect(arr,0,arr.length-1,k);
        
        List<Integer> result = new ArrayList<>();
        for(int j = 0; j < k;j++){
            result.add(arr[j].getKey());
        }
        
        return result;
    }
    
    
    void quickSelect(Map.Entry<Integer,Integer> [] arr, int left, int right, int k){
        // TODO
        while(left < right){
            int pivotIndex = r.nextInt(right - left + 1) + left;
            swap(arr, pivotIndex, right);
            
            int p = partition(arr, left, right);
            
            if(p > k) right = p -1;
            else left = p + 1;
        }
    }
    
    int partition(Map.Entry<Integer,Integer> [] arr, int left, int right){
        int i = left;
        Map.Entry<Integer,Integer> pivot = arr[right];
        for(int j = left; j < right; j++){
            if(arr[j].getValue() > pivot.getValue()){
                swap(arr,i,j);
                i++;
            }
        }
        
        //swap i and right
        swap(arr, i, right);
        return i;
        
    }
    
    void swap(Map.Entry [] arr, int left, int right){
        Map.Entry temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    
    class Entry{
        int key; 
        int value;
        
        public Entry(int key, int value){
            key = key;
            value = value;
        }
            
    }
}