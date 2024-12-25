import java.util.*;

class Job {
    int id, profit, deadline;

    // Constructor for Job class
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sorting jobs in decreasing order of profit
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;

        // Finding the maximum deadline
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi)
                maxi = arr[i].deadline;
        }

        // Array to keep track of free time slots
        int result[] = new int[maxi + 1];
        Arrays.fill(result, -1);

        int countJob = 0, jobProfit = 0;

        // Iterating through jobs
        for (int i = 0; i < n; i++) {
            // Checking from the last possible time slot
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i; // Assigning job to this time slot
                    countJob++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[] { countJob, jobProfit };
    }

    public static void main(String[] args) {
        // Creating a list of jobs
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };

        Solution solution = new Solution();
        int[] result = solution.JobScheduling(jobs, jobs.length);

        // Printing the result
        System.out.println("Number of jobs done: " + result[0]);
        System.out.println("Maximum profit: " + result[1]);
    }
}
