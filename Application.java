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

        System.out.println("Programa de Controle de tarefas");
        System.out.println("Escolha uma opção: ");
        while(option != 5){
            System.out.println();
            System.out.println("Digite (1) Para listar todas suas tarefas");
            System.out.println("Digite (2) Para inserir uma nova tarefa");
            System.out.println("Digite (3) Para alterar uma tarefa");
            System.out.println("Digite (4) Para deletar uma tarefa");
            System.out.println("Digite (5) Para sair");
            System.out.print("Você deseja: ");
            option = sc.nextInt();

            if (option == 1){
                System.out.println();
                for (Integer key : mapList.keySet()){
                    System.out.println(key + " - " + mapList.get(key));
                }
            } 
            else if (option == 2){
                System.out.println();
                System.out.print("Título: ");
                sc.nextLine();
                String title = sc.nextLine();
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Status: ");
                String status = sc.nextLine();
                Task task = new Task(title, description, Status.valueOf(status));
                mapList.put(task.getId(), task);
            }
            else if (option == 3){
                System.out.println();
                System.out.print("Id da tarefa que deseja alterar: ");
                Integer id = sc.nextInt();
                sc.nextLine();
                if (mapList.containsKey(id)){
                    System.out.print("Novo título: ");
                    String newTitle = sc.nextLine();
                    mapList.get(id).setTitle(newTitle);
                    System.out.print("Nova descrição: ");
                    String newDescription = sc.nextLine();
                    mapList.get(id).setDescription(newDescription);
                    System.out.print("Novo status: ");
                    String newStatus = sc.nextLine();
                    mapList.get(id).setStatus(Status.valueOf(newStatus));
                }
            }
            else if (option == 4){
                System.out.println();
                System.out.print("Id da tarefa que deseja remover: ");
                Integer id = sc.nextInt();
                mapList.remove(id);
            }
        }
            
        sc.close();
    }
}
