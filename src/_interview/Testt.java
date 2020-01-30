package _interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/* An order has the the following properties, 
- orderId (a unique identifier)
- amount (purchasing amount)
- timestamp / date (time or date at which order was submitted)
- userId (a unique identifier for the user making the purchase)


Given a list of all orders placed in 2019, write a method to retrieve the top 10 user ids who have purchased maximum 
amount in the month of July.
Note: A user can place multiple orders as well.
 */

public class Testt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	}

	static List<Integer> get_top_cust(List<Order> orders) {

		@SuppressWarnings("deprecation")
		List<Order> temp = orders.stream().filter((x) -> x.getTimeStamp().getMonth() == 6).collect(Collectors.toList());

		Map<Integer, Integer> users = new HashMap<>();

		for (Order o : temp) {
			users.put(o.getUserId(), users.getOrDefault(o.getUserId(), 0) + o.getAmount());
		}

		List<Entry<Integer, Integer>> userIds = new ArrayList<Map.Entry<Integer, Integer>>();
		for (Entry<Integer, Integer> e : users.entrySet())
			userIds.add(e);

		userIds.sort((x, y) -> y.getValue() - x.getValue());

		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < 10; i++)
			ans.add(userIds.get(i).getKey());

		return ans;
	}

}
