class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;            }
                if(nums[low]<=nums[mid]){
                    if(target>=nums[low]&&target<nums[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                else {
                // Check if target lies within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        // Target not found
        return -1;
        }
    
        }

        
    
