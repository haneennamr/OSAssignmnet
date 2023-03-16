import java.util.*;

public class SJF {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print ("enter number of process: ");
        int n = sc.nextInt();
        int processors[] = new int[n];
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n];  //wt means waiting time
        int f[] = new int[n];  // f means it is flag it checks process is completed or not
        int st=0, tot=0;
        float average_waiting_time=0, average_turnaround_time=0;

        for(int i=0;i<n;i++)
        {
            System.out.print ("enter process " + (i+1) + " arrival time: ");
            at[i] = sc.nextInt();
            System.out.print ("enter process " + (i+1) + " burst time: ");
            bt[i] = sc.nextInt();
            processors[i] = i+1;
            f[i] = 0;
        }
        boolean a = true;
        while(true)
        {
            int c=n, min=999;
            if (tot == n) // total no of process = completed process loop will be terminated
                break;
            for (int i=0; i<n; i++)
            {

                if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            /* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
            if (c==n)
                st++;
            else
            {
                ct[c]=st+bt[c];
                st+=bt[c];
                ta[c]=ct[c]-at[c];
                wt[c]=ta[c]-bt[c];
                f[c]=1;
                tot++;
            }
        }
        System.out.println("\np  arrival burst  complete turn waiting");
        for(int i=0;i<n;i++)
        {
            average_waiting_time+= wt[i];
            average_turnaround_time+= ta[i];
            System.out.println(processors[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
        }
        System.out.println ("\naverage turnaround time is "+ (float)(average_turnaround_time/n));
        System.out.println ("average waiting time is "+ (float)(average_waiting_time/n));
        sc.close();
    }
}