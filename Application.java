import java.util.HashMap;
import java.util.InputMismatchException;
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
        
        try {
            while(option != 5){
                System.out.println();
                System.out.println("Digite (1) Para listar todas suas tarefas");
                System.out.println("Digite (2) Para inserir uma nova tarefa");
                System.out.println("Digite (3) Para alterar uma tarefa");
                System.out.println("Digite (4) Para deletar uma tarefa");
                System.out.println("Digite (5) Para sair");
                System.out.print("Você deseja: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println();
                        for (Integer key : mapList.keySet()){
                            System.out.println(key + " - " + mapList.get(key));
                        }
                        break;

                    case 2:
                        System.out.println();
                        System.out.print("Título da tarefa: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.print("Descrição: ");
                        String description = sc.nextLine();
                        System.out.println("Digite (1) se a tarefa estiver PENDENTE");
                        System.out.println("Digite (2) se a tarefa estiver COMPLETO");
                        System.out.print("Status: ");
                        Integer status = sc.nextInt();
                        Task task = new Task(title, description, Status.valueOf(status));
                        mapList.put(task.getId(), task);
                        break;

                    case 3:
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
                        break;
                
                    case 4:
                        System.out.println();
                        System.out.print("Id da tarefa que deseja remover: ");
                        id = sc.nextInt();
                        mapList.remove(id);
                        break;
                    
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Valor inválido inserido!");
        }
        sc.close();
    }
}
