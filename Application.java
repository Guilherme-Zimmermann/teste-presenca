import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.entities.Task;
import model.entities.enums.Status;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<Integer, Task> mapList = new HashMap<>();
        int option = 0;

        System.out.println("Choose a option: ");
        while(option != 5){
            System.out.println();
            System.out.println("1 - List");
            System.out.println("2 - Insert");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");
            System.out.println("5 - Exit");
            System.out.print("Enter a number: ");
            option = sc.nextInt();

            if (option == 1){
                System.out.println();
                for (Integer key : mapList.keySet()){
                    System.out.println(key + " - " + mapList.get(key));
                }
            } 
            else if (option == 2){
                System.out.println();
                System.out.print("Id for insert: ");
                Integer id = sc.nextInt();
                System.out.print("Title: ");
                sc.nextLine();
                String title = sc.nextLine();
                System.out.print("Description: ");
                String description = sc.nextLine();
                System.out.print("Status: ");
                String status = sc.nextLine();
                Task task = new Task(title, description, Status.valueOf(status));
                mapList.put(id, task);
            }
            else if (option == 3){
                System.out.println();
                System.out.print("Id for update: ");
                Integer id = sc.nextInt();
                sc.nextLine();
                if (mapList.containsKey(id)){
                    System.out.print("New title: ");
                    String newTitle = sc.nextLine();
                    mapList.get(id).setTitle(newTitle);
                    System.out.print("New description: ");
                    String newDescription = sc.nextLine();
                    mapList.get(id).setDescription(newDescription);
                    System.out.print("New status: ");
                    String newStatus = sc.nextLine();
                    mapList.get(id).setStatus(Status.valueOf(newStatus));
                }
            }
            else if (option == 4){
                System.out.println();
                System.out.print("Id for remove: ");
                Integer id = sc.nextInt();
                mapList.remove(id);
            }
        }
            
        sc.close();
    }
}
