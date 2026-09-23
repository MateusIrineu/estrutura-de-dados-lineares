public class Main {
    public static void main(String[] args) {
        
        // com array
        System.out.println("teste ARRAY");
        VetorArray<String> v1 = new VetorArray<>();
        
        System.out.println("teste empty: " + v1.isEmpty());

        v1.insertAtRank(0, "Mateus");
        v1.insertAtRank(1, "Oliveira");
        v1.insertAtRank(1, "Irineu");

        System.out.println("teste empty " + v1.isEmpty());
        System.out.println("teste size: " + v1.size());
        System.out.println("teste retorno elemento 1: " + v1.elemAtRank(1));

        v1.replaceAtRank(0, "irineuirineu"); 
        v1.removeAtRank(2); 

        System.out.print("v1: ");
        for (int i = 0; i < v1.size(); i++) {
            System.out.print(v1.elemAtRank(i) + " ");
        }
        System.out.println("\n");


        // lista dupla
        System.out.println("teste LISTA DUPLA");
        VetorListaDupla<String> v2 = new VetorListaDupla<>();

        System.out.println("teste empty 1: " + v2.isEmpty());

        v2.insertAtRank(0, "Matthew");
        v2.insertAtRank(1, "Oliver");
        v2.insertAtRank(1, "Eirenaios");

        System.out.println("teste empty 2: " + v2.isEmpty());
        System.out.println("teste size: " + v2.size());
        System.out.println("teste retorno elemento 1: " + v2.elemAtRank(1));

        v2.replaceAtRank(0, "AAA");
        v2.removeAtRank(2);

        System.out.print("v2: ");
        for (int i = 0; i < v2.size(); i++) {
            System.out.print(v2.elemAtRank(i) + " ");
        }
        System.out.println();
    }
}