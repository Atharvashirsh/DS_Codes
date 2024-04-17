import java.util.Scanner;

class Process {
    public int id;
    public String status;

    public Process(int id) {
        this.id = id;
        this.status = "active";
    }
}

public class BullyAlgo {
    Scanner sc;
    Process[] processes;
    int n;

    public void ring() {
        sc = new Scanner(System.in);
        System.out.println("Enter Number of Processes");
        n = sc.nextInt();
        processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process(i);
        }
    }

    public void performElection() {
        int max_id = getMax();
        System.out.println("Process having highest Process Id " + max_id + " falis ");
        processes[max_id].status = "inactive";
        int initiator = 0;
        while (true) {
            boolean higher_process = false;
            for (int i = initiator + 1; i < n; i++) {
                if (processes[i].status == "active") {
                    System.out.println("Process " + initiator + " Passes Election message to process " + i);
                    higher_process = true;
                }
            }
            System.out.println();
            if (higher_process) {
                for (int i = initiator + 1; i < n; i++) {
                    if (processes[i].status == "active") {
                        System.out.println("Process " + i + " Passes Ok (" + i + ") message to process" + initiator);
                    }
                }
                initiator++;
                System.out.println();
            } else {
                int coord = getMax();
                System.out.println("Finally Process " + coord + " Becomes Coordinator");
                System.out.println();
                for (int i = coord - 1; i >= 0; i--) {
                    if (processes[i].status == "active") {
                        System.out.println(
                                "Process " + coord + " Passes Coordinator (" + coord + ") message to process " + i);
                    }
                }
                System.out.println();
                System.out.println("End of Election");
                break;
            }
        }
    }

    public int getMax() {
        int id = -1;
        int max_pid = -999;
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].status == "active" && max_pid < processes[i].id) {
                max_pid = processes[i].id;
                id = i;
            }
        }
        return id;
    }

    public static void main(String[] args) {
        BullyAlgo bully = new BullyAlgo();
        bully.ring();
        bully.performElection();
    }
}
