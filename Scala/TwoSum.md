1.TwoSum
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

```python
#Java space O(n) time O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
```


```python
#Python
# @return a tuple, (index1, index2)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """        
        dict={}
        for i in xrange(len(nums)):
            x = nums[i]
            if target-x in dict:
                return (dict[target-x], i)
            dict[x] = i
```


```python
#Scala
package ScalaHandsOn

object LC1TwoSum {
  def main(args: Array[String]) {
    var myList = Array(11, 7, 2, 15)
    val target = 9
    val result: Array[Int] = TwoSum(myList,target)

    #mkString will convert collections (including Array) element-by-element to string representations.
    #println(a.mkString(","))
    print("result " + result.mkString(","))
  }
   
  def TwoSum(x: Array[Int], target: Int) : Array[Int] = {
    var res = new Array[Int](2)     
    var maps = collection.mutable.Map[Int, Int]()
    
    for ( i: Int <-  x.indices) {
      var j = target - x(i)
      if (maps.contains(j)) {
        res(0) = maps(j)
        res(1) = i
      } else 
        maps += (x(i) -> i)
    }    
    return res
  }
}

#output: result= 1,2
```
