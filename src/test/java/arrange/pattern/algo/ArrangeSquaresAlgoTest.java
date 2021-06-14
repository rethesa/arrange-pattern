package arrange.pattern.algo;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ArrangeSquaresAlgoTest {
	
	private int[] sheet;

	@Test
	public void fitOneFormIntoSheet() {
		GivenASheetOfLength(1);
		WhenTryingToFitAForm();
		ThenSquareFitsOnSheet();
	}

	private void ThenSquareFitsOnSheet() {
		int[] expectedSheet = {0};
		Assert.assertArrayEquals(expectedSheet, sheet);
	}

	private void WhenTryingToFitAForm() {
		int form = 0;
		sheet[0] = form;
	}

	private void GivenASheetOfLength(int lenth) {
		sheet = new int[lenth];
		Arrays.fill(sheet, -1);
	}

}
