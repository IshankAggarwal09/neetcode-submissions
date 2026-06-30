/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0;
        int r = n-1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid+1)) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
    public int binarySearch(MountainArray mountainArr, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            else if (mountainArr.get(mid) > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int reverseBinarySearch(MountainArray mountainArr, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) /2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            else if (mountainArr.get(mid) > target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int idx = peakIndexInMountainArray(mountainArr);
        int resultIdx = binarySearch(mountainArr, 0, idx, target);
        if (resultIdx != -1) {
            return resultIdx;
        }
        resultIdx = reverseBinarySearch(mountainArr, idx+1, n-1, target);
        return resultIdx;
    }
}