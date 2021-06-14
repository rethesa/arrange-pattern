package arrange.pattern.algo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ArrangeFormsTest {
	
	private int[] sheet;

	@Test
	public void fitOneFormOfLengthOne() {
		givenASheetOfLength(1);
		whenTryingToFitAListOfForms(new int[]{1});
		int[] expectedSheet = {0};
		thenSquareFitsOnSheet(expectedSheet);
	}
	
	@Test
	public void fitOneFormOfLenthTwo() {
		givenASheetOfLength(2);
		whenTryingToFitAListOfForms(new int[]{2});
		int[] expectedSheet = {0,0};
		thenSquareFitsOnSheet(expectedSheet);
	}
	
	@Test
	public void fitTwoFormsOfLengthOne() {
		givenASheetOfLength(2); 
		whenTryingToFitAListOfForms(new int[]{1, 1});
		int[] expectedSheet = {0,1};
		thenSquareFitsOnSheet(expectedSheet);
	}
	
	@Test
	public void fitTwoFormsFirstWithLengthTwo() {
		givenASheetOfLength(3); 
		whenTryingToFitAListOfForms(new int[]{2, 1});
		int[] expectedSheet = {0,0,1};
		thenSquareFitsOnSheet(expectedSheet);
	}
	
	@Test
	public void fitTwoFormsSecondWithLengthTwo2() {
		givenASheetOfLength(3); 
		whenTryingToFitAListOfForms(new int[]{1, 2});
		int[] expectedSheet = {0,1,1};
		thenSquareFitsOnSheet(expectedSheet);
	}

	private void whenTryingToFitAListOfForms(int[] forms) {
		int counter = 0;
		for (int formIndex = 0; formIndex < forms.length; formIndex++) {
			int formSize = forms[formIndex];
			for (int repeat = 0; repeat < formSize; repeat++) {
				sheet[repeat + counter] = formIndex;
			}
			counter = counter + formSize;
		}
	}

	private void thenSquareFitsOnSheet(int[] expectedSheet) {
		String message = "expected = " + Arrays.toString(expectedSheet) + " actual = " + Arrays.toString(sheet);
		Assert.assertArrayEquals(message, expectedSheet, sheet);
	}

	private void givenASheetOfLength(int lenth) {
		sheet = new int[lenth];
		Arrays.fill(sheet, -1);
	}

}
