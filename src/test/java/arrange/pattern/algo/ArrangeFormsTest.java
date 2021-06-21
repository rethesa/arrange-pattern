package arrange.pattern.algo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ArrangeFormsTest {
	
	private int[] row1;
	private int[] row2;

	@Test
	public void fitOneFormOfLengthOne() {
		givenASheetOfLength(0, 1);
		whenTryingToFitAListOfForms(new int[]{1});
		int[] expectedSheet = {0};
		thenRow1StateIs(expectedSheet);
	}
	
	@Test
	public void fitOneFormOfLenthTwo() {
		givenASheetOfLength(0, 2);
		whenTryingToFitAListOfForms(new int[]{2});
		int[] expectedSheet = {0,0};
		thenRow1StateIs(expectedSheet);
	}
	
	@Test
	public void fitTwoFormsOfLengthOne() {
		givenASheetOfLength(0, 2); 
		whenTryingToFitAListOfForms(new int[]{1, 1});
		int[] expectedSheet = {0,1};
		thenRow1StateIs(expectedSheet);
	}
	
	@Test
	public void fitTwoFormsFirstWithLengthTwo() {
		givenASheetOfLength(0, 3); 
		whenTryingToFitAListOfForms(new int[]{2, 1});
		int[] expectedSheet = {0,0,1};
		thenRow1StateIs(expectedSheet);
	}
	
	@Test
	public void fitTwoFormsSecondWithLengthTwo2() {
		givenASheetOfLength(0, 3); 
		whenTryingToFitAListOfForms(new int[]{1, 2});
		int[] expectedSheet = {0,1,1};
		thenRow1StateIs(expectedSheet);
	}
	
	@Test
	public void fitTwoDimensionalForm() {
		givenASheetOfLength(1, 1); 
//		whenTryingToFitAListOfForms(new int[]{(1,1)});
		int[] expectedRow1 = {0};
		int[] expectedRow2 = {0};
		thenRow1StateIs(expectedRow1);
		thenRow2StateIs(expectedRow2);
	}

	private void whenTryingToFitAListOfForms(int[] forms) {
		int startIndex = 0;
		int formValue = 0;
		for (int formLength : forms) {
			for (int repeat = 0; repeat < formLength; repeat++) {
				row1[startIndex + repeat] = formValue;
			}
			startIndex = startIndex + formLength;
			formValue++;
		}
	}

	private void thenRow1StateIs(int[] expectedRow1) {
		String message = "expected = " + Arrays.toString(expectedRow1) + " actual = " + Arrays.toString(row1);
		Assert.assertArrayEquals(message, expectedRow1, row1);
	}
	
	private void thenRow2StateIs(int[] expectedRow2) {
		String message = "expected = " + Arrays.toString(expectedRow2) + " actual = " + Arrays.toString(row2);
		Assert.assertArrayEquals(message, expectedRow2, row2);
		
	}

	private void givenASheetOfLength(int height, int width) {
		if(height == 0) {
			row1 = new int[width];
			Arrays.fill(row1, -1);
		} else {
			row2 = new int[width];
			Arrays.fill(row2, -1);
		}
	}

}
