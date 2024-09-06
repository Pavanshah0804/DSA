import java.util.*;

class Meeting{
    int start;
    int end;
    int index;
    
    Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
    }
}

class Solution{
    
    public static int maxMeetings(int n, int []start, int []end){
        List<Meeting> meetings = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            meetings.add(new Meeting(start[i],end[i],i));
        }
        
        //Sort meetings by time. If two meetings have same time then sort by index.
        Collections.sort(meetings, (a,b)->a.end!=b.end ?a.end-b.end :a.index-b.index);
        int count =0;
        int lastEndTime = -1;
        
        for(Meeting meeting: meetings){
            if(meeting.start > lastEndTime){
                count++;
                lastEndTime = meeting.end;
            }
        }
        return count;
    }
    
    public static void main(String []args){
        int n = 6;
        int []start = {1,3,0,5,8,5};
        int []end = {2,4,6,7,9,9};
        int ans = maxMeetings(n,start,end);
        System.out.println(ans);
    }
}