import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.entities.Task;
import model.entities.enums.Status;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<Integer, Task> mapList = new HashMap<>();
        boolean loop = true;

        System.out.println("Programa de Controle de tarefas");
        System.out.println();
        
        while(loop){
            System.out.println();
            System.out.println("Digite (1) Para listar todas suas tarefas");
            System.out.println("Digite (2) Para inserir uma nova tarefa");
            System.out.println("Digite (3) Para alterar uma tarefa");
            System.out.println("Digite (4) Para deletar uma tarefa");
            System.out.println("Digite (5) Para sair da aplicação");
            System.out.print("Insira uma opção: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println();
                    for (Integer key : mapList.keySet()){
                        System.out.println(key + " - " + mapList.get(key));
                    }
                    break;

                case "2":
                    System.out.println();
                    System.out.print("Título da tarefa: ");
                    String title = sc.nextLine();
                    System.out.print("Descrição: ");
                    String description = sc.nextLine();
                    Task task = new Task(title, description, Status.PENDENTE);
                    mapList.put(task.getId(), task);
                    break;

                case "3":
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
                        System.out.println("Digite (1) se a tarefa estiver PENDENTE");
                        System.out.println("Digite (2) se a tarefa estiver COMPLETO");
                        System.out.print("Novo status: ");
                        Integer newStatus = sc.nextInt();
                        sc.nextLine();
                        mapList.get(id).setStatus(Status.valueOf(newStatus));
                    }
                    break;
            
                case "4":
                    System.out.println();
                    System.out.print("Id da tarefa que deseja remover: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    mapList.remove(id);
                    break;

                case "5":
                    loop = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        }
            
        sc.close();
    }
}
