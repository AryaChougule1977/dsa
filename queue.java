import java.util.Scanner;

public class EventProcessingSystem {
    private String[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public EventProcessingSystem(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add Event (enqueue)
    public void addEvent(String event) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot add event.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = event;
        size++;
        System.out.println("Event added: " + event);
    }

    // Process Next Event (dequeue)
    public void processNextEvent() {
        if (size == 0) {
            System.out.println("No events to process!");
            return;
        }
        String event = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Processing event: " + event);
    }

    // Display Pending Events
    public void displayPendingEvents() {
        if (size == 0) {
            System.out.println("No pending events!");
            return;
        }
        System.out.print("Pending events: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    // Cancel an Event (if not processed)
    public void cancelEvent(String eventName) {
        if (size == 0) {
            System.out.println("No events to cancel!");
            return;
        }

        boolean found = false;
        String[] temp = new String[capacity];
        int newRear = -1, newSize = 0;

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            if (!queue[index].equals(eventName)) {
                newRear++;
                temp[newRear] = queue[index];
                newSize++;
            } else {
                found = true;
            }
        }

        if (found) {
            queue = temp;
            front = 0;
            rear = newRear;
            size = newSize;
            System.out.println("Event canceled: " + eventName);
        } else {
            System.out.println("Event not found or already processed!");
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventProcessingSystem system = new EventProcessingSystem(10); // capacity 10

        while (true) {
            System.out.println("\n--- Real-Time Event Processing System ---");
            System.out.println("1. Add Event");
            System.out.println("2. Process Next Event");
            System.out.println("3. Display Pending Events");
            System.out.println("4. Cancel an Event");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String event = sc.nextLine();
                    system.addEvent(event);
                    break;
                case 2:
                    system.processNextEvent();
                    break;
                case 3:
                    system.displayPendingEvents();
                    break;
                case 4:
                    System.out.print("Enter event name to cancel: ");
                    String cancel = sc.nextLine();
                    system.cancelEvent(cancel);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
