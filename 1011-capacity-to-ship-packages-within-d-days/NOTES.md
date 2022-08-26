Split Array Largest Sum
Minimize Max Distance to Gas Station
Koko Eating Bananas
Capacity To Ship Packages Within D Days (this one)
Divide Chocolate
Find the Smallest Divisor Given a Threshold
​
​
**Thought Process:**
​
* weights = [1,2,3,4,5,6,7,8,9,10], Days = 5
* Capacity must be >= 10 as max weight is 10. Cargo must to capable enough to take each weight individually.
* Now we got starting point. What should be our end point?
* sum(weights)? if this can be the capacity of cargo, we can ship everything day 1.
* Now we can apply Linear search as we have start and end point.
Let us think more
​
* Start point is 10 and end point is 55. We can start visualizing an increasing array from 10 to 55
* Example can be really helpful here
* There is a pattern, i.e. for 10 - 14 number of days > D (FALSE). However from 15 - sum(weights) number of days <=D
* From 10-14 condition is False, from 15-55 condition is True, we have to find first True. Now this problem is similar to Easy problem : Find firstBadVersion
* Anything that has pattern, for example func(x) = [False, False, False, True, True, True, True, True]. Binary Search is ideal way to go if we want to find first True.
*