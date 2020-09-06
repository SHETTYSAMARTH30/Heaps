class TopKFrequentStr {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> count = new HashMap<>();
        
        //Put words and their frequency
        for(String w : words){
            
            count.put(w, count.getOrDefault(w,0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
            
            //If 2 words have same frequency then store the words lexicographically but since we are saving everything reverse of the result we save in descending order of lexicography
            //If not equal the store in ascending order of frequency, so that if size of heap is k then only keep largest k elements (min heap)
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2));
        
        for(String wrd : count.keySet()){
            
            minHeap.add(wrd);
            
            //We only keep 4 elements with max frequency
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        List<String> kElements = new ArrayList();
        
        while(!minHeap.isEmpty()){
            
            kElements.add(minHeap.poll());
        }
        
        //Since we want the elements from max frequency to lower, we reverse the min heap
        Collections.reverse(kElements);
        
        return kElements;
    }
}
