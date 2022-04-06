import java.util.InputMismatchException;    //importar tratamento de erro
import java.util.Scanner;  //importar classe para input/output
public class desafio {
    public static void main(String[] args) {    //método principal para rodar código
        Scanner leitor = new Scanner(System.in);     //declarar import
        System.out.println("\n\nOlá, munícipe. Inicie o seu cadastro\nCalcule o seu imposto abaixo.");
        System.out.println("Insira o seu nome: ");   //iniciar inserção de dados
        String nomeInserido = leitor.nextLine();       //guardar input
        System.out.println("Insira a sua profissão: ");
        String profInserida = leitor.nextLine();

        System.out.println("Insira o número da ação desejada:\n2 - Visualizar cadastro\n3 - Inserir salário\n4 - Encerrar");
        int escolha = leitor.nextInt();   //criar var para transitar no menu sem usar switch
        while (true){      //travar as opções
            if(escolha == 2){        //condicional 1
                System.out.println("--------------Dados registrados--------------\nNome: "+nomeInserido+"\nProfissão: "+profInserida+"\n---------------------------------------------\nInsira o número da ação desejada:\n3 - Inserir salários\n4 - Encerrar");
                escolha = leitor.nextInt();
                if(escolha == 3){
                    guardarSalarios();  
                }else if(escolha == 4){
                    System.exit(0);
                }
            }else if(escolha == 3){  //condicional 2
                guardarSalarios();
            }else if(escolha == 4){  //condicional 3
                System.exit(0);
            }else{
                System.out.println("Opção não identificada");
                main(null);             //voltar pro zero
            }
        }
    }
    public static void guardarSalarios(){    //método para manipular input de salario e calcular
        Scanner leitor = new Scanner(System.in);
        double[] salarioMes = new double [12];        //tamanho do vetor
        do{               // travar opções
            try{                  //extrapola conteúdo mas é horrivel demais o escape de erro
                for(int i = 0; i < salarioMes.length; i++){         //parâmetro
                    int indice = i+1;                                     
                    System.out.println("Insira o seu "+indice+"º salário do ano(exemplo 1500,00): ");  
                    salarioMes[i] = leitor.nextDouble();
                }
            } catch (InputMismatchException e) {    //caso insira dado não conforme
                System.out.println("-----Insira apenas números como no exemplo 1500,00.-----");
                leitor.nextLine();
                guardarSalarios();      //voltar pro começo da coleta
            }
        }while(null != null);            //apenas referência 
        int escolha = 0;      //criar var para transitar no menu sem usar switch
        while(true){                    //travar opções
            System.out.println("Insira o número da ação desejada:\n3 - Visualizar valores declarados\n4 - Encerrar");
            escolha = leitor.nextInt();
            if(escolha == 3){        // impressão direta
                for(int i = 0; i < salarioMes.length; i++){   //validação
                    int indice = i+1;
                    if(salarioMes[i] <= 2000.00){
                        System.out.println(+indice+"º mês - R$ "+salarioMes[i]+": isento.");
                    }else if(salarioMes[i] >= 2001.00 & salarioMes[i] <= 3000.00){
                        System.out.println(+indice+"º mês - R$ "+salarioMes[i]+": tributo - R$ "+salarioMes[i]*8/100);
                    }else if(salarioMes[i] >= 3000.00 & salarioMes[i] <= 4500.00){
                        System.out.println(+indice+"º mês - R$ "+salarioMes[i]+": tributo - R$"+salarioMes[i]*18/100);
                    }else if(salarioMes[i] > 4500.00){
                        System.out.println(+indice+"º mês - R$ "+salarioMes[i]+": tributo - R$"+salarioMes[i]*28/100);
                    }
                }
                System.out.println("Insira o número da ação desejada:\n1 - Início\n4 - Encerrar");
                escolha = leitor.nextInt();
                if(escolha == 1){        // pro menu não fechar feio
                    main(null);              //voltar pro zero
                   }else if(escolha == 4){      //critério do enunciado
                System.exit(0);
            } 
            }else if(escolha == 4){
                System.exit(0);
            }
        }
    }
}