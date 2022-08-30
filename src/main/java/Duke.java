import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    static String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    static String linebreak = "____________________________________________________________";

    static void startSession() {
        System.out.println("Hello from\n" + logo);
        System.out.println(linebreak);
        System.out.println("Hello! I'm Duke Nukem");
        System.out.println("What can I do for you today? Let's rock!");
        System.out.println(linebreak);
    }

    static void endSession() {
        System.out.println(linebreak);
        System.out.println("Bye. Hope to see you again soon! Groovy!");
        System.out.println(linebreak);
    }

    static void storeTasks(ArrayList<Task> Tasks, String text) {
        System.out.println(linebreak);
        String[] result = text.split(" ");
        String[] result2 = text.split("/by ");
        String[] result3 = text.split("/at ");
        Todo newTodo = null;
        Deadline newDeadline = null;
        Event newEvent = null;
        if (result[0].equals("todo")) {
            newTodo = new Todo(result[1]);
            Tasks.add(newTodo);
        }
        else if (result[0].equals("deadline")) {
            newDeadline = new Deadline(result2[0].substring(9), result2[1]);
            Tasks.add(newDeadline);
        }
        else if (result[0].equals("event")) {
            newEvent = new Event(result3[0].substring(6), result3[1]);
            Tasks.add(newEvent);
        }
        System.out.println("I have added this task!");
        if (result[0].equals("todo")) {
            System.out.println(newTodo);
        }
        else if (result[0].equals("deadline")) {
            System.out.println(newDeadline);
        }
        else if (result[0].equals("event")) {
            System.out.println(newEvent);
        }
        System.out.println("Okay loser! You now have " + Tasks.size() + " in the list. Get to work!");
        System.out.println(linebreak);
    }

    static void printTasks(ArrayList<Task> Tasks) {
        System.out.println(linebreak);
        System.out.println("It just keeps piling up");
        int count = 1;
        for (Task i : Tasks) {
            System.out.println(String.valueOf(count) + "." + i);
            count++;
        }
        System.out.println(linebreak);
    }

    static void markTasks(ArrayList<Task> Tasks, String text) {
        System.out.println(linebreak);
        System.out.println("I've marked this task as done, now go do something else!:");
        String[] result = text.split(" ");
        Tasks.get(Integer.valueOf(result[1]) - 1).setDone();
        Tasks.get(Integer.valueOf(result[1]) - 1).setDone();
        System.out.println(Tasks.get(Integer.valueOf(result[1]) - 1));
        System.out.println(linebreak);
    }

    static void unmarkTasks(ArrayList<Task> Tasks, String text) {
        System.out.println(linebreak);
        System.out.println("I've marked this task as not done, get working!:");
        String[] result = text.split(" ");
        Tasks.get(Integer.valueOf(result[1]) - 1).setNotDone();
        System.out.println(Tasks.get(Integer.valueOf(result[1]) - 1));
        System.out.println(linebreak);
    }

    public static void main(String[] args) {
        ArrayList<Task> Tasks = new ArrayList<Task>();

        startSession();

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        while (!line.equals("bye")) {
            if (line.length() > 3 && line.substring(0, 4).equals("mark")) {
                markTasks(Tasks, line);
            } else if (line.length() > 4 && line.substring(0, 6).equals("unmark")) {
                unmarkTasks(Tasks, line);
            } else if (line.equals("list")) {
                printTasks(Tasks);
            } else {
                storeTasks(Tasks, line);
            }
            line = in.nextLine();
        }

        endSession();
    }
}
