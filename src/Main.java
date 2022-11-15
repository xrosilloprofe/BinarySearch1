public class Main {

    public static void main(String[] args) {
        double[][] grades = new double[2][20];
        fillArray(grades);
        show(grades);
        //primero debemos ordenar la matriz
        quickSort(grades, 0, grades[1].length-1);
        show(grades);

        //luego podemos ordenarla
        System.out.println("encontrado: " + busquedaBinaria(grades, 3));

    }

    private static void fillArray(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (Math.random() * 11);
            }
    }

    private static void show(double[][] matrix) {
        for (double[] vector: matrix) {
            for (double element : vector) {
                if (element>=10) System.out.print(element + " ");
                else System.out.print(" " + element + " ");
            }
            System.out.println();
        }
    }

    public static boolean busquedaBinaria(double[][] array, int element) {
        boolean encontrado = false;
        int primero = 0;
        int ultimo=array[1].length-1;
        int medio = (primero + ultimo)/2;

        while( primero <= ultimo && !encontrado){
            if (array[1][medio] == element){
                encontrado = true;
                //si el número que está en el medio es menor que el elemento a buscar, buscamos en la primera parte del array
            }else if(array[1][medio] < element ){
                primero = medio + 1;
            }else{
                ultimo = medio - 1;
            }
            medio = (primero + ultimo)/2;
        }

        return encontrado;

    }

    public static void quickSort(double[][] v, int left, int right) {

        double pivot = v[1][(left + right)/2];
        int i = left;
        int d = right;

        do {
            while (v[1][right] > pivot) {
                right--;
            }
            while (v[1][left] < pivot) {
                left++;
            }
            if (left <= right) {
                swap(v, left, right);
                left++;
                right--;
            }
        } while (left < right);

        if (left < d)
            quickSort(v, left, d);

        if (right > i)
            quickSort(v, i, right);

    }

    private static void swap(double[][] v, int i, int j) {
        for (int k = 0; k < v.length; k++) {
            double aux = v[k][i];
            v[k][i] = v[k][j];
            v[k][j] = aux;
        }
    }

}