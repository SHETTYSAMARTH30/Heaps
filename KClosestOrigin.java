class KClosestOrigin {
    public int[][] kClosest(int[][] points, int K) {
        
        //1- The distance formula is Math.sqrt((x2 - x1)(x2 - x1) + (y2 - y1)*(y2 - y1));
        //But since the origin is 0,0 x1=0, y1=0. Hence we write x2*x2 + y2*y2
        //2- The x value of b[] will be b[0] and y value of b will be b[1]
        //3- We want to store the elements in descending order hence we write b before a (ie distance equation of a and b)
        //4- We have avoided writing Math.sqrt cuz we dnt care abt distance from origin, we just want to which points are closer. So we avoid doing sqaure root for all the points.
        //Create a max heap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a, b) -> ((b[0] * b[0]) + (b[1] * b[1])) - ((a[0] * a[0]) + (a[1] * a[1])));
        
        for(int[] point : points){
            
            maxHeap.add(point);
            
            //We store only the K closest elements and pop off the remaining
            if(maxHeap.size() > K)
                maxHeap.poll();
        }
        
        int[][] closest = new int[K][2];
        
        while(K != 0){
            
            closest[--K] = maxHeap.poll();
        }
    
        return closest;
        
    }
}
