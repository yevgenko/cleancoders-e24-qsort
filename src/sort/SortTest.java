package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SortTest {
  private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
    assertThat(sort(unsorted), is(sorted));
  }

  private List<Integer> intList(Integer... ints) {
    return Arrays.asList(ints);
  }

  @Test
  public void sortings() throws Exception {
    assertSorted(intList(), intList());
  }

  private List<Integer> sort(List<Integer> list) {
    return new ArrayList<Integer>();
  }
}
