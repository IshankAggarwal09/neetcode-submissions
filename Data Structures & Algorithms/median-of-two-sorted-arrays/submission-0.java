class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] mergedArr = new int[n+m];
        int i=0, j=0, k=0;
        while (i<n && j<m) {
            if (nums1[i] < nums2[j]) {
                mergedArr[k++] = nums1[i++];
            }
            else {
                mergedArr[k++] = nums2[j++];
            }
        }
        while (i < n) {
            mergedArr[k++] = nums1[i++]; 
        }
        while (j < m) {
            mergedArr[k++] = nums2[j++];
        }
        int end = mergedArr.length-1;
        int mid = end/2;
        if (end % 2 == 0) {
            return (double)(mergedArr[mid]);
        }
        return ((mergedArr[mid] + mergedArr[mid+1])/2.0);
    }   
}