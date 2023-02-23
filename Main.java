

// 1. Пусть дан произвольный список целых чисел, удалить из него четные числа
// 2. Задан целочисленный список ArrayList. Найти минимальное, 
// максимальное и среднее арифметическое из этого списка.


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.IntSummaryStatistics;

public class Main {

    public static void main(String[] args) {        
        List <Integer> listInt = Arrays.asList(1,2,3,4,5,6,7,8,9,10);        
        List <Integer> result = listInt.stream().reduce(0, (a, b) -> a + b)%2 == 0 ? 
                filter(listInt, p->p%2!=0) : filter(listInt, p->p%2!=0);
                double avg = getAverage(listInt);
        System.out.println("Задание N 1:");
        System.out.println(result);  
        System.out.println("Задание N 2:");
        System.out.println(Collections.max(listInt));
        System.out.println(Collections.min(listInt));   
        System.out.println(avg);    
    }

    private static List <Integer> filter(List <Integer> listInt, Predicate <Integer> predicate) {
        return listInt.stream().filter(predicate).collect(Collectors.toList());
    }

    private static double getAverage(List<Integer> list) {
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        return stats.getAverage();
    }
}




