public class MergeSort {

    public static void main(String[] args) {

        //Definição do array à ser ordenado
        int x[] = {3,4,1,2,5,9,6,7,8,0};
        int i;

        //Mostrar o array pulando linhas
        for(i=0; i<=9;i++){
            System.out.println((i+1)+"º número: "+x[i]);
        }

        System.out.println("-----------------------------");
        System.out.println("Agora o vetor ordenado: ");

        //Chamando o algoritmo para ordenar o array;
        //Passo dois parâmetros, da posição 0 à posição 9 (10 elementos)
        merge(x,0,9); //Declara qual é o inicio e qual e o fim

        //Mostrando o array ordenado
        for(i=0; i<=9;i++){
            System.out.println((i+1)+"º número: "+x[i]);
        }
    }

    //Aqui eu divido o meu vetor em dois e calculo o meio, chamo o metodo de forma recursiva do inicio ao meio
    //Depois do meio+1 ao fim e só ai que eu intercalo esses dois;

    public static void merge(int x[], int inicio, int fim){
        int meio; //Variável para guardar o meio

        //Se à posição do fim for maior que à do inicio, entra aqui
        if(inicio < fim){
            meio = (inicio + fim)/2; //Calculo do meio
            merge(x, inicio, meio); //Recursividade, chama o algoritmo e executa do
                                    //inicio ao meio
            merge(x, meio+1, fim); //Recursividade, chama o algoritmo de uma posição após meio
                                        //até o fim
            intercala(x, inicio, fim, meio);//Chama o algoritmo para intercalar os dois vetores
        }
    }

    //Aqui eu passo  o vetor que quero intercalar, o inicio, o fim e o meio do array
    public static void intercala(int x[], int inicio, int fim, int meio){
        int poslivre, inicio_vetor1, inicio_vetor2, i; //Definição das variaveis
        int aux[] = new int[10]; //Criando um vetor auxliar;
        inicio_vetor1 = inicio; //Adicionando as posições dos parametros nas variaveis
        inicio_vetor2 = meio+1; //Adicionando as posições dos parametros nas variaveis
        poslivre = inicio; //Adicionando as posições dos parametros nas variaveis

        //Enquanto o inicio do vetor um for menor ou igual ao meio
        // e inicio do vetor dois for menor ou igual ao fim
        // entra no laço
        while(inicio_vetor1 <= meio && inicio_vetor2 <= fim){
            if(x[inicio_vetor1] <= x[inicio_vetor2]){ //Compara o inicio do primeiro com o inicio do segundo
                aux[poslivre] = x[inicio_vetor1];
                inicio_vetor1 = inicio_vetor1+1;
            }else{
                aux[poslivre] = x[inicio_vetor2];
                inicio_vetor2 = inicio_vetor2+1;
            }
            poslivre = poslivre+1;
        }

        //Se ainda tiver algum elemento do inicio ao meio que não passou no laço
        // entra aqui
        for(i=inicio_vetor1; i<=meio; i++){
            aux[poslivre] = x[i];
            poslivre = poslivre+1;
        }

        //Se ainda tiver algum elemento do meio ao fim que não passou no laço
        // entra aqui
        for(i = inicio_vetor2; i<=fim; i++){
            aux[poslivre] = x[i];
            poslivre = poslivre+1;
        }

        //Se ainda tiver algum elemento do inicio ao fim que não passou no laço
        // entra aqui
        for (i = inicio; i<=fim;i++){
            x[i] = aux[i];
        }
    }
}
