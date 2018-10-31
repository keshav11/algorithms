package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {

		List<TestClass> list = new ArrayList<>();
		for(int i = 1; i < 10; i++) {
			list.add(new TestClass(i, 10-i));
		}

		Collections.sort(list, new Comparator<TestClass>() {
			@Override
			public int compare(TestClass o1, TestClass o2) {
				if(o1.val1 > o2.val1)
					return 1;
				else if (o1.val1 < o2.val1)
					return -1;
				else
					return 0;
			}
		});

		for(TestClass tc: list) {
			System.out.println(tc.val1);
		}

	}
}
