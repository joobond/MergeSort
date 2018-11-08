public class MergeSort {

    public static void main(String[] args) {
        int x[] = {3,4,1,2,5,9,6,7,8,0};
        int i;

        for(i=0; i<=9;i++){
            System.out.println((i+1)+"º número: "+x[i]);
        }

        System.out.println("-----------------------------");
        System.out.println("Agora o vetor ordenado: ");

        merge(x,0,9); //Declara qual é o inicio e qual e o fim

        for(i=0; i<=9;i++){
            System.out.println((i+1)+"º número: "+x[i]);
        }
    }

    //Aqui eu divido o meu vetor em dois e calculo o meio, chamo o metodo de forma recursiva do inicio ao meio
    //Depois do meio+1 ao fim e só ai que eu intercalo esses dois;

    public static void merge(int x[], int inicio, int fim){
        int meio;
        if(inicio < fim){
            meio = (inicio + fim)/2;
            merge(x, inicio, meio);
            merge(x, meio+1, fim);
            intercala(x, inicio, fim, meio);
        }
    }

    public static void intercala(int x[], int inicio, int fim, int meio){
        int poslivre, inicio_vetor1, inicio_vetor2, i;
        int aux[] = new int[10]; //Criando um vetor auxliar;
        inicio_vetor1 = inicio;
        inicio_vetor2 = meio+1;
        poslivre = inicio;

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

        for(i=inicio_vetor1; i<=meio; i++){
            aux[poslivre] = x[i];
            poslivre = poslivre+1;
        }

        for(i = inicio_vetor2; i<=fim; i++){
            aux[poslivre] = x[i];
            poslivre = poslivre+1;
        }

        for (i = inicio; i<=fim;i++){
            x[i] = aux[i];
        }
    }
}
