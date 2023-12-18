/* import java.util.ArrayList;
import java.util.LinkedList;

public class Sorting {
    // There will be sorting methods for different types of collections here

    // ARRAY MERGE SORT
    public int[] sortArray(int[] nums) {
        if(nums.length == 1 || nums.length == 0){
            return nums;
        }
        int begPointer1 = 0;
        int endPointer1 = nums.length/2;
        int index1 = 0;
        int begPointer2 = nums.length/2;
        int endPointer2 = nums.length;
        int index2 = 0;
        int[] leftSide = new int[endPointer1-begPointer1];
        int[] rightSide = new int[endPointer2-begPointer2];
        for(int i =begPointer1;i<nums.length/2;i++){
            leftSide[index1] = nums[i];
            index1+=1;
        }
        for(int i =begPointer2;i<nums.length;i++){
            rightSide[index2] = nums[i];
            index2+=1;
        }

        return merge(sortArray(leftSide),sortArray(rightSide));
    }
    public int[] merge(int[] nums1, int[] nums2){
        int[] r = new int[nums1.length+nums2.length];
        int orPointer = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 < nums1.length && pointer2 < nums2.length){
            if (nums1[pointer1]<nums2[pointer2]){
                r[orPointer] = nums1[pointer1];
                pointer1+=1;
            }
            else{
                r[orPointer] = nums2[pointer2];
                pointer2+=1;
            }
            orPointer+=1;
        }
        while(pointer1<nums1.length){
            r[orPointer] = nums1[pointer1];
            pointer1+=1;
            orPointer+=1;
        }
        while(pointer2<nums2.length){
            r[orPointer] = nums2[pointer2];
            pointer2+=1;
            orPointer+=1;
        }
        return r;
    }
    //end

    //LIST MERGE SORT
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode tmp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next !=null){
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tmp.next = null;

        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);

        return merge(left_side, right_side);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode tmp_head = new ListNode(0);
        ListNode cur = tmp_head;

        while(l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null){
            cur.next = l1;
            l1 = l1.next;
        }
        if(l2!=null){
            cur.next = l2;
            l2 = l2.next;
        }

        return tmp_head.next;
    }
    //end

    //Merge of many arrays
    public static int[] merge(int[][] a, int from, int to){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = from; i < to; i++) {
            q.add(a[i]);
        }
        ArrayList<Integer> merged = new ArrayList<>();
        while (!q.isEmpty()){
            int[] tmp = q.remove();
            for (int i = 0; i < tmp.length; i++) {
                if (merged.isEmpty()) {
                    merged.add(0, tmp[i]);
                }
                else {
                    int idx = 0;
                    for (Integer in : merged) {
                        if (in < tmp[i]) {
                            idx += 1;
                        } else {
                            break;
                        }
                    }
                    merged.add(idx, tmp[i]);
                }
            }
        }
        int[] mergedAr = new int[merged.size()];
        int index  =0;
        for (Integer num: merged) {
            mergedAr[index] = num;
            index+=1;
        }
        return mergedAr;
    }
    public static int[] merge(int[][] a){
        return merge(a,0,a.length);
    }
    //end


    //
}


 */