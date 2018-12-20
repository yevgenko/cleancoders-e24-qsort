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
    assertSorted(intList(1), intList(1));
    assertSorted(intList(10), intList(10));
    assertSorted(intList(1, 2), intList(1, 2));
    assertSorted(intList(1, 2, 3), intList(1, 2, 3));

    assertSorted(intList(2, 1), intList(1, 2));
    assertSorted(intList(2, 1, 3), intList(1, 2, 3));

    assertSorted(intList(3, 2, 1), intList(1, 2, 3));
    assertSorted(intList(1, 3, 2), intList(1, 2, 3));

    assertSorted(intList(3, 2, 2, 1), intList(1, 2, 2, 3));

    sortBigList(50000);
  }

  private void sortBigList(int n) {
    List<Integer> unsorted = new ArrayList<Integer>();
    for (int i = 0; i < n; i++)
      unsorted.add((int) (Math.random() * 10000.0));
    List<Integer> sorted = sort(unsorted);
//    sort(sorted);
    for (int i = 0; i < n - 1; i++)
      assertTrue(sorted.get(i) <= sorted.get(i + 1));
  }

  private List<Integer> sort(List<Integer> list) {
    List<Integer> sorted = new ArrayList<Integer>();
    List<Integer> greaterElements = new ArrayList<Integer>();
    List<Integer> smallerElements = new ArrayList<Integer>();

    if (list.size() == 0)
      return sorted;

    int firstElement = list.get(0);

    for (int currentElement:list.subList(1, list.size())) {
      if (currentElement < firstElement)
        smallerElements.add(currentElement);
      else
        greaterElements.add(currentElement);
    }

    sorted.addAll(sort(smallerElements));
    sorted.add(firstElement);
    sorted.addAll(sort(greaterElements));

    return sorted;
  }
}
