package leetcode.week1_19_07_2022;

/**
 * @author baur
 * @date on 19.07.2022
 */


public class subtrackProductAndSum {
        public int subtractProductAndSum(int n) {
            if (n == 0) {
                return 0;
            }

            // собираем множители
            int product = 1;
            // собираем суммы
            int sum = 0;

            while (n > 0) {
                // берём последнее число
                int num = n%10;
                // помножаем
                product *= num;
                // скалдываем
                sum += num;
                // укорачиваем цифру с конца
                n = n/10;
            }

//         int z = 0, y = 0, x = 0, v = 0, w = 0, result = 0;
//         z = n%10;
//         y = (n%100 - z)/10;
//         x = (n%1000 - (y*10 + z))/100;
//         v = (n%10000 - (x*100 +y*10 + z))/1000;
//         w = (n%100000 - (v*1000 + x*100 +y*10 + z))/10000;

//         if (w >0) {
//             result = (w*v*x*y*z) - (w+v+x+y+z);
//         } else {
//             if (v > 0) {
//                 result = (v*x*y*z) - (v+x+y+z);
//             } else {
//                 if (x > 0) {
//                     result = (x*y*z) - (x+y+z);
//                 } else {
//                     if (y > 0) {
//                         result = (y*z) - (y+z);
//                     } else {
//                         if (z >0) {
//                             result = z - z;
//                         }
//                     }
//                 }
//             }
//         }
            return product - sum;
        }

}
