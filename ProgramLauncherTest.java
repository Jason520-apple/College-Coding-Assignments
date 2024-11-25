import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProgramLauncherTest {

	//fib number
	@Test
	void testCalculateNthFibonacciNumber() {
		//2
		int expected = 1;
		int actual = ProgramLauncher.calculateNthFibonacciNumber(2);
		
		assertEquals(expected, actual);
		
		//5
		int expected2 = 3;
		int actual2 = ProgramLauncher.calculateNthFibonacciNumber(5);
		
		assertEquals(expected2, actual2);
		
		//9
		int expected3 = 21;
		int actual3 = ProgramLauncher.calculateNthFibonacciNumber(9);
		
		assertEquals(expected3, actual3);
	}

	//median of 3
	@Test
	void testFindMedianOfThree() {
		// 1 4 10
		int arr[] = {1, 4, 10};
		int expected = 4;
		int actual = ProgramLauncher.findMedianOfThree(arr);
		
		assertEquals (expected, actual);
		
		//123 0 82
		int arr2[] = {123, 0, 82};
		int expected2 = 82;
		int actual2 = ProgramLauncher.findMedianOfThree(arr2);
		
		assertEquals (expected2, actual2);
		
		//-1 0 -24
		int arr3[] = {-1, 0, -24};
		int expected3 = -1;
		int actual3 = ProgramLauncher.findMedianOfThree(arr3);
				
		assertEquals (expected3, actual3);
		
		//983, 1, -98
		int arr4[] = {983, 1, -98};
		int expected4 = 1;
		int actual4 = ProgramLauncher.findMedianOfThree(arr4);
				
		assertEquals (expected4, actual4);		
	}
		
	//array search
	@Test
	void testArraySearch() {
		//1 4 3 2, find 3
		int findValue = 3;
		int array[] = {1, 4, 3, 2};
		int expected = 2;
		int actual = ProgramLauncher.arraySearch(array, findValue);
		
		assertEquals (expected, actual);
		
		// 1 5 2 15 65 3, find 1
		int findValue2 = 1;
		int array2[] = {1, 5, 2, 15, 65, 3};
		int expected2 = 0;
		int actual2 = ProgramLauncher.arraySearch(array2, findValue2);
		
		assertEquals (expected2, actual2);
		
		
		//-12 31 31 43 123, find 43
		int findValue3 = 43;
		int array3[] = {-12, 31, 31, 43, 123};
		int expected3 = 3;
		int actual3 = ProgramLauncher.arraySearch(array3, findValue3);
		
		assertEquals (expected3, actual3);
		
		// 1525 123 222 2 -20 93 -763, find -763
		int findValue4 = -763;
		int array4[] = {1525, 123, 222, 2, -20, 93, -763};
		int expected4 = 6;
		int actual4 = ProgramLauncher.arraySearch(array4, findValue4);
		
		assertEquals (expected4, actual4);
		
		
		
	}
}
