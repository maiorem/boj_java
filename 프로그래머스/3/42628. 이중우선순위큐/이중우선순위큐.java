import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            String[] arr = operation.split(" ");
            int num = Integer.parseInt(arr[1]);

            if("I".equals(arr[0])) {
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if("D".equals(arr[0])) {
                if(!minHeap.isEmpty() && num == 1) {
                    minHeap.remove(maxHeap.poll());
                } else if(!maxHeap.isEmpty() && num == -1) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        if(minHeap.isEmpty() && maxHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}