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
        boolean loop = true;
        Integer id = 0;

        System.out.println("Programa de Controle de tarefas");
        System.out.println();
        
        while(loop){
            System.out.println();
            System.out.println("Digite (1) Para listar todas suas tarefas");
            System.out.println("Digite (2) Para inserir uma nova tarefa");
            System.out.println("Digite (3) Para alterar a porcentagem de uma tarefa");
            System.out.println("Digite (4) Para alterar uma tarefa");
            System.out.println("Digite (5) Para deletar uma tarefa");
            System.out.println("Digite (6) Para sair da aplicação");
            System.out.print("Insira uma das opções acima: ");
            String option = sc.nextLine();

            System.out.println();

            switch (option) {
                case "1":
                    System.out.println("ID | TÍTULO | DESCRIÇÃO | STATUS | PORCENTAGEM");

                    for (Integer key : mapList.keySet()){
                        System.out.println(mapList.get(key));
                    }
                    break;

                case "2":
                    System.out.print("Título da tarefa: ");
                    String title = sc.nextLine();

                    System.out.print("Descrição: ");
                    String description = sc.nextLine();
                    
                    Task task = new Task(title, description, Status.EM_ANDAMENTO, Integer.valueOf(0));
                    mapList.put(task.getId(), task);
                    break;

                case "3":
                    try {
                        System.out.print("Id da tarefa para alterar a porcentagem: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        if (mapList.containsKey(id)){
                            System.out.print("Porcentagem concluída: ");
                            int percentage = sc.nextInt();
                            sc.nextLine();
                            
                            if (percentage <= 100){
                                mapList.get(id).setPercentage(percentage);
                            } else {
                                System.out.println("O valor inserido não pode ser maior que 100!");
                            }

                            if (mapList.get(id).getPercentage() == 100){
                                mapList.get(id).setStatus(Status.COMPLETO);
                            }
                        } else {
                            System.out.println("A tarefa com o id informado não existe");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Id inválido!");
                    }
                    
                    break;

                case "4":
                    try {
                        System.out.print("Id da tarefa que deseja alterar: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        if (mapList.containsKey(id)){
                            System.out.print("Novo título: ");
                            String newTitle = sc.nextLine();

                            System.out.print("Nova descrição: ");
                            String newDescription = sc.nextLine();

                            mapList.get(id).setTitle(newTitle);
                            mapList.get(id).setDescription(newDescription);
                        } else {
                            System.out.println("A tarefa com o id informado não existe");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Id inválido!");
                    }
                    break;
            
                case "5":
                    try {
                        System.out.print("Id da tarefa que deseja remover: ");
                        Object idDelete = sc.nextInt();
                        sc.nextLine();
                        mapList.remove(idDelete);
                    } catch (InputMismatchException e) {
                        System.out.println("Id inválido!");
                    }
                    break;
                

                case "6":
                    loop = false;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        }
            
        sc.close();
    }

    public static boolean isInteger(Object n){
        try {       
            Integer.parseInt(n.toString());
            return true;
        }
        catch (InputMismatchException e){
            return false;
        }
    }
}
