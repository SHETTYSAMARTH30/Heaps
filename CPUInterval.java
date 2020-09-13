class CPUInterval {
    public int leastInterval(char[] tasks, int n) {
        
        //To keep a count of the frequencies of character
        int[] count = new int[26];
        
        for(char c : tasks){
            
            count[c-'A']++;
        }
        
        //Inorder to get max frequency at the end
        Arrays.sort(count);
        
        //Now we need to calculate the idle time as total time for tasks = len(tasks) + idle time
        //The max 
        int fMax = count[25];
        
        //This is max possible idle time that can be possible. We do -1 since we dont count spaces for last char eg:- A_ _ A _ _ A _ _ A. There are 4 A but we do 3*n
        int idleTime = (fMax - 1) * n;
        
        //Now we keep adding other tasks in between this idle time and calculate the resultant idle time.
        for(int i = 24; i >=0 && idleTime > 0; i--){
            
            idleTime -= Math.min(count[i], fMax - 1);
        }
        
    //If while subtracting above it goes in negative then we keep idle time as 0
        idleTime = Math.max(0, idleTime);
        
        //Total time = total chars and then the idle time in between
        return tasks.length + idleTime;
        
    }
}
