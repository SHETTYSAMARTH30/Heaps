class ReorganizeStr {
    public String reorganizeString(String S) {
        
        //Stores the frequency of character
        Map<Character, Integer> counts = new HashMap<>();
        
        for(Character c : S.toCharArray()){
            
            counts.put(c, counts.getOrDefault(c,0) + 1);
            
            //If the count of a character exceed a N+1/2 then we cant pair it with any other char
           // int N = S.length();
            //if(counts.get(c) > (N+1)/2)
            //    return "";
        }
        
        //Create max heap, to always fetch 2 character with highest counts
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(b) - counts.get(a));
        
        // or write like this PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> counts.get(a) == counts.get(b) ? a - b : counts.get(b) - counts.get(a));
        
        //Add all the keys to max heap
        maxHeap.addAll(counts.keySet());
        
        StringBuilder result = new StringBuilder();
        
        //We will greedily fetch 2 char with max freq from max heap and add it to String
        while(maxHeap.size() > 1){
            
            //Fetch char with max and 2nd max freq
            char largest = maxHeap.poll();
            char scndLargest = maxHeap.poll();
            
            result.append(largest);
            result.append(scndLargest);
            
            //Reduce their count in map
            counts.put(largest, counts.get(largest) - 1);
            counts.put(scndLargest, counts.get(scndLargest) - 1);
            
            //If size of char is > 0 then we need to add it to maxHeap, inorder to append it again in string
            if(counts.get(largest) > 0)
                maxHeap.add(largest);
            
            if(counts.get(scndLargest) > 0)
                maxHeap.add(scndLargest);
        }
        
        //If maxHeap is empty return string else append the rem char
        if(!maxHeap.isEmpty()){
            
            char last = maxHeap.poll();
            
            //If count is more that means we have to place same char adjacent hence return ""
            if(counts.get(last) > 1)
                return "";
            
            result.append(last);       
        }
        
        
        return result.toString();
        
    }
}
