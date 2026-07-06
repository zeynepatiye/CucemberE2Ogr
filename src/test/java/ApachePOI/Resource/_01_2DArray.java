package ApachePOI.Resource;

public class _01_2DArray {
    public static void main(String[] args) {
        String [][] zoo={
                {"Alan" , "1"},
                {"Kaplan","2"},
                {"Zebra","3","1"},
                {"Fil","4"}

        };
        System.out.println("-----------------");
        System.out.println("Kaplan =" + zoo[1][0]);//1. satırın 0. elemanı
        System.out.println("2 rakamı =" +zoo[1][1]);//1. satırın 1. elemanı
        System.out.println("-----------------");

        for (int i = 0; i < zoo.length; i++) {//satır uzunluğu
            for (int j = 0; j <zoo[i].length ; j++) //i. satırın uzunluğu
                System.out.println(zoo[i][j]+"\t");

                System.out.println();

            }


        }
    }

