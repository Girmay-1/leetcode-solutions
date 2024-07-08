public class MedianOfSortedArrays {
    static int getMedian(int[] arr1, int[] arr2, int n, int m){
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        if((m + n) % 2 ==1){
            for(count =0; count <=(n + m)/2; count++){
                if(i != n && j != m){
                    m1 = (arr1[i] > arr2[j] ? arr2[j++]: arr1[i++]);
                }
                else if(i < n){
                    m1 = arr1[i++];
                }
                //for case when j<m
                else{
                    m1 = arr2[j++];
                }
            }
            return m1;
        }
        else{
            for(count =0; count <=(n + m)/2; count++){
                m2 = m1;
                if(i != n && j != m){
                    m1 = (arr1[i] > arr2[j] ? arr2[j++]: arr1[i++]);
                }
                else if(i < n){
                    m1 = arr1[i++];
                }
                else{
                    m1 = arr2[j++];
                }
            }
            return (m1 + m2)/2;
        }
    }
}
